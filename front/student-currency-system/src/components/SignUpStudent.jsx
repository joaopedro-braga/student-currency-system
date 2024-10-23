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

const SignUpStudent = () => {
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
          <InputLeftElement pointerEvents="none">
          </InputLeftElement>
          <Input
            type="cpfRg"
            placeholder="Social Security Number"
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
          <InputLeftElement pointerEvents="none">
          </InputLeftElement>
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

        <InputGroup>
          <InputLeftElement pointerEvents="none">
          </InputLeftElement>

          <Select
            placeholder="Select Institution"
            style={{
              backgroundColor: "#ECEEF1",
              borderRadius: "12px",
              color: "gray.500",
            }}
            sx={{
              pl: "2.5rem",
              pr: "2.5rem",
              _hover: { borderColor: "#E11138" },
              _focus: {
                borderColor: "#E11138",
                boxShadow: "0 0 0 1px #E11138",
              },
            }}
          >
            <option value="option1">PUC Minas</option>
            <option value="option2">UFMG</option>
          </Select>

          <InputRightElement></InputRightElement>
        </InputGroup>

        <InputGroup>
          <InputLeftElement pointerEvents="none">
          </InputLeftElement>
          <Input
            type="password"
            placeholder="Password"
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

export default SignUpStudent;
