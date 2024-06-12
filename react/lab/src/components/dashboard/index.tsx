import Posts from '../posts';

import './dashboard.scss';

const Dashboard: React.FC = () => {
  return (
    <div className="dashboard">
      <h5>Posts</h5>
      <Posts />
    </div>
  );
};

export default Dashboard;
