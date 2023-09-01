import request from '@/utils/request'

export function login(data) {
  return request({
    url: '/front/user/login',
    method: 'post',
    data
  })
}

export function getInfo(token) {
  return request({
    url: '/front/user/info',
    method: 'get',
    params: { token }
  })
}

export function logout() {
  return request({
    url: '/front/user/logout',
    method: 'post'
  })
}
