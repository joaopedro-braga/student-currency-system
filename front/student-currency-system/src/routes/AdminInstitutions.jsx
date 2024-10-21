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
import RegisterInstitutionModal from "../components/RegisterInstitutionModal";

const AdminInstitutions = () => {
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
          >
            <h1 style={{ fontSize: "30px", color: "white", fontWeight: "700" , marginBottom: "24px"}}>
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
              Sign Up!
            </Button>
          </Box>

          <Modal isOpen={isOpen} onClose={onClose} isCentered>
            <ModalOverlay />
            <ModalContent>
              <ModalHeader style={{ color: "#E11138", fontWeight: "600" }}>
                Register Institution
              </ModalHeader>
              <ModalCloseButton />
              <ModalBody>
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
                    <Th>CNPJ</Th>
                    <Th>Institution Name</Th>
                    <Th>Address</Th>
                    <Th>Action</Th>
                  </Tr>
                </Thead>
                <Tbody>
                  {[
                    {
                      cnpj: "XX.XXX.XXX/0001-XX",
                      name: "PUC-MG",
                      address:
                        "R. Dom José Gaspar, 500 - Coração Eucarístico, BH - MG, 30535-901",
                    },
                    {
                      cnpj: "XX.XXX.XXX/0002-XX",
                      name: "UFMG",
                      address:
                        "Av. Pres. Antônio Carlos, 6627 - Pampulha, BH - MG, 31270-901",
                    },
                    {
                      cnpj: "XX.XXX.XXX/0003-XX",
                      name: "PUC-RJ",
                      address:
                        "R. Marquês de São Vicente, 225 - Gávea, RJ, 22451-900",
                    },
                    {
                      cnpj: "XX.XXX.XXX/0004-XX",
                      name: "UFRJ",
                      address:
                        "Av. Pedro Calmon, 550 - Cidade Universitária, RJ, 21941-901",
                    },
                    {
                      cnpj: "XX.XXX.XXX/0005-XX",
                      name: "UFRGS",
                      address:
                        "Av. Paulo Gama, 110 - Farroupilha, Porto Alegre - RS, 90040-060",
                    },
                    {
                      cnpj: "XX.XXX.XXX/0006-XX",
                      name: "UFSC",
                      address:
                        "Campus Reitor João David Ferreira Lima - Trindade, Florianópolis - SC, 88040-900",
                    },
                  ].map((institution, index) => (
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

export default AdminInstitutions;
