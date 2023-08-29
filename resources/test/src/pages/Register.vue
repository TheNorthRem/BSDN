<template>
  <div :class="$style.register">
    <div :class="$style.header">
      <button :class="$style.heading2" type="button" @click="toLogin">登录</button>
      <div :class="$style.heading21">注册</div>
      <div :class="$style.headerChild" />
    </div>
    <div :class="$style.divblockbasicWrapperChaxw">
      <input :class="$style.heading22" placeholder="密码">
    </div>
    <div :class="$style.divblockbasicWrapperChaxw1">
      <input :class="$style.heading22" placeholder="账号">
      </div>
    <div :class="$style.divblockbasicWrapperChaxw2">
      <button :class="$style.heading24" type="button" @click="register">注册</button>
    </div>
    <img
      :class="$style.notionParadepngIcon"
      alt=""
      src="/notionparadepng@2x.png"
    />
  </div>
</template>
<script>
  import { defineComponent, ref } from "vue";
  //import axios from 'axios';
  export default defineComponent({
    name: "Register",

    data() {
      return {
        username: '',
        password: '',
      };
    },
    methods: {
      async register() {
        try {
          const response = await axios.post('/api/register', {
            username: this.username,
            password: this.password,
          });
          // 注册成功后j自动进入首页
          this.$router.push('/home');
        } catch (error) {
          console.error('Registration failed', error);
        }
      },
    },

    methods:{
      toHome:function(){
        this.$router.push('/home');
      },
      toLogin:function(){
        this.$router.push('/login');
      },
    }
  });
</script>
<style module>
  .heading2 {
    /* 清除默认边框 */
	  border:0;
	  outline:none;
    /*清除默认背景 */
    background-color: transparent;

    color: #000;
    font-family: Inter;
    font-size: 24px;
    font-style: normal;
    font-weight: 700;
    line-height: 24px; /* 100% */
    letter-spacing: -0.13px;
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
    color: var(--color-darkgray);
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
    color: var(--color-black);
  }
  .heading22 {
    /* 清除默认边框 */
	  border:0;
	  outline:none;
    /*清除默认背景 */
    background-color: transparent;

    color: #A7A7A6;
    font-family: Inter;
    font-size: 24px;
    font-style: normal;
    font-weight: 500;
    line-height: 24px; /* 100% */
    letter-spacing: -0.13px;
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
    /* 清除默认边框 */
	  border:0;
	  outline:none;
    /*清除默认背景 */
    background-color: transparent;

    color: #E94457;
    font-family: Inter;
    font-size: 24px;
    font-style: normal;
    line-height: 24px; /* 100% */
    letter-spacing: -0.13px;
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
  .notionParadepngIcon {
    position: absolute;
    top: 299px;
    left: 110px;
    width: 245px;
    height: 114px;
    object-fit: cover;
  }
  .register {
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
