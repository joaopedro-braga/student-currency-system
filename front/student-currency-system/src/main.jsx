import { StrictMode } from "react";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import { ChakraProvider } from "@chakra-ui/react"; 
import { createRoot } from "react-dom/client";
import App from "./App.jsx";
import "./index.css";

import Home from "./routes/Home.jsx";
import SignIn from "./routes/SignIn.jsx";
import SignUp from "./routes/SignUp.jsx";
import AdminBenefits from "./routes/AdminBenefits.jsx";
import AdminInstitutions from "./routes/AdminInstitutions.jsx";
import AdminProfessors from "./routes/AdminProfessors.jsx";
import PartnerCompanyBenefits from "./routes/PartnerCompanyBenefits.jsx";
import StudentBalence from "./routes/StudentBalence.jsx";
import StudentBenefits from "./routes/StudentBenefits.jsx";
import StudentVouchers from "./routes/StudentVouchers.jsx";
import Professor from "./routes/Professor.jsx";

// Definição das rotas
const router = createBrowserRouter([
  {
    path: "/",
    element: <Home />,
  },
  {
    path: "/sign-in",
    element: <SignIn />,
  },
  {
    path: "/sign-up",
    element: <SignUp />,
  },
  {
    path: "/admin-benefits",
    element: <AdminBenefits />,
  },
  {
    path: "/admin-institutions",
    element: <AdminInstitutions />,
  },
  {
    path: "/admin-professors",
    element: <AdminProfessors />,
  },
  {
    path: "/partner-company-benefits",
    element: <PartnerCompanyBenefits />,
  },
  {
    path: "/student-balence",
    element: <StudentBalence />,
  },
  {
    path: "/student-benefits",
    element: <StudentBenefits />,
  },
  {
    path: "/student-vouchers",
    element: <StudentVouchers />,
  },
  {
    path: "/professor",
    element: <Professor />,
  }
]);

// Renderização do app
createRoot(document.getElementById("root")).render(
  <StrictMode>
    <ChakraProvider>
      {/* ChakraProvider para integrar os estilos do Chakra UI */}
      <RouterProvider router={router} />
    </ChakraProvider>
  </StrictMode>
);
 