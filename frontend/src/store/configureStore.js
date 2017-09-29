// ./src/store/configureStore.js
import {createStore, compose, combineReducers, applyMiddleware} from 'redux';
import { reducer as reduxFormReducer } from 'redux-form';
import rootReducer from '../reducers';
// Import thunk middleware
import thunk from 'redux-thunk';

const rootReducerCustom = combineReducers({
  form: reduxFormReducer, // mounted under "form"
});

export default function configureStore(initialState) {
  return createStore(rootReducer, initialState,
    // Apply to store
    applyMiddleware(thunk)
  );
}