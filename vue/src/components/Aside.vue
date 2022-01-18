<template>
  <div>
    <el-menu
        default-active="2"
        class="el-menu-vertical-demo"
        style="width:200px;min-height: calc(100vh - 10%);"
        @open="handleOpen"
        @close="handleClose"
    >
      <el-sub-menu index="1">
        <template #title>
          <el-icon><location /></el-icon>
          <span>选项一</span>
        </template>
        <el-menu-item-group title="分组一">
          <el-menu-item index="1-1">项目 1-1</el-menu-item>
          <el-menu-item index="1-2">项目 1-2</el-menu-item>
        </el-menu-item-group>
        <el-menu-item-group title="分组二">
          <el-menu-item index="1-3">项目 1-3</el-menu-item>
        </el-menu-item-group>
        <el-sub-menu index="1-4">
          <template #title>项目 1-4</template>
          <el-menu-item index="1-4-1">项目 1-4-1</el-menu-item>
        </el-sub-menu>
      </el-sub-menu>
      <el-menu-item index="2">
        <el-icon><icon-menu /></el-icon>
        <span>选项二</span>
      </el-menu-item>
      <el-menu-item index="3">
        <el-icon><document /></el-icon>
        <span>选项三</span>
      </el-menu-item>
      <el-menu-item index="4">
        <el-icon><setting /></el-icon>
        <span>选项四</span>
      </el-menu-item>
    </el-menu>
  </div>

</template>

<script>
export default {
  name: "Aside",
  components:{
    Location,Document,Setting,IconMenu
  }
}
import {
  Location,
  Document,
  Menu as IconMenu,
  Setting,
} from '@element-plus/icons-vue'
</script>

<style scoped>

</style>