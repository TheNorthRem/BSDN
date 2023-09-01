import request from '@/utils/request'


export function bsUserInformationEdit(data) {
    return request({
      url: '/bsUserInformation/list',
      method: 'Post',
      data
    })
  }
  