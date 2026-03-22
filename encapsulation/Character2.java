class Personagem {
    private String nome;
    private int vida;
    private int vidaMaxima;

    public void curar(int valor) {
        if (!valorValido(valor)) {
            System.out.println("Valor invalido");
            return;
        }
        if (!estarVivo()) {
            System.out.println(nome + " esta morto");
            return;
        }
        receberCura(valor);
        System.out.println(nome +" foi curado");
    }
    private void receberCura(int valor) {
        vida += valor;
        if(vida > vidaMaxima) {
            vida = vidaMaxima;
        }
    }
    boolean estarVivo() {
        return vida > 0;
    }
    boolean valorValido(int valor) {
        return valor > 0;
    }
