import React from 'react';
import { connect } from 'react-redux';
import * as studentsActions from '../../actions/studentsActions';
import { Button } from 'reactstrap';
import { GENERATE_STUDENT_CERTIFICATE_BUTTON_LABEL } from './StudentsConstants';

class StudentGenerateCertificateButton extends React.Component{
  constructor(props){
    super(props);
  }
  

  render(){
    return(
      <div>
        <form method="post" action="http://marceloconilhotg2.azurewebsites.net/generateStudentCertificate">
          <input type="text" name="ra" value={this.props.ra} hidden/>
          <button type="submit">Generate Certificate for RA: {this.props.ra}</button>
        </form>
      </div>
    );
  }
}

export default StudentGenerateCertificateButton;