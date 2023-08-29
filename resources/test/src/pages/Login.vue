<template>
  <div :class="$style.login">
    <div :class="$style.header">
      <div :class="$style.heading2">登录</div>
      <button :class="$style.heading21" type="button" @click="toRegister">注册</button>
      <div :class="$style.headerChild" />
    </div>
    <div :class="$style.divblockbasicWrapperChaxw">
      <input :class="$style.heading22" type="text" @input="handleInput" @keyup.enter="handleEnterKey" placeholder="密码">
    </div>
    <div :class="$style.divblockbasicWrapperChaxw1">
      <input :class="$style.heading22" type="text" @input="handleInput" @keyup.enter="handleEnterKey" placeholder="账号">
    </div>
    <div :class="$style.divblockbasicWrapperChaxw2">
      <button :class="$style.heading24"  type="button" @click="toHome">登录</button>
    </div>
    <img :class="$style.homeHeropngIcon" alt="" src="/homeheropng@2x.png" />
  </div>
</template>
<script>
  import { defineComponent, ref } from "vue";

  export default defineComponent({
    name: "Login",

    methods:{
      toHome:function(){
        this.$router.push('/home'); // 使用路由跳转到根路径'/'
      },
      toRegister:function(){
        this.$router.push('/register'); // 使用路由跳转到根路径'/'
      },
      handleInput(event) {
        // 处理输入事件
        this.inputValue = event.target.value;
      },
      handleEnterKey() {
        // 处理按下回车键事件
        console.log('Enter key pressed');
      }
    }
  });
</script>
<style module>
  .heading2 {
    position: absolute;
    top: 33px;
    left: 98px;
    letter-spacing: -0.13px;
    line-height: 24px;
  }

  .heading21 {
    /* 清除默认边框 */
	  border:0;
	  outline:none;
    /*清除默认背景 */
    background-color: transparent;

    font-weight: 700;
    font-size: 24px;
    position: absolute;
    top: 33px;
    left: 355px;
    letter-spacing: -0.13px;
    line-height: 24px;
    color: var(--color-gray-300);
  }
  .headerChild {
    position: absolute;
    top: 32.5px;
    left: 244.5px;
    border-right: 1px solid var(--color-black);
    box-sizing: border-box;
    width: 1px;
    height: 25px;
  }
  .header {
    position: absolute;
    top: 13px;
    left: 0px;
    width: 496px;
    height: 94px;
  }
  .heading22::placeholder{
    color: #a7a7a6;
  }
  .heading22 {
    /* 清除默认边框 */
	  border:none;
	  outline:none;
    /*清除默认背景 */
    background:none;

    position: absolute;
    top: 20px;
    left: 31px;
    letter-spacing: -0.13px;
    line-height: 24px;
    color:black;
    font-family: Inter;
    font-size: 24px;
    font-style: normal;
    font-weight: 500;
    display: flex;
    align-items: center;
    width: 65px;
    height: 24px;
  }
  .divblockbasicWrapperChaxw {
    position: absolute;
    height: calc(100% - 459px);
    width: calc(100% - 91px);
    top: 228px;
    right: 44px;
    bottom: 231px;
    left: 47px;
    border-radius: var(--br-xs);
    background-color: var(--color-whitesmoke-100);
    border: 1px solid var(--color-white);
    box-sizing: border-box;
    overflow: hidden;
  }
  .divblockbasicWrapperChaxw1 {
    position: absolute;
    height: calc(100% - 459px);
    width: calc(100% - 91px);
    top: 127px;
    right: 44px;
    bottom: 332px;
    left: 47px;
    border-radius: var(--br-xs);
    background-color: var(--color-whitesmoke-100);
    border: 1px solid var(--color-white);
    box-sizing: border-box;
    overflow: hidden;
  }
  .heading24 {
     /* 清除默认边框 */
	  border:0;
	  outline:none;
    /*清除默认背景 */
    background-color: transparent;
    font-family: Inter;
    font-size: 24px;
    font-style: normal;
    color: #E94457;
    position: absolute;
    top: 20px;
    left: 185px;
    letter-spacing: -0.13px;
    line-height: 24px;
    font-weight: 800;
    -webkit-text-stroke: 1px #fff;
  }
  .divblockbasicWrapperChaxw2 {
    position: absolute;
    height: calc(100% - 457px);
    width: calc(100% - 89px);
    top: 412px;
    right: 44px;
    bottom: 45px;
    left: 45px;
    border-radius: var(--br-xs);
    background-color: var(--color-seashell);
    border: 1px solid var(--color-mistyrose);
    box-sizing: border-box;
    overflow: hidden;
    color: var(--color-crimson);
  }
  .homeHeropngIcon {
    position: absolute;
    top: 307px;
    left: 96px;
    width: 307px;
    height: 106px;
    object-fit: cover;
  }
  .login {
    position: relative;
    border-radius: var(--br-xs);
    background-color: var(--color-white);
    border: 1px solid var(--color-darkgray);
    box-sizing: border-box;
    width: 500px;
    height: 523px;
    overflow: hidden;
    text-align: left;
    font-size: var(--font-size-5xl);
    color: var(--color-darkgray);
    font-family: var(--font-inter);
  }
</style>
