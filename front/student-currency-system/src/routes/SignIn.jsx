import React from "react";
import { Card, CardBody, Grid } from "@chakra-ui/react";
import { Box } from "@chakra-ui/react";
import bg from "../img/bg.png";
import { Button, ButtonGroup } from "@chakra-ui/react";

const SignIn = () => {
  return (
    <>
      <Card
        w="80%"
        mx="auto"
        border="1px solid #00000033"
        style={{ borderRadius: "20px" }}
      >
        <CardBody>
          <Grid templateColumns="repeat(2, 1fr)" gap={6}>
            <Box>
              <h1
                style={{
                  color: "#E11138",
                  textAlign: "left",
                  padding: "40px",
                  margin: "40px",
                }}
              >
                Sign In
              </h1>
            </Box>
            <Box
              bgImage={`url(${bg})`} // Definindo a imagem como background
              bgPosition="center"
              bgRepeat="no-repeat"
              bgSize="cover"
              style={{ borderRadius: "0px 20px 20px 0px ", padding: "30px" }}
            >
              <h1
                style={{
                  color: "white",
                  textAlign: "left",
                  padding: "10px",
                  margin: "10px",
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
                }}
              >
                Are you not registered yet?
              </h3>
              <h3
                style={{
                  color: "white",
                  textAlign: "right",
                  padding: "10px",
                  margin: "10px",
                }}
              >
                Enter your details to create an account and join us!
              </h3>
              <Button colorScheme="blue">Button</Button>
            </Box>
          </Grid>
        </CardBody>
      </Card>
    </>
  );
};

export default SignIn;
