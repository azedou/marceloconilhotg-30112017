// ./src/components/book/BookPage.js
import React from 'react';
import { connect } from 'react-redux';
import * as studentsActions from '../../actions/studentsActions';
import StudentsList from './StudentsList';
import StudentForm from './StudentForm';
import {ALL_STUDENTS_ENDPOINT,
        ADD_STUDENTS_ENDPOINT,
        ALL_STUDENTS_STRING,
        ADD_STUDENTS_STRING} from './StudentsConstants'
import {Collapse} from 'react-collapse';

class Student extends React.Component{
  constructor(props){
    super(props);
    this.state = {isAllStudentsOpened: false,
                  isAddStudentsOpened: false};
    this.handleClick = this.handleClick.bind(this);
  }
  componentWillMount(){
      this.props.fetchStudents();
  }
  handleClick(e, target) {
    e.preventDefault();
    switch(target) {
    case ALL_STUDENTS_STRING:
        this.setState({isAllStudentsOpened: !this.state.isAllStudentsOpened});
        break;
    case ADD_STUDENTS_STRING:
        this.setState({isAddStudentsOpened: !this.state.isAddStudentsOpened});
        break;
    }
  }

  render(){
    let isAllStudentsOpened = this.state.isAllStudentsOpened;
    let isAddStudentsOpened = this.state.isAddStudentsOpened;
    return(
      <div>
        <h3>Students</h3>
          <div>
            <a id={ALL_STUDENTS_STRING} onClick={(e) => this.handleClick(e, ALL_STUDENTS_STRING)}><h4>{ALL_STUDENTS_ENDPOINT}</h4></a>
            <Collapse isOpened={isAllStudentsOpened} >
              <StudentsList students={this.props.students}/>
            </Collapse>
            <a id={ADD_STUDENTS_STRING} onClick={(e) => this.handleClick(e,ADD_STUDENTS_STRING)}><h4>{ADD_STUDENTS_ENDPOINT}</h4></a>
            <Collapse isOpened={isAddStudentsOpened} >
              <StudentForm />
              <StudentsList students={this.props.students}/>
            </Collapse>
          </div>
        </div>
    );
  }
}

// Maps state from store to props
const mapStateToProps = (state, ownProps) => {
  return {
    // You can now say this.props.students
    students: state.students
  }
};

// Maps actions to props
const mapDispatchToProps = (dispatch) => {
  return {
  // You can now say this.props.fetchStudents
    fetchStudents: students => dispatch(studentsActions.fetchStudents())
  }
};

// Use connect to put them together
export default connect(mapStateToProps, mapDispatchToProps)(Student);