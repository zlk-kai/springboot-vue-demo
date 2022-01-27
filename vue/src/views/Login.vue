<template>
  <div style="width: 100%;height: 100vh;background-color: darkslateblue;overflow:hidden;">
    <div style="width: 400px;margin: 150px auto;">
      <div style="color: #cccccc;font-size: 30px;text-align: center;padding-bottom: 20px;">欢迎登录</div>
      <el-form ref="form" :model="form" size="medium" :rules="rules">
        <el-form-item prop="username">
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
        <el-form-item prop="password">
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
        <el-button style="width: 100%;margin-top: 30px;" type="primary" @click="login">登录</el-button>
        <br>
        <el-button style="width: 100%;margin-top: 30px;" type="primary" @click="$router.push('/Register')">注册
        </el-button>
      </el-form>
    </div>
  </div>
</template>

<script>
import avatar from "@element-plus/icons-vue/dist/es/avatar.mjs";
import request from "../utils/request";
import key from "@element-plus/icons-vue/dist/es/key.mjs";

export default {
  name: "Login",
  components: {
    avatar, key
  },
  data() {
    return {
      form: {},
      rules: {
        username: [
          {required: true, message: '请输入用户名', trigger: 'blur'},
          {min: 3, max: 10, message: '长度在3到10个字符', trigger: 'blur'}
        ],
        password: [
          {required: true, message: '请输入密码', trigger: 'blur'},
          {min: 3, max: 10, message: '长度在3到10个字符', trigger: 'blur'}
        ],
      }
    }
  },
  methods: {
    login() {
      this.$refs['form'].validate((valid) => {
        if (valid) {
          request.post("/user/login", this.form).then(res => {
            console.log(res)
            if (res.code === '0') {
              this.$message({
                type: "success",
                message: "登录成功"
              })
              sessionStorage.setItem("user",JSON.stringify(res.data))  //缓存用户信息
              this.$router.push("/")  //登录成功后进行页面跳转,跳转到主页
            } else {
              this.$message({
                type: "error",
                message: res.msg
              })
            }
          })
        }
      })

    }
  },
}
</script>

<style scoped>

</style>