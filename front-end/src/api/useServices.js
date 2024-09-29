import axios from "axios";

const API_URL = 'http://localhost:8222';

export const useServices = () => {

    const getServices = async () => {
        try {
            const response = await axios.get(`${API_URL}/api/v1/telco/services/viewAll`);
            return response.data;
        } catch (error) {
            throw new Error('An error occurred while fetching services');
        }
    };


    const getSubscribedServices = async (id) => {
        try {
            const response = await axios.get(`${API_URL}/api/v1/telco/services/viewSubscribedServices/${id}`);
            return response.data;
        } catch (error) {
            throw new Error('An error occurred while fetching services');
        }
    };

    const add = async (data) => {
        try {
          const response = await axios({
            method: "post",
            url: `${API_URL}/api/v1/telco/services/add`,
            data: {
              name: data.name,
              price: data.price,
              status: data.status,
            },
            withCredentials: true,
          })
          return response;
        } catch (error) {
          console.log("err", error);
          throw new Error(error.response.data.error.message);
        }
      };

      const subscribe = async (data) => {
        try {
          const response = await axios({
            method: "post",
            url: `${API_URL}/api/v1/telco/services/subscribe`,
            data: {
              customerId: data.customerId,
              ServiceId: data.serviceId,
            },
            withCredentials: true,
          })
          return response;
        } catch (error) {
          console.log("err", error);
          throw new Error(error.response.data.error.message);
        }
      };
      const unSubscribe = async (data) => {
        try {
          const response = await axios({
            method: "post",
            url: `${API_URL}/api/v1/telco/services/unsubscribe`,
            data: {
              serviceSubscriptionId: data.serviceSubscriptionId,
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
        getServices,
        getSubscribedServices,
        add,
        subscribe,
        unSubscribe,
    };  

}