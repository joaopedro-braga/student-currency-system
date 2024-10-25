import React from "react"; 
import {
  Button, 
  Stack, 
  InputGroup, 
  InputLeftElement,
  Input, 
  InputRightElement, 
  Link, 
} from "@chakra-ui/react";

const SignUpCompany = () => {
  return (
    <>
      {/* Title for the company sign-up form */}
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

      {/* Stack for vertically organizing input fields */}
      <Stack spacing={4} style={{ margin: "60px", paddingLeft: "20px" }}>
        {/* Input field for CNPJ (company ID) */}
        <InputGroup>
          <InputLeftElement pointerEvents="none" />{" "}
          {/* Placeholder for future icon */}
          <Input
            type="cnpj"
            placeholder="CNPJ"
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
          <InputLeftElement pointerEvents="none" />{" "}
          {/* Placeholder for future icon */}
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
          <InputRightElement /> {/* Placeholder for future icon or element */}
        </InputGroup>
      </Stack>

      {/* Footer section with a placeholder link and 'Register' button */}
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
        {/* 'Register' button with hover and focus styles */}
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

export default SignUpCompany;
