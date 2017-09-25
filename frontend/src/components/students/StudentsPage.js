// ./src/components/book/BookPage.js
import React from 'react';
import { connect } from 'react-redux';
import * as studentsActions from '../../actions/studentsActions';
import StudentsList from './StudentsList';

class Student extends React.Component{
  constructor(props){
    super(props);
  }

  componentWillMount(){
      this.props.fetchStudents();
  }

  render(){
    return(
      <div>
        <h3>Students</h3>
          <div>
            <StudentsList students={this.props.students}/>
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