import React, { Component } from 'react';
import { login} from '../service/ApiService';
import './Login.css';
import { Link } from 'react-router-dom';



import { Form, Input, Button, Icon, notification } from 'antd';

const FormItem = Form.Item;
const ACCESS_TOKEN = 'accessToken';

class Login extends Component {
    render() {
        const AntWrappedLoginForm = Form.create()(LoginForm)
        return (
            <div className="login-container">
                <h1 className="title">Inloggen</h1>
                <div className="login-content">
                    <AntWrappedLoginForm onLogin={this.props.onLogin} />
                </div>
            </div>
        );
    }
}

class LoginForm extends Component {
    constructor(props) {
        super(props);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleSubmit(event) {
        event.preventDefault();   
        this.props.form.validateFields((err, values) => {
            if (!err) {
                const loginRequest = Object.assign({}, values);
                login(loginRequest)
                .then(response => {
                    localStorage.setItem(ACCESS_TOKEN, response.accessToken);
                    this.props.onLogin();
                }).catch(error => {
                    if(error.status === 401) {
                        notification.error({
                            message: 'Kunst App',
                            description: 'Uw Usernaam of Password is onjuist. Probeer het opnieuw!'
                        });                    
                    } else {
                        notification.error({
                            message: 'Kunst App',
                            description: error.message || 'Sorry! Er is iets misgegaan. Probeer het opnieuw!'
                        });                                            
                    }
                });
            }
        });
    }

    render() {
        const { getFieldDecorator } = this.props.form;
        return (
            <Form onSubmit={this.handleSubmit} className="login-form">
                <FormItem>
                    {getFieldDecorator('usernameOrEmail', {
                        rules: [{ required: true, message: 'Voer uw username of email in!' }],
                    })(
                    <Input 
						prefix={<Icon type="user" />}
						size="large"
                        name="usernaamOfEmail" 
                        placeholder="Gebruikersnaam" />    
                    )}
                </FormItem>
				 
                <FormItem>
                {getFieldDecorator('password', {
                    rules: [{ required: true, message: 'Voer uw password in!' }],
                })(
                    <Input 
                        prefix={<Icon type="lock" />}
                        size="large"
                        name="password" 
                        type="password" 
                        placeholder="Wachtwoord"  />                        
                )}
                </FormItem>
                <FormItem>
                    <Button type="primary" htmlType="submit" size="large" className="login-form-button">Log in</Button>
                    Of  <Link to="/signup"> account aanmaken!</Link>
                </FormItem>
            </Form>
        );
    }
}


export default Login;