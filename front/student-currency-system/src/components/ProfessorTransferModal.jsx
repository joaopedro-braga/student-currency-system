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
const students = [
  { name: "João Pedro Braga" },
  { name: "Maria Clara Silva" },
  { name: "José da Silva Pereira" },
  { name: "Ana Paula Marcos" },
  { name: "João da Silva Pinto" },
  { name: "Maria Silva Silva" },
];

const ProfessorTransferModal = () => {
  return (
    <>
      <Stack spacing={4} style={{ margin: "10px" }}>
        {/*Student dropdown */}
        <InputGroup>
          <InputLeftElement pointerEvents="none" />

          <Select
            placeholder="Select student"
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
            {students.map((students) => (
              <option key={students.name} value={students.name}>
                {students.name}
              </option>
            ))}
          </Select>

          <InputRightElement />
        </InputGroup>
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

export default ProfessorTransferModal;
