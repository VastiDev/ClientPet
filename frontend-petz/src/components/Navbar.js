// src/components/Navbar.js
import React from 'react';
import { NavLink } from 'react-router-dom';

function Navbar() {
    const navbarStyle = {
        backgroundColor: '#0000FF', // Azul
        color: '#FFFF00', // Amarelo
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'flex-start', // Move os links para a esquerda
        padding: '20px', // Aumenta o padding para aumentar a altura da navbar
        position: 'fixed',
        top: 0,
        width: '100%',
    };

    const linkStyle = {
        color: '#FFFF00', // Amarelo
        marginRight: '20px',
        marginLeft: '30px', // Adiciona um pouco de espaçamento à esquerda dos links
        textDecoration: 'none',
        fontSize: '1.5rem', // Aumenta o tamanho da fonte
        fontWeight: 'bold',
    };

    return (
        <nav style={navbarStyle}>
            <NavLink to="/" exact="true" style={linkStyle}>
                Home
            </NavLink>
            <NavLink to="/clientes" style={linkStyle}>
                Clientes
            </NavLink>
            <NavLink to="/pets" style={linkStyle}>
                Pets
            </NavLink>
        </nav>
    );
}

export default Navbar;
