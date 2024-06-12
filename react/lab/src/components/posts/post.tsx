import { type Post } from '../../common/types/post';
import './post.scss';

export interface IPostProps {
  post: Post;
  onClick: (id: string) => void;
}

const Post: React.FC<IPostProps> = ({ post, onClick }) => {
  return (
    <>
      <div className="post" onClick={() => onClick(post.id)}>
        <span className="post-title">{post.title}</span>
        <span className="post-author"> -- {post.author}</span>
        <p className="post-content">{post.content}</p>
      </div>
    </>
  );
};

export default Post;
