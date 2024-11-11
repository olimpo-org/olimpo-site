package org.example.olimposite.Regex;

import java.util.Stack;

public class Regex {
    public Stack<String> validar(String email, String senha, String cpf, String telefone) {
        Stack<String> pilhaErrosRegex = new Stack<>();
        boolean emailValido = email.matches("^\\D\\w+@\\D+\\.\\D{3}(\\.\\D{2})?$");
        boolean senhaValida = senha.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,}$");
        boolean cpfValido = cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");
        boolean telefoneValido = telefone.matches("^\\(\\d{2}\\) \\d{5}-\\d{4}$");

        if (!emailValido) {
            pilhaErrosRegex.push("E-mail inválido");
        }
        else if (!senhaValida) {
            pilhaErrosRegex.push("Formato da senha inválida");
        }
        else if (!cpfValido) {
            pilhaErrosRegex.push("Formato do CPF inválido");
        }
        else if (!telefoneValido) {
            pilhaErrosRegex.push("Formato do telefone inválido.");
        }
        return pilhaErrosRegex;
    }
}
