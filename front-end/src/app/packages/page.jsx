"use client";

import * as React from "react";
import { Box, Typography, Grid, Card, CardContent, CardActions, Button, Divider } from "@mui/material";
import DataUsageIcon from '@mui/icons-material/DataUsage';
import CallIcon from '@mui/icons-material/Call';
import FlightTakeoffIcon from '@mui/icons-material/FlightTakeoff';

const mockDataAddOns = [
  { id: 1, name: "Basic Data Plan", description: "5GB for LKR 399", icon: <DataUsageIcon /> },
  { id: 2, name: "Standard Data Plan", description: "15GB for LKR 799", icon: <DataUsageIcon /> },
  { id: 3, name: "Pro Data Plan", description: "25GB for LKR 1,199", icon: <DataUsageIcon /> },
  { id: 4, name: "Premium Data Plan", description: "50GB for LKR 1,999", icon: <DataUsageIcon /> },
];

const mockVoiceAddOns = [
  { id: 1, name: "Basic Voice Plan", description: "100 minutes for LKR 199", icon: <CallIcon /> },
  { id: 2, name: "Standard Voice Plan", description: "250 minutes for LKR 399", icon: <CallIcon /> },
  { id: 3, name: "Pro Voice Plan", description: "500 minutes for LKR 699", icon: <CallIcon /> },
  { id: 4, name: "Unlimited Voice Plan", description: "Unlimited minutes for LKR 1,499", icon: <CallIcon /> },
];

const mockRoamingAddOns = [
  { id: 1, name: "Basic Roaming Plan", description: "1GB for LKR 1,999", icon: <FlightTakeoffIcon /> },
  { id: 2, name: "Standard Roaming Plan", description: "5GB for LKR 3,999", icon: <FlightTakeoffIcon /> },
  { id: 3, name: "Pro Roaming Plan", description: "10GB for LKR 6,999", icon: <FlightTakeoffIcon /> },
  { id: 4, name: "Unlimited Roaming Plan", description: "Unlimited data for LKR 14,999", icon: <FlightTakeoffIcon /> },
];

const Packages = () => {
  const renderPackages = (packages) => (
    <Grid container spacing={3}>
      {packages.map((pkg) => (
        <Grid item xs={12} sm={6} md={3} key={pkg.id}>
          <Card
            sx={{
              height: "100%",
              boxShadow: 3,
              borderRadius: 2,
              transition: "transform 0.3s, box-shadow 0.3s",
              '&:hover': {
                transform: "translateY(-5px)",
                boxShadow: 6,
              }
            }}
          >
            <CardContent>
              <Box display="flex" alignItems="center" mb={2}>
                <Box sx={{ fontSize: 40, color: 'primary.main', mr: 2 }}>
                  {pkg.icon}
                </Box>
                <Typography variant="h6" fontWeight="bold">
                  {pkg.name}
                </Typography>
              </Box>
              <Typography variant="body2" color="text.secondary">
                {pkg.description}
              </Typography>
            </CardContent>
            <CardActions>
              <Button size="small" variant="contained" color="primary" fullWidth>
                Select
              </Button>
            </CardActions>
          </Card>
        </Grid>
      ))}
    </Grid>
  );

  return (
    <Box sx={{ padding: 3 }}>
      {/* Data Add-Ons Section */}
      <Box sx={{ backgroundColor: "#f5f5f5", padding: 3, borderRadius: 2, marginBottom: 4 }}>
        <Typography variant="h5" gutterBottom>
          Data Add-Ons
        </Typography>
        <Divider sx={{ marginBottom: 2 }} />
        {renderPackages(mockDataAddOns)}
      </Box>

      {/* Voice Add-Ons Section */}
      <Box sx={{ backgroundColor: "#f5f5f5", padding: 3, borderRadius: 2, marginBottom: 4 }}>
        <Typography variant="h5" gutterBottom>
          Voice Add-Ons
        </Typography>
        <Divider sx={{ marginBottom: 2 }} />
        {renderPackages(mockVoiceAddOns)}
      </Box>

      {/* Roaming Add-Ons Section */}
      <Box sx={{ backgroundColor: "#f5f5f5", padding: 3, borderRadius: 2 }}>
        <Typography variant="h5" gutterBottom>
          Roaming Add-Ons
        </Typography>
        <Divider sx={{ marginBottom: 2 }} />
        {renderPackages(mockRoamingAddOns)}
      </Box>
    </Box>
  );
};

export default Packages;
