import axios from "axios";

const API_URL = 'http://localhost:8222';

export const useCustomerSubscriptions = () => {

    const getCustomerSubscriptions = async (id) => {
        try {
            const response = await axios.get(`${API_URL}/api/v1/telco/customer-subscription/view/${id}`);
            return response.data;
        } catch (error) {
            throw new Error('An error occurred while fetching services');
        }
    };





      const subscribe = async (data) => {
        try {
          const response = await axios({
            method: "post",
            url: `${API_URL}/api/v1/telco/customer-subscription/subscribe`,
            data: {
              paytype: data.paytype,
              phone: data.phone,
              basePackage:data.basePackage
            },
            withCredentials: true,
          })
          return response;
        } catch (error) {
          console.log("err", error);
          throw new Error(error.response.data.error.message);
        }
      };

      const creditTopup = async (data) => {
        try {
          const response = await axios({
            method: "post",
            url: `${API_URL}/api/v1/telco/customer-subscription/creditTopup`,
            data: {
              customerId: data.customerId,
              amount: data.amount,
            },
            withCredentials: true,
          })
          return response;
        } catch (error) {
          console.log("err", error);
          throw new Error(error.response.data.error.message);
        }
      };

      const voiceTopup = async (data) => {
        try {
          const response = await axios({
            method: "post",
            url: `${API_URL}/api/v1/telco/customer-subscription/voiceTopup`,
            data: {
              customerId: data.customerId,
              amount: data.amount,
            },
            withCredentials: true,
          })
          return response;
        } catch (error) {
          console.log("err", error);
          throw new Error(error.response.data.error.message);
        }
      };
      const dataTopup = async (data) => {
        try {
          const response = await axios({
            method: "post",
            url: `${API_URL}/api/v1/telco/customer-subscription/dataTopup`,
            data: {
              customerId: data.customerId,
              amount: data.amount,
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
            url: `${API_URL}/api/v1/telco/customer-subscription/unsubscribe`,
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
        getCustomerSubscriptions,
        subscribe,
        unSubscribe,
        creditTopup,
        voiceTopup,
        dataTopup
    };  

}