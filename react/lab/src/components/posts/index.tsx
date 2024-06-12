import Post, { IPost } from './post';
import './posts.scss';

export interface IPostsProps {
  posts: IPost[];
}

const Posts: React.FC<IPostsProps> = ({ posts }) => {
  return (
    <div className="posts-container">
      {posts.map((post) => {
        return <Post key={post.id} post={post} />;
      })}
    </div>
  );
};

export default Posts;
