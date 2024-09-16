// src/App.js
import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Clientes from './components/Clientes';
import Pets from './components/Pets';
import Home from './components/Home';
import Footer from './components/Footer';
import Navbar from './components/Navbar'; // Importe a Navbar

function App() {
    return (
        <Router>
            <div>
                <Navbar />
                <Routes>
                    <Route path="/" element={<Home />} />
                    <Route path="/clientes" element={<Clientes />} />
                    <Route path="/pets" element={<Pets />} />
                </Routes>
                <Footer />
            </div>
        </Router>
    );
}

export default App;



