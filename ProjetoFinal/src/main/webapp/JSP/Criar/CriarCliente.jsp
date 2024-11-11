<%@ page import="org.example.olimposite.DAO.InteresseDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.olimposite.Modells.Interesse" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../CSS/Cadastro/cadastro.css">
    <link rel="icon" href="../../Imagens/ImagemEndereco/LogoBorda.png" />
    <title>Cadastro</title>
</head>
<header>
</header>
<body>

<nav>
    <a
            href="../../index.html"
    >
        <div id="logolimpo"><br /></div>
    </a>
</nav>
<div class="texto">
    <h1>Turbine seus anúncios no Olimpo!</h1>
</div>

<div class="campos">
    <h1>Cadastre-se Gratuitamente</h1>
    <p>Já tem conta? <a href="../../HTML/TelasDeLogin/login.html">Faça o Login</a></p>
    <form action="/ServletCliente" method="post">
        <div class="inputs">
            <input type="text"
                   placeholder=" Nome"
                   name="nome" required>
            <input id="tel" type="tel"
                   placeholder=" Telefone"
                   name="tel" maxlength="15" required>
            <input type="text"
                   placeholder=" Sobrenome"
                   name="sobrenome" required>
            <input id="cpf" type="text"
                   placeholder=" CPF"
                   name="cpf" maxlength="14" required>
            <input id="email" type="text"
                   placeholder=" E-mail"
                   name="email" required>
            <select name="genero" required>
                <option value="">Selecione seu gênero</option>
                <option value="Feminino">Feminino</option>
                <option value="Masculino">Masculino</option>
                <option value="Outro">Outro</option>
            </select>
            <input type="password"
                   placeholder=" Senha"
                   name="senha"
                   id="senha" required>
            <select name="interesse" id="interesse" required>
                <option value="">Selecione um interesse</option>
                <%
                    InteresseDAO interesseDAO = new InteresseDAO();
                    List<Interesse> interesses = interesseDAO.mostrarInteresse();
                    for (int i = 0; i < interesses.size(); i++) {
                        String interesse = interesses.get(i).getNome();
                %>
                <option value="<%=interesse%>"><%=interesse%></option>
                <%
                    }
                %>
            </select>
            <div class="formato-senha">
                <ul>
                    <lh>Senha deve conter:</lh>
                    <li>Minímo 8 digitos</li>
                    <li>Uma letra maiúscula</li>
                    <li>Uma letra minúscula</li>
                    <li>Um número</li>
                </ul>
            </div>
        </div>
        <div class="pronto">
            <button class="botao"><strong>Cadastrar</strong></button>
        </div>
    </form>
</div>
<script>
    const phoneInput = document.getElementById('tel');

    phoneInput.addEventListener('input', function (event) {
        let input = event.target.value;

        // Remove caracteres não numéricos
        input = input.replace(/\D/g, '');

        // Aplica a formatação (XX) XXXXX-XXXX
        input = input.replace(/^(\d{2})(\d)/, '($1) $2');
        input = input.replace(/(\d{5})(\d)/, '$1-$2');

        // Atualiza o valor do input com o formato
        event.target.value = input;
    });
    const cpfInput = document.getElementById('cpf');

    cpfInput.addEventListener('input', function (event) {
        let input = event.target.value;

        // Remove caracteres não numéricos
        input = input.replace(/\D/g, '');

        // Aplica a formatação CPF: XXX.XXX.XXX-XX
        input = input.replace(/(\d{3})(\d)/, '$1.$2');
        input = input.replace(/(\d{3})(\d)/, '$1.$2');
        input = input.replace(/(\d{3})(\d{1,2})$/, '$1-$2');

        // Atualiza o valor do input com o formato
        event.target.value = input;
    });
</script>
</body>
</html>