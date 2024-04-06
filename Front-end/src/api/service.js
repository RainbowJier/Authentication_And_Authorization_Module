import axios from "axios";
import useEnvVariables from "@/hook/useEnvVariables.js";
import { ElMessage } from "element-plus";

// Get service API URL from environment variables
const { serviceApi } = useEnvVariables();

// Create Axios instance with base URL and timeout
const http = axios.create({
  baseURL: serviceApi.value,
  timeout: 1000,
  headers: {
    "Content-Type": "application/json", // Set default content type
  },
});

// Request interceptor
http.interceptors.request.use(
  (config) => {
    // Add Authorization header to requests except for registering and logging in.
    if (
      !(
        config.url.includes("/user/register") ||
        config.url.includes("/user/login")
      )
    ) {
      config.headers.token = localStorage.getItem("token"); // Add token to header using the Bearer scheme
    }
    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);

// Response interceptor
// http.interceptors.response.use(
//   (response) => {
//     console.log(response.data);
//     // Handle successful responses
//     if (response.data.code) {
//       return response.data.data;
//     } else {
//       // Handle error responses, display error message
//       ElMessage.error(response.data.message || "请求失败");
//       return Promise.reject(new Error(response.data.message));
//     }
//   },
//   (error) => {
//     // Handle HTTP request errors
//     ElMessage.error("网络异常，请稍后再试！");
//     return Promise.reject(error);
//   }
// );

// API object containing HTTP request methods
const api = {
  // GET request wrapper
  get(url, config = {}) {
    return http.get(url, config);
  },

  // POST request wrapper
  post(url, data = {}, config = {}) {
    return http.post(url, data, config);
  },

  // PUT request wrapper
  put(url, data = {}, config = {}) {
    return http.put(url, data, config);
  },

  // DELETE request wrapper
  delete(url, config = {}) {
    return http.delete(url, config);
  },
};

export default api;
