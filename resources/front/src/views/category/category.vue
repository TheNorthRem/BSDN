<template>
    <div >
      <el-container>
        <!-- 导航栏 -->
        <el-header>Header</el-header>
      <el-container>
        <!-- 个人简介 -->
        <el-aside width="45%">
            <div class="ele1">
                <div class="eleTitle">{{categoryTitle[0]}}</div>
                <div>
                    xxxxx
                </div>
            </div>
        </el-aside>
        <el-main>
          <el-row :gutter="20" :style="{ height:'23%'}">
              <el-col :span="7"><div class="grid-content">
                <div class="eleTitle">{{categoryTitle[1]}}</div>
              </div></el-col>
              <el-col :span="7"><div class="grid-content">
                <div class="eleTitle">{{categoryTitle[2]}}</div>
              </div></el-col>
          </el-row>
        <el-row :gutter="20" :style="{ height:'23%'}">
          <el-col :span="7"><div class="grid-content">
            <div class="eleTitle">{{categoryTitle[3]}}</div>
          </div></el-col>
          <el-col :span="7"><div class="grid-content">
            <div class="eleTitle">{{categoryTitle[4]}}</div>
          </div></el-col>
        </el-row>
        <el-row :gutter="20" :style="{ height:'23%'}">
          <el-col :span="7"><div class="grid-content">
            <div class="eleTitle">{{categoryTitle[5]}}</div>
          </div></el-col>
          <el-col :span="7"><div class="grid-content">
            <div class="eleTitle">{{categoryTitle[6]}}</div>
          </div></el-col>
        </el-row>
        
        </el-main>
      </el-container>
    </el-container>
    </div>
  
  </template>
  
  <script>
  
  export default {
    name: "App",
    data(){
    return{
      categoryTitle:['分类1','分类2','分类','分类','分类','分类','分类','分类','分类']
    }
  },
    create(){
      this.fetchData();
    },
    async fetchData(){
      try{
      const response = await axios.get('',{
        })
        this.data=response.fetchData;
      }catch(error){
          console.error('更新页面信息失败',error);
      }
    }
    
  }
  </script>
  <style>
  .main-container {
    display: flex;
    flex-direction: column;
    height: 100vh;
  }
  
  .el-container {
    display: flex;
    flex-direction: column;
    height: 100vh; /* 让容器占满视口高度 */
  }
  
  .el-aside {
    padding-left:17%;
    margin-top:6%;
    /* padding-bottom: 7%; */
    display: flex;
    flex-direction: column;
    /* align-items: center;  */
  }
  .el-main{
    margin-top:5%;
    padding-bottom: 7%;
  }
  .ele1 {
    /* margin-top:13%; */
    border-radius: 12px;
    background: #FBFBFA;
    border: 2px solid #F6F5F4;
    /* width: 60%; */
    min-height:73%;
    /* padding: 24px 32px 407.44px 32px; */
    display: flex;
    flex-direction: column;
    /* margin-top: 5%; */
  }
    .eleTitle{
      color: #050505;
      font-family: Inter;
      font-size: 18px;
      font-style: normal;
      font-weight: 700;
      line-height: 24px; /* 133.333% */
      letter-spacing: -0.13px;
      display: flex;
      justify-content: center;
    }
  
    .el-row {
      margin-bottom:3%;
      display: flex;
      align-items: stretch;
    }
    .el-col {
      margin-left:3%;
      border-radius: 12px;
      flex-direction: column;
      display: flex; 
      height:100%;
    }
    .grid-content {
      align-items: center; 
      border: 2px solid #F6F5F4;
      background: #FBFBFA;
      border-radius: 12px;
      flex: 1;
      display: flex;
      justify-content: center;
    }
    .title{
      color: #050505;
      font-family: Inter;
      font-size: 18px;
      font-style: normal;
      font-weight: 700;
      line-height: 24px; /* 133.333% */
      letter-spacing: -0.13px;
      
    }
  
  </style>