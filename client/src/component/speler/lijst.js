import React, { Component } from 'react'
import ApiService from "../service/ApiService";


import { Table} from 'antd';

const { Column, ColumnGroup} = Table

class lijst extends Component {

    constructor(props) {
        super(props)
        this.state = {
            users: [],
            message: null
        }
        this.reloadUserList = this.reloadUserList.bind(this);
    }

    componentDidMount() {
        this.reloadUserList();
    }

    reloadUserList() {
        ApiService.fetchUsers()
            .then((res) => {
				this.setState({users: res.data.result})
				this.props.history.push('/lijst');
            });
    }

   
       

render() {

        return (
            <div className="uno">
            

            <Table  dataSource={this.state.users}>
            <ColumnGroup className="title" title="Lijst spelers">
            <Column title="Id" dataIndex="id" key="id" />
            <Column title="Naam" dataIndex="name" key="name" />
            <Column title="Achternaam" dataIndex="achternaam" key="achternaam" />
            <Column title="Positie" dataIndex="positie" key="positie" />
            <Column title="Nummer t-shirt:" dataIndex="nummer" key="nummer" />
             </ColumnGroup>
              </Table>
            
        </div>

           
        );
    }

}


export default lijst;