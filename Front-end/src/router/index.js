import { createRouter, createWebHistory } from "vue-router";

const routes = [
  {
    path: "/",
    component: () => import("@/views/login.vue"),
  },
  {
    path: "/register",
    component: () => import("@/views/register.vue"),
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
router.beforeEach((to, from, next) => {
  // token exsists
  if (!localStorage.getItem("token")) {
    if (to.path == "/" || to.path == "/register") {
      next();
    } else {
      next("/");
    }
  } else {
    next();
  }
});

export default router;
