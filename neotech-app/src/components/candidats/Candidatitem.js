import React, { Component } from "react";

class Candidatitem extends Component {
  render() {
    const { candidat } = this.props;
    return (
      <div className="container">
        <div className="card card-body bg-light mb-3">
          <div className="row">
            <div className="col-2"></div>
            <div className="col-lg-6 col-md-4 col-8">
              <h3>{candidat.firstName}</h3>
              <p>{candidat.lastName}</p>
            </div>
            <div className="col-md-4 d-none d-lg-block">
              <ul className="list-group">
                <a href="#">
                  <li className="list-group-item board">
                    <i className="fa fa-flag-checkered pr-1">
                      Liste des candidats{" "}
                    </i>
                  </li>
                </a>
                <a href="#">
                  <li className="list-group-item update">
                    <i className="fa fa-edit pr-1">Modifier candidature</i>
                  </li>
                </a>
                <a href="">
                  <li className="list-group-item delete">
                    <i className="fa fa-minus-circle pr-1">
                      Supprimer candidature
                    </i>
                  </li>
                </a>
              </ul>
            </div>
          </div>
        </div>
      </div>
    );
  }
}
export default Candidatitem;
