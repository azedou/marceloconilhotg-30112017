import React from 'react';
import { connect } from 'react-redux';

class StudentsList extends React.Component{
  constructor(props){
    super(props);
  }
  
  render(){
      console.log("RENDER METHOD");
    console.log(this.props);
      
    return(
      <div>
      'DUMMY'
      </div>
    );
  }
}
