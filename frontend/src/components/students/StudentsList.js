import React from 'react';
import {BootstrapTable, TableHeaderColumn} from 'react-bootstrap-table';

class StudentsList extends React.Component{
  constructor(props){
    super(props);
  }
  
  render(){
    return(
          <BootstrapTable data={ this.props.students } striped hover condensed version='4'>
            <TableHeaderColumn dataField='ra' dataSort={ true } isKey >RA</TableHeaderColumn>
            <TableHeaderColumn dataField='name' dataSort={ true } >Name</TableHeaderColumn>
            <TableHeaderColumn dataField='email' dataSort={ true } >E-Mail</TableHeaderColumn>
        </BootstrapTable>
    );
  }
}
export default StudentsList;