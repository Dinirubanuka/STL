"use client"

import { useEffect, useState } from "react";
import { Typography, Box, CircularProgress, Snackbar, Alert } from "@mui/material";
import {useServices} from "@/api/useServices";


const mockServices = [
  { id: 1, name: "Service A", description: "Description for Service A" },
  { id: 2, name: "Service B", description: "Description for Service B" },
  { id: 3, name: "Service C", description: "Description for Service C" },
];

const Services = () => {
  const [services, setServices] = useState([]); // Use mock data
  const [loading] = useState(false); // Simulate loading state
  const [errorMsg, setErrorMsg] = useState("");
  const [success, setSuccess] = useState(false); // Simulate success state

  // Toggle activation for a service
  const toggleServiceActivation = (id) => {
    const updatedServices = services.map((service) =>
      service.id === id
        ? { ...service, active: !service.active }
        : service
    );
    setServices(updatedServices);
    setSuccess(true);
    setErrorMsg("Service status changed successfully!");
  };

  const { getServices } = useServices();
  const getService = async () => {
    try {
      const response = await getServices();
      // console.log(response);
      setServices(response);
    } catch (error) {
      console.error(error);
      throw new Error('An error occurred while fetching services');
    }
  }

  useEffect(() => {
    getService();
  }, []);

  return (
    <>
      <Box>
        {loading ? (
          <Box
            sx={{
              display: "flex",
              flexDirection: "column",
              alignItems: "center",
              justifyContent: "center",
              height: "100vh",
              marginTop: "-10vh",
            }}
          >
            <Typography variant="h5" color="primary">
              Loading...
            </Typography>
            <CircularProgress size={50} thickness={3} />
          </Box>
        ) : (
          <>
            <Typography variant="h4" color="secondary" align="center">
              Services
            </Typography>
            {services && services.map((service) => (
              <Box key={service.id} sx={{ margin: 2, padding: 2, border: '1px solid #ccc', borderRadius: '4px' }}>
                <Typography variant="h6">{service.name}</Typography>
                <Typography>from Rs: {service.price}</Typography>
                <Typography>Status: {service.status}</Typography>
              </Box>
            ))}
          </>
        )}
      </Box>

      <Snackbar
        open={errorMsg !== "" && !success}
        anchorOrigin={{ vertical: "top", horizontal: "center" }}
        onClose={() => setErrorMsg("")}
      >
        <Alert onClose={() => setErrorMsg("")} severity="error">
          {errorMsg}
        </Alert>
      </Snackbar>

      {/* Success Snackbar */}
      <Snackbar
        open={success}
        autoHideDuration={5000}
        anchorOrigin={{ vertical: "top", horizontal: "center" }}
        onClose={() => setSuccess(false)}
      >
        <Alert
          autoHideDuration={5000}
          onClose={() => setSuccess(false)}
          severity="success"
        >
          {errorMsg}
        </Alert>
      </Snackbar>
    </>
  );
};

export default Services;
