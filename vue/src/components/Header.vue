<template>
  <div style="height: 5%; width100%; line-height: 50px;border-bottom: 1px solid #ccc;display: flex;">
    <div style="width: 10%;padding-left: 3%;font-weight: bold;color:dodgerblue; ">后台管理</div>
    <div style="flex:1"></div>
    <div style="width: 10%;">
      <el-dropdown>
    <span class="el-dropdown-link" :prefix="ArrowDown">
      {{ user.username }}
      <el-icon class="el-icon--right">
        <arrow-down/>
      </el-icon>
    </span>
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item @click="$router.push('/person')">个人信息</el-dropdown-item>
            <el-dropdown-item @click="$router.push('/login')">退出系统</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </div>
  </div>
</template>

<script>

import {ArrowDown} from '@element-plus/icons-vue'


export default {
  name: "Header",
  props: ['user'],

  data() {
    return {
      user: {}
    }
  },
  created() {
    let userStr = sessionStorage.getItem("user") || "{}"
    this.user = JSON.parse(userStr)

  },

  components: {
    ArrowDown
  }

}
</script>

<style scoped>

</style>