package org.example.olimposite.Hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
    public String gerarHash(String senha) {
        try {
            // Inicializa um objeto MessageDigest com o algoritmo SHA-256.
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Gera o hash da senha convertida para bytes.
            byte[] encodedHash = digest.digest(senha.getBytes());

            // StringBuilder para construir a representação hexadecimal do hash.
            StringBuilder hexString = new StringBuilder();

            // Converte cada byte do hash para hexadecimal.
            for (byte b : encodedHash) {
                // Converte o byte para um valor hexadecimal sem sinal (0xff & b) e em string.
                String hex = Integer.toHexString(0xff & b);

                // Adiciona um zero à esquerda se o valor hexadecimal tiver apenas um dígito.
                if (hex.length() == 1) hexString.append('0');

                // Adiciona o valor hexadecimal ao StringBuilder.
                hexString.append(hex);
            }

            // Retorna a string com a representação hexadecimal completa do hash.
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            // Lança uma exceção em tempo de execução caso o algoritmo SHA-256 não seja encontrado.
            throw new RuntimeException(e);
        }
    }
}
