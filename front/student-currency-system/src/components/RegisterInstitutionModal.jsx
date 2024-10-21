import React from "react";
import {
  Input,
  Stack,
  InputGroup,
  InputLeftElement,
  InputRightElement,
} from "@chakra-ui/react";

const RegisterInstitution = () => {
    return (
      <>
        <Stack spacing={4} style={{ margin: "10px" }}>
          <InputGroup>
            <InputLeftElement pointerEvents="none"></InputLeftElement>
            <Input
              type="name"
              placeholder="Name"
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
              type="email"
              placeholder="E-mail"
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
            <InputRightElement></InputRightElement>
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
      </>
    );
};

export default RegisterInstitution;