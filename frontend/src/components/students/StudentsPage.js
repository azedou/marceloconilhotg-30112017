// ./src/components/book/BookPage.js
import React from 'react';
import { connect } from 'react-redux';
import * as studentsActions from '../../actions/studentsActions';

class Student extends React.Component{
  constructor(props){
    super(props);
  }

  componentDidMount(){
      console.log("DidMount");
      
  }
  componentWillMount(){
      console.log("will mount");
      this.props.loadAllStudents();
  }

  render(){
      console.log("RENDER METHOD");
    console.log(this.props);
      
    return(
      <div>
        <h3>Students</h3>
        <div>
          <h3>{this.props.students[0]=="undefined"? "LOADING": JSON.stringify(this.props.students)}</h3>
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
  // You can now say this.props.loadAllStudents
    loadAllStudents: students => dispatch(studentsActions.loadAllStudents())
  }
};

// Use connect to put them together
export default connect(mapStateToProps, mapDispatchToProps)(Student);