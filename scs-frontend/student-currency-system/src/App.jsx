import { useState } from 'react'
import './App.css'

import { Outlet } from 'react-router-dom';


function App() {

  return (
    <>
      <h1>Julia</h1>
      <Outlet />
    </>
  )
}

export default App
