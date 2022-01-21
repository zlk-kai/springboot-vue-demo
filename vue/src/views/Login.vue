<template>
  <div style="width: 100%;height: 100vh;background-color: darkslateblue;overflow:hidden;">
    <div style="width: 400px;margin: 150px auto;">
      <div style="color: #cccccc;font-size: 30px;text-align: center;padding-bottom: 20px;">欢迎登录</div>
      <el-form ref="form" :model="form" size="medium">
        <el-form-item>
          <el-icon color="#cccccc" size="35">
            <avatar/>
            :
          </el-icon>
          <el-input
              clearable
              v-model="form.username"
              placeholder="请输入账号"
          />
        </el-form-item>
        <el-form-item style="" size="medium">
          <el-icon color="#cccccc" size="35">
            <key/>
            :
          </el-icon>
          <el-input
              clearable
              show-password
              v-model="form.password"
              type="password"
              placeholder="请输入密码"
          />
        </el-form-item>
        <el-button style="width: 100%;margin-top: 30px;" type="primary">登录</el-button>
        <br>
        <el-button style="width: 100%;margin-top: 30px;" type="primary" @click="login">注册</el-button>
      </el-form>
    </div>
  </div>
</template>

<script>
import avatar from "@element-plus/icons-vue/dist/es/avatar.mjs";
import key from "@element-plus/icons-vue/dist/es/lollipop.mjs";

export default {
  name: "Login",
  components: {
    avatar, key,age: '',
  },
  data() {
    return {
      form: {},
    }
  },
  methods: {
    login() {
      request.post("/user/login", this.form).then(res => {
        console.log(res)
        if (res.code === '0') {
          this.$message({
            type: "success",
            message: "登录成功"
          })
          this.$router.push("/")  //登录成功后进行页面跳转,跳转到主页
        } else {
          this.$message({
            type: "error",
            message: res.msg
          })
        }
        this.load() //更新表格数据
      })
    }
  },
}
</script>

<style scoped>

</style>