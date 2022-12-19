<template>
  <div style="font-size: 12px; line-height: 60px; display: flex">
    <div style="flex: 1; font-size: 18px">
      <span :class="collapseBtnClass" style="cursor: pointer" @click="collapse"></span>
      <el-breadcrumb separator="/" style="display: inline-block; margin-left: 10px">
        <el-breadcrumb-item :to="'/'">Homepage</el-breadcrumb-item>
        <el-breadcrumb-item>{{ currentPathName}}</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <el-dropdown style="width: 70px; cursor: pointer">
      <span>Zejun Li</span><i class="el-icon-arrow-down" style="margin-left: 5px"></i>
      <el-dropdown-menu slot="dropdown">
        <el-dropdown-item>Profile</el-dropdown-item>
        <el-dropdown-item>Log out</el-dropdown-item>
      </el-dropdown-menu>
    </el-dropdown>
  </div>
</template>

<script>
export default {
  name: "Header",
  props: {
    collapseBtnClass: String,
    collapse: ''
  },
  computed: {
    currentPathName (){
      return this.$store.state.currentPathName;
    }
  },
  watch:{
    currentPathName (newVal, oldVal){
      console.log(newVal)
    }
  }
}
</script>

<style scoped>

</style>