<template>
  <div style="width: 100%;padding:10px;min-height: calc(100vh - 50px); ">
<!--   功能区-->
    <div style="margin: 10px 0;">
      <el-button type="primary">新增</el-button>
      <el-button type="primary">导入</el-button>
      <el-button type="primary">导出</el-button>
    </div>
<!--    搜索区-->
    <div style="margin: 10px 0;">
      <el-input v-model="search" style="width: 30%;" placeholder="输入关键字" />
      <el-button type="primary" style="margin: 2%;">搜索查询</el-button>
    </div>
  <el-table
      :data="tableData"
      stripe
      style="width: 100%">
    <el-table-column
        prop="date"
        sortable
        label="日期"
    />
    <el-table-column
        prop="name"
        label="名字"
    />
    <el-table-column
        prop="address"
        label="地址"
    />
    <el-table-column fixed="right" label="操作" >
      <template #default>
        <el-button type="success" @click="handleClick">编辑</el-button>
        <el-button type="danger" >删除</el-button>
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
    </div>
  </div>

</template>

<script>

export default {
  name: 'Home',
  components: {
  },
  data(){
    return{
      search: '',
      currentPage: 10,
      total: 10,
      tableData: [
        {
          date: '2022-05-03',
          name: 'Tom',
          address: 'No. 189, Grove St, Los Angeles',
        },
        {
          date: '2022-05-02',
          name: 'Tom',
          address: 'No. 189, Grove St, Los Angeles',
        },
        {
          date: '2022-05-04',
          name: 'Tom',
          address: 'No. 189, Grove St, Los Angeles',
        },
        {
          date: '2022-05-01',
          name: 'Tom',
          address: 'No. 189, Grove St, Los Angeles',
        },
      ]
    }
  }
}
</script>
