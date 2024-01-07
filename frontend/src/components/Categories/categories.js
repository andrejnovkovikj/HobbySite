import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import './categories.css';
import {Link} from "react-router-dom";

const categories = (props) => {

    return (

        <div className={"container mm-4 mt-5"}>

            <div className={"row"}>

                <div className={"table-responsive "}>
                    <h1>Categories</h1>
                    <table className={"table table-striped"}>

                        <thead>
                        <tr>
                            <th scope={"col"}>Name</th>
                        </tr>
                        </thead>
                        <tbody>
                        {props.categories.map((term) => {
                            return (
                                <tr>
                                    <Link className="nav-link" to={`/activities`}>{term.name}</Link>
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
export default categories;