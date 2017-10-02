import React from 'react';
import { connect } from 'react-redux';
import * as studentsActions from '../../actions/studentsActions';
import StudentReduxForm from './StudentReduxForm'

class StudentForm extends React.Component{
  constructor(props){
    super(props);
  }
  
  submit = (value) => {
    this.props.addStudent(value);
    this.props.fetchStudents();
  }
  
  render(){
    return(
        <div>
          <StudentReduxForm onSubmit={this.submit}/>
        </div>
    );
  }
}

// Maps state from store to props
const mapStateToProps = (state, ownProps) => {
  return {
    // You can now say this.props.students
    response: state.response
  }
};

// Maps actions to props
const mapDispatchToProps = (dispatch) => {
  return {
  // You can now say this.props.addStudent
    addStudent: student => dispatch(studentsActions.addStudent(student)),
    fetchStudents: students => dispatch(studentsActions.fetchStudents())
  }
};

// Use connect to put them together
export default connect(mapStateToProps, mapDispatchToProps)(StudentForm);