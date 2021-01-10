package com.skating.activity.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import com.skating.common.annotation.Excel;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * 活动信息对象 act_activity
 * 
 * @author 1768
 * @date 2021-01-10
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("act_activity")
public class ActActivity implements Serializable {

private static final long serialVersionUID=1L;


    /** 主键，自增 */
    @TableId(value = "id")
    private Long id;

    /** 背景图 */
    @Excel(name = "背景图")
    private String backPicture;

    /** 活动名 */
    @Excel(name = "活动名")
    private String activityName;

    /** 活动描述 */
    @Excel(name = "活动描述")
    private String description;

    /** 活动地点 */
    @Excel(name = "活动地点")
    private String location;

    /** 开始时间 */
    @Excel(name = "开始时间")
    private String startDate;

    /** 结束时间 */
    @Excel(name = "结束时间")
    private String endDate;

    /** 创建时间 */
    private String createTime;

    /** 是否删除 */
    @Excel(name = "是否删除")
    private String deleteFlag;
}
