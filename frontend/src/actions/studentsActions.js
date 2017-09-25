import * as types from './actionType';
import Axios from 'axios';
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
  const url = 'https://c41c9904-443a-45af-9eb9-8eee688f64ba.mock.pstmn.io/allStudents';
  // Returns a dispatcher function
  // that dispatches an action at a later time
  return (dispatch) => {
    // Returns a promise
    return Axios.get(url,{ headers: { 'x-api-key': '739d337476754777bb72ab7ddf4888fe' } })
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

