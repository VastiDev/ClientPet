// src/components/Home.js
import React from 'react';
import gatosCachorrosImage from '../assets/gatos-cachorros-principal.png'; // Importe a imagem

function Home() {
    const containerStyle = {
        textAlign: 'center',
        marginTop: '100px', // Adicionar espaçamento para afastar da navbar
    };

    const imageStyle = {
        width: '800px', // Definir um tamanho fixo para garantir que a imagem aumente
        height: 'auto',
        marginTop: '70px', // Espaçamento abaixo do título
        marginBottom: '30px',
    };

    const textStyle = {
        fontSize: '2.5rem',
        fontWeight: 'bold',
        color: '#333',
        marginBottom: '30px', // Espaçamento abaixo do texto
    };

    return (
        <div style={containerStyle}>
            <h1 style={textStyle}>Sistema para gerenciamento de Clientes e seus Pets</h1>
            <img src={gatosCachorrosImage} alt="Gatos e Cachorros" style={imageStyle} />
        </div>
    );
}

export default Home;


