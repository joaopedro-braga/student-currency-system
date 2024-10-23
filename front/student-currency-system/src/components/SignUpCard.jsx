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
import bg from "../img/bg.png";
import SignUpForms from "./SignUpForms";
import SignUpStudent from "./SignUpStudent";
import SignUpCompany from "./SignUpCompany";

const SignUpCard = () => {  
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
                bgImage={`url(${bg})`}
                bgRepeat="no-repeat"
                bgSize="cover"
                style={{
                  borderRadius: "20px",
                  padding: "30px",
                  margin: "5px",
                  paddingTop: "80px",
                }}
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
                  Welcome!
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
                  Not a member yet?
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
                  Enter your details to create an account and be part of our
                  community!
                </h3>
              </Box>
              <Box
                display="flex"
                flexDirection="column"
                justifyContent="center"
                alignItems="flex-start"
              >
                <SignUpForms></SignUpForms>
              </Box>
            </Grid>
          </CardBody>
        </Card>
      </Box>
    );
}

export default SignUpCard;