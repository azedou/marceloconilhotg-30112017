import React from 'react';
import {BootstrapTable, TableHeaderColumn} from 'react-bootstrap-table';

function onRowSelect(row, isSelected, e) {
  let rowStr = '';
  for (const prop in row) {
    rowStr += prop + ': "' + row[prop] + '"';
  }
  console.log(e);
  console.log(`is selected: ${isSelected}, ${rowStr}`);
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
    
class StudentsList extends React.Component{
  constructor(props){
    super(props);
  }
  
  render(){
    return(
          <BootstrapTable data={ this.props.students } striped hover condensed pagination selectRow={ selectRowProp } version='4'>
            <TableHeaderColumn dataField='ra' dataSort filter={ { type: 'TextFilter', delay: 1000 } } isKey >RA</TableHeaderColumn>
            <TableHeaderColumn dataField='name' dataSort filter={ { type: 'TextFilter', delay: 1000 } } >Name</TableHeaderColumn>
            <TableHeaderColumn dataField='email' dataSort filter={ { type: 'TextFilter', delay: 1000 } } >E-Mail</TableHeaderColumn>
        </BootstrapTable>
    );
  }
}
export default StudentsList;