"use client";

import React from 'react';
import Grid from '@mui/material/Grid';
import Paper from '@mui/material/Paper';
import { Avatar, Typography } from '@mui/material';
import SectionTitle from '../../components/profile/SectionTitle';
import PersonIcon from '@mui/icons-material/Person';
import Badge from '@mui/material/Badge';
import Stack from '@mui/material/Stack';
import theme from '../../components/theme/theme';

function ProfilePage() {
  const [profileData, setProfileData] = React.useState({
    fname: "John",
    lname: "Doe",
    password: "password123",
  });

  return (
    <Stack sx={{
      [theme.breakpoints.up('md')]: {
        justifyContent: 'center',
        height: '90vh'
      },
      [theme.breakpoints.down('md')]: {
        height: 'auto',
        justifyContent: 'space-between',
        width: '70%',
        marginTop: 2
      }
    }}>
      <Grid container sx={{ height: '90%' }}>
        <Grid item xs={12} md={12}>
          <Paper sx={{ display: 'flex', flexDirection: 'column', alignItems: 'center', padding: 2 }} className='rounded-tl-lg shadow-md'>
            <SectionTitle titleText={"Your Profile"} />
            <Avatar sx={{ width: 200, height: 200 }} className='bg-green-800'>
              <PersonIcon sx={{ fontSize: 150 }} />
            </Avatar>
            <Badge badgeContent={'USER'} color="success" />
            <Typography sx={{ marginTop: 2 }}>
              {profileData.fname} {profileData.lname}
            </Typography>
            <Typography sx={{ marginTop: 2 }}>
              Password: {profileData.password}
            </Typography>
          </Paper>
          <Paper sx={{ display: 'flex', flexDirection: 'column', alignItems: 'center', padding: 2, boxShadow: 'none' }} className='rounded-bl-xl shadow-md'>
            <Stack justifyContent='center' alignItems='center' direction='row'>
              <SectionTitle titleText={"Your Information"} />
            </Stack>
            {/* Additional content for user's information can go here */}
          </Paper>
        </Grid>
      </Grid>
    </Stack>
  );
}

export default ProfilePage;
