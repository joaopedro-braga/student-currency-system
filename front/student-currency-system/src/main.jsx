import { StrictMode } from "react";
import { createBrowserRouter, RouterProvider, Navigate } from "react-router-dom";
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
import PrivateRoute from "./components/auth/PrivateRoute.jsx";

// Definição das rotas
const router = createBrowserRouter([
  {
    path: "/",
    element: <Navigate to="/sign-in" />,
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
    element: (
      <PrivateRoute allowedRoles={['ADMIN']}>
        <AdminBenefits />
      </PrivateRoute>
    ),
  },
  {
    path: "/admin-institutions",
    element: (
      <PrivateRoute allowedRoles={['ADMIN']}>
        <AdminInstitutions />
      </PrivateRoute>
    ),
  },
  {
    path: "/admin-professors",
    element: (
      <PrivateRoute allowedRoles={['ADMIN']}>
        <AdminProfessors />
      </PrivateRoute>
    ),
  },
  {
    path: "/partner-company-benefits",
    element: (
      <PrivateRoute allowedRoles={['COMPANY']}>
        <PartnerCompanyBenefits />
      </PrivateRoute>
    ),
  },
  {
    path: "/student-balence", 
    element: (
      <PrivateRoute allowedRoles={['STUDENT']}>
        <StudentBalence />
      </PrivateRoute>
    ),
  },
  {
    path: "/student-benefits",
    element: (
      <PrivateRoute allowedRoles={['STUDENT']}>
        <StudentBenefits />
      </PrivateRoute>
    ),
  },
  {
    path: "/student-vouchers",
    element: (
      <PrivateRoute allowedRoles={['STUDENT']}>
        <StudentVouchers />
      </PrivateRoute>
    ),
  },
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
 