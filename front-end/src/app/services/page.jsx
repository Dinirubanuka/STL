import { useState, useEffect } from "react";
import { Typography, Box, CircularProgress, Snackbar, Alert } from "@mui/material";
import { useParams } from "react-router-dom";

const Services = () => {
  const { userId } = useParams();
  const [services, setServices] = useState([]);
  const [loading, setLoading] = useState(false);
  const [errorMsg, setErrorMsg] = useState("");
  const [success, setSuccess] = useState(false);

  // Mock data for services (replace this with your actual data fetching logic)
  const mockServices = [
    { id: 1, name: "Service 1", description: "Description for Service 1" },
    { id: 2, name: "Service 2", description: "Description for Service 2" },
    { id: 3, name: "Service 3", description: "Description for Service 3" },
  ];

  useEffect(() => {
    setLoading(true);
    setErrorMsg("");
    try {
      // Simulate fetching services (replace with actual API call if needed)
      setTimeout(() => {
        setServices(mockServices);
        setSuccess(true);
      }, 1000); // Simulating a 1 second API call delay
    } catch (err) {
      setErrorMsg("Failed to fetch services");
    } finally {
      setLoading(false);
    }
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
            {services?.map((service) => (
              <Box key={service.id} sx={{ padding: 2, border: "1px solid #ccc", margin: 2 }}>
                <Typography variant="h6">{service.name}</Typography>
                <Typography variant="body2" color="textSecondary">
                  {service.description}
                </Typography>
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
          Services loaded successfully!
        </Alert>
      </Snackbar>
    </>
  );
};

export default Services;
