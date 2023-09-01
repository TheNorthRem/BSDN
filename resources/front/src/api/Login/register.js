import request from '@/utils/request'


export function register(data) {
    return request({
      url: '/login/register',
      method: 'post',
      data
    })
  }
  