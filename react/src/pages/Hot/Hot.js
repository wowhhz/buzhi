import React, {Component} from 'react';
import './Hot.css';
import {Link} from 'react-router-dom';
// import PostItem from './Post'

// import image from './images/brickpsert.jpg';



export default class Hot extends Component {
  constructor(props){
    super(props)
    this.state = {
      postList : [{
        "title":"帖子标题0",
        "content":"这是帖子的内容0",
        "url":"/post/0"
      },{
        "title":"帖子标题1",
        "content":"这是帖子的内容1",
        "url":"/post/1"
      },{
        "title":"帖子标题2",
        "content":"这是帖子的内容2",
        "url":"/post/2"
      },{
        "title":"帖子标题3",
        "content":"这是帖子的内容3",
        "url":"/post/3"
      }]
    }
  }
  
    render() {
        let posts = this.state.postList.map((item, key) => {
          return (
          <div key={key} className="postItem">
            <div className="title">
            <Link to={item.url}>{item.title}</Link></div>
            <div className="content">{item.content}</div>
          </div>)
        })

        return (
            <div className="">
                {/* <div>热门讨论</div> */}
                {/* <img src={image}/> */}
                {posts}
            </div>
        )
    }
}