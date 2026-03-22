public static class Personagem {
    private String nome;
    private int vida;
    private int vidaMaxima;

    Personagem(String nome, int vidaMaxima, int vidaInicial) {
        setNome(nome);

        if (vidaMaxima > 0) {
            this.vidaMaxima = vidaMaxima;
        } else {
            System.out.println("Valor invalido para vida maxima");
        }

        if (vidaInicial >= 0 && vidaInicial <= this.vidaMaxima) {
            this.vida = vidaInicial;
        } else {
            System.out.println("Vida inicial invalida");
        }
    }

    public void setNome(String nome) {
        if (nome != null && !nome.trim().isEmpty()) {
            this.nome = nome;
        } else {
            System.out.println("Nome invalido");
        }
    }

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public void receberDano(int valor) {
        if (valor <= 0) {
            System.out.println("Valor de dano invalido!");
        } else if (vida <= 0) {
            System.out.println(nome + " ja esta morto!");
        } else {
            vida -= valor;
            if (vida < 0) {
                vida = 0;
            }
            System.out.println(nome + " perdeu " + valor + " de vida!");
        }
    }

    public void curar(int valor) {
        if (valor <= 0) {
            System.out.println("Valor invalido de cura!");
        } else if (vida <= 0) {
            System.out.println("Nao pode curar pois ja esta morto");
        } else if (vida + valor <= vidaMaxima) {
            vida += valor;
            System.out.println(nome + " recuperou " + valor + " de vida!");
        } else {
            System.out.println("Valor maior que vida maxima, curou so " + (vidaMaxima - vida));
            vida = vidaMaxima;
        }
    }
}
public static void main(String[] args) {
Personagem p = new Personagem("Bernardo", 30, 10);

p.receberDano(9);
p.curar(4);
p.curar(67);
System.out.println(p.getVida());
}
