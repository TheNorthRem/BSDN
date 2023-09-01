import request from '@/utils/request'


export function add(data) {
    return request({
      url: '/bsUser/add',
      method: 'post',
      data
    })
  }