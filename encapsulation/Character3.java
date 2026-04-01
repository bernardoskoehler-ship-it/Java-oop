class Personagem {
    String nome;
    private int vida;

    public String getNome() {
        return nome;
    }
    public int getVida() {
        return vida;
    }

    public boolean estaVivo() {
        return getVida() > 0;
    }

    public boolean podeAtacar(Personagem alvo) {
        if(!estaVivo()) {
            System.out.println(getNome() +" nao pode atacar pois esta morto");
            return false;
        }
        if(!alvo.estaVivo()) {
            System.out.println(alvo.getNome() +" ja esta morto");
            return false;
        }
        return true;
    }

    private void receberDano(int valor) {
        vida -= valor;
        if(getVida() < 0) {
            vida = 0;
        }
    }

    void atacar(Personagem alvo) {
        if (podeAtacar(alvo)) {
            alvo.receberDano(10);
            System.out.println(getNome() + " atacou " +alvo.getNome());
        }
    }
}
