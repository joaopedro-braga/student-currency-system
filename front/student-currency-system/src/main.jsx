import { StrictMode } from "react";
import { createBrowserRouter, RouterProvider } from "react-router-dom"; // Correção das importações

import { createRoot } from "react-dom/client";
import App from "./App.jsx";
import "./index.css";

import Home from "./routes/Home.jsx";
import SignUpStudent from "./routes/SignUpStudent.jsx";
import SignUpPartnerCompany from "./routes/SignUpPartnerCompany.jsx";
import SignIn from "./routes/SignIn.jsx";
import SignUp from "./routes/SignUp.jsx";

const router = createBrowserRouter([
  {
    path: "/",
    element: <Home />,
  },
  {
    path: "/sign-up-student",
    element: <SignUpStudent />,
  },
  {
    path: "/sign-up-partner-company",
    element: <SignUpPartnerCompany />,
  },
  {
    path: "/sign-in",
    element: <SignIn />,
  },
  {
    path: "/sign-up",
    element: <SignUp />,
  },
]);


createRoot(document.getElementById("root")).render(
  <StrictMode>
    <RouterProvider router={router} />
  </StrictMode>
);
