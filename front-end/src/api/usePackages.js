import axios from "axios";

const API_URL = 'http://localhost:8222';

export const usePackages= () => {

    const getPackages = async () => {
        try {
            const response = await axios.get(`${API_URL}/api/v1/telco/packages/viewAll`);
            return response.data;
        } catch (error) {
            throw new Error('An error occurred while fetching services');
        }
    };


    const getActivatePackages = async (id) => {
        try {
            const response = await axios.get(`${API_URL}/api/v1/telco/packages/viewActivePackages/${id}`);
            return response.data;
        } catch (error) {
            throw new Error('An error occurred while fetching services');
        }
    };

    const add = async (data) => {
        try {
          const response = await axios({
            method: "post",
            url: `${API_URL}/api/v1/telco/packages/add`,
            data: {
              name: data.name,
              price: data.price,
              size: data.size,
              payType: data.payType,
              serviceType:data.serviceType
            },
            withCredentials: true,
          })
          return response;
        } catch (error) {
          console.log("err", error);
          throw new Error(error.response.data.error.message);
        }
      };

      const activate = async (data) => {
        console.log(data);
        try {
          const response = await axios({
            method: "post",
            url: `${API_URL}/api/v1/telco/packages/activate`,
            data: {
              customerId: data.customerId,
              packageId: data.packageId,
            },
            withCredentials: true,
          })
          return response;
        } catch (error) {
          console.log("err", error);
          throw new Error(error.response.data.error.message);
        }
      };
      const deactivate = async (data) => {
        try {
          const response = await axios({
            method: "post",
            url: `${API_URL}/api/v1/telco/packages/deactivate`,
            data: {
              packageActivationId: data.packageActivationId,
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
        getPackages,
        getActivatePackages,
        add,
        activate,
        deactivate
    };  

}