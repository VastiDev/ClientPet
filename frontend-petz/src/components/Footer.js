// src/components/Footer.js
import React from 'react';
import strawberryImage from '../assets/strawberry.png';

function Footer() {
    const footerStyle = {
        backgroundColor: '#FFFF00', // Amarelo
        color: '#0000FF', // Azul
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center',
        padding: '20px', // Aumenta o padding para aumentar a altura do rodapé
        position: 'fixed',
        bottom: 0,
        width: '100%',
    };

    const textStyle = {
        marginLeft: '10px',
        fontSize: '1.5rem', // Aumenta o tamanho da fonte
    };

    const strawberryStyle = {
        width: '40px', // Aumenta o tamanho da imagem do morango
        height: '40px',
    };

    return (
        <footer style={footerStyle}>
            <img src={strawberryImage} alt="Morango" style={strawberryStyle} />
            <span style={textStyle}>front created by ChatGPT-o1</span>
        </footer>
    );
}

export default Footer;
