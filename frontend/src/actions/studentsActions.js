import * as types from './actionType';
import Axios from 'axios';
import Blob from 'blob';
import fileDownload from 'react-file-download';
import {PROD, DEV, BASE_API_URL, BASE_MOCKED_API_URL} from '../constants'
import {ALL_STUDENTS_ENDPOINT,
    GENERATE_STUDENT_CERTIFICATE_ENDPOINT,
    ADD_STUDENT_ENDPOINT
    } from './studentsConstants'
import {
    LOAD_ALL_STUDENTS,
    LOAD_ALL_STUDENTS_ERROR,
    LOAD_ALL_STUDENTS_SUCCESS,
    ADD_STUDENT,
    ADD_STUDENT_ERROR,
    ADD_STUDENT_SUCCESS
    } from './actionType';

var configHeaderMock ={ headers: { 'x-api-key': '9101623f031545f3bf47a7a101387c34' } };


// Sync Action
export const addStudentSuccess = () => {
  return {
    type: 'ADD_STUDENT'
  }
};

//Async Action
export const addStudent = (student) => {
  let url;
     url = BASE_API_URL + ADD_STUDENT_ENDPOINT;
  // Returns a dispatcher function
  // that dispatches an action at a later time
  return (dispatch) => {
    // Returns a promise
    return Axios.post(url, student)
      .then(response => {
        console.log(response);
        // Dispatch another action
        // to consume data
        dispatch(addStudentSuccess())
      })
      .catch(error => {
        throw(error);
      });
  };
};

// Sync Action
export const fetchStudentsSuccess = (students) => {
  return {
    type: 'LOAD_ALL_STUDENTS_SUCCESS',
    students
  }
};

//Async Action
export const fetchStudents = () => {
  let url;
     url = BASE_API_URL + ALL_STUDENTS_ENDPOINT;
  // Returns a dispatcher function
  // that dispatches an action at a later time
  return (dispatch) => {
    // Returns a promise
    return Axios.get(url, configHeaderMock)
      .then(response => {
        // Dispatch another action
        // to consume data
        dispatch(fetchStudentsSuccess(response.data))
      })
      .catch(error => {
        throw(error);
      });
  };
};