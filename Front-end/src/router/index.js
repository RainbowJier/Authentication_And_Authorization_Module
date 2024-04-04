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
        path: "/",
        component: () => import("@/components/main/main.vue"),
      },
    ],
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
