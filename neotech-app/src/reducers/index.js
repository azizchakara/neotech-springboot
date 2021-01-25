import { combineReducers } from "redux";
import errorReducer from "./errorReducer";
import candidatReducer from "./candidatReducer";

export default combineReducers({
  errors: errorReducer,
  candidats: candidatReducer,
});
