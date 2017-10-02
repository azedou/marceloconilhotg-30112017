import React from 'react';
import {BootstrapTable, TableHeaderColumn} from 'react-bootstrap-table';
import StudentGenerateCertificateButton from './StudentGenerateCertificateButton'

var selectedStudent

class StudentsList extends React.Component{
  constructor(props){
    super(props);
    this.state = {selectedStudentRa: ""};
    this.handleOnSelect = this.handleOnSelect.bind(this);
  }

  handleOnSelect(row) {
          this.setState({selectedStudentRa: row.ra});
  }
  
  render(){
   var selectRowProp = {
        mode: 'checkbox',
        clickToSelect: true,
        bgColor: 'lightblue',
        hideSelectColumn: true,
        onSelect: this.handleOnSelect
  };
    return(
      <div>
          <BootstrapTable data={ this.props.students } striped hover condensed pagination selectRow={selectRowProp } version='4'>
            <TableHeaderColumn dataField='ra' dataSort filter={ { type: 'TextFilter', delay: 1000 } } isKey >RA</TableHeaderColumn>
            <TableHeaderColumn dataField='name' dataSort filter={ { type: 'TextFilter', delay: 1000 } } >Name</TableHeaderColumn>
            <TableHeaderColumn dataField='email' dataSort filter={ { type: 'TextFilter', delay: 1000 } } >E-Mail</TableHeaderColumn>
            <TableHeaderColumn dataField='course' dataSort filter={ { type: 'TextFilter', delay: 1000 } } >Course</TableHeaderColumn>
            <TableHeaderColumn dataField='cycle' dataSort filter={ { type: 'TextFilter', delay: 1000 } } >Cycle</TableHeaderColumn>
            <TableHeaderColumn dataField='theme' dataSort filter={ { type: 'TextFilter', delay: 1000 } } >Theme</TableHeaderColumn>
            <TableHeaderColumn dataField='discipline' dataSort filter={ { type: 'TextFilter', delay: 1000 } } >Discipline</TableHeaderColumn>
        </BootstrapTable>
        <StudentGenerateCertificateButton ra={this.state.selectedStudentRa}/>
      </div>
    );
  }
}

export default StudentsList;