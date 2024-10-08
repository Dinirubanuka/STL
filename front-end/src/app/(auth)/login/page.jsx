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
import FormControlLabel from "@mui/material/FormControlLabel";
import Checkbox from "@mui/material/Checkbox";
import Link2 from "@mui/material/Link";

function Login() {
  const defaultTheme = createTheme();

  // UI-specific variables and placeholders
  const formWidth = "50%"; // Adjust the form width if necessary
  const errMsg = ""; // Placeholder for error message
  const handleClose = () => {}; // Placeholder for closing the Snackbar
  const toggleCheck = () => {}; // Placeholder for checkbox toggle
  const check = false; // Checkbox state

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
        <Grid
          item
          xs={12}
          sm={12}
          md={12}
          component={Box}
          elevation={6}
          square
        >
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
                Login to your account
              </Typography>
              <Typography
                component="h1"
                variant="h5"
                className="font-light text-black"
              >
                Welcome!
              </Typography>
            </Stack>

            <Box
              component="form"
              noValidate
              sx={{ mt: 1, width: formWidth }}
            >
              <TextField
                margin="normal"
                required
                fullWidth
                type="text"
                id="username"
                label="Username"
                autoComplete="on"
              />
              <TextField
                margin="normal"
                required
                fullWidth
                type="password"
                id="password"
                label="Password"
              />
              <Button
                type="submit"
                fullWidth
                variant="contained"
                sx={{ mt: 3, mb: 2, padding: "10px" }}
                className="bg-slate-900 hover:bg-blue-700"
              >
                Sign In
              </Button>
              <Grid container>
                <Grid item>
                  <Link2 href="/registration" variant="body2">
                    {"Don't have an account? Sign Up"}
                  </Link2>
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

export default Login;



// const { setAuth } = useAuth();

//   const navigate = useNavigate();
//   const userRef = useRef();

//   const [user, resetUser, userAttributes] = useInput("user", "");
//   const [pwd, setPwd] = useState("");
//   const [errMsg, setErrMsg] = useState("");
//   const [check, toggleCheck] = useToggle("persist", false);

//   const handleClose = () => {
//     setErrMsg("");
//   };

//   useEffect(() => {
//     userRef.current.focus();
//   }, []);

//   const isXsScreen = useMediaQuery((theme) => theme.breakpoints.down("sm"));
//   const formWidth = isXsScreen ? "70%" : "30%";

//   const handleSubmit = async (e) => {
//     e.preventDefault();
//     try {
//       const response = await axios.post(
//         "login",
//         JSON.stringify({ username: user, pass: pwd }),
//         {
//           headers: { "Content-Type": "application/json" },
//           withCredentials: true,
//         }
//       );

//       const role = response.data.userrole;
//       const accessToken = response.data.accessToken;
//       //decode phone
//       const phone = jwt_decode(accessToken).phone;
//       const userId = jwt_decode(accessToken).userId;
//       setAuth({ role, accessToken, phone, userId });
//       // resetUser();
//       // setPwd("");

//       if (role === "user") {
//         navigate("/general-user");
//       } else {
//         navigate("/surpport");
//       }
//     } catch (err) {
//       if (!err?.response) {
//         setErrMsg("Network error");
//       } else if (err.response?.status === 400) {
//         setErrMsg("Missing username or password");
//       } else if (err.response?.status === 401) {
//         setErrMsg("Unauthorized");
//       } else {
//         setErrMsg("Login failed, try again");
//       }
//     }
//   };
