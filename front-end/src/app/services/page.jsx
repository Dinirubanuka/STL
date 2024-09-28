import { useState } from "react";
import { Typography, Box, CircularProgress, Snackbar, Alert, Button } from "@mui/material";

const mockServices = [
  { id: 1, name: "Service A", description: "Description for Service A" },
  { id: 2, name: "Service B", description: "Description for Service B" },
  { id: 3, name: "Service C", description: "Description for Service C" },
];

const Services = () => {
  const [services, setServices] = useState(mockServices); // Use mock data
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
            {services.map((service) => (
              <Box
              key={service.id}
              sx={{
                margin: 2,
                padding: 2,
                border: '1px solid #ccc',
                borderRadius: '4px',
                display: 'flex',  // Align content horizontally
                justifyContent: 'space-between',  // Space between text and button
                alignItems: 'center',  // Vertically align items
              }}
            >
              <Box>
                <Typography variant="h6">{service.name}</Typography>
                <Typography>{service.description}</Typography>
              </Box>
              <Button
                variant="contained"
                color={service.active ? "secondary" : "primary"}
                onClick={() => toggleServiceActivation(service.id)}
              >
                {service.active ? "Deactivate" : "Activate"}
              </Button>
            </Box>
            
            ))}
          </>
        )}
      </Box>

      {/* Error Snackbar */}
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
