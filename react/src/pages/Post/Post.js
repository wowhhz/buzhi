import React, {Component} from 'react';
import './Post.css';
import {Link} from 'react-router-dom';
// import PostItem from './Post'

// import image from './images/brickpsert.jpg';



export default class Hot extends Component {
  constructor(props){
    super(props)
  }
  
    render() {

        return (
            <div className="">
                <div>这里是标题 {this.props.match.params.number} </div>
                <div>这里是正文 {this.props.match.params.number} </div>
            </div>
        )
    }
}