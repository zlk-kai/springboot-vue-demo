<template>
  <div>
    <Header/>
    <!--    主体-->
    <div style="display: flex">
      <!--      侧边栏-->
      <Aside/>
      <!--      内容区域-->
      <router-view/>
    </div>
  </div>
</template>

<script>


import Header from "../components/Header";
import Aside from "../components/Aside";
import Home from "../views/Home";

export default {
  name: "layout",
  components:{
    Header,
    Aside,
    Home
  }
}
</script>

<style scoped>

</style>