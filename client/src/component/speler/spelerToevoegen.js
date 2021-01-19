import React, { Component } from 'react'
import ApiService from "../service/ApiService";

import {Input, Button} from "antd"


class addTeam extends Component{

    constructor(props){
        super(props);
       this.state ={
           name: '',
           achternaam: '',
           positie: '',
           nummer: '',
           foto: '',
            message: null
        }
       this.saveUser = this.saveUser.bind(this);
    }

    saveUser = (e) => {
        e.preventDefault();
        let user = {
                    name: this.state.name,
                    achternaam: this.state.achternaam, 
                    positie: this.state.positie, 
                    nummer: this.state.nummer, 
                    foto: this.state.foto, 
                    
                };
        ApiService.addUser(user)
            .then(res => {
                this.setState({message : 'Team added successfully.'});
                this.props.history.push('/spelers-lijst');// aqui cambiar
            });
    }

    onChange = (e) =>
        this.setState({ 
       
            [e.target.name]: e.target.value });
        

    render() {
     
       
        return(
            <div className="table table-striped">    
            <tr/>   
            <tr/>        
                <h5 className="title" display="center"> Speler toevoegen</h5>
                <form>
               
                  <div className="form-group">
                    <label>Naam speler : </label>
                          <Input type="text" placeholder="name" name="name" className="form-control" 
                          value={this.state.name} onChange={this.onChange}/>
                    </div>
                    <hr/>
                    <div className="form-group">
                    <label>Achternaam : </label>
                          <Input  type="text" placeholder="achternaam" name="achternaam" 
                          value={this.state.achternaam} onChange={this.onChange}/>
                    </div>
                    <hr/>
                    <div className="form-group">
                    <label >Positie : </label>
                          <select   name="positie" 
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
                    <label>Nummer t-shirt : </label>
                          <Input type="text" placeholder="nummer" name="nummer" 
                          value={this.state.nummer} onChange={this.onChange}
                          />
                          
                    </div>
                    <hr/>
                    
                    <Button type="primary" onClick={this.saveUser}>Opslan gegevens</Button>
            </form>
    </div>
        );
    }
}


export default addTeam;