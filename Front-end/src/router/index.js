import { createRouter, createWebHistory } from "vue-router";
import { useCookies } from "@vueuse/integrations/useCookies";
const cookies = useCookies();
const routes = [
  {
    path: "/",
    component: () => import("@/views/login/layout.vue"),
    children: [
      {
        path: "/",
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
    component: () => import("@/views/home/layout.vue"),
    children: [
      {
        path: "/main",
        component: () => import("@/components/home/main.vue"),
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
router.beforeEach((to, from, next) => {
  if (!cookies.get("admin-token")) {
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
