import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import './activities.css';

const activities = (props) => {

    return (

        <div className={"container mm-4 mt-5"}>

            <div className={"row"}>
                <div className={"table-responsive "}>
                    <h1>All Activities</h1>
                    <table className={"table table-striped"}>

                        <thead>
                        <tr>
                            <th scope={"col"}>Name</th>
                            <th scope={"col"}>Description</th>
                            <th scope={"col"}>Category</th>
                            <th scope={"col"}>Company</th>
                            <th scope={"col"}>Location</th>
                            <th scope={"col"}>Days Available</th>
                            <th scope={"col"}>Opens</th>
                            <th scope={"col"}>Closes</th>
                        </tr>
                        </thead>
                        <tbody>
                        {props.activities.map((term) => {
                            return (
                                <tr>
                                    <td>{term.name}</td>
                                    <td>{term.description}</td>
                                    <td>{term.category.name}</td>
                                    <td>{term.company.name}</td>
                                    <td>{term.location.name}</td>
                                    <td>{term.daysAvailable}</td>
                                    <td>{term.openTime}</td>
                                    <td>{term.closeTime}</td>
                                </tr>
                            );
                        })}
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    );
}
export default activities;