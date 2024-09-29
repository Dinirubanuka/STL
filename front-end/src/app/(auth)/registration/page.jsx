"use client";

import React from "react";
import { ThemeProvider, createTheme } from "@mui/material/styles";
import { Snackbar } from "@mui/material";
import { Alert } from "@mui/material";
import Grid from "@mui/material/Grid";
import Typography from "@mui/material/Typography";
import Box from "@mui/material/Box";
import { Stack } from "@mui/material";
import Button from "@mui/material/Button";
import CssBaseline from "@mui/material/CssBaseline";
import TextField from "@mui/material/TextField";
import Link from "@mui/material/Link";

function Register() {
  const defaultTheme = createTheme();

  // UI-specific variables and placeholders
  const formWidth = "50%"; // Adjust the form width if necessary
  const errMsg = ""; // Placeholder for error message
  const handleClose = () => {}; // Placeholder for closing the Snackbar

  return (
    <ThemeProvider theme={defaultTheme}>
      <Snackbar
        open={Boolean(errMsg)}
        autoHideDuration={6000} // Adjust the duration as needed
        onClose={handleClose}
        anchorOrigin={{
          vertical: "top",
          horizontal: "center",
        }}
      >
        <Alert
          severity="error"
          onClose={handleClose}
          role="alert"
          variant="filled"
        >
          {errMsg}
        </Alert>
      </Snackbar>
      <Grid container component="main" sx={{ height: "100vh" }}>
        <Grid item xs={12} sm={12} md={12} component={Box} elevation={6} square>
          <Typography
            sx={{ margin: "20px", fontFamily: "inter" }}
            component="h1"
            variant="h5"
            className="font-extrabold text-black"
          >
            Sri-Care
          </Typography>
          <Box
            sx={{
              height: "90%",
              mx: 5,
              display: "flex",
              flexDirection: "column",
              alignItems: "center",
              justifyContent: "center",
            }}
          >
            <Stack justifyContent="center" alignItems="center" spacing={3}>
              <Typography
                component="h1"
                variant="h4"
                className="font-extrabold text-black"
                sx={{ fontFamily: "inter" }}
              >
                Create Your Account
              </Typography>
              <Typography
                component="h1"
                variant="h5"
                className="font-light text-black"
              >
                Welcome aboard!
              </Typography>
            </Stack>

            <Box component="form" noValidate sx={{ mt: 1, width: formWidth }}>
              <TextField
                margin="normal"
                required
                fullWidth
                type="text"
                id="firstName"
                label="First Name"
                autoComplete="on"
              />
              <TextField
                margin="normal"
                required
                fullWidth
                type="text"
                id="lastName"
                label="Last Name"
                autoComplete="on"
              />
              <TextField
                margin="normal"
                required
                fullWidth
                type="email"
                id="email"
                label="Email"
                autoComplete="on"
              />
              <TextField
                margin="normal"
                required
                fullWidth
                type="text"
                id="mobileNumber"
                label="Mobile Number"
              />
              <TextField
                margin="normal"
                required
                fullWidth
                type="password"
                id="password"
                label="Password"
              />
              <TextField
                margin="normal"
                required
                fullWidth
                type="password"
                id="confirmPassword"
                label="Confirm Password"
              />
              <Button
                type="submit"
                fullWidth
                variant="contained"
                sx={{ mt: 3, mb: 2, padding: "10px" }}
                className="bg-slate-900 hover:bg-blue-700"
              >
                Register
              </Button>
              <Grid container>
                <Grid item>
                  <Link href="/login" variant="body2">
                    {"Already have an account? Sign In"}
                  </Link>
                </Grid>
              </Grid>
            </Box>
          </Box>
        </Grid>
        <CssBaseline />
      </Grid>
    </ThemeProvider>
  );
}

export default Register;


// const {
//   page,
//   setPage,
//   title,
//   subtitle,
//   handleSubmit,
//   getValues,
//   setValue
// } = useFormContext();
// const [errMsg, setErrMsg] = useState('');
// const handleClose = () => {
//   setErrMsg('');
// };

// const onSubmit = async (e) => {
//   if(page === 2){
//     const data = getValues();
//     try{
//       const response = await axios.post('register', data);
//       if(response.data.message === 'User added successfully'){
//         setPage(page + 1);
//       }else{
//         setErrMsg(response.data.message);
//       }
//     }catch(err){
//       setErrMsg(err.response.data.message);
//     }
//   }else{
//     setPage(page + 1);
//   }

    
// };

// const handlePrev = () => setPage(page - 1);
// const handleNext = () => setPage(page + 1);

// const navigate = useNavigate();
// const handleButtonClick = () => {
//   navigate("/");
// };
