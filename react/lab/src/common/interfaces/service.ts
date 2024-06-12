import { Operation } from 'fast-json-patch';

export interface Service<R, D, I> {
  create(data: D): Promise<R>;
  getAll(): Promise<R[]>;
  get(id: I): Promise<R>;
  delete(id: I): Promise<void>;
  patch(id: I, data: Operation[]): Promise<void>;
}
