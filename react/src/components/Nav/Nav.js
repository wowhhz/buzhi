import React, {Component} from 'react';
// import style from './Nav.css'; // how to use style without an object? can't do!! what if it's a tag!!!
import {Link} from 'react-router-dom';
import './Nav.css';

export default class Nav extends Component {
    render() {
        return (
            <ul className="navigator">
            {/* <ul className={style.navigator}> */}
                <li><Link to="/">Buzhi</Link></li>
                <li><Link to="/hot">热门</Link></li>
                <li><Link to="/publish">发布</Link></li>
                <li><input placeholder="Search" type="text" className="search"/></li>
                {/* need to judge if logged in */}
                <li><Link to="/user">用户信息</Link></li>
            </ul>
        )
    }
}