import React, { Component } from "react";
import PropTypes from "prop-types";
import { connect } from "react-redux";
import { createCandidat } from "../../actions/candidatsActions";
class AddCandidature extends Component {
  constructor() {
    super();
    this.state = {
      firstName: "",
      lastName: "",
      email: "",
      datedeCandidature: "",
    };
    this.onChange = this.onChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
  }

  onChange(e) {
    this.setState({ [e.target.name]: e.target.value });
  }
  onSubmit(e) {
    e.preventDefault();
    const newCandidature = {
      firstName: this.state.firstName,
      lastName: this.state.lastName,
      email: this.state.email,
      datedeCandidature: this.state.datedeCandidature,
    };
    this.props.createCandidat(newCandidature, this.props.history);
  }
  render() {
    return (
      <div className="project">
        <div className="container">
          <div className="row">
            <div className="col-md-8 m-auto">
              <h5 className="display-4 text-center">Ajouter Candidature</h5>
              <hr />
              <form onSubmit={this.onSubmit}>
                <div className="form-group">
                  <input
                    type="text"
                    className="form-control form-control-lg "
                    placeholder="First Name"
                    name="firstName"
                    value={this.state.firstName}
                    onChange={this.onChange}
                  />
                </div>
                <div className="form-group">
                  <input
                    type="text"
                    className="form-control form-control-lg"
                    placeholder="Last Name"
                    name="lastName"
                    value={this.state.lastName}
                    onChange={this.onChange}
                  />
                </div>

                <input
                  className="form-control form-control-lg"
                  placeholder="Email"
                  name="email"
                  value={this.state.email}
                  onChange={this.onChange}
                ></input>
                <br></br>
                <div className="form-group">
                  <input
                    type="date"
                    className="form-control form-control-lg"
                    name="datedeCandidature"
                    value={this.state.datedeCandidature}
                    onChange={this.onChange}
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
    );
  }
}
AddCandidature.propTypes = {
  createCandidat: PropTypes.func.isRequired,
};

export default connect(null, { createCandidat })(AddCandidature);
