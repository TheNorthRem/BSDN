<template>
  <div>
    <!-- <login v-if="showLogin"></login> -->
    <el-container>
      <el-header>
        <div class="topBar">
          <!-- <img src="../../assets/logo.png" style="width: 50px; height: 50px;"> -->
          <el-button type="text" class="homeButton">首页</el-button>
          <el-button type="text" class="articleButton">文章分类</el-button>
          <el-button type="text" class="Button1">按钮1</el-button>
          <el-button type="text" class="Button2">按钮2</el-button>
          <el-button type="text" class="register" @click="changeRegister">注册</el-button>
          <el-button type="text" class="login" @click="changeLogin">登录</el-button>
          <el-input v-model="input21" placeholder="热搜" prefix-icon="el-icon-search" size="mini" class="search" />
          <el-button plain size="mini" class="post">发布</el-button>
        </div>
      </el-header>
      <el-main />
    </el-container>
    <login v-if="loginFlag"></login>
    <register v-if="registerFlag"></register>
  </div>
</template>
    
<script>
import login from '@/components/login/login';
import register from '@/components/login/register';
export default{
  components: {
    login,
    register
  },
  data(){
    return {
      loginFlag:false,
      registerFlag:false,
      input2: "",
      input21: "",
      input22: "",
      input23: "",
    }
  },
  methods:{
    changeLogin(){
      this.loginFlag = !this.loginFlag;
      this.registerFlag = false;
    },
    changeRegister(){
      this.registerFlag = !this.registerFlag;
      this.loginFlag = false;
    }
  }
}

</script>
    
<style>
div.topBar {
  border-bottom: 1px solid #000;
  background-color: rgba(251, 251, 250, 1);

}

.homeButton {
  color: #000;
  font-style: normal;
  position: relative;
  left: 150px;
}

.articleButton {
  color: #000;
  font-style: normal;
  position: relative;
  left: 200px;
}

.Button1 {
  color: #000;
  font-style: normal;
  position: relative;
  left: 250px;
}

.Button2 {
  color: #000;
  font-style: normal;
  position: relative;
  left: 300px;
}

.el-input {
  margin-left: 300px;
  margin-right: 100px;
  width: 300px;
}

.register {
  color: #000;
  font-style: normal;
  position: relative;
  left: 900px;
}

.login {
  color: #000;
  font-style: normal;
  position: relative;
  left: 800px;
}

.post {
  background-color: #000;
  color: azure;
  position: relative;
  left: 200px;
}
</style>