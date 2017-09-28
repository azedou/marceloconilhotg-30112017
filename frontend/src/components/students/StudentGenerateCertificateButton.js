import React from 'react';
import { Button } from 'reactstrap';

class StudentGenerateCertificateButton extends React.Component{
  constructor(props){
    super(props);
  }
  
  render(){
    console.log("BUTTON");
    console.log(this.props.selectedStudentRa);
    return(
        <Button>{this.props.selectedStudentRa}</Button>
    );
  }
}
export default StudentGenerateCertificateButton;