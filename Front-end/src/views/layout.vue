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

                <button class="btn mr-3  rounded-full  bg-red-500 text-white hover:bg-red-400 ">
                    Log In
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
                        <li><a>Logout</a></li>
                    </ul>
                </div>
            </div>
        </div>

        <!-- main -->
        <div class="flex-1 flex bg-green-600">
            <!-- left side -->
            <div class="w-1/4 bg-gray-500">01</div>

            <!-- contents (fills remaining space) -->
            <div class="flex-1 bg-gray-800">02</div>

            <!-- other -->
            <div class="w-1/4 bg-yellow-300"> 0</div>
        </div>
    </div>
</template>

<script>
//这里可以导入其他文件（比如：组件，工具js，第三方插件js，json文件，图片文件等等）
//例如：import 《组件名称》 from '《组件路径》';

export default {
    name: '',
    //import引入的组件需要注入到对象中才能使用
    components: {},
    props: {},
    data() {
        //这里存放数据
        return {

        };
    },
    //监听属性 类似于data概念
    computed: {},
    //监控data中的数据变化
    watch: {},
    //方法集合
    methods: {

    },
    //生命周期 - 创建完成（可以访问当前this实例）
    created() {

    },
    //生命周期 - 挂载完成（可以访问DOM元素）
    mounted() {

    },
    //生命周期 - 创建之前
    beforeCreate() { },
    //生命周期 - 挂载之前
    beforeMount() { },
    //生命周期 - 更新之前
    beforeUpdate() { },
    //生命周期 - 更新之后
    updated() { },
    //生命周期 - 销毁之前
    beforeDestroy() { },
    //生命周期 - 销毁完成
    destroyed() { },
    //如果页面有keep-alive缓存功能，这个函数会触发
    activated() { },
}
</script>
<style scoped></style>