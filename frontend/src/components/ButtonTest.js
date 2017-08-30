import React from "react";
import {AllStudentsTable} from './AllStudentsTable';

export class ButtonTest extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            showComponent: false,
        };
        this._onButtonClick = this._onButtonClick.bind(this);
    }

    _onButtonClick() {
        this.setState({
            showComponent: true,
        });
    }
    render(){
        return(
            <div>
            <button onClick={this._onButtonClick} >ButtonTest</button>
                <div>
            {this.state.showComponent ? <AllStudentsTable /> : null}
                </div>
            </div>
        );
    }
}