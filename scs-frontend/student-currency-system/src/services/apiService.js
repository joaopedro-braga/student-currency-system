import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/api';

const apiService = axios.create({
  baseURL: API_BASE_URL,
});

apiService.interceptors.request.use(
  (config) => {
    const token = localStorage.getItem('token');
    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);

apiService.interceptors.response.use(
  (response) => response,
  (error) => {
    if (error.response) {
      if (error.response.status === 401) {
        localStorage.removeItem('token');
        window.location.href = '/sign-in'; 
      }
      return Promise.reject(error.response);
    } else if (error.request) {
      console.error('Nenhuma resposta do servidor:', error.request);
      return Promise.reject(error);
    } else {
      console.error('Erro na requisição:', error.message);
      return Promise.reject(error);
    }
  }
);


export default apiService;