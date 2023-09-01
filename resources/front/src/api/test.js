import request from '@/utils/request'


export function getInfo(data) {
    return request({
      url: '/bsUserInformation/list',
      method: 'get',
    })
  }
  