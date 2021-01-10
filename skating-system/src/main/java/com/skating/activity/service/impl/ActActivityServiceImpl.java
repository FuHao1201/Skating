package com.skating.activity.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.skating.activity.mapper.ActActivityMapper;
import com.skating.activity.domain.ActActivity;
import com.skating.activity.service.IActActivityService;

/**
 * 活动信息Service业务层处理
 *
 * @author 1768
 * @date 2021-01-10
 */
@Service
public class ActActivityServiceImpl extends ServiceImpl<ActActivityMapper, ActActivity> implements IActActivityService {

}
