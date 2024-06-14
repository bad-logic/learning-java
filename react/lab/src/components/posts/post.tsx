import { useContext } from 'react';
import { type Post } from '../../common/types/post';
import './post.scss';
import { SelectedPostContext } from '.';

export interface IPostProps {
  post: Post;
}

const Post: React.FC<IPostProps> = ({ post }) => {
  const context = useContext(SelectedPostContext);
  if (!context) {
    throw new Error('Post must be wrapped by selected Post context');
  }
  return (
    <>
      <div className="post" onClick={() => context.handlePostClicked(post)}>
        <span className="post-title">{post.title}</span>
        <span className="post-author"> -- {post.author}</span>
        <p className="post-content">{post.content}</p>
      </div>
    </>
  );
};

export default Post;
