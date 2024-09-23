import { useState } from "react";
import { Typography, Box, CircularProgress, Snackbar, Alert } from "@mui/material";

const mockServices = [
  { id: 1, name: "Service A", description: "Description for Service A" },
  { id: 2, name: "Service B", description: "Description for Service B" },
  { id: 3, name: "Service C", description: "Description for Service C" },
];

const Services = () => {
  const [services] = useState(mockServices); // Use mock data
  const [loading] = useState(false); // Simulate loading state
  const [errorMsg, setErrorMsg] = useState("");
  const [success] = useState(false); // Simulate success state

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
              <Box key={service.id} sx={{ margin: 2, padding: 2, border: '1px solid #ccc', borderRadius: '4px' }}>
                <Typography variant="h6">{service.name}</Typography>
                <Typography>{service.description}</Typography>
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

      <Snackbar
        open={success}
        autoHideDuration={5000}
        anchorOrigin={{ vertical: "top", horizontal: "center" }}
        onClose={() => {
          setSuccess(false);
          setErrorMsg("");
        }}
      >
        <Alert
          autoHideDuration={5000}
          onClose={() => {
            setSuccess(false);
            setErrorMsg("");
          }}
          severity="success"
        >
          {errorMsg}
          {/* on success */}
        </Alert>
      </Snackbar>
    </>
  );
};

export default Services;
