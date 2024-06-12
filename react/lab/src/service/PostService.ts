import { Backend } from '../common/http';
import { Service } from '../common/interfaces/service';
import { networks } from '../common/config';
import { CreatePost, Post } from '../common/types/post';
import { Operation } from 'fast-json-patch';

class PostService implements Service<Post, CreatePost, string> {
  create(data: CreatePost): Promise<Post> {
    return Backend.apply({ ...networks.backendService.endpoints.post.addPost, data: data });
  }

  getAll(): Promise<Post[]> {
    return Backend.apply({ ...networks.backendService.endpoints.post.getAll });

    // return Promise.resolve([
    //   {
    //     id: '111',
    //     author: 'John',
    //     content: 'This is the first post from john',
    //     title: 'my first post',
    //   },
    //   {
    //     id: '112',
    //     author: 'Dean',
    //     content: 'This is the first post from dean',
    //     title: 'my first post',
    //   },
    //   {
    //     id: '113',
    //     author: 'Marry',
    //     content: 'This is the first post from Marry',
    //     title: 'my first post',
    //   },
    // ]);
  }

  get(id: string): Promise<Post> {
    const config = { ...networks.backendService.endpoints.post.getSingle };
    config.url = config.url.replace('{id}', id);
    return Backend.apply(config);
  }

  delete(id: string): Promise<void> {
    const config = { ...networks.backendService.endpoints.post.deletePost };
    config.url = config.url.replace('{id}', id);
    return Backend.apply(config);
  }

  patch(id: string, data: Operation[]): Promise<void> {
    const config = { ...networks.backendService.endpoints.post.updatePost, data: data };
    config.url = config.url.replace('{id}', id);
    return Backend.apply(config);
  }
}

export default new PostService();
