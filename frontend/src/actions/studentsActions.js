import * as types from './actionType';
import Axios from 'axios';
import Blob from 'blob';
import fileDownload from 'react-file-download';
import {PROD, DEV, BASE_API_URL, BASE_MOCKED_API_URL} from '../constants'
import {ALL_STUDENTS_ENDPOINT,
    GENERATE_STUDENT_CERTIFICATE_ENDPOINT
    } from './studentsConstants'
import {
    LOAD_ALL_STUDENTS,
    LOAD_ALL_STUDENTS_ERROR,
    LOAD_ALL_STUDENTS_SUCCESS,
    GENERATE_STUDENT_CERTIFICATE_SUCCESS
    } from './actionType';

var configHeaderMock ={ headers: { 'x-api-key': '9101623f031545f3bf47a7a101387c34' } };
// Sync Action
export const generateStudentCertificateSuccess = (certificate) => {
  return {
    type: 'GENERATE_STUDENT_CERTIFICATE_SUCCESS',
    certificate
  }
};
//Async Action
export const generateStudentCertificate = (ra) => {
  let url = BASE_API_URL + "/generateStudentCertificate";
  // Returns a dispatcher function
  // that dispatches an action at a later time
  return (dispatch) => {
    // Returns a promise
    return Axios.get(url, {ra:{ra}})
      .then(response => {
        console.log(response)
        let blob = new Blob([response.data], { type:   'application/pdf' } );
        let link = document.createElement('a');
        link.href = window.URL.createObjectURL(blob);
        link.download = 'Report.pdf';
        link.click();
        //fileDownload(response.data, 'test.pdf');
        // Dispatch another action
        // to consume data
      })
      .catch(error => {
        console.log(error);
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