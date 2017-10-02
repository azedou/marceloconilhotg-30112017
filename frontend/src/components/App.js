// ./src/components/App.js
import React  from 'react';
import {Link} from 'react-router';

const App = (props) => {
  return (
    <div >
      <nav >
        <div >
          <div >
            <h1>Endpoints</h1>
          </div>
          <div >
            <ul >
              <li><Link to="/">Home</Link></li>
              <li><Link to="/students">Students</Link></li>
            </ul>
          </div>
        </div>
      </nav>
      {/* Each smaller components */}
      {props.children}
    </div>
  );
};

export default App