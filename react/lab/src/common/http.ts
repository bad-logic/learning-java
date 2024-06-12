import axios, { AxiosRequestConfig, AxiosResponse, AxiosInstance } from 'axios';
import { backendServiceBaseUrl } from './config';
import { HttpException } from './exception';

class Http {
  static async apply<D>(instance: AxiosInstance, config: AxiosRequestConfig): Promise<D> {
    const response: AxiosResponse<D> = await instance.request<D>(config);
    if ([200, 201].includes(response.status)) {
      return response.data;
    }
    throw new HttpException(response);
  }
}

export class Backend {
  private constructor() {}

  private static axiosInstance = axios.create({
    baseURL: backendServiceBaseUrl,
    timeout: 3000,
  });

  static async apply<D>(config: AxiosRequestConfig): Promise<D> {
    // eslint-disable-next-line no-useless-catch
    try {
      return Http.apply<D>(Backend.axiosInstance, config);
    } catch (err) {
      // your logic to handle errors
      throw err;
    }
  }
}
