<template>
  <div style="width: 100%;height: 100vh;background-color: darkslateblue;overflow:hidden;">
    <div style="width: 400px;margin: 150px auto;">
      <div style="color: #cccccc;font-size: 30px;text-align: center;padding-bottom: 20px;">欢迎注册</div>
      <el-form ref="form" :model="form" :rules="rules" size="medium">
        <el-form-item style="" size="medium" prop="username">
          <el-icon color="#cccccc" size="35">
            <promotion/>
            :
          </el-icon>
          <el-input
              clearable
              v-model="form.username"
              placeholder="请输入用户名"
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
        <el-form-item style="" size="medium" prop="confirm">
          <el-icon color="#cccccc" size="35">
            <sugar/>
            :
          </el-icon>
          <el-input
              clearable
              show-password
              v-model="form.confirm"
              type="password"
              placeholder="请再次输入密码"
          />
        </el-form-item>
        <el-button style="width: 100%;margin-top: 30px;" type="primary" @click="register">注册</el-button>
        <br>
        <el-button style="width: 100%;margin-top: 30px;" type="primary" @click="$router.push('/login')">登录</el-button>
      </el-form>
    </div>
  </div>
</template>

<script>

import request from "../utils/request";
import key from "@element-plus/icons-vue/dist/es/key.mjs";
import promotion from "@element-plus/icons-vue/dist/es/promotion.mjs";
import sugar from "@element-plus/icons-vue/dist/es/sugar.mjs";


export default {
  name: "Login",
  components: {
    key, promotion, sugar
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
        confirm: [
          {required: true, message: '请2次输入密码', trigger: 'blur'},
          {min: 3, max: 10, message: '长度在3到10个字符', trigger: 'blur'}
        ],
      }
    }
  },
  methods: {
    register() {

      if (this.form.password !== this.form.confirm) {
        this.$message({
          type: "error",
          message: '2次输入密码不一致'
        })
        return
      }
      this.$refs['form'].validate((valid) => {
        if (valid) {
          request.post("/user/register", this.form).then(res => {
            console.log(res)
            if (res.code === '0') {
              this.$message({
                type: "success",
                message: "注册成功"
              })
              this.$router.push("/login")  //登录成功后进行页面跳转,跳转到主页
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