import request from '@/utils/request'

export function getById(id) {
    return request({
      url: '/bsUser/getById',
      method: 'get',
      param:{id}
    })
  }