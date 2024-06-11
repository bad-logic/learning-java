import { useEffect, useRef, useState } from 'react';
import './post.scss';

export interface IPost {
  id: number;
  title: string;
  author: string;
  content: string;
}

export interface IPostProps {
  post: IPost;
}

const Post: React.FC<IPostProps> = ({ post }) => {
  const [clicked, setClicked] = useState(false);
  const postRef = useRef(null);

  useEffect(() => {
    document.addEventListener('mousedown', handleOutsideClick);
    return () => {
      document.removeEventListener('mousedown', handleOutsideClick);
    };
  });

  const handleOutsideClick = (e: MouseEvent) => {
    if (postRef.current && !postRef?.current?.contains(e.target)) {
      setClicked(false);
    }
  };

  const handlePostClick = () => {
    setClicked(!clicked);
  };
  return (
    <div className="post" onClick={handlePostClick} ref={postRef}>
      <span className="post-title">{post.title}</span>
      <span className="post-author">-- {post.author}</span>
      <p className="post-content">{post.content}</p>

      {clicked && (
        <div className="post-btns">
          <button>edit</button>
          <button>delete</button>
        </div>
      )}
    </div>
  );
};

export default Post;
