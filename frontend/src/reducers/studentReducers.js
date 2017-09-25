import {
  LOAD_ALL_STUDENTS,
  LOAD_ALL_STUDENTS_ERROR,
  LOAD_ALL_STUDENTS_SUCCESS
} from '../actions/actionType';

export default (state = [], action) => {
  switch (action.type) {
    case 'LOAD_ALL_STUDENTS_SUCCESS':
          return action.students;
    default:
          return state;
  }
};