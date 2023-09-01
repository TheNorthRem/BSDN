<template>
    <div >
      <el-container>
        <!-- 导航栏 -->
        <el-header><headers></headers></el-header>
      <el-container>
        <!-- 个人简介 -->
        <el-aside width="78%">
        <div class="topBox">
          <img src="../../assets/toppeekipng.png" class="toppeeking">
          <el-carousel :interval="5000" arrow="always" :style="{ height:'40%',width:'83.5%'}">
              <el-carousel-item v-for="item in 4" :key="item">
                <h3>{{ item }}</h3>
              </el-carousel-item>
          </el-carousel>
        </div>
        
          <el-row :style="{ height:'20%'}">
            <el-col :span="20"><div class="grid-content"></div></el-col>
          </el-row>
          <el-row  :style="{ height:'4%' }">
            <el-col :span="20"><div class="title">{{passageTitle[0]}}</div></el-col>
          </el-row>
        
          <el-row  :style="{ height:'20%'}">
            <el-col :span="20"><div class="grid-content"></div></el-col>
          </el-row>
          <el-row  :style="{ height:'4%' }">
            <el-col :span="20"><div class="title">{{passageTitle[1]}}</div></el-col>
          </el-row>
        </el-aside>
        <el-main>
          <div class="photo-wrapper">
                <!-- <image src=this.data.photosrc class="photo"/> -->
            </div>
            <div class="profileBox" id="app">
                <div class="profileTitle">Profile</div>
                <div>
                    {{profile}}
                </div>
            </div>
          
        </el-main>
      </el-container>
    </el-container>
    </div>
  
  </template>
  <script>
  import headers from "@/components/head/headers.vue"
  export default {
    components:{
      headers,
    },
    data(){
      return{
        profile:'个人简介',
        passageTitle:['title1','title2']
      }
    },
    name: "App",
  };
  
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
  .el-aside{
    padding-top: 6%;
    padding-left: 10%;
  }
  .el-main {
    /* padding-left: 5%; */
    padding-top: 6%;
    padding-bottom: 7%;
    display: flex;
    flex-direction: column;
    align-items: center; 
  }
  
  .photo-wrapper {
    z-index:1;
    position: relative;
    width: 45%;
    padding-top: 45%; /* 保持正方形 */
    margin-bottom: 8%; 
    margin-left:20%;
    background: #F6F5F4;
    border: 2px solid #F6F5F4;
    overflow: hidden;
    display: flex;
    justify-content: center;
    align-items: center;
  }
  
  .photo {
    z-index:3;
    display: flex;
    justify-content: center;
    align-items: center;
    
  }
  
  .profileBox {
    padding-right:10%;
    border-radius: 12px;
    background: #FBFBFA;
    border: 2px solid #F6F5F4;
    width: 80%;
    height:30%;
    /* padding: 24px 32px 407.44px 32px; */
    display: flex;
    flex-direction: column;
    align-items: center; 
    margin-top: 5%;
  }
    .profileTitle{
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
      display: flex;
      align-items: stretch;
    }
    .el-col {
      border-radius: 12px;
      flex-direction: column;
      display: flex; 
      height:100%;
    }
    .grid-content {
      border: 2px solid #F6F5F4;
      background: #FBFBFA;
      border-radius: 12px;
      flex: 1;
      display: flex;
    }
    .title{
      color: #050505;
      font-family: Inter;
      font-size: 18px;
      font-style: normal;
      font-weight: 700;
      line-height: 24px; /* 133.333% */
      letter-spacing: -0.13px;
      padding-bottom:3%;
      padding-top:1%;
    }
  
    .el-carousel{
      overflow:hidden;
      position: absolute;
      top:12px;
      border-radius: 12px;
    }
    .el-carousel__item{
      overflow:hidden;
      position: absolute;
      border-radius: 12px;
    }
    .el-carousel__item h3 {
      overflow:hidden;
      border-radius: 12px;
      position: absolute;
      z-index:1;
      color: #475669;
      font-size: 18px;
      opacity: 0.75;
      line-height: 300px;
      width:100%;
    }
    
    .el-carousel__item:nth-child(2n) {
      overflow:hidden;
      border-radius: 12px;
      background-color: #99a9bf;
    }
    
    .el-carousel__item:nth-child(2n+1) {
      overflow:hidden;
      border-radius: 12px;
      background-color: #d3dce6;
    }
  .topBox{
    overflow:hidden;
    margin-bottom:4%;
    padding-top: 6%;
    border-radius: 12px;
    padding-bottom:2%;
  }
  .toppeeking{
    padding-top: 6%;
    padding-left: 10%;
    position: absolute;
    top: 0;
    left: 0;
    object-fit: cover;
    width: 221px;
    height: 150px;
    min-width: 221px;
    max-width: 221px;
    min-height: 150px;
    max-height: 150px;
    z-index:3;
    overflow: hidden;
  }
  </style>