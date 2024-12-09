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
  Text,
  TableContainer,
} from "@chakra-ui/react"; 

import { SearchIcon, DeleteIcon } from "@chakra-ui/icons"; 
import { FiEdit } from "react-icons/fi"; 
import RegisterInstitutionModal from "../components/RegisterInstitutionModal"; 

// Main component that renders the Institutions management page
const AdminInstitutions = () => {
  // State hooks to handle modal visibility using Chakra's useDisclosure hook
  const { isOpen, onOpen, onClose } = useDisclosure();
  const {
    isOpen: isEditOpen,
    onOpen: onEditOpen,
    onClose: onEditClose,
  } = useDisclosure();

  // State to store a list of institutions with initial data
  const [institutions, setInstitutions] = useState([
    {
      cnpj: "XX.XXX.XXX/0001-XX",
      name: "PUC-MG",
      address:
        "R. Dom José Gaspar, 500 - Coração Eucarístico, BH - MG, 30535-901",
    },
    {
      cnpj: "XX.XXX.XXX/0002-XX",
      name: "UFMG",
      address: "Av. Pres. Antônio Carlos, 6627 - Pampulha, BH - MG, 31270-901",
    },
  ]);

  // State to store the currently selected institution for editing
  const [selectedInstitution, setSelectedInstitution] = useState({
    cnpj: "",
    name: "",
    address: "",
  });

  // Function to handle clicking the edit button for an institution
  const handleEditClick = (institution) => {
    setSelectedInstitution(institution); // Store the selected institution data
    onEditOpen(); // Open the edit modal
  };

  // Function to handle input changes within the edit modal
  const handleChange = (e) => {
    const { name, value } = e.target; // Get the field name and new value
    setSelectedInstitution((prev) => ({ ...prev, [name]: value })); // Update the corresponding field
  };

  // Function to save changes made to an institution's data
  const handleSave = () => {
    setInstitutions((prev) =>
      prev.map((institution) =>
        institution.cnpj === selectedInstitution.cnpj
          ? selectedInstitution
          : institution
      )
    ); // Update the institution list
    onEditClose(); // Close the edit modal
  };

  return (
    <>
      <NavBar /> {/* Renders the navigation bar */}
      <div style={{ margin: "30px" }}>
        <Grid templateColumns="20% 1fr" gap={6}>
          {" "}
          {/* Layout grid */}
          <Box
            bgImage={`url(${bg})`} // Set background image
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
              Institution Registration
            </h1>
            <h2
              style={{ fontSize: "24px", color: "white", marginBottom: "30px" }}
            >
              Register your partner educational institutions with ease!
            </h2>
            <Button
              colorScheme="whiteAlpha"
              onClick={onOpen}
              style={{ fontSize: "18px", fontWeight: "600" }}
            >
              Register Institution
            </Button>
          </Box>
          {/* Modal for registering a new institution */}
          <Modal isOpen={isOpen} onClose={onClose} isCentered>
            <ModalOverlay />
            <ModalContent>
              <ModalHeader style={{ color: "#E11138", fontWeight: "600" }}>
                Register Institution
              </ModalHeader>
              <ModalCloseButton />
              <ModalBody>
                {/* Custom registration form */}
                <RegisterInstitutionModal />
              </ModalBody>
              <ModalFooter>
                <Button backgroundColor="#E11138" color="white" mr={3}>
                  Save
                </Button>
                <Button onClick={onClose}>Cancel</Button>
              </ModalFooter>
            </ModalContent>
          </Modal>
          {/* Table displaying the list of institutions */}
          <Box
            padding="30px"
            border="1px solid #00000033"
            borderRadius="8px"
            boxShadow="lg"
          >
            <Stack spacing={4}>
              <HStack spacing={4}>
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
                      // Styling for hover and focus states
                      _hover: { borderColor: "#E11138" },
                      _focus: {
                        borderColor: "#E11138",
                        boxShadow: "0 0 0 1px #E11138",
                      },
                    }}
                  />
                </InputGroup>
                <Button backgroundColor="#E11138" color="white" variant="solid">
                  Button
                </Button>
              </HStack>
            </Stack>

            <TableContainer marginTop="30px" maxHeight="400px" overflowY="auto">
              <Table variant="simple" size="sm">
                <Thead>
                  <Tr>
                    <Th>CNPJ</Th>
                    <Th>Institution Name</Th>
                    <Th>Address</Th>
                    <Th>Action</Th>
                  </Tr>
                </Thead>
                <Tbody>
                  {institutions.map((institution, index) => (
                    <Tr key={index}>
                      <Td wordBreak="break-word">{institution.cnpj}</Td>
                      <Td wordBreak="break-word">{institution.name}</Td>
                      <Td wordBreak="break-word">{institution.address}</Td>
                      <Td>
                        <Button
                          size="sm"
                          backgroundColor="white"
                          color="#E11138"
                          margin="8px"
                          onClick={() => handleEditClick(institution)}
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
      {/* Modal for editing an existing institution */}
      <Modal isOpen={isEditOpen} onClose={onEditClose} isCentered>
        <ModalOverlay />
        <ModalContent>
          <ModalHeader style={{ color: "#E11138", fontWeight: "600" }}>
            Edit Institution
          </ModalHeader>
          <ModalCloseButton />
          <ModalBody>
            <Stack spacing={4}>
              <Text>CNPJ</Text>
              <InputGroup>
                <Input
                  name="cnpj"
                  value={selectedInstitution.cnpj}
                  onChange={handleChange}
                  isReadOnly // CNPJ should be read-only
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
              <Text>Institution Name</Text>
              <InputGroup>
                <Input
                  name="name"
                  value={selectedInstitution.name}
                  onChange={handleChange}
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
              <Text>Address</Text>
              <InputGroup>
                <Input
                  name="address"
                  value={selectedInstitution.address}
                  onChange={handleChange}
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

export default AdminInstitutions;