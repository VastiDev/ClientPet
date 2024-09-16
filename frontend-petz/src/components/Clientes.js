// src/components/Clientes.js
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import gatosCachorrosClientes from '../assets/gatos-cachorros-clientes.png'; // Importe a imagem

function Clientes() {
    const [clientes, setClientes] = useState([]);
    const [formData, setFormData] = useState({
        nomeCompleto: '',
        email: '',
        cep: '',
        celular: '',
        telefone: '',
        sexo: '',
        dataNascimento: '',
        cpf: '',
        aceitaTermos: false,
    });

    useEffect(() => {
        axios
            .get('http://localhost:8080/cliente-pet/api/clientes')
            .then((response) => {
                setClientes(response.data);
            })
            .catch((error) => {
                console.error('Erro ao buscar clientes:', error);
            });
    }, []);

    const handleChange = (e) => {
        const { name, value, type, checked } = e.target;
        setFormData((prevState) => ({
            ...prevState,
            [name]: type === 'checkbox' ? checked : value,
        }));
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        axios
            .post('http://localhost:8080/cliente-pet/api/clientes', formData)
            .then((response) => {
                setClientes([...clientes, response.data]);
                setFormData({
                    nomeCompleto: '',
                    email: '',
                    cep: '',
                    celular: '',
                    telefone: '',
                    sexo: '',
                    dataNascimento: '',
                    cpf: '',
                    aceitaTermos: false,
                });
            })
            .catch((error) => {
                console.error('Erro ao criar cliente:', error);
            });
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
        width: '50%',
    };

    const imageStyle = {
        maxWidth: '35%',
        height: 'auto',
    };

    return (
        <div style={containerStyle}>
            <form onSubmit={handleSubmit} style={formStyle}>
                <h2>Cadastro de Clientes</h2>
                <input
                    type="text"
                    name="nomeCompleto"
                    placeholder="Nome Completo"
                    value={formData.nomeCompleto}
                    onChange={handleChange}
                    style={inputStyle}
                    required
                />
                <input
                    type="email"
                    name="email"
                    placeholder="E-mail"
                    value={formData.email}
                    onChange={handleChange}
                    style={inputStyle}
                    required
                />
                <input
                    type="text"
                    name="cep"
                    placeholder="CEP"
                    value={formData.cep}
                    onChange={handleChange}
                    style={inputStyle}
                    required
                />
                <input
                    type="text"
                    name="celular"
                    placeholder="Celular"
                    value={formData.celular}
                    onChange={handleChange}
                    style={inputStyle}
                    required
                />
                <input
                    type="text"
                    name="telefone"
                    placeholder="Telefone"
                    value={formData.telefone}
                    onChange={handleChange}
                    style={inputStyle}
                />
                <select name="sexo" value={formData.sexo} onChange={handleChange} style={inputStyle} required>
                    <option value="">Selecione o Sexo</option>
                    <option value="MASCULINO">Masculino</option>
                    <option value="FEMININO">Feminino</option>
                </select>
                <input
                    type="date"
                    name="dataNascimento"
                    value={formData.dataNascimento}
                    onChange={handleChange}
                    style={inputStyle}
                    required
                />
                <input
                    type="text"
                    name="cpf"
                    placeholder="CPF"
                    value={formData.cpf}
                    onChange={handleChange}
                    style={inputStyle}
                    required
                />
                <label>
                    <input
                        type="checkbox"
                        name="aceitaTermos"
                        checked={formData.aceitaTermos}
                        onChange={handleChange}
                        style={{ marginRight: '10px' }}
                        required
                    />
                    Aceito os termos
                </label>
                <button type="submit" style={inputStyle}>Cadastrar Cliente</button>
            </form>
            <img src={gatosCachorrosClientes} alt="Gatos e Cachorros" style={imageStyle} />
        </div>
    );
}

export default Clientes;

