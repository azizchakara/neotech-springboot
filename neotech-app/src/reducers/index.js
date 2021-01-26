import { combineReducers } from "redux";
import errorReducer from "./errorReducer";
import candidatReducer from "./candidatReducer";
import securityReducer from "./securityReducer";

export default combineReducers({
  errors: errorReducer,
  candidats: candidatReducer,
  securityReducer: securityReducer,
});
