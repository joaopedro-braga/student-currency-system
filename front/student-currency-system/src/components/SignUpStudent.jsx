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

// Functional component for rendering the student sign-up form
const SignUpStudent = () => {
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

      {/* Vertical stack for organizing input fields */}
      <Stack spacing={4} style={{ margin: "60px", paddingLeft: "20px" }}>
        {/* Input field for Social Security Number */}
        <InputGroup>
          <InputLeftElement pointerEvents="none" />{" "}
          {/* Placeholder for future icons */}
          <Input
            type="cpfRg"
            placeholder="Social Security Number"
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

        {/* Input field for Address */}
        <InputGroup>
          <InputLeftElement pointerEvents="none" />
          <Input
            type="adress"
            placeholder="Adress"
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
          <InputRightElement /> {/* Placeholder for future elements */}
        </InputGroup>

        {/* Dropdown to select the educational institution */}
        <InputGroup>
          <InputLeftElement pointerEvents="none" />
          <Select
            placeholder="Select Institution"
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
            {/* Options for institutions */}
            <option value="option1">PUC Minas</option>
            <option value="option2">UFMG</option>
          </Select>
          <InputRightElement />
        </InputGroup>

        {/* Input field for Password */}
        <InputGroup>
          <InputLeftElement pointerEvents="none" />
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

      {/* Footer with a link and register button */}
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
        <Link /> {/* Empty link placeholder */}
        {/* Register button with custom styles */}
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
          Register
        </Button>
      </div>
    </>
  );
};

export default SignUpStudent;
