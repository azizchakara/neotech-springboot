import { GET_CANDIDATS } from "../actions/types";
const initialState = {
  candidats: [],
  candidat: {},
};

export default function (state = initialState, action) {
  switch (action.type) {
    case GET_CANDIDATS:
      return {
        ...state,
        candidats: action.payload,
      };
    default:
      return state;
  }
}
