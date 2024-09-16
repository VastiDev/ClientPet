// src/components/Pets.js
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import gatosCachorrosPets from '../assets/gatos-cachorros-pets.png'; // Importe a imagem

function Pets() {
    const [formData, setFormData] = useState({
        nomePet: '',
        porte: '',
        tipo: '',
        microchip: '',
        raca: '',
        sexo: '',
        dataNascimento: '',
        peso: '',
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData((prevState) => ({
            ...prevState,
            [name]: value,
        }));
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        // Submissão do formulário aqui
    };

    const containerStyle = {
        display: 'flex',
        justifyContent: 'space-between',
        alignItems: 'center',
        margin: '20px',
    };

    const formStyle = {
        flex: 1,
        marginRight: '20px',
    };

    const inputStyle = {
        fontSize: '1.2rem',
        padding: '10px',
        margin: '10px 0',
        width: '100%',
    };

    const imageStyle = {
        maxWidth: '35%',
        height: 'auto',
    };

    return (
        <div style={containerStyle}>
            <form onSubmit={handleSubmit} style={formStyle}>
                <h2>Cadastro de Pets</h2>
                <input
                    type="text"
                    name="nomePet"
                    placeholder="Nome do Pet"
                    value={formData.nomePet}
                    onChange={handleChange}
                    style={inputStyle}
                    required
                />
                <select name="porte" value={formData.porte} onChange={handleChange} style={inputStyle} required>
                    <option value="">Selecione o Porte</option>
                    <option value="PEQUENO">Pequeno</option>
                    <option value="MÉDIO">Médio</option>
                    <option value="GRANDE">Grande</option>
                </select>
                <select name="tipo" value={formData.tipo} onChange={handleChange} style={inputStyle} required>
                    <option value="">Selecione o Tipo</option>
                    <option value="CACHORRO">Cachorro</option>
                    <option value="GATO">Gato</option>
                    <option value="AVE">Ave</option>
                    {/* Adicione mais tipos conforme necessário */}
                </select>
                <input
                    type="text"
                    name="microchip"
                    placeholder="Microchip"
                    value={formData.microchip}
                    onChange={handleChange}
                    style={inputStyle}
                />
                <input
                    type="text"
                    name="raca"
                    placeholder="Raça"
                    value={formData.raca}
                    onChange={handleChange}
                    style={inputStyle}
                    required
                />
                <input
                    type="date"
                    name="dataNascimento"
                    value={formData.dataNascimento}
                    onChange={handleChange}
                    style={inputStyle}
                    required
                />
                <input
                    type="number"
                    name="peso"
                    placeholder="Peso"
                    value={formData.peso}
                    onChange={handleChange}
                    style={inputStyle}
                />
                <button type="submit" style={inputStyle}>Cadastrar Pet</button>
            </form>
            <img src={gatosCachorrosPets} alt="Gatos e Cachorros" style={imageStyle} />
        </div>
    );
}

export default Pets;
