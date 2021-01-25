import React, { Component } from "react";
import Candidatitem from "./candidats/Candidatitem";
import CreateCandidatButton from "./candidats/CreateCandidatButton";
import { connect } from "react-redux";
import { getCandidats } from "../actions/candidatsActions";
import PropTypes from "prop-types";

class Dashboard extends Component {
  componentDidMount() {
    this.props.getCandidats();
  }

  render() {
    const { candidats } = this.props.candidat;
    console.log(this.props.candidat);

    return (
      <div className="projects">
        <div className="container">
          <div className="row">
            <div className="col-md-12">
              <h1 className="display-4 text-center">Espace des candidatures</h1>
              <br />
              <CreateCandidatButton />
              <br />
              <hr />
              {candidats.map((candidat) => (
                <Candidatitem key={candidat.id} candidat={candidat} />
              ))}
            </div>
          </div>
        </div>
      </div>
    );
  }
}

Dashboard.propTypes = {
  candidat: PropTypes.object.isRequired,
  getCandidats: PropTypes.func.isRequired,
};

const mapStateToProps = (state) => ({
  candidat: state.candidats,
});

export default connect(mapStateToProps, { getCandidats })(Dashboard);
