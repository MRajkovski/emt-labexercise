import React from 'react';
import {Link} from 'react-router-dom';

const RoomBook = (props) => {
    return (
        <tr>
            <td>{props.term.name}</td>
            <td>{props.term.category}</td>
            <td>{props.term.numOfRooms}</td>
            <td>{props.term.host.name} </td>
            <td className={"text-right"}>
                <a title={"Delete"} className={"btn btn-danger m-1"}
                   onClick={() => props.onDelete(props.term.id)}>
                    Delete
                </a>
                <Link className={"btn btn-info ml-2"}
                      onClick={() => props.onEdit(props.term.id)}
                      to={`/rooms/edit/${props.term.id}`}>
                    Edit
                </Link>
                {props.term.numOfRooms > 0 && (
                    <a
                        title={"Book"}
                        className={"btn btn-success m-1"}
                        onClick={() => props.onBook(props.term.id)}
                    >
                        Book
                    </a>
                )}
            </td>
        </tr>
    )
}

export default RoomBook;
