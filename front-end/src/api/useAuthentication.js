import axios from "axios";
import { nextTick } from "process";

const API_URL = "http://localhost:8222";

export const useAuthentication = () => {
  const signup = async (data) => {
    console.log("data", data);
    try {
      const response = await axios({
        method: "post",
        url: `${API_URL}api/v1/auth/register`,
        data: {
          firstname:data.firstname,
          lastname:data.lastname,
          nec:data.nec,
          mobileNumber:data.mobileNumber,
          email: data.email,
          password: data.password,
          
        },
        withCredentials: true,
      });

      console.log("res", response);
      return response;
    } catch (error) {
      console.log("err", error);
      throw new Error(error.response.data.error.message);
    }
  };

  const authorize = () => {
    return {
      name: "Tharindu Ranasinghe",
      sex: "male",
      no: "N7754121",
      nationality: "SRILANKAN",
      dob: "1995-02-02",
      proffession: "Softeware Engineer",
      doi: "2021-02-02",
      doe: "2031-02-02",
      type: "PASSPORT",
    };
  };
  const signin = async (data) => {
    try {
      const response = await axios({
        method: "post",
        url: `${API_URL}/auth/login`,
        data: {
          email: data.email,
          password: data.password,
        },
        withCredentials: true,
      });
      return response;
    } catch (error) {
      throw new Error(error.response.data.error.message);
    }
  };

  return {
    signin,
    signup,
    authorize,
  };
};
