import request from '@/utils/request'

export function del(id) {
    return request({
      url: '/bsUser/getById',
      method: 'get',
      param:{id}
    })
  }