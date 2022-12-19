<template>
  <div>

    <div style="margin: 10px 0">
      <el-input style="width: 200px" placeholder="Type here to search" v-model="course"></el-input>
      <el-button type= "primary" class="ml-5" icon="el-icon-search" circle @click="load"></el-button>
      <el-button icon= "el-icon-refresh" circle @click="reset"></el-button>
    </div>

    <div style="margin: 10px 0">
      <el-button type="primary" @click="handleAdd">Add <i class="el-icon-circle-plus-outline"></i> </el-button>
      <el-popconfirm
          class="ml-5"
          confirm-button-text="Confirm"
          cancel-button-text="Cancel"
          icon="el-icon-info"
          icon-color="red"
          title="Are you sure?"
          @confirm="delBatch"
      >
        <el-button type="danger" slot="reference">Mass delete <i class="el-icon-remove-outline"></i> </el-button>
      </el-popconfirm>
    </div>
    <el-table :data="tableData" border stripe :header-cell-class-name="headerBg" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55">
      </el-table-column>
      <el-table-column prop="id" label="ID" width="80">
      </el-table-column>
      <el-table-column prop="course" label="Course" width="140">
      </el-table-column>
      <el-table-column prop="description" label="Description" width="120">
      </el-table-column>
      <el-table-column prop="term" label="Term" width="120">
      </el-table-column>
      <el-table-column prop="grade" label="Grade" width="120">
      </el-table-column>
      <el-table-column prop="units" label="Units">
      </el-table-column>
      <el-table-column prop="instructor" label="Instructor">
      </el-table-column>
      <el-table-column prop="rating" label="Rating">
      </el-table-column>
      <el-table-column label="Action">
        <template slot-scope="scope">
          <!--edit button-->
          <el-button type="warning" icon="el-icon-edit" circle @click="handleEdit(scope.row)"></el-button>
          <el-popconfirm
              class="ml-5"
              confirm-button-text="Confirm"
              cancel-button-text="Cancel"
              icon="el-icon-info"
              icon-color="red"
              title="Are you sure?"
              @confirm="del(scope.row.id)"
          >
            <el-button type="danger" icon="el-icon-delete" circle slot="reference"></el-button>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
    <div style="padding: 10px 0">
      <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="pageNum"
          :page-sizes="[2, 5, 10, 20]"
          :page-size="pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total">
      </el-pagination>
    </div>

    <el-dialog title="User Info" :visible.sync="dialogFormVisible" width="30%">
      <el-form label-width="80px">
        <el-form-item label="Course">
          <el-input v-model="form.course" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="Description">
          <el-input v-model="form.description" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="Term">
          <el-input v-model="form.term" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="Grade">
          <el-input v-model="form.grade" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="Units">
          <el-input v-model="form.units" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="Instructor">
          <el-input v-model="form.instructor" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="Rating">
          <el-input v-model="form.rating" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
    <el-button @click="dialogFormVisible = false">Cancel</el-button>
    <el-button type="primary" @click="save">Confirm</el-button>
  </span>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "User",
  data(){
    return{
      tableData: [],
      total: 0,
      //page total number
      pageNum: 1,
      pageSize: 5,
      course: "",
      form:{},
      dialogFormVisible: false,
      mutipleSelection:[],
      headerBg: 'headerBg'
    }
  },
  created() {
    this.load()
  },
  methods: {
    load(){
      this.request.get("http://localhost:9090/user/page", {
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize,
          course: this.course
        }
      }).then(res =>{
        console.log(res)
        this.tableData = res.data
        this.total = res.total
      })
    },
    save(){
      this.request.post("http://localhost:9090/user", this.form).then(res => {
        if(res) {
          this.$message.success("Saved")
          this.dialogFormVisible = false
          this.load()
        }else{
          this.$message.error("Save failed")
        }
      })
    },
    handleAdd(){
      this.dialogFormVisible = true
      this.form = {}
    },

    handleEdit(row){
      this.form = row
      this.dialogFormVisible = true
    },

    del(id){
      this.request.delete("/user/" + id).then(res => {
        if(res) {
          this.$message.success("Deleted")
          this.load()
        }else{
          this.$message.error("Delete failed")
        }
      })
    },
    handleSelectionChange(val){
      this.mutipleSelection = val
    },
    delBatch(){
      let ids = this.mutipleSelection.map(v=>v.id)
      this.request.post("/user/del/batch", ids).then(res => {
        if(res) {
          this.$message.success("Mass Deleted")
          this.load()
        }else{
          this.$message.error("Mass Delete failed")
        }
      })
    },
    reset(){
      this.course = ""
      this.load()
    },


    handleSizeChange(pageSize){
      console.log(pageSize)
      this.pageSize = pageSize
      this.load()
    },
    handleCurrentChange(pageNum){
      console.log(pageNum)
      this.pageNum = pageNum
      this.load()
    }
  }
}
</script>

<style>
.headerBg {
  background: darkslategray!important;
}
</style>