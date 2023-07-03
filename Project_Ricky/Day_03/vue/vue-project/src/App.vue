<template>
  <!-- define the content of HTML  -->
  <div>
    <!-- <h1>{{message}}</h1> -->
    <element-vue>
      
    </element-vue>
  </div>
</template>

<script>
import ElementVue from './views/element/ElementVue.vue'
// define the content of JS
export default {
  components: { ElementVue },
  data() {
    return {
      message: "Hello Vue from Ricky"
    }
  },
  methods: {
    
  },
}
</script>

<style>
  /* define the content of CSS */
</style>
 