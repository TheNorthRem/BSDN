<template>
  <div v-if="showLogin">
    <el-row v-if="success">
      <el-col :sm="12" :lg="6">
        <el-result icon="success" title="成功提示" sub-title="请根据提示进行操作">
          <template slot="extra">
            <el-button type="primary" size="medium">返回</el-button>
          </template>
        </el-result>
      </el-col>
    </el-row>
    <el-form ref="ruleForm" :model="ruleForm" status-icon :rules="rules" label-width="100px" class="demo-ruleForm">
      <el-form-item label="用户名" prop="pass">
        <el-input v-model="ruleForm.username" type="text" autocomplete="off" />
      </el-form-item>
      <el-form-item label="密码" prop="checkPass">
        <el-input v-model="ruleForm.password" type="password" autocomplete="off" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">注册</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { register } from '@/api/Login/register'

export default {
  data() {
    var username = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入用户名'))
      } else {
        if (this.ruleForm.checkPass >= 6 && this.ruleForm.checkPass <= 10) {
          this.$refs.ruleForm.validateField('checkPass')
        }
        callback()
      }
    }
    var password = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'))
      } else {
        callback()
      }
    }
    return {
      showLogin: true,
      success: false,
      ruleForm: {
        username: '',
        password: ''
      },
      token: {
        data: ''
      },
      rules: {
        pass: [
          { validator: username, trigger: 'blur' }
        ],
        checkPass: [
          { validator: password, trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          register(this.ruleForm).then(res => {
            // localStorage.setItem('token', res.data.token)
            this.showLogin = false
            this.$message({
              type: 'success',
              message: '注册成功'
            })
          }
          )
        } else {
          console.log('error submit!!')
          return false
        }
      })
    },
    resetForm(formName) {
      this.$refs[formName].resetFields()
    }
  }
}

</script>

  <style>
  .el-form {
    text-align: center;
    background-color: #fff;
    width: 50%;
    height: 50%;
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%);
  }
  </style>
