import React from "react";
import { ThemeProvider } from "@mui/material/styles";
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
import ChangePassword from "../forgotPassword/page";
import Link2 from "@mui/material/Link";


function Login() {
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
          component={Paper}
          elevation={6}
          square
        >
          <Typography
            sx={{ margin: "20px", fontFamily: "inter" }}
            component="h1"
            variant="h5"
            className="font-extrabold text-black"
          >
            SriCare
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
                className="font-extrabold text-neutral-500"
                sx={{ fontFamily: "inter" }}
              >
                Login to your account
              </Typography>
              <Typography
                component="h1"
                variant="h5"
                className="font-light text-neutral-500"
              >
                Welcome back !
              </Typography>
            </Stack>

            <Box
              component="form"
              noValidate
              onSubmit={handleSubmit}
              sx={{ mt: 1, width: formWidth }}
            >
              <TextField
                margin="normal"
                required
                fullWidth
                type="text"
                id="username"
                ref={userRef}
                label="Username"
                autoComplete="on"
                {...userAttributes}
              />
              <TextField
                margin="normal"
                required
                fullWidth
                type="password"
                id="password"
                label="Password"
                onChange={(e) => setPwd(e.target.value)}
                value={pwd}
              />
              <FormControlLabel
                control={
                  <Checkbox
                    color="primary"
                    id="remember"
                    onChange={toggleCheck}
                    checked={check}
                  />
                }
                label="Remember me"
              />
              <Button
                type="submit"
                fullWidth
                variant="contained"
                sx={{ mt: 3, mb: 2, padding: "10px" }}
                className="rounded-full bg-slate-900 hover:bg-sky-700"
              >
                Sign In
              </Button>
              <Grid container>
                <Grid item xs>
                  <ChangePassword />
                </Grid>
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
