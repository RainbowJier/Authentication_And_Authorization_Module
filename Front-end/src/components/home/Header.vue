<template>
    <div class="navbar">
        <div class="flex-1">
            <a class="btn btn-ghost text-xl">daisyUI</a>
        </div>
        <div class="flex-none gap-2">
            <div class="form-control">
                <input type="text" placeholder="Search" class="input input-bordered w-24 md:w-auto" />
            </div>
            <div class="dropdown dropdown-end">
                <div tabindex="0" role="button" class="btn btn-ghost btn-circle avatar">
                    <div class="w-10 rounded-full">
                        <img alt="Tailwind CSS Navbar component"
                            src="https://img.daisyui.com/images/stock/photo-1534528741775-53994a69daeb.jpg" />
                    </div>
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
                    <li @click="logout"><a>Logout</a></li>
                </ul>
            </div>
        </div>
    </div>
</template>

<script setup>
import { ref } from "vue"
import api from "@/api/service.js";
import { useRouter } from 'vue-router'
import { useCookies } from '@vueuse/integrations/useCookies'
import { useUsersStore } from "@/stores/user.js"

// Data
const userStore = useUsersStore()
const cookies = useCookies()
const router = useRouter()

const userInfo = userStore.GET_USERINFO()

// Methods
const logout = () => {
    api.get('/user/logout')
        .then(response => {
            if (response.data.code == 200) {
                ElNotification({
                    title: 'Success',
                    message: 'Logout Successfully',
                    type: 'success',
                })

                //Delete token from Cookies.
                cookies.remove("admin-token")

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

<style lang="less" scoped></style>