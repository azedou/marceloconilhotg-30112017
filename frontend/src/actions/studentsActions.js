import * as types from './actionType';
import axios from 'axios';
import {
    LOAD_ALL_STUDENTS,
    LOAD_ALL_STUDENTS_ERROR
    } from './actionType';


export const loadAllStudents = () => {
	return (dispatch) =>{
	    
	    return axios({
			  url: "http://marceloconilhotg2.azurewebsites.net/allStudents",
			  timeout: 30000,
			  method: 'get',
			  responseType: 'json'
		  })
			.then((response) => {
			    dispatch({
			        type: LOAD_ALL_STUDENTS,
			        payload: response
			    });
			    return response;
			},
			(error) =>{
			    dispatch({
			        type: LOAD_ALL_STUDENTS_ERROR,
			        payload: error,
			        error: true
			    });
			}
	    );
    }
};

