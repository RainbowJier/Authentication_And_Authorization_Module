<template>
    <!-- 输入框 -->
    <div class="bg-base-100 w-1/2 h-full rounded-r-3xl flex flex-col">
        <!-- Sign up -->
        <div class="basis-1/6 flex justify-center items-center">
            <h2 class="text-2xl">欢迎回来</h2>
        </div>
        <!-- 用户名 -->
        <div class="basis-1/6 flex justify-center items-center">
            <label class="w-3/5 input input-bordered flex items-center gap-2">
                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" fill="currentColor"
                    class="w-4 h-4 opacity-70">
                    <path
                        d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6ZM12.735 14c.618 0 1.093-.561.872-1.139a6.002 6.002 0 0 0-11.215 0c-.22.578.254 1.139.872 1.139h9.47Z" />
                </svg>
                <input type="text" class="grow" placeholder="用户名" v-model="user.userName" />
            </label>
        </div>
        <!-- password -->
        <div class="basis-1/6  w-full flex justify-center items-center">
            <label class="w-3/5 input input-bordered flex items-center gap-2">
                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" fill="currentColor"
                    class="w-4 h-4 opacity-70">
                    <path fill-rule="evenodd"
                        d="M14 6a4 4 0 0 1-4.899 3.899l-1.955 1.955a.5.5 0 0 1-.353.146H5v1.5a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1-.5-.5v-2.293a.5.5 0 0 1 .146-.353l3.955-3.955A4 4 0 1 1 14 6Zm-4-2a.75.75 0 0 0 0 1.5.5.5 0 0 1 .5.5.75.75 0 0 0 1.5 0 2 2 0 0 0-2-2Z"
                        clip-rule="evenodd" />
                </svg>
                <input type="password" class="grow " placeholder="密码" v-model="user.password" />
            </label>
        </div>
        <!-- Login -->
        <div class="basis-1/6  w-full flex justify-center items-center">
            <button class="btn w-3/5 h-10 rounded-full bg-base-300" @click="login">登 录</button>
        </div>
        <!-- 第三方登录 -->
        <div class="basis-1/6  w-full flex justify-center items-center ">
            <button class="w-3/5 btn rounded-full  bg-base-300 ">忘记密码</button>
        </div>
        <!-- Register -->
        <router-link to='/register' class="basis-1/6 w-full flex justify-center items-center">
            <button class="btn-sm btn rounded-full bg-base-300">注册</button>
        </router-link>
    </div>
</template>

<script setup>
import api from "@/api/service.js"
import { useRouter } from 'vue-router'
import { useCookies } from '@vueuse/integrations/useCookies'
import { useUsersStore } from "@/stores/user.js"

// Data
const userStore = useUsersStore()
const cookies = useCookies()
const router = useRouter()


const user = reactive({
    userName: '',
    password: ''
})

// Methods
function login() {
    api.post('/user/login', user)
        .then(response => {
            // console.log(response.data)
            if (response.data.code == 200) {
                ElNotification({
                    title: 'Success',
                    message: 'Sign in Successfully',
                    type: 'success',
                })

                const storedToken = response.data.data.token
                const userInfo = response.data.data.userInfo

                // Store the userInfo into pinia.
                userStore.SET_USERINFO(userInfo)

                // Get userInfo
                // const userInfo = userStore.GET_USERINFO()
                // console.log(userInfo.name)

                // Store the token in the cookie.
                cookies.set("admin-token", storedToken)

                // Store token in the LocalStorage.
                // localStorage.setItem('token', response.data.data.token)
                // localStorage.getItem("token")

                // Push to index page.
                router.push("/index")
            } else {
                ElNotification({
                    title: 'Error',
                    message: 'Username or Password is incorrect.',
                    type: 'error',
                })
            }
        })
        .catch(error => {
            ElNotification({
                title: 'Error',
                message: 'The system encountered an error. Please reach out to the manager for assistance.',
                type: 'error',
            })
        });
}
</script>

<style lang="less" scoped></style>