<template>
  <div style="min-width: calc(100% - 200px);padding:10px;min-height: calc(100vh - 50px); ">
    <!--   功能区-->
    <div style="margin: 10px 0;">
      <el-button type="primary" @click="add">新增</el-button>
      <el-button type="primary" @click="add">新增</el-button>
      <el-button type="primary" @click="add">新增</el-button>
    </div>
    <!--    搜索区-->
    <div style="margin: 10px 0;">
      <el-input v-model="search" style="width: 30%;" placeholder="输入关键字" clearable/>
      <el-button type="primary" style="margin: 2%;" @click="load">查询用户名称</el-button>
    </div>
    <el-table :data="tableData" stripe style="width: 100%">
      <el-table-column prop="id" sortable label="ID"/>
      <el-table-column prop="username" label="用户名"/>
      <el-table-column prop="nickname" label="昵称"/>
        <el-table-column prop="age" label="年龄"/>
      <el-table-column prop="sex" label="性别"/>
      <el-table-column prop="address"  label="地址"/>
      <el-table-column label="操作">
        <template #default="scope">
          <el-button  @click="handleEdit(scope.row)">编辑</el-button>
          <el-popconfirm title="确定要删除吗？" @confirm="handleDelete(scope.row.id)">
            <template #reference>
              <el-button  type="danger" >删除</el-button>
            </template>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
    <div class="demo-pagination-block">
      <span class="demonstration"></span>
      <el-pagination
          v-model:currentPage="currentPage"
          :page-sizes="[10, 20, 30, 40]"
          :page-size="pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
      >
      </el-pagination>

      <el-dialog v-model="dialogVisible" title="提示" width="30%">
        <el-form :model="form" label-width="120px;">
          <el-form-item label="用户名">
            <el-input v-model="form.username" clearable></el-input>
          </el-form-item>
          <el-form-item label="昵 称">
            <el-input v-model="form.nickname" clearable></el-input>
          </el-form-item>
          <el-form-item label="年 龄">
            <el-input v-model="form.age" clearable></el-input>
          </el-form-item>
          <el-form-item label="性 别">
            <el-radio v-model="form.sex" label="男" size="large">男</el-radio>
            <el-radio v-model="form.sex" label="女" size="large">女</el-radio>
          </el-form-item>
          <el-form-item label="地 址">
            <el-input v-model="form.address" clearable></el-input>
          </el-form-item>
        </el-form>
        <template #footer>
          <span class="dialog-footer">
            <el-button @click="dialogVisible = false">取消</el-button>
            <el-button type="primary" @click="save">确定</el-button>
          </span>
        </template>
      </el-dialog>
    </div>
  </div>

</template>

<script>

import request from "../utils/request";

export default {
  name: 'Home',
  components: {},
  data() {
    return {
      form: {},
      dialogVisible: false,
      search: '',
      currentPage: 1,
      pageSize: 10,
      total: 0,
      tableData: []
    }
  },
  created() {
    this.load()
  },
  methods: {
    load(){
      request.get("/user",{
        params:{
          pageNum: this.currentPage,
          pageSize: this.pageSize,
          search: this.search
        }
      }).then(res =>{
        console.log(res)
        this.tableData = res.data.records
        this.total = res.data.total
      })
    },
    add() {
      this.dialogVisible = true
      this.form = {}
    },
    //
    save()  {
      //新增数据
      if (this.form.id){
        //更新数据
        request.put("/user",this.form).then(res =>{
          console.log(res)
          if(res.code === '0'){
            this.$message({
              type: "success",
              message: "更新成功"
            })
          } else {
            this.$message({
              type: "error",
              message: res.msg
            })
          }
          this.load() //更新表格数据
          this.dialogVisible = false //关闭弹窗
        })
      }else {
        //新增数据
        request.post("/user",this.form).then(res =>{
          console.log(res)
          if(res.code === '0'){
            this.$message({
              type: "success",
              message: "新增成功"
            })
          }else {
            this.$message({
              type: "error",
              message: res.msg
            })
          }
          this.load() //更新表格数据
          this.dialogVisible = false //关闭弹窗
        })
      }
    },
    //编辑数据
    handleEdit(row){
      //单行赋值
      this.form = JSON.parse(JSON.stringify(row))
      this.dialogVisible = true
    },
    //删除数据
    handleDelete(id){
      console.log(id)
      request.delete("/user/" + id).then(res => {
        if(res.code === '0'){
          this.$message({
            type: "success",
            message: "删除成功"
          })
        }else {
          this.$message({
            type: "error",
            message: res.msg
          })
        }
        this.load() //更新表格数据
      })
    },
    //改变当前每页个数触发
    handleSizeChange(pageSize){
      this.pageSize = pageSize
      this.load()
    },
    //改变当前页码触发
    handleCurrentChange(pageNum){
      this.currentPage = pageNum
      this.load()
    }
  }
}

</script>


