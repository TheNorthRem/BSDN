<template>
  <div id="app">
    <headers />
    <router-view />
  </div>
</template>

<script>
import headers from '@/components/head/headers.vue'
export default {
  components: {
    headers
  },
  data() {
    return {

    }
  }
}
</script>

<style>
</style>
