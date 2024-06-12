import { useEffect, useState } from 'react';
import { Operation, compare } from 'fast-json-patch';

import Post from './post';
import PostService from '../../service/PostService';

import './posts.scss';

const Posts: React.FC = () => {
  const [posts, setPosts] = useState<Post[]>([]);
  const [selectedPost, setSelectedPost] = useState<Post | null>(null);

  useEffect(() => {
    PostService.getAll().then((data) => {
      setPosts(data);
    });
  }, []);

  const updatePostStateData = (field: 'title' | 'content', value: string) => {
    setSelectedPost((post) => {
      if (post != null) {
        return {
          ...post,
          [field]: value,
        };
      }
      return null;
    });
  };

  const [clicked, setClicked] = useState(false);

  const updatePost = async () => {
    if (selectedPost !== null) {
      const olderVersion = posts.filter((p) => p.id === selectedPost.id)[0];
      const payload: Operation[] = compare(olderVersion, selectedPost);
      await PostService.patch(selectedPost.id, payload);
    }
    setClicked(false);
  };

  const deletePost = async () => {
    if (selectedPost !== null) {
      await PostService.delete(selectedPost.id);
    }
    setClicked(false);
  };

  const onClick = (id: string) => {
    if (!clicked) {
      setClicked(true);
    }
    setSelectedPost(posts.filter((p) => p.id === id)[0]);
  };

  return (
    <div className="posts">
      <div className="posts-container">
        {posts.map((post) => {
          return <Post key={post.id} post={post} onClick={onClick} />;
        })}
      </div>

      {clicked && (
        <div className="post-editor">
          <div className="post-editor--close-btn" onClick={() => setClicked(false)}>
            x
          </div>
          <input
            name="title"
            value={selectedPost?.title}
            onChange={(e) => updatePostStateData('title', e.target.value)}
          ></input>
          <textarea
            name="content"
            value={selectedPost?.content}
            onChange={(e) => updatePostStateData('content', e.target.value)}
          ></textarea>
          <div className="post-btns">
            <button onClick={updatePost}>edit</button>
            <button onClick={deletePost}>delete</button>
          </div>
        </div>
      )}
    </div>
  );
};

export default Posts;
