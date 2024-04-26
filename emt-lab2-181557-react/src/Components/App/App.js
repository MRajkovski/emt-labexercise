import React from 'react';
import './App.css';
import RoomList from '../Rooms/RoomList/RoomList.js';

function App() {
    return (
        <div className="App">
            <header className="App-header">
                <h1>Welcome to Your Airbnb Clone</h1>
            </header>
            <main>
                <RoomList />
            </main>
        </div>
    );
}

export default App;
