import React from 'react';
import { useNavigate } from 'react-router-dom';

const RoomForm = (props) =>{
    const navigate = useNavigate();

    const [formData, updateFormData] = React.useState({
        name:"",
        category:"ROOM",
        numOfRooms:0,
        hostId:0
    });


    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        });
    };
    const onFormSubmit = (e) => {
        e.preventDefault();
        const { name, category, numOfRooms, hostId } = formData;
        props.onAddRoom(name, category, numOfRooms, hostId,);
        navigate('/rooms');
    };

    return (
        <div className="container mt-5">
            <div className="row justify-content-center">
                <div className="col-md-8">
                    <div className="card">
                        <div className="card-header bg-primary text-white">
                            <h4>Add New Room</h4>
                        </div>
                        <div className="card-body">
                            <form onSubmit={onFormSubmit}>
                                <div className="mb-3">
                                    <label htmlFor="name" className="form-label">Room Name</label>
                                    <input
                                        type="text"
                                        className="form-control"
                                        id="name"
                                        name="name"
                                        required
                                        placeholder="Enter room name"
                                        onChange={handleChange}
                                    />
                                </div>
                                <div className="mb-3">
                                    <label className="form-label">Category</label>
                                    <select name="category" className="form-select" onChange={handleChange}>
                                        {props.categories.map((term, index) =>
                                            <option key={index} value={term}>{term}</option>
                                        )}
                                    </select>
                                </div>
                                <div className="mb-3">
                                    <label className="form-label">Host</label>
                                    <select name="hostId" className="form-select" onChange={handleChange}>
                                        {props.hosts.map((host) =>
                                            <option key={host.id} value={host.id}>{host.name}</option>
                                        )}
                                    </select>
                                </div>
                                <div className="mb-3">
                                    <label htmlFor="numOfRooms" className="form-label">Available Rooms</label>
                                    <input
                                        type="number"
                                        className="form-control"
                                        id="numOfRooms"
                                        name="numOfRooms"
                                        required
                                        placeholder="Enter available rooms"
                                        onChange={handleChange}
                                    />
                                </div>
                                <button type="submit" className="btn btn-success">Submit</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}
export default RoomForm;