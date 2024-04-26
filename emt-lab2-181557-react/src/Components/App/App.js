import React, {Component} from "react";
import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import RoomService from "../../Repository/RoomRepository";
import RoomForm from "../Rooms/RoomForm/RoomForm";
import CategoryList from "../CategoryList/CategoryList";
import RoomEdit from "../Rooms/RoomEdit/RoomEdit";
import Header from "../Header/Header";
import RoomList from '../Rooms/RoomList/RoomList.js';

class App extends Component{
    constructor(props) {
        super(props);
        this.state = {
            rooms: [],
            categories: []
        }
    }
    render(){
        return(
            <Router>
                <Header />
                <main>
                    <div className="container">

                        <Routes>
                            <Route
                                path={"/rooms"}
                                element={<RoomList
                                    rooms={this.state.rooms}
                                    onDelete={this.deleteRoom}
                                    onEdit={this.editRoom}
                                    onBook={this.bookRoom}
                                />}
                            />
                            <Route
                                path={"/"}
                                element={<RoomList
                                    rooms={this.state.rooms}
                                    onDelete={this.deleteRoom}
                                    onEdit={this.editRoom}
                                    onBook={this.bookRoom}
                                />}
                            />
                            <Route
                                path={"/categories"}
                                element={<CategoryList
                                    categories={this.state.categories}
                                />}
                            />
                            <Route
                                path={"/rooms/add"}
                                element={<RoomForm
                                    categories={this.state.categories}
                                />}
                            />
                            <Route
                                path={"/rooms/edit/:id"}
                                element={<RoomEdit
                                    categories={this.state.categories}
                                    onEditRoom={this.editRoom}
                                />}
                            />

                        </Routes>
                    </div>
                </main>
            </Router>
        );
    }
    componentDidMount() {
        this.fetchData()
    }

    fetchData = () => {
        this.loadCategories();
        this.loadRooms();
    }

    loadRooms = () => {
        RoomService.fetchRooms()
            .then((data) => {
                this.setState({
                    rooms: data.data
                })
            });
    }
    loadCategories = () => {
        RoomService.getCategories()
            .then((data) => {
                this.setState({
                    categories: data.data
                })
            });
    }
    deleteRoom = (id) => {
        RoomService.deleteRoom(id)
            .then(() => {
                this.loadRooms();
            });
    }

    bookRoom = (id) => {
        RoomService.bookRoom(id)
            .then(() => {
                this.loadRooms();
            });
    }

    addRoom = (name, category,numOfRooms ,hostId) => {
        RoomService.addRoom(name, category, numOfRooms, hostId)
            .then(() => {
                this.loadRooms();
            });
    }
    editRoom = (id, name, category,numOfRooms,hostId) => {
        RoomService.editRoom(id, name, category, numOfRooms, hostId)
            .then(() => {
                this.loadRooms();
            });
    }
}

export default App;
