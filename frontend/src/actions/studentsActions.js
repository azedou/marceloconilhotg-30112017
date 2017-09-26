import * as types from './actionType';
import Axios from 'axios';
import {PROD, DEV, BASE_API_URL, BASE_MOCKED_API_URL} from '../constants'
import {ALL_STUDENTS_ENDPOINT} from './studentsConstants'
import {
    LOAD_ALL_STUDENTS,
    LOAD_ALL_STUDENTS_ERROR,
    LOAD_ALL_STUDENTS_SUCCESS
    } from './actionType';

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
  if(DEV === process.env.NODE_ENV){
    console.log("DEV ENV !!!!!!!");
     url = BASE_MOCKED_API_URL + ALL_STUDENTS_ENDPOINT;
  }else{
    console.log("PROD ENV !!!!!!!");
     url = BASE_API_URL + ALL_STUDENTS_ENDPOINT;
  }
  // Returns a dispatcher function
  // that dispatches an action at a later time
  return (dispatch) => {
    // Returns a promise
    return Axios.get(url,{ headers: { 'x-api-key': '9101623f031545f3bf47a7a101387c34' } })
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

