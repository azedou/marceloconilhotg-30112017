import React from "react";
import axios from 'axios';

export class AllStudentsTable extends React.Component{
    constructor(props) {
        super(props);
        this.state = { 
            students : [],
            showComponent: false};
    }
    getAllStudents(){
        var student = null;
        axios.get('https://marceloconilhotg2.azurewebsites.net/allStudents')
            .then(function (response) {
                student = response.data[0];
                console.log(student);
            })
            .catch(function (error) {
                console.log(error);
            });
        console.log("setState:");
        this.setState({ 
                    students: [...this.state.students,student],
                    showComponent: true  
        });
        
    }
    componentWillMount(){
        this.getAllStudents();
        
    }
    componentDidMount(){
        console.log(this.state);
    }
    render(){
        return(
            <div>
            {this.state.showComponent ? "mostra tudo " + this.state.value : null}
            </div>
        );
    }
}