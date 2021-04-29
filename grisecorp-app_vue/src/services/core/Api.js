import axios from 'axios';

const api = axios.create({
  baseURL: '/assets/data/grupo-etapa.json',
  timeout: 1000000,
});

api.interceptors.request.use(async (config) => {
  let token = '';
  if (token) {
    token = '';
  }

  return config;
});

api.interceptors.response.use(
  (response) => response,
  (error) => {
    if (error.response && Number(error.response.status) === 401) {

    }

    return Promise.reject(error.response);
  },
);

export default api;
