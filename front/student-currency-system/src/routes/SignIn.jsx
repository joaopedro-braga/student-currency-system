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
} from "@chakra-ui/react";
import { EmailIcon, LockIcon } from "@chakra-ui/icons";
import bg from "../img/bg.png";

const SignIn = () => {
  return (
    <Box
      height="100vh"
      display="flex"
      justifyContent="center"
      alignItems="center"
    >
      <Card
        w="70%"
        mx="auto"
        border="1px solid #00000033"
        style={{ borderRadius: "20px" }}
      >
        <CardBody>
          <Grid templateColumns="repeat(2, 1fr)" gap={6}>
            <Box
              display="flex"
              flexDirection="column"
              justifyContent="center"
              alignItems="flex-start"
            >
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
                Sign In
              </h1>
              <Stack
                spacing={4}
                style={{ margin: "60px", paddingLeft: "20px" }}
              >
                <InputGroup>
                  <InputLeftElement pointerEvents="none">
                    <EmailIcon color="gray.500" />
                  </InputLeftElement>
                  <Input
                    type="email"
                    placeholder="E-mail"
                    w="437px"
                    style={{ backgroundColor: "#ECEEF1", borderRadius: "12px" }}
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
                    <LockIcon color="gray.500" />
                  </InputLeftElement>
                  <Input
                    type="password"
                    placeholder="Password"
                    w="437px"
                    style={{ backgroundColor: "#ECEEF1", borderRadius: "12px" }}
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
                  marginBottom: "40px", // Para adicionar espaço abaixo do botão
                  width: "100%", // Para que o conteúdo ocupe a largura total
                  paddingLeft: "80px", // Para manter o alinhamento à esquerda do link
                  paddingRight: "60px", // Para manter o alinhamento à direita do botão
                }}
              >
                <Link>Forgot your password?</Link>
                <Button
                  style={{
                    backgroundColor: "#E11138",
                    color: "white",
                  }}
                  sx={{
                    _hover: { borderColor: "#E11138" },
                    _focus: {
                      borderColor: "#E11138",
                      boxShadow: "0 0 0 1px #E11138",
                    },
                  }}
                >
                  Log In
                </Button>
              </div>
            </Box>
            <Box
              display="flex"
              flexDirection="column"
              bgImage={`url(${bg})`}
              bgRepeat="no-repeat"
              bgSize="cover"
              style={{ borderRadius: "20px", padding: "30px", margin: "5px" , paddingTop: "80px"}}
            >
              <h1
                style={{
                  color: "white",
                  textAlign: "left",
                  padding: "10px",
                  margin: "10px",
                  fontSize: "2em",
                  fontWeight: "bold",
                }}
              >
                Hi!
              </h1>
              <h3
                style={{
                  color: "white",
                  textAlign: "left",
                  padding: "10px",
                  margin: "10px",
                  fontSize: "1.17em",
                }}
              >
                Are you not registered yet?
              </h3>
              <h3
                style={{
                  color: "white",
                  textAlign: "left",
                  padding: "10px",
                  margin: "10px",
                  marginBottom: "30px",
                  fontSize: "1.17em",
                }}
              >
                Enter your details to create an account and join us!
              </h3>
              <Box display="flex" justifyContent="flex-end">
                <Button
                  colorScheme="whiteAlpha"
                  style={{
                    marginRight: "30px",
                    marginTop: "20px",
                    marginBottom: "40px",
                  }}
                >
                  Sign Up
                </Button>
              </Box>
            </Box>
          </Grid>
        </CardBody>
      </Card>
    </Box>
  );
};

export default SignIn;
