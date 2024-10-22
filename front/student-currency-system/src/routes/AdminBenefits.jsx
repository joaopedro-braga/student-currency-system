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

import { SearchIcon, DeleteIcon } from "@chakra-ui/icons";
import { FiEdit } from "react-icons/fi";
import RegisterProfessorModal from "../components/RegisterProfessorModal";

const AdminBenefits = () => {
  const { isOpen, onOpen, onClose } = useDisclosure(); 

  const [selectedBenefit, setSelectedBenefit] = useState({
    name: "",
    price: "",
    description: "",
    institution: "",
  }); 

  const {
    isOpen: isEditOpen,
    onOpen: onEditOpen,
    onClose: onEditClose,
  } = useDisclosure(); 

  const handleEditClick = (benefit) => {
    setSelectedBenefit(benefit); 
    onEditOpen(); 
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setSelectedBenefit((prev) => ({ ...prev, [name]: value })); 
  };

  return (
    <>
      <NavBar />
      <div style={{ margin: "30px" }}>
        <Grid templateColumns="20% 1fr" gap={6}>
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
            justifyContent={["center", "center", "center", "center"]}
          >
            <h1
              style={{
                fontSize: "30px",
                color: "white",
                fontWeight: "700",
                marginBottom: "24px",
              }}
            >
              Benefits Registration
            </h1>
            <h2
              style={{ fontSize: "24px", color: "white", marginBottom: "30px" }}
            >
              Register benefits for students of partner institutions!
            </h2>
            <Button
              colorScheme="whiteAlpha"
              onClick={onOpen}
              style={{ fontSize: "18px", fontWeight: "600" }}
            >
              Register Benefit
            </Button>
          </Box>

          {/* Modal de Registro */}
          <Modal isOpen={isOpen} onClose={onClose} isCentered>
            <ModalOverlay />
            <ModalContent>
              <ModalHeader style={{ color: "#E11138", fontWeight: "600" }}>
                Register Professor
              </ModalHeader>
              <ModalCloseButton />
              <ModalBody>
                <RegisterProfessorModal />
              </ModalBody>
              <ModalFooter>
                <Button backgroundColor="#E11138" color="white" mr={3}>
                  Save
                </Button>
                <Button onClick={onClose}>Cancel</Button>
              </ModalFooter>
            </ModalContent>
          </Modal>

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
                      _hover: { borderColor: "#E11138" },
                      _focus: {
                        borderColor: "#E11138",
                        boxShadow: "0 0 0 1px #E11138",
                      },
                    }}
                  />
                </InputGroup>
                <Button backgroundColor="#E11138" color="white" variant="solid">
                  Search
                </Button>
              </HStack>
            </Stack>

            <TableContainer marginTop="30px" maxHeight="400px" overflowY="auto">
              <Table variant="simple" size="sm">
                <Thead>
                  <Tr>
                    <Th>Image</Th>
                    <Th>Name</Th>
                    <Th>Price</Th>
                    <Th>Institution</Th>
                    <Th>Description</Th>
                    <Th>Action</Th>
                  </Tr>
                </Thead>
                <Tbody>
                  {[
                    {
                      image: "https://via.placeholder.com/150",
                      name: "Netflix Gift Card",
                      price: "$ 1000",
                      institution: "UFSC",
                      description: "Gift Card for Netflix",
                    },
                    {
                      image: "https://via.placeholder.com/150",
                      name: "Amazon Gift Card",
                      price: "$ 2000",
                      institution: "UFSC",
                      description: "Gift Card for Amazon",
                    },
                  ].map((benefit, index) => (
                    <Tr key={index}>
                      <Td>
                        <img
                          src={benefit.image}
                          alt={benefit.name}
                          style={{
                            width: "50px",
                            height: "50px",
                            borderRadius: "8px",
                          }}
                        />
                      </Td>
                      <Td wordBreak="break-word">{benefit.name}</Td>
                      <Td wordBreak="break-word">{benefit.price}</Td>
                      <Td wordBreak="break-word">{benefit.institution}</Td>
                      <Td wordBreak="break-word">{benefit.description}</Td>
                      <Td>
                        <Button
                          size="sm"
                          backgroundColor="white"
                          color="#E11138"
                          margin="8px"
                          onClick={() => handleEditClick(benefit)}
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

      <Modal isOpen={isEditOpen} onClose={onEditClose} isCentered>
        <ModalOverlay />
        <ModalContent>
          <ModalHeader style={{ color: "#E11138", fontWeight: "600" }}>
            Edit Benefit
          </ModalHeader>
          <ModalCloseButton />
          <ModalBody>
            <Stack spacing={4}>
              <Text>Name</Text>
              <InputGroup>
                <Input
                  name="name"
                  value={selectedBenefit.name}
                  onChange={handleChange}
                  placeholder="Name"
                  w="437px"
                  style={{
                    backgroundColor: "#ECEEF1",
                    borderRadius: "8px",
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
              <Text>Price</Text>
              <InputGroup>
                <Input
                  name="price"
                  value={selectedBenefit.price}
                  onChange={handleChange}
                  placeholder="Price"
                  w="437px"
                  style={{
                    backgroundColor: "#ECEEF1",
                    borderRadius: "8px",
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
              <Text>Instituition</Text>
              <InputGroup>
                <Input
                  name="institution"
                  value={selectedBenefit.institution}
                  onChange={handleChange}
                  placeholder="Institution"
                  w="437px"
                  style={{
                    backgroundColor: "#ECEEF1",
                    borderRadius: "8px",
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
              <Text>Description</Text>
              <InputGroup>
                <Input
                  name="description"
                  value={selectedBenefit.description}
                  onChange={handleChange}
                  placeholder="Description"
                  w="437px"
                  style={{
                    backgroundColor: "#ECEEF1",
                    borderRadius: "8px",
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
            </Stack>
          </ModalBody>
          <ModalFooter>
            <Button backgroundColor="#E11138" color="white" mr={3}>
              Save Changes
            </Button>
            <Button onClick={onEditClose}>Cancel</Button>
          </ModalFooter>
        </ModalContent>
      </Modal>
    </>
  );
};

export default AdminBenefits;
