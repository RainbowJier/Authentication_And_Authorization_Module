import { ref } from "vue";

// Define the useEnvVariables function
export default function useEnvVariables() {
  // Create ref to store the values of environment variables
  const port = ref(import.meta.env.VITE_APP_PORT);
  const baseApi = ref(import.meta.env.VITE_APP_BASE_API);
  const baseFileApi = ref(import.meta.env.VITE_APP_BASE_FILE_API);
  const serviceApi = ref(import.meta.env.VITE_APP_SERVICE_API);

  // Return the values of environment variables
  return {
    port,
    baseApi,
    baseFileApi,
    serviceApi,
  };
}
