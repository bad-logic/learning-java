import { useEffect, useState, createContext } from 'react';
import { Operation, compare } from 'fast-json-patch';

import Post from './post';
import PostService from '../../service/PostService';

import './posts.scss';

type TContext = {
  post: Post | null;
  handlePostClicked: (p: Post) => void;
};

export const SelectedPostContext = createContext<TContext | null>(null);

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

  const handlePostClicked = (post: Post) => {
    if (!clicked) {
      setClicked(true);
    }
    setSelectedPost(post);
  };

  return (
    <SelectedPostContext.Provider value={{ post: selectedPost, handlePostClicked: handlePostClicked }}>
      <h6>List of Post</h6>
      <div className="posts">
        <div className="posts-container">
          {posts.map((post) => {
            return <Post key={post.id} post={post} />;
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
            <div className="post-editor--btns">
              <button onClick={updatePost}>edit</button>
              <button onClick={deletePost}>delete</button>
            </div>
          </div>
        )}
      </div>
    </SelectedPostContext.Provider>
  );
};

export default Posts;
