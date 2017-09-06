// ./src/reducers/index.js
import { combineReducers } from 'redux';
import books from './bookReducers';
import students from './studentReducers';

export default combineReducers({
  books: books,
  students: students,
});