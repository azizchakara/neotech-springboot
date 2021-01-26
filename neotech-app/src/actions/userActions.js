import axios from "axios";
import { GET_ERRORS } from "./types";

export const createUser = (users, history) => async (dispatch) => {
  try {
    const res = await axios.post("http://localhost:8084/users", users);
    history.push("/dashboard");
  } catch (err) {
    dispatch({
      type: GET_ERRORS,
      payload: err.response.data,
    });
  }
};
