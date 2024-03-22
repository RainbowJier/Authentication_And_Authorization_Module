<!--
 * new page
 * @author: RainbowJier
 * @since: 2024-03-19
 * Register.vue
-->
<!--  -->
<template>

    <div class="bg-base-300 flex justify-center items-center h-screen">
        <div class="flex w-1/2 h-3/5  shadow-lg">
            <!-- 图片 -->
            <div class="bg-info w-1/2 h-full rounded-l-lg">
                <img src="@\assets\Login\loginPic.jpg" class="w-full h-full object-cover rounded-l-lg">
            </div>
            <!-- 输入框 -->
            <div class="bg-base-100 w-1/2 h-full flex flex-col rounded-r-lg">

                <!-- 用户名 -->
                <div class="basis-1/5 flex justify-center items-center">
                    <label class="w-3/5 input input-bordered flex items-center gap-2">
                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" fill="currentColor"
                            class="w-4 h-4 opacity-70">
                            <path
                                d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6ZM12.735 14c.618 0 1.093-.561.872-1.139a6.002 6.002 0 0 0-11.215 0c-.22.578.254 1.139.872 1.139h9.47Z" />
                        </svg>
                        <input type="text" class="grow" placeholder="Username" v-model="user.userName" />
                    </label>
                </div>
                <!-- 密码 -->
                <div class="basis-1/5 flex justify-center items-center ">
                    <label class="w-3/5 input input-bordered flex items-center gap-2">
                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" fill="currentColor"
                            class="w-4 h-4 opacity-70">
                            <path fill-rule="evenodd"
                                d="M14 6a4 4 0 0 1-4.899 3.899l-1.955 1.955a.5.5 0 0 1-.353.146H5v1.5a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1-.5-.5v-2.293a.5.5 0 0 1 .146-.353l3.955-3.955A4 4 0 1 1 14 6Zm-4-2a.75.75 0 0 0 0 1.5.5.5 0 0 1 .5.5.75.75 0 0 0 1.5 0 2 2 0 0 0-2-2Z"
                                clip-rule="evenodd" />
                        </svg>
                        <input type="password" class="grow" placeholder="Password" v-model="user.password" />
                    </label>
                </div>
                <!-- Email -->
                <div class="basis-1/5 flex justify-center items-center ">
                    <label class="w-3/5 input input-bordered flex items-center gap-2">
                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" fill="currentColor"
                            class="w-4 h-4 opacity-70">
                            <path
                                d="M2.5 3A1.5 1.5 0 0 0 1 4.5v.793c.026.009.051.02.076.032L7.674 8.51c.206.1.446.1.652 0l6.598-3.185A.755.755 0 0 1 15 5.293V4.5A1.5 1.5 0 0 0 13.5 3h-11Z" />
                            <path
                                d="M15 6.954 8.978 9.86a2.25 2.25 0 0 1-1.956 0L1 6.954V11.5A1.5 1.5 0 0 0 2.5 13h11a1.5 1.5 0 0 0 1.5-1.5V6.954Z" />
                        </svg>
                        <input type="text" class="grow" placeholder="Email" />
                    </label>
                </div>
                <!-- Verification code -->
                <!-- <div class="basis-1/5 flex justify-center items-center ">
                    <label class="w-3/5 input input-bordered flex items-center gap-2">
                        <input type="text" placeholder="Verification code" class="grow" />
                        <button>

                        </button>
                    </label>

                </div> -->
                <!-- Sign up -->
                <div class="basis-1/5 flex justify-center items-center">
                    <button class="w-3/5 btn btn-active bg-base-300" @click="register">Sign up</button>
                </div>


            </div>
        </div>
    </div>
</template>



<script setup>
// 导入需要的 API
import api from "@/api/service.js";
import { useRouter } from 'vue-router'
// Data
const router = useRouter()
const user = reactive({
    userName: '',
    password: ''
})


// Methods
const register = () => {
    api.post('/register', user)
        .then(response => {
            ElNotification({
                title: 'Success',
                message: 'Sign up Successfully',
                type: 'success',
            })
            router.push("/login")
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