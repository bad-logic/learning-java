export type CreatePost = {
  title: string;
  content: string;
  author: string;
};

export type Post = CreatePost & {
  id: string;
  author: string;
};
