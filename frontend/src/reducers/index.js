// ./src/reducers/index.js
import {createStore, combineReducers, compose, applyMiddleware} from 'redux';
import thunk from 'redux-thunk';
import books from './bookReducers';
import students from './studentReducers';
import { reducer as reduxFormReducer } from 'redux-form';

export default combineReducers({
  books: books,
  students: students,
  form: reduxFormReducer
});

const store = createStore(compose(applyMiddleware(thunk)));