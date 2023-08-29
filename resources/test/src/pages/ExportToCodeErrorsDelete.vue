<template>
  <div :class="$style.exportToCodeErrorsDelete">
    <div :class="$style.needsToUseAutolayout" />
    <div :class="$style.headerNeedsToUseAutolayou" />
    <div :class="$style.divblockbasicWrapperChaxw" />
    <div :class="$style.divblockbasicWrapperChaxw1" />
    <div :class="$style.divblockbasicWrapperChaxw2" />
  </div>
</template>
<script>
  import { defineComponent, ref } from "vue";

  export default defineComponent({
    name: "ExportToCodeErrorsDelete",
  });
</script>
<style module>
  .needsToUseAutolayout {
    position: absolute;
    top: 0px;
    left: 0px;
    border: 4px solid var(--color-red);
    box-sizing: border-box;
    width: 500px;
    height: 523px;
  }
  .headerNeedsToUseAutolayou {
    position: absolute;
    top: 13px;
    left: 0px;
    border: 4px solid var(--color-red);
    box-sizing: border-box;
    width: 496px;
    height: 94px;
  }
  .divblockbasicWrapperChaxw {
    position: absolute;
    top: 228px;
    left: 47px;
    border: 4px solid var(--color-red);
    box-sizing: border-box;
    width: 409px;
    height: 64px;
  }
  .divblockbasicWrapperChaxw1 {
    position: absolute;
    top: 127px;
    left: 47px;
    border: 4px solid var(--color-red);
    box-sizing: border-box;
    width: 409px;
    height: 64px;
  }
  .divblockbasicWrapperChaxw2 {
    position: absolute;
    top: 413px;
    left: 46px;
    border: 4px solid var(--color-red);
    box-sizing: border-box;
    width: 409px;
    height: 64px;
  }
  .exportToCodeErrorsDelete {
    position: relative;
    width: 500px;
    height: 523px;
    overflow: hidden;
  }
</style>
