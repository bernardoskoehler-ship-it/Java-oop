public static class Usuario {
    private String nome;
    private String senha;
    private String email;

    Usuario(String nome, String senha, String email) {
        setNome(nome);
        setSenha(senha);
        setEmail(email);
    }

    public void setNome(String nome) {
        if (nome != null && !nome.trim().isEmpty()) {
            this.nome = nome;
        } else {
            System.out.println("Nome invalido");
        }
    }

    public void setEmail(String email) {
        if (email != null && email.contains("@")) {
            this.email = email;
        } else {
            System.out.println("Email invalido");
        }
    }

    public void setSenha(String senha) {
        if (senha != null && senha.trim().length() >= 6) {
            this.senha = senha;
        } else {
            System.out.println("Senha invalida");
        }
    }

    public String getNome() {
        return nome;
    }

    public boolean verificarSenha(String tentativa) {
        return this.senha.equals(tentativa);
    }

    public void mostrarConta() {
        System.out.println("Usuario: " + nome + " | Email: " + email + " | Senha: ********");
    }
}
public static void main(String[] args) {
    Usuario u = new Usuario("Bernardo", "1234567", "bernardoskoehler@gmail.com");
    u.mostrarConta();
}
