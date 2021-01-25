import logo from "./logo.svg";
import "./App.css";
import Dashboard from "./components/Dashboard";
import { Component } from "react";
import Header from "./components/Layout/Header";
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter as Router, Route } from "react-router-dom";
import AddCandidature from "./components/candidats/AddCandidature";
import { Provider } from "react-redux";
import store from "./store";

class App extends Component {
  render() {
    return (
      <Provider store={store}>
        <Router>
          <div className="App">
            <Header />
            <Route exact path="/dashboard" component={Dashboard} />
            <Route exact path="/addCandidature" component={AddCandidature} />
          </div>
        </Router>
      </Provider>
    );
  }
}
export default App;