import React from "react";
import axios from 'axios';

export class AllStudentsTable extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            students: []
        };
    }
    componentDidMount(){
        axios.get('http://marceloconilhotg2.azurewebsites.net/allStudents')
            .then(function (response) {
                console.log(response);
                const students = response.data.map(obj => obj.data);
                console.log(students);
                this.setState({ students });
            })
            .catch(function (error) {
                console.log(error);
            });
    }
    render(){
        return(
            <div>
                <table>
                  <th>blablablabla</th>
                </table>
            </div>
        );
    }
}