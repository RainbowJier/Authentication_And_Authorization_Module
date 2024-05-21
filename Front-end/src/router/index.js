import { createRouter, createWebHistory } from "vue-router";

const routes = [
  {
    path: "",
    component: () => import("@/views/login/layout.vue"),
    children: [
      {
        path: "",
        name: "login",
        component: () => import("@/components/login/login.vue"),
      },
      {
        path: "/register",
        component: () => import("@/components/login/register.vue"),
      },
    ],
  },
  {
    path: "/index",
    component: () => import("@/views/index/layout.vue"),
    children: [
      {
        path: "/main",
        component: () => import("@/components/main/main.vue"),
      },
    ],
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

// 注册全局前置守卫
// token exsists
// router.beforeEach((to, from, next) => {
//   if (!localStorage.getItem("token")) {
//     if (to.path == "/" || to.path == "/register") {
//       next();
//     } else {
//       next("/");
//     }
//   } else {
//     next();
//   }
// });

export default router;
