import axios from "axios";

const APII_URL = 'http://localhost:8222';

export const useServices = () => {

    const getServices = async () => {
        try {
            const response = await axios.get(`${APII_URL}/api/v1/telco/services/viewAll`);
            return response.data;
        } catch (error) {
            throw new Error('An error occurred while fetching services');
        }
    };

    return {
        getServices
    };  

}