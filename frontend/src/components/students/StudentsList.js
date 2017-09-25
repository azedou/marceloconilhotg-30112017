import React from 'react';
import {BootstrapTable, TableHeaderColumn} from 'react-bootstrap-table';
import { Col, Panel } from 'react-bootstrap';

class StudentsList extends React.Component{
  constructor(props){
    super(props);
  }
  
  render(){
    return(
          <BootstrapTable data={ this.props.students } version='4'>
            <TableHeaderColumn dataField='ra' isKey>RA</TableHeaderColumn>
            <TableHeaderColumn dataField='name'>Name</TableHeaderColumn>
            <TableHeaderColumn dataField='email'>E-Mail</TableHeaderColumn>
        </BootstrapTable>
    );
  }
}
export default StudentsList;