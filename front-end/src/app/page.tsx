import * as React from "react";
import { Box, Tab, Tabs, Stack } from "@mui/material";
import { useState } from "react";
import Profile from "../app/profile/page";
import BillList from "../app/billList/page";
import Services from "../app/services/page";
// import ChatSurpport from "../../components/ChatApp/ChatSurpport";

function TabPanel(props) {
  const { children, value, index, ...other } = props;

  return (
    <div
      role="tabpanel"
      hidden={value !== index}
      id={`tabpanel-${index}`}
      aria-labelledby={`tab-${index}`}
      {...other}
    >
      {value === index && <Box sx={{ p: 3 }}>{children}</Box>}
    </div>
  );
}

export default function Home() {
  const [value, setValue] = useState(0);

  const handleChange = (event, newValue) => {
    setValue(newValue);
  };

  return (
    <div>
      <Box component="main" sx={{ flexGrow: 1, p: 3, height: "100vh" }}>
        <Box>
          <Stack direction="row" justifyContent="space-between">
            <h2 className="text-3xl font-bold">SriCare Home Page</h2>
          </Stack>

          <Tabs
            value={value}
            onChange={handleChange}
            aria-label="Home Tabs"
            centered
            sx={{ borderColor: "divider" }}
          >
            <Tab label="Profile" sx={{ fontWeight: "bold" }} />
            <Tab label="Billing" sx={{ fontWeight: "bold" }} />
            <Tab label="Services" sx={{ fontWeight: "bold" }} />
            <Tab label="Customer Support" sx={{ fontWeight: "bold" }} />
          </Tabs>

          <TabPanel value={value} index={0} style={{ overflowY: "auto", height: "80vh" }}>
            <Profile />
          </TabPanel>
          <TabPanel value={value} index={1} style={{ overflowY: "auto", height: "80vh" }}>
            <BillList />
          </TabPanel>
          <TabPanel value={value} index={2} style={{ overflowY: "auto", height: "80vh" }}>
            <Services />
          </TabPanel>
          {/* <TabPanel value={value} index={3} style={{ overflowY: "auto", height: "80vh" }}>
            <ChatSurpport />
          </TabPanel> */}
        </Box>
      </Box>
    </div>
  );
}
