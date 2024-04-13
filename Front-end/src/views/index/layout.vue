<!--  -->
<template>
    <div class='h-screen flex flex-col'>
        <!-- Header -->
        <div class="w-full h-14 flex justify-between">
            <div class="w-1/4 flex justify-start items-center ml-10 to-blue-200">
                <button class="text-xl font-bold text-red-500">Rainbow</button>
            </div>

            <!-- Search -->
            <div class="flex-1 flex justify-center items-center ">
                <label class="w-3/5 h-10  rounded-full input input-bordered flex items-center gap-2 ">
                    <input type="text" class="grow" placeholder="Search" />
                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" fill="currentColor"
                        class="w-4 h-4 opacity-70">
                        <path fill-rule="evenodd"
                            d="M9.965 11.026a5 5 0 1 1 1.06-1.06l2.755 2.754a.75.75 0 1 1-1.06 1.06l-2.755-2.754ZM10.5 7a3.5 3.5 0 1 1-7 0 3.5 3.5 0 0 1 7 0Z"
                            clip-rule="evenodd" />
                    </svg>
                </label>
            </div>
            <!-- Options -->
            <div class="w-1/4 flex justify-end items-center ">
                <button class="btn mr-3  rounded-full ">Setting</button>

                <button class="btn mr-3  rounded-full  bg-red-500 text-white hover:bg-red-400 " @click="logout">
                    Log out
                </button>

                <!-- others -->
                <div class="dropdown dropdown-end rounded-full mr-3">
                    <div tabindex="0" role="button" class="btn btn-ghost btn-circle">
                        ...
                    </div>
                    <ul tabindex="0"
                        class="mt-3 z-[1] p-2 shadow menu menu-sm dropdown-content bg-base-100 rounded-box w-52">
                        <li>
                            <a class="justify-between">
                                Profile
                                <span class="badge">New</span>
                            </a>
                        </li>
                        <li><a>Settings</a></li>
                    </ul>
                </div>
            </div>
        </div>

        <!-- main -->
        <div class="flex-1 flex bg-green-600">
            <!-- left side -->
            <div class="w-1/4 bg-gray-500">side</div>

            <!-- router-views -->
            <router-view></router-view>
        </div>
    </div>
</template>

<script setup>
import api from "@/api/service.js";
import { useRouter } from 'vue-router'
// Data
const router = useRouter()

// Methods
const logout = () => {
    api.get('/user/logout')
        .then(response => {
            console.log(response.data)
            if (response.data.code == 200) {
                ElNotification({
                    title: 'Success',
                    message: 'Logout Successfully',
                    type: 'success',
                })
                //Delete token from LocalStorage
                localStorage.removeItem("token")
                // Push to login page.
                router.push("/")
            } else {
                ElNotification({
                    title: 'Error',
                    message: 'The system encountered an error. Please reach out to the manager for assistance.',
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
