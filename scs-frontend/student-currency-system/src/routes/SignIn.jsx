import React from "react";
import {
  Box,
  Card,
  CardBody,
  Grid,
  Stack,
  InputGroup,
  InputLeftElement,
  Input,
  InputRightElement,
  Link,
  Button,
} from "@chakra-ui/react";
import { EmailIcon, LockIcon } from "@chakra-ui/icons";
import bg from "../img/bg.png";
import { useNavigate } from 'react-router-dom';
import apiService from '../services/apiService.js';
import { useState } from 'react';

// SignIn Component: Main component to render the sign-in form
const SignIn = () => {

  const navigate = useNavigate();
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [loginError, setLoginError] = useState(null);
    const [emailError, setEmailError] = useState(null); 
    const [passwordError, setPasswordError] = useState(null);


  const isEmailValid = () => {

    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
  };

  const isPasswordValid = () => {
    return password.length >= 6; 
  };
  

  const handleLogin = async () => {

    if (!isEmailValid()) {
      setEmailError("Digite um email válido.");
      return; 
    }

    if (!isPasswordValid()) {
      setPasswordError("A senha deve ter pelo menos 6 caracteres.");
      return;
    }
    
    setEmailError(null);
    setPasswordError(null);

    try {
      const response = await apiService.post('/auth/login', {
        login: email, 
        password: password,
      });

      localStorage.setItem('token', response.data.token);
      localStorage.setItem('role', response.data.role);

      console.log("Login realizado:", response.data);

      switch (response.data.role) {
      case 'ADMIN':
        navigate('/admin-benefits');
        break;
      case 'STUDENT':
        navigate('/student-balance');
        break;
      case 'PROFESSOR':
        navigate('/student-balance');
        break;
      case 'COMPANY':
          navigate('/partner-company-benefits');
          break;
      default:
        navigate('/');
        break;
      }

    } catch (error) {
      if (error.response) {
          setLoginError(error.response.data || "Erro ao fazer login. Verifique suas credenciais.");
      } else if (error.request){
          setLoginError("Erro de rede. Verifique sua conexão.");
      } else {
          setLoginError("Erro desconhecido. Tente novamente mais tarde.");
      }
  }
  };

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
            {/* Left Section: Sign-in form */}
            <Box
              display="flex"
              flexDirection="column"
              justifyContent="center"
              alignItems="flex-start"
            >
              <h1
                style={{
                  color: "#E11138", // Primary pink color
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

              {/* Input Fields */}
              <Stack
                spacing={4}
                style={{ margin: "60px", paddingLeft: "20px" }}
              >
                <InputGroup>
                  <InputLeftElement pointerEvents="none">
                    {/* Email icon */}
                    <EmailIcon color="gray.500" />
                  </InputLeftElement>
                  <Input
                    type="email"
                    placeholder="E-mail"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                    w="437px"
                    style={{ backgroundColor: "#ECEEF1", borderRadius: "12px" }}
                    sx={{
                      // Styling for hover and focus states
                      _hover: { borderColor: "#E11138" },
                      _focus: {
                        borderColor: "#E11138", //
                        boxShadow: "0 0 0 1px #E11138",
                      },
                    }}
                  />
                </InputGroup>

                <InputGroup>
                  <InputLeftElement pointerEvents="none">
                    {/* Lock password icon */}
                    <LockIcon color="gray.500" />
                  </InputLeftElement>
                  <Input
                    type="password"
                    placeholder="Password"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                    w="437px"
                    style={{ backgroundColor: "#ECEEF1", borderRadius: "12px" }}
                    sx={{
                      // Styling for hover and focus states
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

              {/* Forgot password link and login button */}
              <div
                style={{
                  display: "flex",
                  justifyContent: "space-between",
                  alignItems: "center",
                  marginBottom: "40px",
                  width: "100%",
                  paddingLeft: "80px",
                  paddingRight: "60px",
                }}
              >
                {/* Forgot password link */}
                <Link>Forgot your password?</Link>
                {/* Log in button */}
                <Button
                  onClick={handleLogin}
                  style={{
                    backgroundColor: "#E11138",
                    color: "white",
                    borderRadius: "12px",
                  }}
                  sx={{
                    // Styling for hover and focus states
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

            {/* Right Section: Welcome message and Sign-up button */}
            <Box
              display="flex"
              flexDirection="column"
              bgImage={`url(${bg})`} // Background image
              bgRepeat="no-repeat"
              bgSize="cover"
              style={{
                borderRadius: "20px",
                padding: "30px",
                margin: "5px",
                paddingTop: "80px",
              }}
            >
              {/* Welcome message */}
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
              {/* Registration prompt */}
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
                {/* Sign-up button */}
                <Button
                  onClick={() => navigate('/sign-up')}
                  colorScheme="whiteAlpha"
                  style={{
                    marginRight: "30px",
                    marginTop: "20px",
                    marginBottom: "40px",
                    borderRadius: "12px",
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
