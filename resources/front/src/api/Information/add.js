import request from '@/utils/request'


export function add(data) {
    return request({
      url: '/bsUserInformation/add',
      method: 'post',
      data
    })
  }