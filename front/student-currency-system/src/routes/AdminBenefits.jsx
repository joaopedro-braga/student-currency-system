import React from "react";
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
} from "@chakra-ui/react";

import { SearchIcon, DeleteIcon } from "@chakra-ui/icons";
import { FiEdit } from "react-icons/fi";
import RegisterProfessorModal from "../components/RegisterProfessorModal";

const AdminBenefits = () => {
  const { isOpen, onOpen, onClose } = useDisclosure();
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
              Register benegits for students of partner institutions!
            </h2>
            <Button
              colorScheme="whiteAlpha"
              onClick={onOpen}
              style={{ fontSize: "18px", fontWeight: "600" }}
            >
              Register Benefit
            </Button>
          </Box>

          <Modal isOpen={isOpen} onClose={onClose} isCentered>
            <ModalOverlay />
            <ModalContent>
              <ModalHeader style={{ color: "#E11138", fontWeight: "600" }}>
                Register Professor
              </ModalHeader>
              <ModalCloseButton />
              <ModalBody>
                <RegisterProfessorModal></RegisterProfessorModal>
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
                  Button
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
                    {
                      image: "https://via.placeholder.com/150",
                      name: "Spotify Gift Card",
                      price: "$ 500",
                      institution: "UFSC",
                      description: "Gift Card for Spotify",
                    },
                    {
                      image: "https://via.placeholder.com/150",
                      name: "Google Play Gift Card",
                      price: "$ 300",
                      institution: "UFSC",
                      description: "Gift Card for Google Play",
                    },
                    {
                      image: "https://via.placeholder.com/150",
                      name: "Apple Store Gift Card",
                      price: "$ 400",
                      institution: "UFSC",
                      description: "Gift Card for Apple Store",
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
                          marginLeft="0"
                          paddingLeft="0"
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
    </>
  );
};

export default AdminBenefits;
