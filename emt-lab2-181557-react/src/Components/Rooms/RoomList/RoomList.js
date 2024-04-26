import React from 'react';
import ReactPaginate from 'react-paginate';
import { Link } from 'react-router-dom';
import RoomBook from "../RoomBook/RoomBook";

class RoomList extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            page: 0,
            size: 5
        };
    }

    render() {
        const offset = this.state.size * this.state.page;
        const nextPageOffset = offset + this.state.size;
        const pageCount = Math.ceil(this.props.rooms.length / this.state.size);
        const rooms = this.getRoomsPage(offset, nextPageOffset);

        return (
            <div className="container mt-5">
                <div className="row">
                    <div className="table-responsive">
                        <table className="table table-striped">
                            <thead>
                            <tr>
                                <th scope="col">Name</th>
                                <th scope="col">Category</th>
                                <th scope="col">Available Rooms</th>
                                <th scope="col">Host</th>
                            </tr>
                            </thead>
                            <tbody>
                            {rooms}
                            </tbody>
                        </table>
                    </div>
                    <div className="col mb-3">
                        <div className="row">
                            <div className="col-sm-12 col-md-12">
                                <Link className="btn btn-dark btn-block" to="/rooms/add">Add New Room</Link>
                            </div>
                        </div>
                    </div>
                </div>
                <ReactPaginate
                    previousLabel={"← Previous"}
                    nextLabel={"Next →"}
                    breakLabel={<span className="gap">...</span>}
                    breakClassName={"page-item"}
                    breakLinkClassName={"page-link"}
                    onPageChange={this.handlePageClick}
                    pageCount={pageCount}
                    marginPagesDisplayed={2}
                    pageRangeDisplayed={5}
                    containerClassName={"pagination justify-content-center"}
                    pageClassName={"page-item"}
                    pageLinkClassName={"page-link"}
                    previousClassName={"page-item"}
                    previousLinkClassName={"page-link"}
                    nextClassName={"page-item"}
                    nextLinkClassName={"page-link"}
                    activeClassName={"active"}
                />
            </div>
        );
    }
    handlePageClick = (data) => {
        this.setState({
            page: data.selected
        });
    };
    getRoomsPage = (offset, nextPageOffset) => {
        return this.props.rooms.map((term, index) => {
            return (
                <RoomBook
                    term={term}
                    onDelete={this.props.onDelete}
                    onEdit={this.props.onEdit}
                    onLowerAvailableNights={this.props.onLowerAvailableNights}
                />
            );
        }).filter((room, index) => {
            return index >= offset && index < nextPageOffset;
        });
    };

}
export default RoomList;
