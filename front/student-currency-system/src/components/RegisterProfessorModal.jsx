import React from "react";
import {
  Input,
  Stack,
  InputGroup,
  InputLeftElement,
  InputRightElement,
  Select,
} from "@chakra-ui/react";

// List of institutions to be used in the dropdown
const institutions = [
  { id: "pucminas", name: "PUC Minas" },
  { id: "usp", name: "Universidade de São Paulo" },
  { id: "unicamp", name: "Universidade Estadual de Campinas " },
  { id: "ufmg", name: "Universidade Federal de Minas Gerais" },
  { id: "fatec", name: "Faculdade de Tecnologia de São Paulo" },
];

const RegisterProfessorModal = () => {
  return (
    <>
      <Stack spacing={4} style={{ margin: "10px" }}>
        {/* Name input field */}
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

        {/* Email input field */}
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

        {/* CPF input field */}
        <InputGroup>
          <InputLeftElement pointerEvents="none"></InputLeftElement>
          <Input
            type="cpf"
            placeholder="CPF"
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

        {/* Institution dropdown */}
        <InputGroup>
          <InputLeftElement pointerEvents="none" />

          <Select
            placeholder="Select institution"
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
            {institutions.map((institution) => (
              <option key={institution.id} value={institution.id}>
                {institution.name}
              </option>
            ))}
          </Select>

          <InputRightElement />
        </InputGroup>

        {/* Department input field */}
        <InputGroup>
          <InputLeftElement pointerEvents="none"></InputLeftElement>
          <Input
            type="department"
            placeholder="Department"
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

export default RegisterProfessorModal;
