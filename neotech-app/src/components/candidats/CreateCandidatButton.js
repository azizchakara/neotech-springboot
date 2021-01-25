import React from "react";
import { Link } from "react-router-dom";

const CreateCandidatButton = () => {
  return (
    <React.Fragment>
      <Link to="/addCandidature" className="btn btn-lg btn-info">
        Ajouter Candidature
      </Link>
    </React.Fragment>
  );
};

export default CreateCandidatButton;
