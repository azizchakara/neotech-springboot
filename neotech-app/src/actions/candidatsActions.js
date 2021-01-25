import axios from "axios";
import { GET_ERRORS, GET_CANDIDATS } from "./types";

export const createCandidat = (candidats, history) => async (dispatch) => {
  try {
    const res = await axios.post("http://localhost:8084/candidats", candidats);
    history.push("/dashboard");
  } catch (err) {
    dispatch({
      type: GET_ERRORS,
      payload: err.response.data,
    });
  }
};

export const getCandidats = () => async (dispatch) => {
  const res = await axios.get("http://localhost:8084/candidats/all");
  dispatch({
    type: GET_CANDIDATS,
    payload: res.data,
  });
};
