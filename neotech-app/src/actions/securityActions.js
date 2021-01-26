import axios from "axios";
import { GET_ERRORS, SET_CURRENT_USER } from "./types";
import setJWTTOKEN from "../securityUtils/setJWTTOKEN";
import jwt_decode from "jwt-decode";

export const createNewUser = (newUser, history) => async (dispatch) => {
  try {
    console.log("gg");
    await axios.post("/users/login", newUser);
    history.push("login");
    dispatch({
      type: GET_ERRORS,
      payload: {},
    });
  } catch (err) {
    console.log(err);
  }
};

export const login = (loginRequest) => async (dispatch) => {
  try {
    const res = await axios.post("/users/login", loginRequest);
    const { token } = res.data;
    localStorage.setItem("jwtToken", token);
    setJWTTOKEN(token);
    const decoded = jwt_decode(token);
    dispatch({
      type: SET_CURRENT_USER,
      playload: decoded,
    });
  } catch (err) {
    dispatch({
      type: GET_ERRORS,
      playload: err.response.data,
    });
  }
};