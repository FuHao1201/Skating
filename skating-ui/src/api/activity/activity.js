import request from '@/utils/request'

// 查询活动信息列表
export function listActivity(query) {
  return request({
    url: '/activity/activity/list',
    method: 'get',
    params: query
  })
}

// 查询活动信息详细
export function getActivity(id) {
  return request({
    url: '/activity/activity/' + id,
    method: 'get'
  })
}

// 新增活动信息
export function addActivity(data) {
  return request({
    url: '/activity/activity',
    method: 'post',
    data: data
  })
}

// 修改活动信息
export function updateActivity(data) {
  return request({
    url: '/activity/activity',
    method: 'put',
    data: data
  })
}

// 删除活动信息
export function delActivity(id) {
  return request({
    url: '/activity/activity/' + id,
    method: 'delete'
  })
}

// 导出活动信息
export function exportActivity(query) {
  return request({
    url: '/activity/activity/export',
    method: 'get',
    params: query
  })
}