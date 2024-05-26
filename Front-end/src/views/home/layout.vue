<!--  -->
<template>
    <div class='h-screen flex flex-col'>
        <!-- header -->
        <div class="bg-slate-400">
            <f-header></f-header>
        </div>
        <div class="basis-full  flex flex-row  bg-gray-100">
            <!-- left side -->
            <div class="bg-white">
                <f-menu></f-menu>
            </div>

            <!-- router-views -->
            <div class="basis-full overflow-y-auto flex items-center justify-center">
                <router-view></router-view>
            </div>
        </div>
    </div>
</template>

<script setup>
import FHeader from "@/components/home/Header.vue"
import FMenu from "@/components/home/Menu.vue"
import FTaglist from "@/components/home/TagList.vue"

import { useRouter } from 'vue-router'
import { useCookies } from '@vueuse/integrations/useCookies'
import { useUsersStore } from "@/stores/user.js"


// Data
const userStore = useUsersStore()
const cookies = useCookies()
const router = useRouter()

const userInfo = userStore.GET_USERINFO()

// Methods




</script>
