<template>
  <div style="width: 100%;padding:10px;min-height: calc(100vh - 50px); ">
    <!--   功能区-->
    <div style="margin: 10px 0;">
      <el-button type="primary" @click="add">新增</el-button>
      <el-button type="primary" @click="add">导入</el-button>
      <el-button type="primary" @click="add">导出</el-button>
    </div>
    <!--    搜索区-->
    <div style="margin: 10px 0;">
      <el-input v-model="search" style="width: 30%;" placeholder="输入关键字"/>
      <el-button type="primary" style="margin: 2%;">搜索查询</el-button>
    </div>
    <el-table
        :data="tableData"
        stripe
        style="width: 100%">
      <el-table-column
          prop="id"
          sortable
          label="ID"
      />
      <el-table-column
          prop="username"
          label="用户名"
      />
      <el-table-column
          prop="nickName"
          label="昵称"
      />
      <el-table-column
          prop="age"
          label="年龄"
      />
      <el-table-column
          prop="username"
          label="性别"
      />
      <el-table-column
          prop="address"
          label="地址"
      />
      <el-table-column label="操作">
        <template #default>
          <el-button type="success" @click="handleClick">编辑</el-button>
          <el-button type="danger">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <div class="demo-pagination-block">
      <span class="demonstration"></span>
      <el-pagination
          v-model:currentPage="currentPage"
          :page-sizes="[10, 20, 30, 40]"
          :page-size="10"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
      >
      </el-pagination>

      <el-dialog v-model="dialogVisible" title="提示" width="30%">
        <el-form :model="form" label-width="120px;">
          <el-form-item label="用户名">
            <el-input v-model="form.username"></el-input>
          </el-form-item>
          <el-form-item label="昵 称">
            <el-input v-model="form.nickname"></el-input>
          </el-form-item>
          <el-form-item label="年 龄">
            <el-input v-model="form.age"></el-input>
          </el-form-item>
          <el-form-item label="性 别">
            <el-radio v-model="form.sex" label="1" size="large">男</el-radio>
            <el-radio v-model="form.sex" label="2" size="large">女</el-radio>
          </el-form-item>
          <el-form-item label="地 址">
            <el-input v-model="form.address"></el-input>
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
      total: 10,
      tableData: []
    }
  },
  methods: {
    add() {
      this.dialogVisible = true
      this.form = {}
    },
    save()  {
      request.post("/api/user",this.form).then(res =>{
        console.log(res)
      })
    }
  }
}
</script>
