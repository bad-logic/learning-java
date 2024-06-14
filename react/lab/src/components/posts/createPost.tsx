import { useRef } from 'react';

import './createPost.scss';
import PostService from '../../service/PostService';

const PostForm = () => {
  const titleRef = useRef<null | HTMLInputElement>(null);
  const authorRef = useRef<null | HTMLInputElement>(null);
  const contentRef = useRef<null | HTMLTextAreaElement>(null);

  const savePost = async () => {
    if (
      titleRef.current &&
      titleRef.current.value.trim() &&
      authorRef.current &&
      authorRef.current.value?.trim() &&
      contentRef.current &&
      contentRef.current.value?.trim()
    ) {
      await PostService.create({
        title: titleRef.current.value.trim(),
        author: authorRef.current.value.trim(),
        content: contentRef.current.value.trim(),
      });
    }
  };

  return (
    <>
      <div className="post-form">
        <h6>Create Post</h6>
        <label htmlFor="title">Title</label>
        <input name="title" ref={titleRef}></input>
        <label htmlFor="author">Author</label>
        <input name="author" ref={authorRef}></input>
        <label htmlFor="content">Content</label>
        <textarea name="content" ref={contentRef}></textarea>

        <button onClick={savePost}>save</button>
      </div>
    </>
  );
};

export default PostForm;
