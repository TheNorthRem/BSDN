<template>
  <div :class="$style.home">
    <div :class="$style.divjsx1098867672">
      <div :class="$style.navPrimaryNavigation">
        <div :class="$style.listSubmenu">
          <div :class="$style.item">
            <div :class="$style.buttonProduct">首页</div>
            <img :class="$style.pseudoIcon" alt="" src="/pseudo4.svg" />
          </div>
          <div :class="$style.item1">
            <div :class="$style.buttonDownload">文章分类</div>
            <img :class="$style.pseudoIcon1" alt="" src="/pseudo11.svg" />
          </div>
          <div :class="$style.item2">
            <div :class="$style.buttonSolutions">Solutions</div>
            <img :class="$style.pseudoIcon2" alt="" src="/pseudo5.svg" />
          </div>
          <div :class="$style.item3">
            <div :class="$style.buttonSolutions">Resources</div>
            <img :class="$style.pseudoIcon3" alt="" src="/pseudo31.svg" />
          </div>
          <div :class="$style.itemLink">Pricing</div>
        </div>
        <div :class="$style.section">
          <div :class="$style.divblockbasicWrapperChaxw">
            <div :class="$style.header">
              <img :class="$style.icon" alt="" src="/-2@2x.png" />
            </div>
          </div>
          <div :class="$style.div" />
        </div>
        <div :class="$style.divjsx4212776476">
          <button :class="$style.listSubmenu1">注册</button>
          <div :class="$style.divjsx42127764761" />
          <button :class="$style.itemLink1" @click="showLogin = !showLogin">登录</button>
          <Login v-if="showLogin"/>
          <div :class="$style.itemLink2">
            <button :class="$style.div1">发布</button>
          </div>
          <div :class="$style.buttonDownload1">个人主页</div>
        </div>
      </div>
    </div>
    <div :class="$style.section1">
      <div :class="$style.div2">热搜</div>
      <div :class="$style.figure">
        <div :class="$style.figure1">
          <div :class="$style.blockquote">
            <div :class="$style.figcaption">
              <div :class="$style.divtweetAvatarOh0lo">
                <div :class="$style.span">
                  <img
                    :class="$style.twitterAvatarAndrepngIcon"
                    alt=""
                    src="/twitteravatarandrepng@2x.png"
                  />
                </div>
              </div>
              <div :class="$style.divtweetUsernamewrap0yv69">
                <b :class="$style.andrBlackman">André Blackman</b>
                <div :class="$style.mindofandre">@mindofandre</div>
              </div>
            </div>
          </div>
          <b :class="$style.heading2">Passage1</b>
        </div>
      </div>
    </div>
    <div :class="$style.section2">
      <div :class="$style.figcaption1">
        <div :class="$style.divtweetUsernamewrap0yv691">
          <b :class="$style.andrBlackman">轮播图</b>
        </div>
      </div>
    </div>
    <div :class="$style.span1">
      <div :class="$style.span2">
        <div :class="$style.image">
          <div :class="$style.image1" />
        </div>
        <img :class="$style.toppeekipngIcon" alt="" src="/toppeekipng@2x.png" />
      </div>
    </div>
    <div :class="$style.section3">
      <div :class="$style.divblockbasicWrapperChaxw1">
        <div :class="$style.header1">
          <b :class="$style.heading21">Name</b>
          <b :class="$style.heading22"> </b>
          <div :class="$style.link">
            <div :class="$style.likes">Likes</div>
            <div :class="$style.div3"> </div>
          </div>
        </div>
      </div>
    </div>
    <img :class="$style.previewIcon" alt="" src="/preview1.svg" />
    <div :class="$style.section4">
      <div :class="$style.figure2">
        <div :class="$style.figure1">
          <div :class="$style.blockquote">
            <div :class="$style.figcaption">
              <div :class="$style.divtweetAvatarOh0lo">
                <div :class="$style.span">
                  <img
                    :class="$style.twitterAvatarAndrepngIcon"
                    alt=""
                    src="/twitteravatarandrepng@2x.png"
                  />
                </div>
              </div>
              <div :class="$style.divtweetUsernamewrap0yv69">
                <b :class="$style.andrBlackman">André Blackman</b>
                <div :class="$style.mindofandre">@mindofandre</div>
              </div>
            </div>
          </div>
          <b :class="$style.heading2">Passage1</b>
        </div>
      </div>
    </div>
    <div :class="$style.b239a6dc48354511d2e42d8aa6f439Parent">
      <img
        :class="$style.b239a6dc48354511d2e42d8aa6f439Icon"
        alt=""
        src="/8b239a6dc48354511d2e42d8aa6f439removebgpreview-1-1@2x.png"
      />
      <div :class="$style.linkNotionHomeSvg">
        <div :class="$style.frame">
          <div :class="$style.buttonSolutions1">BSDN</div>
        </div>
      </div>
    </div>
  </div>
  
</template>
<script>
  import { defineComponent, ref } from "vue";
  import Login from "./Login.vue";
  export default defineComponent({
    name: "Home",
    components:{
      Login
    },
    data() {
      return {
        showLogin: false
      };
    }
    
  });
</script>
<style module>
  .buttonProduct {
    position: relative;
    line-height: 31px;
    display: flex;
    align-items: center;
    justify-content: center;
    width: 52px;
    flex-shrink: 0;
    z-index: 0;
  }
  .pseudoIcon {
    position: absolute;
    margin: 0 !important;
    top: 13px;
    left: 71.92px;
    width: 8px;
    height: 6px;
    z-index: 1;
  }
  .item {
    position: absolute;
    top: calc(50% - 15px);
    left: 0px;
    display: flex;
    flex-direction: row;
    padding: 0px 22.919998168945312px 0px var(--padding-3xs);
    align-items: flex-start;
    justify-content: flex-start;
    text-align: center;
  }
  .buttonDownload {
    position: relative;
    line-height: 31px;
    z-index: 0;
  }
  .pseudoIcon1 {
    position: absolute;
    margin: 0 !important;
    top: 13px;
    left: 86.98px;
    width: 8px;
    height: 6px;
    z-index: 1;
  }
  .item1 {
    position: absolute;
    top: calc(50% - 15px);
    left: 89.92px;
    display: flex;
    flex-direction: row;
    padding: 0px 22.980003356933594px 0px var(--padding-3xs);
    align-items: flex-start;
    justify-content: flex-start;
  }
  .buttonSolutions {
    position: relative;
    line-height: 31px;
    font-weight: 500;
    z-index: 0;
  }
  .pseudoIcon2 {
    position: absolute;
    margin: 0 !important;
    top: 13px;
    left: 81.78px;
    width: 8px;
    height: 6px;
    z-index: 1;
  }
  .item2 {
    position: absolute;
    top: calc(50% - 15px);
    left: 194.9px;
    display: flex;
    flex-direction: row;
    padding: 0px 22.779998779296875px 0px var(--padding-3xs);
    align-items: flex-start;
    justify-content: flex-start;
  }
  .pseudoIcon3 {
    position: absolute;
    margin: 0 !important;
    top: 13px;
    left: 90.4px;
    width: 8px;
    height: 6px;
    z-index: 1;
  }
  .item3 {
    position: absolute;
    top: calc(50% - 15px);
    left: 294.68px;
    display: flex;
    flex-direction: row;
    padding: 0px 22.389999389648438px 0px var(--padding-3xs);
    align-items: flex-start;
    justify-content: flex-start;
  }
  .itemLink {
    position: absolute;
    top: 0px;
    left: 413.08px;
    line-height: 31px;
    font-weight: 500;
  }
  .listSubmenu {
    position: relative;
    width: 471.92px;
    height: 30px;
  }
  .icon {
    position: absolute;
    top: -21px;
    left: -26px;
    width: 26px;
    height: 26px;
    object-fit: cover;
  }
  .header {
    position: absolute;
    top: 24px;
    left: 32px;
    width: 170px;
    height: 93.94px;
  }
  .divblockbasicWrapperChaxw {
    position: relative;
    border-radius: var(--br-xs);
    width: 367px;
    height: 4px;
    overflow: hidden;
    flex-shrink: 0;
  }
  .div {
    position: relative;
    width: 45px;
    height: 45px;
  }
  .section {
    border-radius: var(--br-xs);
    background-color: var(--color-white);
    border: 2px solid var(--color-gainsboro);
    box-sizing: border-box;
    height: 30px;
    display: flex;
    flex-direction: column;
    padding: 0px var(--padding-11xs);
    align-items: flex-start;
    justify-content: space-between;
  }
  .listSubmenu1 {
     /* 清除默认边框 */
	  border:0;
	  outline:none;
    /*清除默认背景 */
    background-color: transparent;

    color: #050505;
    text-align: center;
    font-family: Inter;
    font-size: 15px;
    font-style: normal;
    font-weight: 500;
    line-height: 31px; /* 206.667% */
    position: absolute;
    top: -1px;
    left: 6px;
    line-height: 31px;
    font-weight: 500;
    text-align: center;
  }
  .divjsx42127764761 {
    position: absolute;
    top: calc(50% - 12px);
    left: 60px;
    background-color: var(--color-gray-400);
    width: 1px;
    height: 20px;
  }
  .itemLink1 {
     /* 清除默认边框 */
	  border:0;
	  outline:none;
    /*清除默认背景 */
    background-color: transparent;

    color: #050505;
    font-family: Inter;
    font-size: 15px;
    font-style: normal;
    font-weight: 500;
    line-height: 31px; /* 206.667% */
    position: absolute;
    top: -2px;
    left: 85px;
    line-height: 31px;
    font-weight: 500;
  }
  .div1 {
     /* 清除默认边框 */
	  border:0;
	  outline:none;
    /*清除默认背景 */
    background-color: transparent;

    color: #FFF;
    font-family: Inter;
    font-size: 13.5px;
    font-style: normal;
    font-weight: 600;
    line-height: 19px;
    position: relative;
    letter-spacing: 0.05px;
    line-height: 19px;
    font-weight: 600;
  }
  .itemLink2 {
    position: absolute;
    top: 0px;
    left: 215.52px;
    border-radius: var(--br-8xs);
    background-color: var(--color-gray-200);
    box-shadow: 0px 0.3259260058403015px 0.73px rgba(0, 0, 0, 0.12),
      0px 1.5407400131225586px 2.87px rgba(0, 0, 0, 0.07),
      0px 4px 9px rgba(0, 0, 0, 0.05);
    display: flex;
    flex-direction: row;
    padding: var(--padding-8xs-5) 10.089996337890625px var(--padding-6xs-5)
      var(--padding-2xs);
    box-sizing: border-box;
    align-items: flex-start;
    justify-content: flex-start;
    min-height: 30px;
    font-size: var(--font-size-sm-5);
    color: var(--color-white);
  }
  .buttonDownload1 {
    position: absolute;
    top: -2px;
    left: 139px;
    line-height: 31px;
  }
  .divjsx4212776476 {
    position: relative;
    width: 265px;
    height: 30px;
  }
  .navPrimaryNavigation {
    position: absolute;
    width: calc(100% - 184px);
    top: calc(50% - 15px);
    right: 60px;
    left: 124px;
    border: 1px solid var(--color-gray-100);
    box-sizing: border-box;
    display: flex;
    flex-direction: row;
    align-items: flex-start;
    justify-content: space-between;
  }
  .divjsx1098867672 {
    position: absolute;
    top: calc(50% - 723.5px);
    left: calc(50% - 720px);
    background-color: var(--color-gray-100);
    border: 1px solid var(--color-gray-100);
    box-sizing: border-box;
    width: 1438px;
    height: 62px;
  }
  .div2 {
    position: absolute;
    top: -680px;
    left: 588.96px;
    line-height: 31px;
    font-weight: 500;
    display: flex;
    align-items: center;
    justify-content: center;
    width: 148px;
    height: 27px;
  }
  .twitterAvatarAndrepngIcon {
    position: absolute;
    top: 0px;
    left: 0px;
    width: 48px;
    height: 48px;
    object-fit: cover;
  }
  .span {
    position: absolute;
    height: 100%;
    width: 100%;
    top: 0px;
    right: 0px;
    bottom: 0px;
    left: 0px;
    overflow: hidden;
  }
  .divtweetAvatarOh0lo {
    position: relative;
    border-radius: var(--br-5xl);
    width: 48px;
    height: 48px;
    overflow: hidden;
    flex-shrink: 0;
    z-index: 1;
  }
  .andrBlackman {
    position: relative;
    letter-spacing: 0.02px;
    line-height: 22px;
  }
  .mindofandre {
    position: relative;
    letter-spacing: 0.01px;
    line-height: 22px;
    color: var(--color-gray-500);
  }
  .divtweetUsernamewrap0yv69 {
    flex: 1;
    display: flex;
    flex-direction: column;
    padding: 0px 106.33999633789062px 0px 0px;
    align-items: flex-start;
    justify-content: flex-start;
    z-index: 0;
  }
  .figcaption {
    width: 291px;
    height: 56px;
    display: flex;
    flex-direction: row;
    padding: 0px var(--padding-5xs) var(--padding-12xs) 0px;
    box-sizing: border-box;
    align-items: center;
    justify-content: flex-start;
    gap: var(--gap-5xs);
  }
  .blockquote {
    position: absolute;
    top: 71px;
    left: 15px;
    overflow: hidden;
    display: flex;
    flex-direction: row;
    padding: 11.25px 0px;
    align-items: flex-start;
    justify-content: flex-start;
  }
  .heading2 {
    position: absolute;
    top: 162px;
    left: -13px;
    font-size: var(--font-size-lg);
    letter-spacing: -0.13px;
    line-height: 24px;
    display: flex;
    align-items: center;
    width: 104px;
    height: 35px;
  }
  .figure1 {
    position: absolute;
    top: 96px;
    left: 97px;
    border-radius: var(--br-7xs);
    width: 321.34px;
    height: 186.5px;
  }
  .figure {
    position: absolute;
    top: -17px;
    left: -76px;
    border-radius: var(--br-7xs);
    width: 361px;
    height: 268px;
    text-align: left;
    color: var(--color-gray-300);
  }
  .section1 {
    position: absolute;
    height: calc(100% - 1219px);
    width: calc(100% - 517px);
    top: 696px;
    right: 435px;
    bottom: 523px;
    left: 82px;
    border-radius: var(--br-xs);
    background-color: var(--color-gray-100);
    border: 2px solid var(--color-whitesmoke-200);
    box-sizing: border-box;
    text-align: center;
    color: var(--color-darkgray-100);
  }
  .divtweetUsernamewrap0yv691 {
    flex: 1;
    display: flex;
    flex-direction: column;
    padding: 0px 111.33999633789062px 0px 0px;
    align-items: flex-start;
    justify-content: flex-start;
    z-index: 0;
  }
  .figcaption1 {
    position: absolute;
    top: 334px;
    left: 35px;
    display: flex;
    flex-direction: row;
    padding: 0px var(--padding-5xs) 0px 0px;
    align-items: center;
    justify-content: flex-start;
  }
  .section2 {
    position: absolute;
    height: calc(100% - 1042px);
    width: calc(100% - 524px);
    top: 216px;
    right: 435px;
    bottom: 826px;
    left: 89px;
    border-radius: var(--br-xs);
    background-color: var(--color-gray-100);
    border: 2px solid var(--color-whitesmoke-200);
    box-sizing: border-box;
  }
  .image1 {
    position: absolute;
    top: calc(50% - 75px);
    left: calc(50% - 110.5px);
    width: 221px;
    height: 150px;
    overflow: hidden;
  }
  .image {
    position: relative;
    width: 221px;
    height: 150px;
    max-width: 221px;
    z-index: 0;
  }
  .toppeekipngIcon {
    position: absolute;
    margin: 0 !important;
    top: 0px;
    left: 0px;
    width: 221px;
    height: 150px;
    object-fit: cover;
    min-width: 221px;
    max-width: 221px;
    min-height: 150px;
    max-height: 150px;
    z-index: 1;
  }
  .span2 {
    overflow: hidden;
    display: flex;
    flex-direction: row;
    align-items: flex-start;
    justify-content: flex-start;
    position: relative;
    max-width: 221px;
  }
  .span1 {
    position: absolute;
    top: 80px;
    left: calc(50% - 604px);
    overflow: hidden;
    display: flex;
    flex-direction: row;
    align-items: flex-start;
    justify-content: flex-start;
    max-width: 221px;
  }
  .heading21 {
    position: absolute;
    top: 11px;
    left: 0px;
    letter-spacing: -0.13px;
    line-height: 24px;
    display: flex;
    align-items: center;
    width: 51px;
    height: 27px;
  }
  .heading22 {
    position: absolute;
    top: 40.94px;
    left: 0px;
    letter-spacing: -0.13px;
    line-height: 24px;
  }
  .likes {
    position: relative;
    line-height: 24px;
  }
  .div3 {
    position: relative;
    line-height: 24px;
    margin-left: -0.58px;
  }
  .link {
    position: absolute;
    top: 41px;
    left: 0px;
    height: 24px;
    display: flex;
    flex-direction: row;
    align-items: flex-start;
    justify-content: flex-start;
    font-size: var(--font-size-base);
    color: var(--color-cornflowerblue);
  }
  .header1 {
    position: absolute;
    top: 29px;
    left: 38px;
    width: 170px;
    height: 96px;
  }
  .divblockbasicWrapperChaxw1 {
    position: absolute;
    height: calc(100% - 2px);
    width: calc(100% - 4px);
    top: 2px;
    right: 2px;
    bottom: 0px;
    left: 2px;
    border-radius: var(--br-xs);
    background-color: var(--color-gray-100);
    overflow: hidden;
  }
  .section3 {
    position: absolute;
    height: calc(100% - 1275px);
    width: calc(100% - 1189px);
    top: 418px;
    right: 123px;
    bottom: 857px;
    left: 1066px;
    border-radius: var(--br-xs);
    background-color: var(--color-gray-100);
    border: 2px solid var(--color-whitesmoke-200);
    box-sizing: border-box;
    font-size: var(--font-size-lg);
  }
  .previewIcon {
    position: absolute;
    top: 216px;
    left: 1108px;
    width: 150px;
    height: 153.78px;
  }
  .figure2 {
    position: absolute;
    top: -17px;
    left: -76px;
    border-radius: var(--br-7xs);
    width: 361px;
    height: 268px;
  }
  .section4 {
    position: absolute;
    height: calc(100% - 1219px);
    width: calc(100% - 517px);
    top: 1015px;
    right: 435px;
    bottom: 204px;
    left: 82px;
    border-radius: var(--br-xs);
    background-color: var(--color-gray-100);
    border: 2px solid var(--color-whitesmoke-200);
    box-sizing: border-box;
  }
  .b239a6dc48354511d2e42d8aa6f439Icon {
    position: absolute;
    top: 0px;
    left: 0px;
    width: 75px;
    height: 75px;
    object-fit: cover;
    opacity: 0.5;
  }
  .buttonSolutions1 {
    position: absolute;
    height: 115.63%;
    width: 100.22%;
    top: 6.25%;
    left: 10.78%;
    line-height: 31px;
    font-weight: 900;
    display: flex;
    align-items: center;
    -webkit-text-stroke: 1px #fff;
  }
  .frame {
    position: absolute;
    top: 0px;
    left: calc(50% - 46px);
    width: 92.8px;
    height: 32px;
  }
  .linkNotionHomeSvg {
    position: absolute;
    top: 12px;
    left: 12px;
    width: 112px;
    height: 35px;
    overflow: hidden;
  }
  .b239a6dc48354511d2e42d8aa6f439Parent {
    position: absolute;
    top: 0px;
    left: 0px;
    width: 124px;
    height: 75px;
    font-size: var(--font-size-13xl);
    color: var(--color-black);
  }
  .home {
    position: relative;
    background-color: var(--color-white);
    box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
    width: 100%;
    height: 1447px;
    text-align: left;
    font-size: var(--font-size-mini);
    color: var(--color-gray-300);
    font-family: var(--font-inter);
  }
</style>
