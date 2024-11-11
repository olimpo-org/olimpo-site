<%@ page import="org.example.olimposite.DAO.InteresseDAO" %>
<%@ page import="org.example.olimposite.Modells.Interesse" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../../../CSS/AreaRestrita/Criar/criarCliente.css" />
    <link rel="icon" href="../../../Imagens/ImagensAreaRestrita/LogoOlimpo2.1.png" />
    <title>Criar Cliente</title>
</head>
<body>
<nav>
    <a
            href="../../../JSP/CRUD/Mostrar/Cliente.jsp"
    >
        <div id="logolimpo"><br /></div>
    </a>
</nav>

<img src="../../../Imagens/Casas.png" alt="" class="imgCasa" />

<div class="campos">
    <h1>Cadastro Área Restrita</h1>
    <div class="inputs">
        <form action="/ServletCriarClienteAreaRestrita" method="post">
            <div class="form">
                <div class="box form1">
                    <input type="text" placeholder="Nome" name="nome" required />
                    <input type="text" placeholder="Sobrenome" name="sobrenome" required />
                    <input type="text" placeholder="E-mail" name="email" required />
                    <input type="text" placeholder="Senha" name="senha" required />
                </div>
                <div class="box form2">
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
                    <input type="text" id="tel" placeholder="Telefone" name="tel" maxlength="15" required />
                    <input type="text" id="cpf" placeholder="CPF" name="cpf" maxlength="14" required />
                    <select name="genero" required>
                        <option value="">Selecione seu gênero</option>
                        <option value="Feminino">Feminino</option>
                        <option value="Masculino">Masculino</option>
                        <option value="Outro">Outro</option>
                    </select>
                </div>
            </div>

            <button class="btn"><strong>Cadastrar</strong></button>
        </form>
    </div>
</div>
<img src="../../../Imagens/Predios.png" alt="" class="imgPredio" />
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

