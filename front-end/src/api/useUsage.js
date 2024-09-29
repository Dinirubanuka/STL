import axios from "axios";

const API_URL = 'http://localhost:8222';

export const useUsages = () => {

    const usage = async (data) => {
        try {
          const response = await axios({
            method: "post",
            url: `${API_URL}/api/v1/telco/usage/use`,
            data: {
              packageActivationId: data.packageActivationId,
              usage:data.usage,
            },
            withCredentials: true,
          })
          return response;
        } catch (error) {
          console.log("err", error);
          throw new Error(error.response.data.error.message);
        }
      };
    
    return {
       usage
    };  

}