import Vue from 'vue'
import Axios from 'axios'

import 'normalize.css/normalize.css' // A modern alternative to CSS resets

import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import locale from 'element-ui/lib/locale/lang/zh-CN' // lang i18n

import '@/styles/index.scss' // global css

import App from './App'
import store from './store'
import router from './router'

import '@/icons' // icon
import '@/permission' // permission control

/**
 * If you don't want to use mock-server
 * you want to use MockJs for mock api
 * you can execute: mockXHR()
 *
 * Currently MockJs will be used in the production environment,
 * please remove it before going online ! ! !
 */
if (process.env.NODE_ENV === 'production') {
  const { mockXHR } = require('../mock')
  mockXHR()
}

// set ElementUI lang to EN
Vue.use(ElementUI, { locale })
// 如果想要中文版 element-ui，按如下方式声明
// Vue.use(ElementUI)

Vue.config.productionTip = false

new Vue({
  el: '#app',
  router,
  store,
  render: h => h(App)
})

//设置axios请求头加入token
Axios.interceptors.request.use(config => {  
  if (config.push === '/') { 
     } else { 
      		 if (localStorage.getItem('token')) { 
               		//在请求头加入token，名字要和后端接收请求头的token名字一样    
              		 config.headers.token=localStorage.getItem('token');        
       	 	}   
        }  
         return config;  
   },  
   error => { 
      return Promise.reject(error);
   });

//=============================
//响应回来token是否过期
Axios.interceptors.response.use(response => {  
      console.log('响应回来：'+response.data.code)  
        //和后端token失效返回码约定403    
        if (response.data.code == 403) {
                // 引用elementui message提示框       
                ElementUI.Message({        
                    message: '身份已失效',  
                    type: 'err'        
                    });
                //清除token  
                localStorage.removeItem('token ');
                //跳转      
                router.push({name: 'login'});    
            } else { 
                    return response  
            }  
       }, 
  error => { 
     return Promise.reject(error);  
     })