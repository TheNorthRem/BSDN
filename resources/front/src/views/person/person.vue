<template>
  <div >
    <el-container>
      <!-- 导航栏 -->
      <el-header>Header</el-header>
    <el-container>
      <!-- 个人简介 -->
      <el-aside width="22%">
          <div class="photo-wrapper">
              <div class="photo"></div>
          </div>
          <div class="profileBox">
              <div class="profileTitle">Profile</div>
              <div>
                  {{profile}}
              </div>
          </div>
      </el-aside>
      <el-main>
        <el-row :gutter="20" :style="{ height:'40%'}">
            <el-col :span="12"><div class="grid-content"></div></el-col>
            <el-col :span="12"><div class="grid-content"></div></el-col>
        </el-row>
        <el-row :gutter="20" :style="{ height:'4%' }">
          <el-col :span="12"><div class="title">{{passageTitle[0]}}</div></el-col>
          <el-col :span="12"><div class="title">{{passageTitle[1]}}</div></el-col>
        </el-row>
      
      <el-row :gutter="20" :style="{ height:'40%'}">
        <el-col :span="12"><div class="grid-content"></div></el-col>
        <el-col :span="12"><div class="grid-content"></div></el-col>
      </el-row>
      <el-row :gutter="20" :style="{ height:'4%' }">
        <el-col :span="12"><div class="title">{{passageTitle[2]}}</div></el-col>
        <el-col :span="12"><div class="title">{{passageTitle[3]}}</div></el-col>
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
      profile:'个人简介',
      passageTitle:['title1','title2','title3','title4']
    }
  },
  
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
  padding-left: 5%;
  padding-top: 6%;
  padding-bottom: 7%;
  display: flex;
  flex-direction: column;
  align-items: center; 
}

.photo-wrapper {
  position: relative;
  width: 60%;
  padding-top: 60%; /* 保持正方形 */
  margin-bottom: 8%; 
  background: #F6F5F4;
  border: 2px solid #F6F5F4;
  overflow: hidden;
}

.photo {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  display: flex;
  justify-content: center;
  align-items: center;
}

.profileBox {
  border-radius: 12px;
  background: #FBFBFA;
  border: 2px solid #F6F5F4;
  width: 50%;
  padding: 24px 32px 407.44px 32px;
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
    margin-bottom: 20px;
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
    padding-bottom:1%;
  }

</style>