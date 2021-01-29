/* eslint-disable jsx-a11y/anchor-is-valid */
import React, { Component } from 'react';
import {
    Link,withRouter
} from 'react-router-dom';
import './AppHeader.css';
import soccer from '../imag/Soccer1.png';
import refresh from '../imag/Refresh.png';
import list from '../imag/List.png';
import User1 from '../imag/User1.png';
import { Layout, Menu, Dropdown } from 'antd';
const Header = Layout.Header;
    
class AppHeader extends Component {
    constructor(props) {
        super(props);   
        this.handleMenuClick = this.handleMenuClick.bind(this);   
    }
    handleMenuClick({ key }) {
      if(key === "logout") {
        this.props.onLogout();
      }
    }

    render() {
        let menuItems;
        if(this.props.currentUser) {
          menuItems = [
            <Menu.Item key="/spelers-lijst">
              <Link to="/spelers-lijst">
                <img src={refresh} alt="refresh" className="nav-icon" />
              </Link>
            </Menu.Item>,           

            <Menu.Item key="/speler-toevoegen">
            <Link to="/speler-toevoegen">
              <img src={soccer} alt="soccer"  />
            </Link>
            </Menu.Item>,
        
                
        <Menu.Item key="/lijst">
            <Link to="/lijst">
              <img src={list} alt="list" className="poll-icon" />
            </Link>
            </Menu.Item>,
            
            <Menu.Item key="/profile" className="profile-menu">
                <ProfileDropdownMenu 
                  currentUser={this.props.currentUser} 
                  handleMenuClick={this.handleMenuClick}/>
            </Menu.Item>,
      
          ]; 
        } else {
          menuItems = [
            <Menu.Item key="/login">
              <Link  to="/login">Inloggen</Link>
            </Menu.Item>,
            <Menu.Item key="/signup">
              <Link to="/signup">Registreren</Link>
            </Menu.Item>                  
          ];
        }

        return (
            <Header className="app-header">
            <div >
              <div className="app-title" >
                <Link to="/">Speler-Novi.NL</Link>
                
              </div>
              <Menu
                className="app-menu"
                mode="horizontal"
                selectedKeys={[this.props.location.pathname]}
                style={{ lineHeight: '64px' }} >
                  {menuItems}
              </Menu>
            </div>
          </Header>
        );
    }
}

function ProfileDropdownMenu(props) {
  const dropdownMenu = (
    <Menu onClick={props.handleMenuClick} 
    className="profile-dropdown-menu">
      <Menu.Divider />
      <Menu.Item key="logout" className="dropdown-item">
        Uitloggen
      </Menu.Item>
    </Menu>
  );

  return (
    <Dropdown 
      overlay={dropdownMenu} 
      trigger={['click']}
      getPopupContainer = { () => document.getElementsByClassName('profile-menu')[0]}>
      <a >
        <img src={User1} alt="User1" className="poll-icon" />
      </a>
    </Dropdown>
  );
}

export default withRouter(AppHeader);