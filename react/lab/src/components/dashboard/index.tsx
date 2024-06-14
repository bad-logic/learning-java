import Posts from '../posts';
import PostForm from '../posts/createPost';

import './dashboard.scss';

const Dashboard: React.FC = () => {
  return (
    <div className="dashboard">
      <PostForm />
      <Posts />
    </div>
  );
};

export default Dashboard;
