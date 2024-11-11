import React, { useState } from "react";
import NavBar from "../components/NavBar";
import bg from "../img/bg.png";
import {
  Box,
  Grid,
  Button,
  Modal,
  ModalOverlay,
  ModalContent,
  ModalHeader,
  ModalFooter,
  ModalBody,
  ModalCloseButton,
  InputLeftElement,
  Input,
  InputGroup,
  useDisclosure,
  Stack,
  IconButton,
  HStack,
  Table,
  Thead,
  Tbody,
  Tr,
  Th,
  Td,
  TableContainer,
  Text,
} from "@chakra-ui/react";

import { SearchIcon } from "@chakra-ui/icons";

const STUDENT_BALANCE = 1500.0;

const StudentBalance = () => {
  const transfers = [
    {
      transferDate: "2024-11-10",
      senderName: "Alice Johnson",
      transferAmount: 250.0,
      transferType: "Domestic",
      description: "Rent payment",
    },
    {
      transferDate: "2024-11-11",
      senderName: "Bob Smith",
      transferAmount: 500.0,
      transferType: "International",
      description: "Freelance work",
    },
    {
      transferDate: "2024-11-12",
      senderName: "Carla Williams",
      transferAmount: 150.75,
      transferType: "Domestic",
      description: "Gift",
    },
    {
      transferDate: "2024-11-13",
      senderName: "David Brown",
      transferAmount: 325.0,
      transferType: "International",
      description: "Invoice payment",
    },
    {
      transferDate: "2024-11-14",
      senderName: "Emily Clark",
      transferAmount: 200.0,
      transferType: "Domestic",
      description: "Loan repayment",
    },
  ];

  const [professors, setProfessors] = useState([
    {
      cpf: "XXX.XXX.XXX-XX",
      name: "João Paulo Pereira",
      department: "Computer Science",
      institution: "PUC-MG",
    },
    {
      cpf: "XXX.XXX.XXX-XX",
      name: "Gabriel Ramos",
      department: "Computer Engineer",
      institution: "PUC-MG",
    },
    {
      cpf: "XXX.XXX.XXX-XX",
      name: "João Pedro Braga",
      department: "Informational Systems",
      institution: "PUC-MG",
    },
    {
      cpf: "XXX.XXX.XXX-XX",
      name: "Maria Silva",
      department: "Mathematics",
      institution: "PUC-MG",
    },
  ]);

  return (
    <>
      {/* Navigation bar component */}
      <NavBar />

      <div style={{ margin: "30px" }}>
        <Grid templateColumns="20% 1fr" gap={6}>
          {/* Left section: Registration box */}
          <Box
            bgImage={`url(${bg})`}
            bgRepeat="no-repeat"
            bgSize="cover"
            bgPosition="center"
            borderRadius="8px"
            padding="30px"
            textAlign="center"
            display="flex"
            flexDirection="column"
            justifyContent="center"
          >
            <h1
              style={{
                fontSize: "30px",
                color: "white",
                fontWeight: "700",
                marginBottom: "24px",
              }}
            >
              Account Balance
            </h1>

            <Text fontSize="2xl" color="white">
              $ {STUDENT_BALANCE.toFixed(2)}
            </Text>
          </Box>

          {/* Right section: Search and table */}
          <Box
            padding="30px"
            border="1px solid #00000033"
            borderRadius="8px"
            boxShadow="lg"
          >
            <Stack spacing={4}>
              <HStack spacing={4}>
                {/* Search input */}
                <InputGroup>
                  <InputLeftElement pointerEvents="none">
                    <IconButton
                      aria-label="Search database"
                      icon={<SearchIcon />}
                      backgroundColor="#E11138"
                      color="white"
                    />
                  </InputLeftElement>
                  <Input
                    placeholder="Enter the date or transaction"
                    style={{ paddingLeft: "50px" }}
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
                <Button backgroundColor="#E11138" color="white">
                  Search
                </Button>
              </HStack>
            </Stack>

            {/* transferss table */}
            <TableContainer marginTop="30px" maxHeight="400px" overflowY="auto">
              <Table variant="simple" size="sm">
                <Thead>
                  <Tr>
                    <Th>Transfer Date</Th>
                    <Th>Sender's Name</Th>
                    <Th>Transfer Amount</Th>
                    <Th>Transfer Type</Th>
                    <Th>Description</Th>
                  </Tr>
                </Thead>
                <Tbody>
                  {transfers.map((transfers, index) => (
                    <Tr key={index} >
                      <Td wordBreak="break-word" margin="16px" padding= "20px">
                        {transfers.transferDate}
                      </Td>
                      <Td>{transfers.senderName}</Td>
                      <Td wordBreak="break-word">{transfers.transferAmount}</Td>
                      <Td wordBreak="break-word">{transfers.transferType}</Td>
                      <Td wordBreak="break-word">{transfers.description}</Td>
                    </Tr>
                  ))}
                </Tbody>
              </Table>
            </TableContainer>
          </Box>
        </Grid>
      </div>
    </>
  );
};

export default StudentBalance;
