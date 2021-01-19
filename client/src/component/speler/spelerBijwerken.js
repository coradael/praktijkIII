import React, { Component } from 'react'
import ApiService from "../service/ApiService";

import {Input, Button} from "antd";


class editKunst extends Component {

    constructor(props){
        super(props);
        this.state ={
            id: '',
            name: '',
            achternaam: '',
            positie: '',
            nummer: '',
            //foto: '',
            
        }
        this.saveUser = this.saveUser.bind(this);
        this.loadUser = this.loadUser.bind(this);
    }

    componentDidMount() {
        this.loadUser();
    }

    loadUser() {
        ApiService.fetchUserById(window.localStorage.getItem("userId"))
            .then((res) => {
                let user = res.data.result;
                this.setState({
                id: user.id,
                name: user.name,
                achternaam: user.achternaam,
                positie: user.positie,
                nummer: user.nummer,
                })
            });
    }

    onChange = (e) =>
        this.setState({ [e.target.name]: e.target.value });

    saveUser = (e) => {
        e.preventDefault();
        let user = {id: this.state.id, 
                    name: this.state.name, 
                    achternaam: this.state.achternaam,
                    positie: this.state.positie,
                    nummer: this.state.nummer,
                };
        ApiService.editUser(user)
            .then(res => {
                this.setState({message : 'User edited successfully.'});
                this.props.history.push('/lijst'); // cambiar donde va a cambiar
            });
    }

    render() {
        return (
            <div className="table table-striped">
                <h2 className="title" >Edit User</h2>
                <form>


                    <div className="form-group">
                        <label>Name team:</label>
                        <Input placeholder="name" name="name" className="form-control" 
                     
                        value={this.state.name} onChange={this.onChange}/>
                    </div>
                    <hr/>
                    <div className="form-group">
                    <label>Achternaam:</label>
                          <Input  type="text" placeholder="achternaam" name="achternaam" className="form-control" 
                          value={this.state.achternaam} onChange={this.onChange}/>
                    </div>
                    <hr/>
                    <div className="form-group">
                    <label >Positie:</label>
                          <select  placeholder="positie" name="positie" className="form-control" 
                          value={this.state.positie} onChange={this.onChange}>
                          <option value="Keeper">Keeper</option>
                          <option value="Linksback">Linksback</option>
                          <option value="Linker centrale verdediger ">Linker centrale verdediger </option>
                          <option value="Rechter centrale verdediger ">Rechter centrale verdediger </option>
                          <option value="Centrale verdedigende middenvelder">Centrale verdedigende middenvelder </option>
                          <option value="Rechter middenvelder">rechter middenvelder</option>
                          <option value="Linker middenvelder ">Linker middenvelder </option>
                          <option value="Middenvelder ">Middenvelder </option>
                          <option value="Linksbuiten ">Linksbuiten </option>
                          <option value="Rechtsbuiten ">Rechtsbuiten </option>
                          <option value="Spits ">Spits </option>
                          </select>
                    </div>
                    <hr/>
                    <div className="form-group">
                    <label>Nummer t-shirt:</label>
                          <Input type="text" placeholder="nummer" name="nummer" className="form-control" 
                          value={this.state.nummer} onChange={this.onChange}/>
                    </div>
                    

                    <Button type="primary" className="btn btn-success" onClick={this.saveUser}>Opslaan</Button>
                </form>
            </div>
        );
    }
}

export default editKunst;