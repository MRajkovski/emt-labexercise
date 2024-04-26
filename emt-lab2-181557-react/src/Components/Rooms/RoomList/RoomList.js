import React, { useState, useEffect } from 'react';
import RoomItem from '../RoomItem/RoomItem.js';

function RoomList() {
    const [rooms, setRooms] = useState([]);

    useEffect(() => {
        fetch('localhost:8081/api/rooms')
            .then(response => response.json())
            .then(data => setRooms(data))
            .catch(error => console.error('Error fetching rooms:', error));
    }, []); // Empty dependency array means this effect runs only once when the component mounts

    return (
        <div className="room-list">
            <h2>Rooms Available</h2>
            {rooms.map(room => (
                <RoomItem key={room.id} room={room} />
            ))}
        </div>
    );
}

export default RoomList;
