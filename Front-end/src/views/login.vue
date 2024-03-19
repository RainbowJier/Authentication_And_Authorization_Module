<!--
 * 登录页面
 * @author: RainbowJier
 * @since: 2024-02-22
 * login.vue
-->
<template>
    <div class="bg-base-300 flex justify-center items-center h-screen">
        <div class="flex w-1/2 h-3/5 ">
            <!-- 图片 -->
            <div class="bg-info w-1/2 h-full rounded-l-lg">
                <img src="@\assets\Login\loginPic.jpg" class="w-full h-full object-cover rounded-l-lg">
            </div>


            <!-- 输入框 -->
            <div class="bg-base-100 w-1/2 h-full rounded-r-lg">
                <!-- 用户名 -->
                <div class="w-full h-32 flex justify-center items-end">
                    <label class="w-3/5 input input-bordered flex items-center gap-2">
                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" fill="currentColor"
                            class="w-4 h-4 opacity-70">
                            <path
                                d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6ZM12.735 14c.618 0 1.093-.561.872-1.139a6.002 6.002 0 0 0-11.215 0c-.22.578.254 1.139.872 1.139h9.47Z" />
                        </svg>
                        <input type="text" class="grow" placeholder="用户名" />
                    </label>
                </div>
                <!-- 密码 -->
                <div class="w-full h-32 flex justify-center items-center">
                    <label class="w-3/5 input input-bordered flex items-center gap-2">
                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" fill="currentColor"
                            class="w-4 h-4 opacity-70">
                            <path fill-rule="evenodd"
                                d="M14 6a4 4 0 0 1-4.899 3.899l-1.955 1.955a.5.5 0 0 1-.353.146H5v1.5a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1-.5-.5v-2.293a.5.5 0 0 1 .146-.353l3.955-3.955A4 4 0 1 1 14 6Zm-4-2a.75.75 0 0 0 0 1.5.5.5 0 0 1 .5.5.75.75 0 0 0 1.5 0 2 2 0 0 0-2-2Z"
                                clip-rule="evenodd" />
                        </svg>
                        <input type="password" class="grow " placeholder="密码" />
                    </label>
                </div>
                <!-- 登录 -->
                <div class=" w-full h-20 flex justify-center items-center">
                    <button class="w-3/5 btn btn-active btn-neutral">登录</button>
                </div>
                <!-- 第三方登录 -->
                <div class="w-full h-20 flex justify-center items-center ">
                    <button class="w-3/5 btn btn-active bg-base-300">qq登录</button>
                </div>
                <div class="divider">OR</div>
                <!-- 注册 -->
                <router-link to='/register' class=" w-full h-20 flex justify-center items-center">
                    <button class="w-3/5 btn btn-active bg-base-300">注册</button>
                </router-link>

            </div>

        </div>

    </div>
</template>

<script>

export default {
    data() {
        return {

        };
    },
    methods: {

    }

}

</script>

<style scoped></style>
