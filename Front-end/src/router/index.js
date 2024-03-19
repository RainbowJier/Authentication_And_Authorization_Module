import { createRouter, createWebHistory } from "vue-router";

const routes = [
  {
    path: "/",
    component: () => import("@/views/layout.vue"),
  },
  {
    path: "/login",
    component: () => import("@/views/login.vue"),
  },
  {
    path: "/register",
    component: () => import("@/views/register.vue"),
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
