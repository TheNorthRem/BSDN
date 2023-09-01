<template>
  <div>
    <div class="topBar">
<<<<<<< HEAD
      <div style="margin-left:100px;">
        <el-button class="leftButton" type="text" @click="head">首页</el-button>
        <el-button class="leftButton" type="text" @click="category">文章分类</el-button>
=======
      <div>
        <el-button class="leftButton" type="text" style="margin-left:200px;">首页</el-button>
        <el-button class="leftButton" type="text" @click="toCategory">文章分类</el-button>
>>>>>>> 3b71dd105e04812a0bbf21b033418cfc2b6a9fbb
        <el-button class="leftButton" type="text">button1</el-button>
        <el-button class="leftButton" type="text">button2</el-button>
      </div>
      <div>
        <el-input
          v-model="input1"
          placeholder="热搜"
          size="small"
          class="search"
        />
      </div>
      <div style="margin-right: 20px;">
        <el-button type="text" class="register" @click="changeRegister">注册</el-button>
        <el-button type="text" class="login" @click="changeLogin">登录</el-button>
        <el-button plain size="mini" class="post">发布</el-button>
      </div>
    </div>
    <div class="imgBox">
      <img src="../../assets/logo.png" style="height:80px;width:80px;">
    </div>
    <div class="textBox">BSDN</div>
    <login v-if="loginFlag" />
    <register v-if="registerFlag" />
  </div>
</template>

<script>
<<<<<<< HEAD
import login from '@/components/login/login'
import register from '@/components/login/register'
export default {
  name: 'Headers',
=======
import login from '@/components/login/login';
import register from '@/components/login/register';

export default{
>>>>>>> 3b71dd105e04812a0bbf21b033418cfc2b6a9fbb
  components: {
    login,
    register
  },
  data() {
    return {
      loginFlag: false,
      registerFlag: false,
      input1: ''
    }
  },
<<<<<<< HEAD
  methods: {
    head() {
      this.$router.push({ path: '/' })
    },
    category() {
      this.$router.push({ path: '/category' })
    },
    changeLogin() {
      this.loginFlag = !this.loginFlag
      this.registerFlag = false
    },
    changeRegister() {
      this.registerFlag = !this.registerFlag
      this.loginFlag = false
    }
=======
  methods:{
    changeLogin(){
      this.loginFlag = !this.loginFlag;
      this.registerFlag = false;
      try{
        const response = axios.post('',{
          username: this.username,
          password: this.password
        });
        if(response.data.success){
          console.log("respone login data success");
        }else{
          console.log("respone login data fail");
        }
      }catch(error){
          console.error('登录请求失败',error);
      }
    },
    changeRegister(){
      this.registerFlag = !this.registerFlag;
      this.loginFlag = false;
      try{
        const response = axios.post('',{
          username: this.username,
          password: this.password
        });
        if(response.data.success){
          console.log("respone register data success");
        }else{
          console.log("respone register data fail");
        }
      }catch(error){
          console.error('注册请求失败',error);
      }
    },
>>>>>>> 3b71dd105e04812a0bbf21b033418cfc2b6a9fbb
  }
}

</script>

<style>
.topBar{
    z-index: 1;
    position: relative; /* 设置定位上下文 */
    background-color: rgba(251, 251, 250, 1);
    display: flex;
    align-items: center;
    justify-content: space-between;
    /* padding: 50px 10px; */
    line-height: 48px;
    padding: 16px 60px 16px 124px;
    gap: 50px;
    /* box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.1); */
}
.imgBox{
  position: absolute; /* 设置绝对定位 */
  z-index: 2;
  height:80px;
  width:80px;
  top: 5%; /* 将图像垂直居中 */
  left: 2.7%; /* 将图像水平居中 */
  transform: translate(-50%, -50%); /* 调整图像的位置 */
}
.textBox{
  position: absolute; /* 设置绝对定位 */
  z-index: 2;
  color: #000;
  font-family: Inter;
  font-size: 36px;
  font-style: normal;
  font-weight: 900;
  line-height: 31px; /* 96.875% */
<<<<<<< HEAD
  top: 5%;
=======
  top: 25px; /* 将图像垂直居中 */
>>>>>>> 3b71dd105e04812a0bbf21b033418cfc2b6a9fbb
  left: 6%;
  transform: translate(-50%, -50%);
  /* -webkit-text-stroke: 1px rgb(255, 255, 255); */
}
.el-menu-demo{
  background-color: rgba(251, 251, 250, 1);
  margin-left:200px ;

}
.el-submenu{
  margin-left:10px;
  margin-right:10px ;
}
.el-menu--collapse .el-menu .el-submenu, .el-menu--popup{
  min-width: 120px!important;
}
.leftButton{
    color:#000;
    margin-left: 50px;
}
.el-input {
  border-radius: 12px;
  display: flex;
  justify-content: center; /* 水平居中 */
  align-items: center;
  width: 400px;
  margin-right: 10px;
}
.register{
  color:#000;
  font-style: normal;
  margin-right: 10px;
}
.separator {
  width: 1px;
  height: 20px;
  background-color: #ccc; /* 分割线颜色 */
  margin: 0 20px; /* 调整分割线的间距 */
}

.login{
  color:#000;
  font-style: normal;
  margin-right: 10px;
}
.post{
  background-color:#000;
  color:azure;
}
</style>
