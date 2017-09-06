import {
  LOAD_ALL_STUDENTS,
  LOAD_ALL_STUDENTS_ERROR
} from '../actions/actionType';

export default (state = [], action) => {
  switch (action.type){
    case LOAD_ALL_STUDENTS:(state, action)=>{
      console.log("entrou no reducer");
      state = {...state}
      state.students = action.payload;
      return state;
    }
    default:
          return state;
  }
};