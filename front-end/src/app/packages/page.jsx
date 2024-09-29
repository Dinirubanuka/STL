"use client";

import * as React from "react";
import { Box, Typography, Grid, Card, CardContent, CardActions, Button, Divider } from "@mui/material";
import {usePackages} from "@/api/usePackages";

const mockDataAddOns = [
  { id: 1, name: "Data Pack A", description: "10GB for $10" },
  { id: 2, name: "Data Pack B", description: "20GB for $15" },
  { id: 3, name: "Data Pack C", description: "30GB for $20" },
  { id: 4, name: "Data Pack D", description: "50GB for $25" },
];

const mockVoiceAddOns = [
  { id: 1, name: "Voice Pack A", description: "100 minutes for $5" },
  { id: 2, name: "Voice Pack B", description: "200 minutes for $8" },
  { id: 3, name: "Voice Pack C", description: "500 minutes for $12" },
  { id: 4, name: "Voice Pack D", description: "Unlimited minutes for $20" },
];

const mockRoamingAddOns = [
  { id: 1, name: "Roaming Pack A", description: "1GB for $30" },
  { id: 2, name: "Roaming Pack B", description: "5GB for $60" },
  { id: 3, name: "Roaming Pack C", description: "10GB for $100" },
  { id: 4, name: "Roaming Pack D", description: "20GB for $150" },
];

const Packages = () => {
  const [pacs,setPacs] = React.useState([]);
  const { getPackages,activate } = usePackages();
  const getService = async () => {
    try {
      const response = await getPackages();
      console.log(response);
      setPacs(response);
    } catch (error) {
      console.error(error);
      throw new Error('An error occurred while fetching services');
    }
  }

  const handleActive = (id) => {
    console.log(id);
    activate({customerId:1,packageId:id});
  }

  React.useEffect(() => {
    getService();
  }, []);



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
              <Typography variant="h6" fontWeight="bold">
                {pkg.name}
              </Typography>
              <Typography variant="body2" color="text.secondary">
                {pkg.size} {pkg.size<500?"GB":"minutes"} for ${pkg.price}
              </Typography>
            </CardContent>
            <CardActions>
              <Button size="small" variant="contained" color="primary" fullWidth onClick={()=>handleActive(pkg.id)}>
                Active
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
        {renderPackages(pacs)}
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
