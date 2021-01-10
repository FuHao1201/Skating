package com.skating.web.controller.activity;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import java.util.List;
import java.util.Arrays;

import com.skating.common.utils.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.skating.common.annotation.Log;
import com.skating.common.core.controller.BaseController;
import com.skating.common.core.domain.AjaxResult;
import com.skating.common.enums.BusinessType;
import com.skating.activity.domain.ActActivity;
import com.skating.activity.service.IActActivityService;
import com.skating.common.utils.poi.ExcelUtil;
import com.skating.common.core.page.TableDataInfo;

/**
 * 活动信息Controller
 * 
 * @author 1768
 * @date 2021-01-10
 */
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/activity/activity" )
public class ActActivityController extends BaseController {

    private final IActActivityService iActActivityService;

    /**
     * 查询活动信息列表
     */
    @PreAuthorize("@ss.hasPermi('activity:activity:list')")
    @GetMapping("/list")
    public TableDataInfo list(ActActivity actActivity)
    {
        startPage();
        LambdaQueryWrapper<ActActivity> lqw = Wrappers.lambdaQuery(actActivity);
        if (StringUtils.isNotBlank(actActivity.getBackPicture())){
            lqw.eq(ActActivity::getBackPicture ,actActivity.getBackPicture());
        }
        if (StringUtils.isNotBlank(actActivity.getActivityName())){
            lqw.like(ActActivity::getActivityName ,actActivity.getActivityName());
        }
        if (StringUtils.isNotBlank(actActivity.getDescription())){
            lqw.eq(ActActivity::getDescription ,actActivity.getDescription());
        }
        if (StringUtils.isNotBlank(actActivity.getLocation())){
            lqw.eq(ActActivity::getLocation ,actActivity.getLocation());
        }
        if (StringUtils.isNotBlank(actActivity.getStartDate())){
            lqw.eq(ActActivity::getStartDate ,actActivity.getStartDate());
        }
        if (StringUtils.isNotBlank(actActivity.getEndDate())){
            lqw.eq(ActActivity::getEndDate ,actActivity.getEndDate());
        }
        if (StringUtils.isNotBlank(actActivity.getDeleteFlag())){
            lqw.eq(ActActivity::getDeleteFlag ,actActivity.getDeleteFlag());
        }
        List<ActActivity> list = iActActivityService.list(lqw);
        return getDataTable(list);
    }

    /**
     * 导出活动信息列表
     */
    @PreAuthorize("@ss.hasPermi('activity:activity:export')" )
    @Log(title = "活动信息" , businessType = BusinessType.EXPORT)
    @GetMapping("/export" )
    public AjaxResult export(ActActivity actActivity) {
        LambdaQueryWrapper<ActActivity> lqw = new LambdaQueryWrapper<ActActivity>(actActivity);
        List<ActActivity> list = iActActivityService.list(lqw);
        ExcelUtil<ActActivity> util = new ExcelUtil<ActActivity>(ActActivity. class);
        return util.exportExcel(list, "activity" );
    }

    /**
     * 获取活动信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('activity:activity:query')" )
    @GetMapping(value = "/{id}" )
    public AjaxResult getInfo(@PathVariable("id" ) Long id) {
        return AjaxResult.success(iActActivityService.getById(id));
    }

    /**
     * 新增活动信息
     */
    @PreAuthorize("@ss.hasPermi('activity:activity:add')" )
    @Log(title = "活动信息" , businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ActActivity actActivity) {
        return toAjax(iActActivityService.save(actActivity) ? 1 : 0);
    }

    /**
     * 修改活动信息
     */
    @PreAuthorize("@ss.hasPermi('activity:activity:edit')" )
    @Log(title = "活动信息" , businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ActActivity actActivity) {
        return toAjax(iActActivityService.updateById(actActivity) ? 1 : 0);
    }

    /**
     * 删除活动信息
     */
    @PreAuthorize("@ss.hasPermi('activity:activity:remove')" )
    @Log(title = "活动信息" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}" )
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(iActActivityService.removeByIds(Arrays.asList(ids)) ? 1 : 0);
    }
}
