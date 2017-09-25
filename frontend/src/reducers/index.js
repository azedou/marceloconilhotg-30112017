// ./src/reducers/index.js
import {createStore, combineReducers, compose, applyMiddleware} from 'redux';
import thunk from 'redux-thunk';
import books from './bookReducers';
import students from './studentReducers';

export default combineReducers({
  books: books,
  students: students,
});

const store = createStore(students,
    compose(applyMiddleware(thunk))
);