import React from 'react';
import { useNavigate } from 'react-router-dom';

const RoomEdit = (props) => {

    const navigate = useNavigate();

    const [formData, updateFormData] = React.useState({
        name: "",
        category: "HOUSE",
        numOfRooms: -1,
        hostId: -1
    });

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        });
    };

    const onFormSubmit = (e) => {
        e.preventDefault();
        const name = formData.name !== "" ? formData.name : (props.room ? props.room.name : '');
        const category = formData.category !== "HOUSE" ? formData.category : (props.room ? props.room.category : '');
        const numOfRooms = formData.numOfRooms !== -1 ? formData.numOfRooms : (props.rooms ? props.rooms.numOfRooms : 0);
        const hostId = formData.hostId !== -1 ? formData.hostId : (props.room ? props.room.host.id : 0);

        props.onEditRoom(props.rooms.id, name, category, numOfRooms,hostId);
        navigate("/rooms");
    };
    return (
        <div className="container mt-5">
            <div className="row justify-content-center">
                <div className="col-md-8">
                    <div className="card">
                        <div className="card-header bg-primary text-white">
                            <h4>Edit Room</h4>
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
                                        placeholder={props.room ? props.room.name : ''}
                                        onChange={handleChange}
                                    />
                                </div>
                                <div className="mb-3">
                                    <label className="form-label">Category</label>
                                    <select name="category" className="form-select" onChange={handleChange} value={formData.category}>
                                        {props.categories.map((term, index) => (
                                            <option key={index} value={term}>{term}</option>
                                        ))}
                                    </select>
                                </div>
                                <div className="mb-3">
                                    <label htmlFor="numOfRooms" className="form-label">Available Rooms</label>
                                    <input
                                        type="number"
                                        className="form-control"
                                        id="numOfRooms"
                                        name="numOfRooms"
                                        placeholder={props.room ? props.room.numOfRooms : ''}
                                        onChange={handleChange}
                                    />
                                </div>
                                <div className="mb-3">
                                    <label className="form-label">Host</label>
                                    <select name="hostId" className="form-select" onChange={handleChange} value={formData.hostId}>
                                        {props.hosts.map(host => (
                                            <option key={host.id} value={host.id}>{host.name}</option>
                                        ))}
                                    </select>
                                </div>

                                <button type="submit" className="btn btn-success">Update</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default RoomEdit;