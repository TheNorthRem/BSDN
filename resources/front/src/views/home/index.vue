<template>
  <div>
    <el-container>
      <!-- 导航栏 -->
      <el-container>
        <!-- 渲染路由对应的组件 -->
        <router-view />
      </el-container>
    </el-container>
  </div>

</template>
<script>
// import headers from '@/components/head/headers.vue'
export default {
  name: 'App',
  data() {
    return {
      profile: '个人简介',
      passageTitle: ['title1', 'title2']
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

  </style>
