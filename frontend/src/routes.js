// ./src/routes.js
import React  from 'react';
import {Route, IndexRoute} from 'react-router';
import Home from './components/common/HomePage';
import Students from './components/students/StudentsPage'
import App from './components/App'

export default (
  <Route path="/" component={App}>
    <IndexRoute component={Home}></IndexRoute>
    <Route path="/students" component={Students}></Route>
  </Route>
);