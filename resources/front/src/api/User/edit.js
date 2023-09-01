import request from '@/utils/request'


export function edit(data) {
    return request({
      url: '/bsUser/edit',
      method: 'post',
      data
    })
  }