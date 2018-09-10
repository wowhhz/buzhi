import React from 'react';

import {Route, Switch} from 'react-router-dom';

import Bundle from './Bundle';
import Loading from 'components/Loading/Loading';

import Home from 'bundle-loader?lazy&name=home!pages/Home/Home';
import Hot from 'bundle-loader?lazy&name=hot!pages/Hot/Hot';
import Publish from 'bundle-loader?lazy&name=publish!pages/Publish/Publish';
import Post from 'bundle-loader?lazy&name=post!pages/Post/Post';
import Counter from 'bundle-loader?lazy&name=counter!pages/Counter/Counter';
import User from 'bundle-loader?lazy&name=user!pages/User/User';
import NotFound from 'bundle-loader?lazy&name=notFound!pages/NotFound/NotFound';

const createComponent = (component) => (props) => (
    <Bundle load={component}>
        {
            (Component) => Component ? <Component {...props} /> : <Loading/>
        }
    </Bundle>
);

export default () => (
    <div>
        <Switch>
            <Route exact path="/" component={createComponent(Home)}/>
            <Route path="/hot" component={createComponent(Hot)}/>
            <Route path="/post/:number" component={createComponent(Post)}/>
            <Route path="/publish" component={createComponent(Publish)}/>
            <Route path="/user" component={createComponent(User)}/>
            <Route path="/counter" component={createComponent(Counter)}/>
            <Route component={createComponent(NotFound)}/>
        </Switch>
    </div>
);
