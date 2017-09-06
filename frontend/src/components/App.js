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
              <li><Link to="/students">/students</Link></li>
              <li><Link to="/about">About</Link></li>
              <li><Link to="/books">Book</Link></li>
              <li><Link to="/cart">Cart</Link></li>
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