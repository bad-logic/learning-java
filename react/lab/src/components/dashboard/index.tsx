import { useState } from 'react';
import Posts from '../posts';

import './dashboard.scss';
import { IPost } from '../posts/post';

const Dashboard: React.FC = () => {
  const [title, setTitle] = useState('');
  const [data, setData] = useState<IPost[]>(() => {
    return [
      {
        id: 111,
        author: 'John',
        content: 'This is the first post from john',
        title: 'my first post',
      },
      {
        id: 112,
        author: 'Dean',
        content: 'This is the first post from dean',
        title: 'my first post',
      },
      {
        id: 113,
        author: 'Marry',
        content: 'This is the first post from Marry',
        title: 'my first post',
      },
    ];
  });

  const updateTitleForFirstElement = () => {
    setData((data) => {
      const newData = [...data];
      newData[0].title = title;
      return newData;
    });
    setTitle('');
  };

  return (
    <div className="dashboard">
      <div className="dashboard-form">
        <input
          name="title"
          value={title}
          onChange={(e) => setTitle(e.target.value)}
          placeholder="change title for the first post"
        />
        <button onClick={updateTitleForFirstElement}>Save</button>
      </div>
      <Posts posts={data} />
    </div>
  );
};

export default Dashboard;
