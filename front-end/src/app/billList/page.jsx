"use client";

import { useEffect, useState } from "react";
import { Snackbar, Alert, Box, Typography, CircularProgress, Link } from "@mui/material";
import ListItem from "./ListItem"; // Assuming ListItem is a presentational component

const BillList = () => {
  const [bills, setBills] = useState([]);
  const [loading, setLoading] = useState(false);
  const [errorMsg, setErrorMsg] = useState("");
  const [success, setSuccess] = useState(false);

  useEffect(() => {
    const fetchBills = async () => {
      setLoading(true);
      setErrorMsg("");
      try {
        // Simulating a network request with a timeout
        setTimeout(() => {
          const mockBills = [
            { id: 1, when: "2024-09-23", amount: 50, userId: "1234" },
            { id: 2, when: "2024-08-15", amount: 75, userId: "1234" },
            { id: 3, when: "2024-07-10", amount: 40, userId: "1234" },
          ];
          setBills(mockBills);
        }, 1000);
      } catch (err) {
        setErrorMsg("Failed to fetch bills");
      } finally {
        setLoading(false);
      }
    };
    fetchBills();
  }, []);

  const reversedBills = bills.sort((a, b) => {
    if (b.when < a.when) return -1;
    if (b.when > a.when) return 1;
    return 0;
  });

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
              Your Bills
            </Typography>
            <Link href={`billing/services/${bills[0]?.userId}`}>Services</Link>
            {reversedBills?.map((bill) => (
              <ListItem key={bill.id} bill={bill} />
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
        </Alert>
      </Snackbar>
    </>
  );
};

export default BillList;
