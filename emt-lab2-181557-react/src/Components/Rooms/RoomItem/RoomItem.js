import React from 'react';

const RoomItem = ({ room }) => {
    return (
        <div className="room-item">
            <h2>{room.name}</h2>
            <p>Category: {room.category}</p>
            <p>Number of Rooms: {room.numberOfRooms}</p>
            <p>Host: {room.host.name} {room.host.surname}</p>
            <p>Country: {room.host.country.name} ({room.host.country.continent})</p>
        </div>
    );
}

export default RoomItem;
