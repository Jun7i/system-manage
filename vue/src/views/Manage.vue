<template>
  <div>
    <el-container style="min-height: 100vh; margin-bottom: -20px">
      <el-aside :width="sideWidth+'px'" style="background-color: rgb(238, 241, 246);">
        <Aside :isCollapse="isCollapse" />
      </el-aside>

      <el-container>
        <el-header style="border-bottom: 1px solid #ccc">
          <Header :collapseBtnClass="collapseBtnClass" :collapse="collapse"/>

        </el-header>

        <el-main>
          <router-view />

        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'
import Aside from "../components/Aside.vue";
import Header from "../components/Header.vue";
export default {
  name: 'Home',
  data() {
    const item = {
      date: '2016-05-02',
      name: 'Tom',
      address: 'No. 189, Grove St, Los Angeles'
    };
    return {
      collapseBtnClass:'el-icon-s-fold',
      isCollapse:false,
      sideWidth: 180

    }
  },
  components: {
    Aside,
    Header
  },
  methods: {
    collapse() {
      this.isCollapse = !this.isCollapse
      if(this.isCollapse) {
        this.sideWidth = 64
        this.collapseBtnClass = 'el-icon-s-unfold'
      }else{
        this.sideWidth = 180
        this.collapseBtnClass = 'el-icon-s-fold'
      }
  },

}
}
</script>

