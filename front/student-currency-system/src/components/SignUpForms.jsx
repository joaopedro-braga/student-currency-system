import React from "react"; 
import {
  Button, 
  Stack, 
  InputGroup,
  InputLeftElement, 
  Input, 
  InputRightElement, 
  Link, 
  Select, 
} from "@chakra-ui/react";

import {
  EmailIcon, 
  LockIcon, 
  SettingsIcon,
} from "@chakra-ui/icons";
import { FaUser } from "react-icons/fa"; 

// Functional component that renders the sign-up form
const SignUpForms = () => {
  return (
    <>
      {/* Title for the sign-up form */}
      <h1
        style={{
          color: "#E11138",
          textAlign: "left",
          paddingTop: "40px",
          marginTop: "40px",
          fontSize: "2em",
          fontWeight: "bold",
          marginLeft: "80px",
        }}
      >
        Sign Up
      </h1>

      {/* Stack for organizing input fields vertically with spacing */}
      <Stack spacing={4} style={{ margin: "60px", paddingLeft: "20px" }}>
        {/* Input field for Name with user icon */}
        <InputGroup>
          <InputLeftElement pointerEvents="none">
            <FaUser color="gray.500" /> {/* User icon with gray color */}
          </InputLeftElement>
          <Input
            type="name"
            placeholder="Name"
            w="437px"
            style={{
              backgroundColor: "#ECEEF1",
              borderRadius: "12px",
            }}
            sx={{
              // Styling for hover and focus states
              _hover: { borderColor: "#E11138" },
              _focus: {
                borderColor: "#E11138",
                boxShadow: "0 0 0 1px #E11138",
              },
            }}
          />
        </InputGroup>

        {/* Input field for Email with email icon */}
        <InputGroup>
          <InputLeftElement pointerEvents="none">
            <EmailIcon color="gray.500" /> {/* Email icon with gray color */}
          </InputLeftElement>
          <Input
            type="email" // Input type for email
            placeholder="E-mail"
            w="437px"
            style={{
              backgroundColor: "#ECEEF1",
              borderRadius: "12px",
            }}
            sx={{
              // Styling for hover and focus states
              _hover: { borderColor: "#E11138" },
              _focus: {
                borderColor: "#E11138",
                boxShadow: "0 0 0 1px #E11138",
              },
            }}
          />
          <InputRightElement />
        </InputGroup>

        {/* Dropdown to select the user type with settings icon */}
        <InputGroup>
          <InputLeftElement pointerEvents="none">
            <SettingsIcon color="gray.500" /> {/* Settings icon */}
          </InputLeftElement>
          <Select
            placeholder="Select user type"
            style={{
              backgroundColor: "#ECEEF1",
              borderRadius: "12px",
              color: "gray.500",
            }}
            sx={{
              // Styling for hover and focus states
              pl: "2.5rem",
              pr: "2.5rem",
              _hover: { borderColor: "#E11138" },
              _focus: {
                borderColor: "#E11138",
                boxShadow: "0 0 0 1px #E11138",
              },
            }}
          >
            {/* Options for user types */}
            <option value="option1">Student</option>
            <option value="option2">Partner Company</option>
          </Select>
          <InputRightElement />
        </InputGroup>

        {/* Input field for Password with lock icon */}
        <InputGroup>
          <InputLeftElement pointerEvents="none">
            <LockIcon color="gray.500" /> {/* Lock icon for password field */}
          </InputLeftElement>
          <Input
            type="password" // Password input type to hide characters
            placeholder="Password"
            w="437px"
            style={{
              backgroundColor: "#ECEEF1",
              borderRadius: "12px",
            }}
            sx={{
              // Styling for hover and focus states
              _hover: { borderColor: "#E11138" },
              _focus: {
                borderColor: "#E11138",
                boxShadow: "0 0 0 1px #E11138",
              },
            }}
          />
          <InputRightElement />
        </InputGroup>
      </Stack>

      {/* Footer section with a placeholder link and 'Continue' button */}
      <div
        style={{
          display: "flex",
          justifyContent: "space-between",
          alignItems: "center",
          marginBottom: "40px",
          width: "100%",
          paddingLeft: "80px",
          paddingRight: "60px",
        }}
      >
        <Link /> {/* Placeholder for future navigation link */}
        <Button
          style={{
            backgroundColor: "#E11138",
            color: "white",
            borderRadius: "12px",
          }}
          sx={{
            // Styling for hover and focus states
            _hover: { borderColor: "#E11138" },
            _focus: {
              borderColor: "#E11138",
              boxShadow: "0 0 0 1px #E11138",
            },
          }}
        >
          Continue
        </Button>
      </div>
    </>
  );
};

export default SignUpForms;
