<template>
  <div :class="$style.login">
    <div :class="$style.header">
      <b :class="$style.heading2">登录</b>
      <b :class="$style.heading21">注册</b>
      <div :class="$style.headerChild" />
    </div>
    <div :class="$style.divblockbasicWrapperChaxw">
      <div :class="$style.heading22">密码</div>
    </div>
    <div :class="$style.divblockbasicWrapperChaxw1">
      <div :class="$style.heading22">账号</div>
    </div>
    <div :class="$style.divblockbasicWrapperChaxw2">
      <div :class="$style.heading24">登录</div>
    </div>
    <img :class="$style.homeHeropngIcon" alt="" src="/homeheropng@2x.png" />
  </div>
</template>
<script>
  import { defineComponent, ref } from "vue";

  export default defineComponent({
    name: "Login",
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
  .heading22 {
    position: absolute;
    top: 20px;
    left: 31px;
    letter-spacing: -0.13px;
    line-height: 24px;
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
    position: absolute;
    top: 20px;
    left: 185px;
    letter-spacing: -0.13px;
    line-height: 24px;
    font-weight: 500;
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
    width: 100%;
    height: 523px;
    overflow: hidden;
    text-align: left;
    font-size: var(--font-size-5xl);
    color: var(--color-darkgray);
    font-family: var(--font-inter);
  }
</style>
