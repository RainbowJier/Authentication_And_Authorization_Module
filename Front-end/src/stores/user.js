import { defineStore } from "pinia";

// 第一个参数是应用程序中 store 的唯一 id
export const useUsersStore = defineStore("users", {
  state: () => {
    return {
      userInfo: {},
    };
  },
  actions: {
    SET_USERINFO(userInfo) {
      this.userInfo = userInfo;
    },
    GET_USERINFO() {
      return this.userInfo;
    },
  },
});
