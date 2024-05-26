<!--
 * 登录页面
 * @author: RainbowJier
 * @since: 2024-02-22
 * login.vue
-->
<template>
    <div class="bg-gray-200 flex justify-center items-center h-screen">
        <div class="flex w-1/2 h-3/5 shadow-lg rounded-3xl">
            <!-- left view -->
            <div class="w-1/2 h-full flex justify-center items-center ">
                <img src="@\assets\Login\loginPic.jpg" class="w-full h-full object-cover rounded-l-3xl">
            </div>

            <!-- login / register -->
            <router-view></router-view>
        </div>

    </div>
</template>

<script setup>


</script>
