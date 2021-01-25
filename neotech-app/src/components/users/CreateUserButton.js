import React from "react";
import { Link } from "react-router-dom";

const CreateUserButton = () => {
  return (
    <React.Fragment>
      <Link to="/addUser" className="btn btn-lg btn-info">
        Submit
      </Link>
    </React.Fragment>
  );
};

export default CreateUserButton;
