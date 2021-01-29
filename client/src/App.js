import React, { Component } from 'react';
import {
  Route,
  withRouter,
  Switch
} from 'react-router-dom';

import { getCurrentUser } from './component/service/ApiService';
import { ACCESS_TOKEN } from './component/service/index';
import Login from './component/user/Login';
import Signup from './component/user/Signup';
import AppHeader from './header/AppHeader';
import lijstBijwerken from "./component/speler/lijstBijwerken";
import spelerToevoegen from "./component/speler/spelerToevoegen";
import spelerBijwerken from "./component/speler/spelerBijwerken";
import lijst from "./component/speler/lijst";
import background1 from "./imag/Champions.jpg";
import { Layout, notification } from 'antd';



const { Content } = Layout;

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      currentUser: null,
      isAuthenticated: false,
      
    }
    this.handleLogout = this.handleLogout.bind(this);
    this.loadCurrentUser = this.loadCurrentUser.bind(this);
    this.handleLogin = this.handleLogin.bind(this);
    

    notification.config({
      placement: 'topRight',
      top: 70,
      duration: 3,
    });    
  }

  loadCurrentUser() {
    this.setState({
      isLoading: true
    });
    getCurrentUser()
    .then(response => {
      this.setState({
        currentUser: response,
        isAuthenticated: true,
        isLoading: false
      });
    }).catch(error => {
      this.setState({
        isLoading: false
      });  
    });
  }

  componentDidMount() {
    this.loadCurrentUser();
  }

  handleLogout(redirectTo="/", notificationType="success", description="Je bent succesvol uitgelogd.") {
    localStorage.removeItem(ACCESS_TOKEN);

    this.setState({
      currentUser: null,
      isAuthenticated: false
    });

    this.props.history.push(redirectTo);
    
    notification[notificationType]({
      message: 'Speler App',
      description: description,
    });
  }


  handleLogin() {
    notification.success({
      message: 'Speler App',
      description: "U bent succesvol ingelogd.",
    });


    this.loadCurrentUser();
    this.props.history.push("/lijst");
  }

  render() {
  
    return (
        <Layout className="app-container">
          <AppHeader isAuthenticated={this.state.isAuthenticated} 
            currentUser={this.state.currentUser} 
            onLogout={this.handleLogout} />

          <Content className="app-content">
            <div className="container">
              <Switch>      
                <Route exact path="/" > 
                <div className= "image">
                <img src={background1} 
                // width="700" height="500" 
                 display="center" />
                </div>
                </Route>     
                  
                <Route path="/login" 
                  render={(props) => <Login onLogin={this.handleLogin} {...props} />}></Route>
                <Route path="/signup" component={Signup}></Route>
              </Switch>

              <Switch>
                      <Route path="/lijst" exact component={lijst} /> 
                      <Route path="/spelers-lijst" component={lijstBijwerken} />
                      <Route path="/speler-toevoegen" component={spelerToevoegen} />
                      <Route path="/speler-bijwerken" component={spelerBijwerken} />
                  
              </Switch>
            </div>
          </Content>
        </Layout>
    );
  }
}

export default withRouter(App);