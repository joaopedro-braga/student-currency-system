import React from "react";
import {
  Card,
  CardBody,
  Grid,
  Box,
  Button,
  Stack,
  InputGroup,
  InputLeftElement,
  Input,
  InputRightElement,
  Link,
  Select,
} from "@chakra-ui/react";

const SignUpCompany = () => {
  return (
    <>
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
      <Stack spacing={4} style={{ margin: "60px", paddingLeft: "20px" }}>
        <InputGroup>
          <InputLeftElement pointerEvents="none"></InputLeftElement>
          <Input
            type="cnpj"
            placeholder="CNPJ"
            w="437px"
            style={{
              backgroundColor: "#ECEEF1",
              borderRadius: "12px",
            }}
            sx={{
              _hover: { borderColor: "#E11138" },
              _focus: {
                borderColor: "#E11138",
                boxShadow: "0 0 0 1px #E11138",
              },
            }}
          />
        </InputGroup>

        <InputGroup>
          <InputLeftElement pointerEvents="none"></InputLeftElement>
          <Input
            type="adress"
            placeholder="Adress"
            w="437px"
            style={{
              backgroundColor: "#ECEEF1",
              borderRadius: "12px",
            }}
            sx={{
              _hover: { borderColor: "#E11138" },
              _focus: {
                borderColor: "#E11138",
                boxShadow: "0 0 0 1px #E11138",
              },
            }}
          />
          <InputRightElement></InputRightElement>
        </InputGroup>

      </Stack>

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
        <Link></Link>
        <Button
          style={{
            backgroundColor: "#E11138",
            color: "white",
            borderRadius: "12px",
          }}
          sx={{
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