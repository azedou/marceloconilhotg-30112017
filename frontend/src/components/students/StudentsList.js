import React from 'react';
import {BootstrapTable, TableHeaderColumn} from 'react-bootstrap-table';
import StudentGenerateCertificateButton from './StudentGenerateCertificateButton'

function onRowSelect(row, isSelected, e) {
  selectedStudent = row.ra;
}

function onSelectAll(isSelected, rows) {
  console.log(`is select all: ${isSelected}`);
  if (isSelected) {
    console.log('Current display and selected data: ');
  } else {
    console.log('unselect rows: ');
  }
  for (let i = 0; i < rows.length; i++) {
    console.log(rows[i].id);
  }
}

const selectRowProp = {
        mode: 'checkbox',
        clickToSelect: true,
        bgColor: 'lightblue',
        hideSelectColumn: true,
        onSelect: onRowSelect,
        onSelectAll: onSelectAll
    };

let selectedStudent;
    
class StudentsList extends React.Component{
  constructor(props){
    super(props);
    
    this.state = {selectedStudentRa: ""};
    this.handleClick = this.handleClick.bind(this);
    
  }
  
   handleClick(e, target) {
    e.preventDefault();
    console.log("ON CLICK");
    this.setState({selectedStudentRa: selectedStudent});
    console.log(this.state.selectedStudentRa);
  }
  
  render(){
    return(
      <div>
          <BootstrapTable data={ this.props.students } striped hover condensed pagination selectRow={ selectRowProp } version='4'>
            <TableHeaderColumn dataField='ra' dataSort filter={ { type: 'TextFilter', delay: 1000 } } isKey >RA</TableHeaderColumn>
            <TableHeaderColumn dataField='name' dataSort filter={ { type: 'TextFilter', delay: 1000 } } >Name</TableHeaderColumn>
            <TableHeaderColumn dataField='email' dataSort filter={ { type: 'TextFilter', delay: 1000 } } >E-Mail</TableHeaderColumn>
        </BootstrapTable>
        <button onClick={(e) => this.handleClick(e)}>CLICK ME</button>
      </div>
    );
  }
}
export default StudentsList;