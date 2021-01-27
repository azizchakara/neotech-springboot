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
              <div className="container">
                <div className="card card-body bg-light mb-3">
                  <div className="row">
                    <div className="col-2">
                      <span className="mx-auto"></span>
                    </div>
                    <div className="col-lg-6 col-md-4 col-8"></div>
                    <div className="col-md-4 d-none d-lg-block">
                      <ul className="list-group">
                        <a href="#">
                          <li className="list-group-item board">
                            <i className="fa fa-flag-checkered pr-1">
                              Liste des candidats
                            </i>
                          </li>
                        </a>
                        <a href="#">
                          <li className="list-group-item update">
                            <i className="fa fa-edit pr-1">Modifier candidat</i>
                          </li>
                        </a>
                        <a href="">
                          <li className="list-group-item delete">
                            <i className="fa fa-minus-circle pr-1">
                              Supprimer candidat
                            </i>
                          </li>
                        </a>
                      </ul>
                    </div>
                  </div>
                </div>
              </div>
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
