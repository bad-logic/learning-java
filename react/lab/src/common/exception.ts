import { AxiosResponse } from 'axios';

export class HttpException {
  private message: string;
  private response: AxiosResponse;

  constructor(response: AxiosResponse) {
    this.message = response.statusText;
    this.response = response;
  }

  getMessage() {
    return this.message;
  }

  getResponse() {
    return this.response;
  }
}
