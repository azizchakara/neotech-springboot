import React, { Component } from "react";
import PropTypes from "prop-types";
import { connect } from "react-redux";
import { createProject } from "../../actions/projectActions";
class AddProject extends Component {
  constructor() {
    super();
    this.state = {
      firstName: "",
      lastName: "",
      email: "",
      password: "",
      datedeCandidature: "",
    };
    this.onChange = this.onChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
  }
  onChange(e) {
    this.setState({ [e.target.name]: e.target.value });
    console.log(e.target);
  }
  onSubmit(e) {
    e.preventDefault();
    const newCandidature = {
      firstName: this.state.firstName,
      lastName: this.state.lastName,
      email: this.state.email,
      password: this.state.password,
      datedeCandidature: this.state.datedeCandidature,
    };
    this.props.createProject(newCandidature, this.props.history);
  }
  render() {
    return (
      <div>
        <div className="project">
          <div className="container">
            <div className="row">
              <div className="col-md-8 m-auto">
                <h5 className="display-4 text-center">Nouveau Candidature</h5>
                <hr />
                <form onSubmit={this.onSubmit}>
                  <div className="form-group">
                    <input
                      type="text"
                      className="form-control form-control-lg "
                      placeholder=" FirstName"
                      name="firstName"
                      value={this.state.firstName}
                      onChange={this.onChange}
                    />
                  </div>
                  <div className="form-group">
                    <input
                      type="text"
                      className="form-control form-control-lg"
                      placeholder="LastName"
                      name="lastName"
                      value={this.state.lastName}
                      onChange={this.onChange}
                    />
                  </div>
                  <div className="form-group">
                    <input
                      className="form-control form-control-lg"
                      placeholder="Email"
                      name="email"
                      value={this.state.email}
                      onChange={this.onChange}
                    />
                  </div>

                  <div className="form-group">
                    <input
                      type="password"
                      placeholder="Password"
                      className="form-control form-control-lg"
                      name="password"
                      value={this.state.password}
                      onChange={this.onChange}
                    />
                  </div>
                  <div className="form-group">
                    <input
                      type="date"
                      placeholder="datedeCandidature"
                      className="form-control form-control-lg"
                      name="datedeCandidature"
                      value={this.state.datedeCandidature}
                      onChange={this.datedeCandidature}
                    />
                  </div>
                  <input
                    type="submit"
                    className="btn btn-primary btn-block mt-4"
                  />
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

AddProject.propTypes = {
  createProject: PropTypes.func.isRequired,
};
export default connect(null, { createProject })(AddProject);
