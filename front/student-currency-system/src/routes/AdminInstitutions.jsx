import React from "react";
import NavBar from "../components/NavBar";
import fundo from "../img/fundo.png";
import { Button, Box } from "@chakra-ui/react";

const AdminInstitutions = () => {
  return (
    <>
      <NavBar />
      <div
        className="banner"
        style={{
          backgroundImage: `url(${fundo})`,
          backgroundSize: "cover",
          height: "", // Ajuste de altura, pode ser personalizado
          width: "100%",
        }}
      >
        <div style={{padding: "50px"}}>
          <h1
            style={{
              fontSize: "36px",
              color: "white",
              fontWeight: "500",
              lineHeight: "39.6px",
              textAlign: "center",
              padding: "20px",
            }}
          >
            INSTITUTION REGISTRATION
          </h1>

          <h2
            style={{
              fontSize: "32px",
              fontWeight: "700",
              lineHeight: "44.8px",
              textAlign: "center",
              color: "white",
              marginBottom: "30px",
            }}
          >
            Register your partner educational institutions with ease.
          </h2>
          <Button
            colorScheme="whiteAlpha"
            style={{
              fontSize: "20px",
              fontWeight: "600",
              lineHeight: "24.2px",
              marginRight: "300px",
              marginTop: "20px",
              marginBottom: "40px",
              borderRadius: "12px",
              textAlign: "center",
              padding: "25px",
              display: "flex", 
              alignItems: "center", 
              justifyContent: "center", 
              margin: "0 auto", 
              height: "60px", 
            }}
          >
            SIGN UP
          </Button>
        </div>
      </div>
    </>
  );
};

export default AdminInstitutions;
