<template>
  <div :class="$style.person">
    <div :class="$style.header">
      <div :class="$style.sectionWrapper">
        <div :class="$style.section">
          <div :class="$style.divblockbasicWrapperChaxw">
            <div :class="$style.header1">
              <img :class="$style.svgIcon" alt="" src="/svg.svg" />
              <b :class="$style.heading2">Profile </b>
              <b :class="$style.heading2"> </b>
              <div :class="$style.link">
                <div :class="$style.likes">Likes</div>
                <div :class="$style.div"> </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <img :class="$style.previewIcon" alt="" src="/preview.svg" />
      <div :class="$style.section1">
        <b :class="$style.heading22">Passage1</b>
      </div>
      <div :class="$style.section1">
        <b :class="$style.heading22">Passage1</b>
      </div>
      <div :class="$style.section3">
        <b :class="$style.heading22">Passage1</b>
        <div :class="$style.section4">
          <b :class="$style.heading22">Passage1</b>
        </div>
      </div>
      <div :class="$style.section5">
        <b :class="$style.heading22">Passage1</b>
      </div>
      <div :class="$style.divjsx1098867672">
        <div :class="$style.navPrimaryNavigation">
          <div :class="$style.listSubmenu">
            <div :class="$style.item">
              <button :class="$style.buttonProduct" @click="openHome">首页</button>
              <img :class="$style.pseudoIcon" alt="" src="/pseudo.svg" />
            </div>
            <div :class="$style.item1">
              <div :class="$style.buttonDownload">文章分类</div>
              <img :class="$style.pseudoIcon1" alt="" src="/pseudo6.svg" />
            </div>
            <div :class="$style.item2">
              <div :class="$style.buttonSolutions">Solutions</div>
              <img :class="$style.pseudoIcon2" alt="" src="/pseudo1.svg" />
            </div>
            <div :class="$style.item3">
              <div :class="$style.buttonSolutions">Resources</div>
              <img :class="$style.pseudoIcon3" alt="" src="/pseudo7.svg" />
            </div>
            <div :class="$style.itemLink">Pricing</div>
          </div>
          <div :class="$style.section6">
            <div :class="$style.divblockbasicWrapperChaxw1">
              <div :class="$style.header1">
                <img :class="$style.icon" alt="" src="/-2@2x.png" />
              </div>
            </div>
            <div :class="$style.div1" />
          </div>
          <div :class="$style.divjsx4212776476">
            <div :class="$style.listSubmenu1">注册</div>
            <div :class="$style.divjsx42127764761" />
            <div :class="$style.itemLink1">登录</div>
            <div :class="$style.itemLink2">
              <div :class="$style.div2">发布</div>
            </div>
          </div>
        </div>
        <div :class="$style.b239a6dc48354511d2e42d8aa6f439Parent">
          <img
            :class="$style.b239a6dc48354511d2e42d8aa6f439Icon"
            alt=""
            src="/8b239a6dc48354511d2e42d8aa6f439removebgpreview-1-1@2x.png"
          />
          <div :class="$style.linkNotionHomeSvgWrapper">
            <div :class="$style.linkNotionHomeSvg">
              <div :class="$style.frame">
                <div :class="$style.buttonSolutions1">BSDN</div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
  import { defineComponent, ref } from "vue";

  export default defineComponent({
    name: "Person",
    methods:{
      openHome:function(){
        alert("test");
      }
    }
  });
</script>
<style module>
  .svgIcon {
    position: absolute;
    height: calc(100% - 67.94px);
    width: calc(100% - 144px);
    top: 0px;
    right: 144px;
    bottom: 67.94px;
    left: 0px;
    max-width: 100%;
    overflow: hidden;
    max-height: 100%;
  }
  .heading2 {
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
  .div {
    position: relative;
    line-height: 24px;
    margin-left: -0.58px;
  }
  .link {
    position: absolute;
    top: 69.94px;
    left: 0px;
    display: flex;
    flex-direction: row;
    align-items: flex-start;
    justify-content: flex-start;
    font-size: var(--font-size-base);
    color: var(--color-cornflowerblue);
  }
  .header1 {
    position: absolute;
    top: 24px;
    left: 32px;
    width: 170px;
    height: 93.94px;
  }
  .divblockbasicWrapperChaxw {
    position: absolute;
    height: calc(100% - 3.62px);
    width: calc(100% - 4px);
    top: 2px;
    right: 2px;
    bottom: 1.62px;
    left: 2px;
    border-radius: var(--br-xs);
    background-color: var(--color-gray-100);
    overflow: hidden;
  }
  .section {
    position: absolute;
    height: 100%;
    width: 100%;
    top: 0px;
    right: 0px;
    bottom: 0px;
    left: 0px;
    border-radius: var(--br-xs);
    background-color: var(--color-gray-100);
    border: 2px solid var(--color-whitesmoke-200);
    box-sizing: border-box;
  }
  .sectionWrapper {
    position: absolute;
    height: calc(100% - 368px);
    width: calc(100% - 1202px);
    top: 308px;
    right: 1130px;
    bottom: 60px;
    left: 72px;
  }
  .previewIcon {
    position: absolute;
    top: 121px;
    left: 110px;
    width: 150px;
    height: 153.78px;
  }
  .heading22 {
    position: absolute;
    top: 304px;
    left: 2px;
    letter-spacing: -0.13px;
    line-height: 24px;
    display: flex;
    align-items: center;
    width: 104px;
    height: 35px;
  }
  .section1 {
    position: absolute;
    height: calc(100% - 609px);
    width: calc(100% - 959px);
    top: 106px;
    right: 602px;
    bottom: 503px;
    left: 357px;
    border-radius: var(--br-xs);
    background-color: var(--color-gray-100);
    border: 2px solid var(--color-whitesmoke-200);
    box-sizing: border-box;
  }
  .section4 {
    position: absolute;
    height: 100%;
    width: 100%;
    top: 385px;
    right: 538px;
    bottom: -385px;
    left: -538px;
    border-radius: var(--br-xs);
    background-color: var(--color-gray-100);
    border: 2px solid var(--color-whitesmoke-200);
    box-sizing: border-box;
  }
  .section3 {
    position: absolute;
    height: calc(100% - 609px);
    width: calc(100% - 959px);
    top: 106px;
    right: 58px;
    bottom: 503px;
    left: 901px;
    border-radius: var(--br-xs);
    background-color: var(--color-gray-100);
    border: 2px solid var(--color-whitesmoke-200);
    box-sizing: border-box;
  }
  .section5 {
    position: absolute;
    height: calc(100% - 609px);
    width: calc(100% - 959px);
    top: 491px;
    right: 54px;
    bottom: 118px;
    left: 905px;
    border-radius: var(--br-xs);
    background-color: var(--color-gray-100);
    border: 2px solid var(--color-whitesmoke-200);
    box-sizing: border-box;
  }
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
    border: 1px solid var(--color-white);
    box-sizing: border-box;
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
  .divblockbasicWrapperChaxw1 {
    position: relative;
    border-radius: var(--br-xs);
    width: 367px;
    height: 4px;
    overflow: hidden;
    flex-shrink: 0;
  }
  .div1 {
    position: relative;
    width: 45px;
    height: 45px;
  }
  .section6 {
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
    position: absolute;
    top: -1px;
    left: 93.5px;
    line-height: 31px;
    font-weight: 500;
    text-align: center;
  }
  .divjsx42127764761 {
    position: absolute;
    top: calc(50% - 10px);
    left: 145.33px;
    background-color: var(--color-gray-400);
    width: 1px;
    height: 20px;
  }
  .itemLink1 {
    position: absolute;
    top: 0px;
    left: 168.5px;
    line-height: 31px;
    font-weight: 500;
  }
  .div2 {
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
    border: 1px solid var(--color-white);
    box-sizing: border-box;
    display: flex;
    flex-direction: row;
    align-items: flex-start;
    justify-content: space-between;
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
    top: 0px;
    left: 0px;
    width: 112px;
    height: 35px;
    overflow: hidden;
  }
  .linkNotionHomeSvgWrapper {
    position: absolute;
    top: 12px;
    left: 12px;
    width: 112px;
    height: 35px;
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
  .divjsx1098867672 {
    position: absolute;
    top: 0px;
    left: calc(50% - 720px);
    background-color: var(--color-gray-100);
    width: 1438px;
    height: 62px;
    font-size: var(--font-size-mini);
  }
  .header {
    position: absolute;
    top: 66px;
    left: 0px;
    background-color: var(--color-white);
    width: 1440px;
    height: 897px;
  }
  .person {
    position: relative;
    width: 100%;
    height: 1029px;
    text-align: left;
    font-size: var(--font-size-lg);
    color: var(--color-gray-300);
    font-family: var(--font-inter);
  }
</style>
