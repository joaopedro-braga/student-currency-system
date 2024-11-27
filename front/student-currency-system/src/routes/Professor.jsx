import React, { useState, useEffect } from "react";
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

import { SearchIcon, DeleteIcon } from "@chakra-ui/icons";
import { FiEdit } from "react-icons/fi";
import ProfessorTransferModal from "../components/ProfessorTransferModal";

const Professor = () => {
  const { isOpen, onOpen, onClose } = useDisclosure(); // Controls the state of the registration modal

  // State to store the list of professors
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

  // State to store the selected professor's data for editing
  const [selectedProfessor, setSelectedProfessor] = useState({
    cpf: "",
    name: "",
    department: "",
    institution: "",
  });

  // State to store the user's balance
  const [saldo, setSaldo] = useState(0);

  useEffect(() => {
    // Simula uma chamada ao banco de dados para obter o saldo
    const fetchSaldo = async () => {
      try {
        // Aqui você pode fazer a chamada para o banco de dados
        const response = await fetch("/api/saldo");
        const data = await response.json();
        setSaldo(data.saldo);
      } catch (error) {
        console.error("Erro ao buscar saldo:", error);
      }
    };

    fetchSaldo();
  }, []);

  const {
    isOpen: isEditOpen,
    onOpen: onEditOpen,
    onClose: onEditClose,
  } = useDisclosure(); // Controls the edit modal

  // Opens the edit modal with the selected professor's data
  const handleEditClick = (professor) => {
    setSelectedProfessor(professor);
    onEditOpen();
  };

  // Updates the selected professor's data as the user edits
  const handleChange = (e) => {
    const { name, value } = e.target;
    setSelectedProfessor((prev) => ({ ...prev, [name]: value }));
  };

  // Saves the edited professor's data back into the list
  const handleSave = () => {
    setProfessors((prev) =>
      prev.map((professor) =>
        professor.cpf === selectedProfessor.cpf ? selectedProfessor : professor
      )
    );
    onEditClose();
  };

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
            <h2
              style={{ fontSize: "24px", color: "white", marginBottom: "30px" }}
            >
              ${saldo.toFixed(2)}
            </h2>
            <Button
              colorScheme="whiteAlpha"
              onClick={onOpen}
              style={{ fontSize: "18px", fontWeight: "600" }}
            >
              New Transfer
            </Button>
          </Box>

          {/* Registration Modal */}
          <Modal isOpen={isOpen} onClose={onClose} isCentered>
            <ModalOverlay />
            <ModalContent>
              <ModalHeader style={{ color: "#E11138", fontWeight: "600" }}>
                New Transfer
              </ModalHeader>
              <ModalCloseButton />
              <ModalBody>
                {/* Form to register new professors */}
                <ProfessorTransferModal />
              </ModalBody>
              <ModalFooter>
                <Button backgroundColor="#E11138" color="white" mr={3}>
                  Transfer
                </Button>
                <Button onClick={onClose}>Cancel</Button>
              </ModalFooter>
            </ModalContent>
          </Modal>

          {/* Right section: Search and table */}
          <Box
            padding="30px"
            border="1px solid #00000033"
            borderRadius="8px"
            boxShadow="lg"
          >
            <Stack spacing={4}>
							<h1 style={{fontSize:"40px", fontWeight:"500", marginBottom:"8px"}}>Transfers</h1>
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
                    placeholder="Enter the educational institution"
                    style={{ paddingLeft: "50px" }}
                    sx={{
                      _hover: { borderColor: "#E11138" },
                      _focus: {
                        borderColor: "#E11138",
                        boxShadow: "0 0 0 1px #E11138",
                      },
                    }}
                  />
                </InputGroup>
                <Button backgroundColor="#E11138" color="white">
                  Button
                </Button>
              </HStack>
            </Stack>

            {/* Professors table */}
            <TableContainer marginTop="30px" maxHeight="400px" overflowY="auto">
              <Table variant="simple" size="sm">
                <Thead>
                  <Tr>
                    <Th>CPF</Th>
                    <Th>Name</Th>
                    <Th>Department</Th>
                    <Th>Institution</Th>
                    <Th>Action</Th>
                  </Tr>
                </Thead>
                <Tbody>
                  {professors.map((professor, index) => (
                    <Tr key={index}>
                      <Td wordBreak="break-word">{professor.cpf}</Td>
                      <Td wordBreak="break-word">{professor.name}</Td>
                      <Td wordBreak="break-word">{professor.department}</Td>
                      <Td wordBreak="break-word">{professor.institution}</Td>
                      <Td>
                        <Button
                          size="sm"
                          backgroundColor="white"
                          color="#E11138"
                          margin="8px"
                          onClick={() => handleEditClick(professor)}
                        >
                          <FiEdit />
                        </Button>
                        <Button
                          size="sm"
                          backgroundColor="white"
                          color="#E11138"
                        >
                          <DeleteIcon />
                        </Button>
                      </Td>
                    </Tr>
                  ))}
                </Tbody>
              </Table>
            </TableContainer>
          </Box>
        </Grid>
      </div>
      {/* Edit Professor Modal */}
      <Modal isOpen={isEditOpen} onClose={onEditClose} isCentered>
        <ModalOverlay />
        <ModalContent>
          <ModalHeader style={{ color: "#E11138", fontWeight: "600" }}>
            Edit Professor
          </ModalHeader>
          <ModalCloseButton />
          <ModalBody>
            <Stack spacing={4}>
              <Text>CPF</Text>
              <InputGroup>
                <Input name="cpf" value={selectedProfessor.cpf} isReadOnly />
              </InputGroup>
              <Text>Name</Text>
              <InputGroup>
                <Input
                  name="name"
                  value={selectedProfessor.name}
                  onChange={handleChange}
                />
              </InputGroup>
              <Text>Department</Text>
              <InputGroup>
                <Input
                  name="department"
                  value={selectedProfessor.department}
                  onChange={handleChange}
                />
              </InputGroup>
              <Text>Institution</Text>
              <InputGroup>
                <Input
                  name="institution"
                  value={selectedProfessor.institution}
                  onChange={handleChange}
                />
              </InputGroup>
            </Stack>
          </ModalBody>
          <ModalFooter>
            <Button
              backgroundColor="#E11138"
              color="white"
              mr={3}
              onClick={handleSave}
            >
              Save
            </Button>
            <Button onClick={onEditClose}>Cancel</Button>
          </ModalFooter>
        </ModalContent>
      </Modal>
    </>
  );
};

export default Professor;
