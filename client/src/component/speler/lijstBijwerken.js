import React, { Component } from 'react'
import ApiService from "../service/ApiService";

import { Table, Button } from 'antd';

const { Column, ColumnGroup } = Table

class listKunst extends Component {

    constructor(props) {
        super(props)
        this.state = {
            users: [],
            message: null
        }
        this.deleteUser = this.deleteUser.bind(this);
        this.editUser = this.editUser.bind(this);
        this.addUser = this.addUser.bind(this);
        this.reloadUserList = this.reloadUserList.bind(this);
    }

    componentDidMount() {
        this.reloadUserList();
    }

    reloadUserList() {
        ApiService.fetchUsers()
            .then((res) => {
                this.setState({users: res.data.result})
            });
    }

    deleteUser(userId) {
        ApiService.deleteUser(userId)
           .then(res => {
               this.setState({message : 'User deleted successfully.'});
               this.setState({users: this.state.users.filter(user => user.id !== userId)});
           })

    }

    editUser(id) {
        window.localStorage.setItem("userId", id);
        this.props.history.push('/speler-bijwerken');
    }

    addUser() {
        window.localStorage.removeItem("userId");
        this.props.history.push('/speler-toevoegen');
    }

    render() {
        return (
            <div>
                      

        <Table dataSource={this.state.users}>
                    <ColumnGroup className="title" title="Spelers bijwerken">
                    <Column title="Id" dataIndex="id" key="id" />
                    <Column title="Naam" dataIndex="name" key="name" />
                    <Column title="Achternaam" dataIndex="achternaam" key="achternaam" />
                    <Column title="Positie" dataIndex="positie" key="positie" />
                    <Column title="Nummer t-shirt:" dataIndex="nummer" key="nummer" />
                    <Column dataIndex='id'
                            key= 'id'
                            render={(text, record) => (
                            <Button type="primary"
                            onClick={() => { this.deleteUser(record.id); }}
                            >Verwijderen</Button>)}
                            />
                    <Column 
                            dataIndex='id'
                            key= 'id'
                            render={(text, record) => (
                            <Button type="primary"onClick={() => { this.editUser(record.id); }}>Wijzigen</Button>)}
                         />
                    
                    </ColumnGroup>
            
        </Table>
       
            </div>
        );
    }

}

export default listKunst;