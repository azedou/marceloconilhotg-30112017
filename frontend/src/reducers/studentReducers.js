import {
  LOAD_ALL_STUDENTS_SUCCESS,
  GENERATE_STUDENT_CERTIFICATE_SUCCESS,
  ADD_STUDENT_SUCCESS
} from '../actions/actionType';

export default (state = [], action) => {
  switch (action.type) {
    case 'LOAD_ALL_STUDENTS_SUCCESS':
          return action.students;
    case 'GENERATE_STUDENT_CERTIFICATE_SUCCESS':
          return action.certificate;
    case 'ADD_STUDENT_SUCCESS':
          return action.certificate;
    default:
          return state;
  }
};