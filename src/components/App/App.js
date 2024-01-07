import React, { Component } from "react";
import './App.css';
import Activities from "../Activities/activities";
import HobbySiteService from "../../repository/hobbysiteRepository";
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import Header from "../Header/header";
import Categories from "../Categories/categories";
import Homepage from "../HomePage/homepage";

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            activities: [],
            categories: [],
        };
    }

    render() {
        return (

            <Router>
                <Header />
                <main className={"container"}>
                    <Routes>
                        <Route path="/" element={<Homepage homepage={this.state.homepage} />} />
                        <Route path="/activities" element={<Activities activities={this.state.activities} />} />
                        <Route path="/categories" element={<Categories categories={this.state.categories} />} />
                    </Routes>
                </main>
            </Router>
        );
    }

    componentDidMount() {
        this.loadActivities();
        this.loadCategories();
    }

    loadActivities = () => {
        HobbySiteService.fetchActivities()
            .then((data) => {
                this.setState({
                    activities: data.data
                });
            });
    }

    loadCategories = () => {
        HobbySiteService.fetchCategories()
            .then((data) => {
                this.setState({
                    categories: data.data
                });
            });
    }
}

export default App;