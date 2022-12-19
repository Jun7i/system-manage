<template>
  <el-menu :default-openeds="['1', '3']" style="min-height: 100%; overflow-x: hidden"
           background-color="rgb(13, 45, 94)"
           text-color="#fff"
           active-text-color="#ffd04b"
           :collapse-transition="false"
           :collapse="isCollapse"
           router
  >
    <div style="height: 60px; line-height: 60px; text-align: center">
      <img src="../assets/logo.png" alt="" style="width: 20px; position: relative; top: 5px;">
      <b style="color: white; margin-left: 5px" v-show="!isCollapse">Project Name</b>
    </div>
    <el-menu-item index="/">
      <i class="el-icon-house"></i>
        <span slot="title">Home</span>
    </el-menu-item>
    <el-submenu index="2">
      <template slot="title"><i class="el-icon-menu"></i>
        <span slot="title">System</span>
      </template>
      <el-menu-item index="/user">
        <template slot="title"><i class="el-icon-document"></i>
          <span slot="title">Course History</span>
        </template>
      </el-menu-item>
    </el-submenu>
  </el-menu>
</template>

<script>
export default {
  name: "Aside",
  props: {
    isCollapse: Boolean
  }
}
</script>

<style scoped>

</style>