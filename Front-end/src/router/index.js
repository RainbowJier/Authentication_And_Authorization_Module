import { createRouter, createWebHistory } from "vue-router";
import { useCookies } from "@vueuse/integrations/useCookies";

const routes = [
  {
    path: "/",
    component: () => import("@/views/login/layout.vue"),
    children: [
      {
        path: "/",
        component: () => import("@/components/login/login.vue"),
        meta: {
          title: "登录页面",
        },
      },
      {
        path: "/register",
        component: () => import("@/components/login/register.vue"),
        meta: {
          title: "注册页面",
        },
      },
    ],
  },
  {
    path: "/index",
    component: () => import("@/views/home/layout.vue"),
    meta: {
      title: "商城后台",
    },
    children: [
      {
        path: "",
        component: () =>
          import("@/components/home/system_panel/system_panel.vue"),
      },
      {
        path: "/system_management_role",
        meta: {
          title: "角色管理",
        },
        component: () => import("@/components/home/system_management/role.vue"),
      },
      {
        path: "/system_management_user",
        meta: {
          title: "角色管理",
        },
        component: () => import("@/components/home/system_management/user.vue"),
      },
      {
        path: "/system_management_menu",
        meta: {
          title: "菜单管理",
        },
        component: () => import("@/components/home/system_management/menu.vue"),
      },
    ],
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

const cookies = useCookies();

// 注册全局前置守卫
// token exsists
// router.beforeEach((to, from, next) => {
//   // Page dynamic title.
//   document.title = to.meta.title ? to.meta.title : "";

//   // Token
//   if (!cookies.get("admin-token")) {
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
