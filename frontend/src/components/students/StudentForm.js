import React from 'react';
import { Form, FormGroup, Label, Input, FormFeedback, FormText } from 'reactstrap';

class StudentForm extends React.Component{
  constructor(props){
    super(props);
  }
  
  render(){
    return(
        <Form>
        <FormGroup color="success">
          <Label for="ra">RA: </Label>
          <Input state="success" />
          <FormFeedback>Success! You did it!</FormFeedback>
          <FormText color="muted">Example help text that remains unchanged.</FormText>
        </FormGroup>
        <FormGroup color="warning">
          <Label for="examplePassword">Input with warning</Label>
          <Input state="warning" />
          <FormFeedback>Whoops, check your formatting and try again.</FormFeedback>
          <FormText color="muted">Example help text that remains unchanged.</FormText>
        </FormGroup>
        <FormGroup color="danger">
          <Label for="examplePassword">Input with danger</Label>
          <Input state="danger" />
          <FormFeedback>Oh noes! that name is already taken</FormFeedback>
          <FormText color="muted">Example help text that remains unchanged.</FormText>
        </FormGroup>
      </Form>
    );
  }
}
export default StudentForm;