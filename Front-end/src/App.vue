<template>
  <router-view v-if="isRouterAlive" />
</template>

<script>
// import login from "@/views/login.vue"
export default {
  name: 'App',
  provide() {
    return {
      reload: this.reload
    }
  },
  data() {
    return {
      isRouterAlive: true
    }
  },
  methods: {
    reload() {
      this.isRouterAlive = false;
      this.$nextTick(function () {
        this.isRouterAlive = true;
      });
    }
  },
  components: {
  }
}
</script>

<style scoped></style>
