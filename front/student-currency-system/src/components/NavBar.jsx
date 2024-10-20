import * as React from "react";
import AppBar from "@mui/material/AppBar";
import Box from "@mui/material/Box";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import IconButton from "@mui/material/IconButton";
import MenuIcon from "@mui/icons-material/Menu";
import AccountCircle from "@mui/icons-material/AccountCircle";
import Switch from "@mui/material/Switch";
import FormControlLabel from "@mui/material/FormControlLabel";
import FormGroup from "@mui/material/FormGroup";
import MenuItem from "@mui/material/MenuItem";
import Menu from "@mui/material/Menu";
import { LuUserCircle2 } from "react-icons/lu";

import {
  Button,
  Drawer,
  DrawerBody,
  DrawerContent,
  DrawerHeader,
  DrawerOverlay,
  useDisclosure,
} from "@chakra-ui/react";

import Logo from "../img/Logo.png";

import { IoChevronDown } from "react-icons/io5";

const NavBar = () => {
  const [auth, setAuth] = React.useState(true);
  const [anchorEl, setAnchorEl] = React.useState(null);

  const handleChange = (event) => {
    setAuth(event.target.checked);
  };

  const handleMenu = (event) => {
    setAnchorEl(event.currentTarget);
  };

  const handleClose = () => {
    setAnchorEl(null);
  };

  const { isOpen, onOpen, onClose } = useDisclosure();

  return (
    <>
      <Box sx={{ flexGrow: 1 }}>
        <FormGroup>
          <FormControlLabel
            control={
              <Switch
                checked={auth}
                onChange={handleChange}
                aria-label="login switch"
              />
            }
            label={auth ? "Logout" : "Login"}
          />
        </FormGroup>
        <AppBar position="static" style={{ backgroundColor: "white" }}>
          <Toolbar>
            <IconButton
              size="large"
              edge="start"
              color="inherit"
              aria-label="menu"
              sx={{ mr: 2, color: "black" }}
              onClick={onOpen}
            >
              <MenuIcon />
              <Drawer placement="left" onClose={onClose} isOpen={isOpen}>
                <DrawerOverlay />
                <DrawerContent>
                  <DrawerHeader
                    borderBottomWidth="1px"
                    display="flex"
                    justifyContent="center"
                  >
                    <img src={Logo} alt="Logo" style={{ width: "200px" }} />
                  </DrawerHeader>
                  <DrawerBody>
                    {/* Menu admin */}
                    <p style={{ margin: "5px" }}>Institutions</p>
                    <p style={{ margin: "5px" }}>Professors</p>
                    <p style={{ margin: "5px" }}>Benfits</p>
                    {/* Menu partner company */}
                    <p style={{ margin: "5px" }}>Registred Benfits</p>
                    {/* Menu student */}
                    <p style={{ margin: "5px" }}>Balance</p>
                    <p style={{ margin: "5px" }}>Benfits</p>
                    <p style={{ margin: "5px" }}>Vouchers</p>
                    {/* Menu professors*/}
                    <p style={{ margin: "5px" }}>Student Transfers</p>
                  </DrawerBody>
                </DrawerContent>
              </Drawer>
            </IconButton>
            <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
              <img
                src={Logo}
                alt="Logo"
                style={{ width: "200px", margin: "25px" }}
              />
            </Typography>
            {auth && (
              <div>
                <IconButton
                  size="large"
                  aria-label="account of current user"
                  aria-controls="menu-appbar"
                  aria-haspopup="true"
                  onClick={handleMenu}
                >
                  <LuUserCircle2 style={{ color: "black", width: "35px" }} />
                  <h4
                    style={{
                      margin: "15px",
                      fontSize: "20px",
                      fontWeight: "500",
                      lineHeight: "16px",
                      textAlign: "left",
                      color: "black",
                    }}
                  >
                    ADMIN
                  </h4>
                  <IoChevronDown size={23} color="black" textAlign="center" />
                </IconButton>
                <Menu
                  id="menu-appbar"
                  anchorEl={anchorEl}
                  anchorOrigin={{
                    vertical: "top",
                    horizontal: "right",
                  }}
                  keepMounted
                  transformOrigin={{
                    vertical: "top",
                    horizontal: "right",
                  }}
                  open={Boolean(anchorEl)}
                  onClose={handleClose}
                >
                  <MenuItem onClick={handleClose}>Profile</MenuItem>
                  <MenuItem onClick={handleClose}>My account</MenuItem>
                </Menu>
              </div>
            )}
          </Toolbar>
        </AppBar>
      </Box>
    </>
  );
};

export default NavBar;
