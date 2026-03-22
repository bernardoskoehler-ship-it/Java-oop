static class Personagem {
    private String nome;
    private int vida;
    private int vidaMaxima = 50;

    protected Personagem(String nome, int vida) {
        setNome(nome);
        setVida(vida);
    }

    public void mostrarStatus() {
        System.out.println("Nome: " + getNome());
        System.out.println("vida: " + getVida() + "/" +vidaMaxima);
        if (estaVivo()) {
            System.out.println("Status: Vivo");
        } else {
            System.out.println("Status: Morto");
        }
    }

    boolean valorValido(int valor) {
        return valor > 0;
    }

    /// GET/SET /// /// /// /// /// /// ///
    private void setNome(String nome) {
        if (nome != null && !nome.trim().isEmpty()) {
            this.nome = nome;
        } else {
            this.nome = "Null";
        }
    }

    private void setVida(int vida) {
        if (valorValido(vida) && vida <= vidaMaxima) {
            this.vida = vida;
        } else {
            this.vida = 10;
        }
    }

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    /// GET/SET /// /// /// /// /// /// ///

    protected boolean podeAtacar(Personagem alvo) {
        return this != alvo && estaVivo() && alvo.estaVivo();
    }

    boolean estaVivo() {
        return getVida() > 0;
    }

    protected void atacar(Personagem alvo) {
        if (!podeAtacar(alvo)) {
            System.out.println(getNome() + " nao pode atacar");
            return;
        }
        System.out.println(getNome() + " atacou " + alvo.getNome());
        alvo.receberDano(10);
    }

    protected void receberDano(int dano) {
        if (!valorValido(dano)) {
            System.out.println("Valor invalido!");
            return;
        }
        if (!estaVivo()) {
            System.out.println(getNome() + " ja esta morto");
            return;
        }
        vida -= dano;
        if (getVida() < 0) {
            vida = 0;
        }
    }

    protected void ataqueEspecial(Personagem alvo) {
        if (!podeAtacar(alvo)) {
            System.out.println(getNome() + " nao pode usar ataque especial!");
            return;
        }
        System.out.println(getNome() + " usou seu ataque especial em " + alvo.getNome());
        alvo.receberDano(10);
    }

    void curar(int cura) {
        if (!valorValido(cura)) {
            System.out.println("Valor invalido de cura!");
            return;
        }
        if (!estaVivo()) {
            System.out.println("Nao pode curar enquanto morto!");
            return;
        }
        int curaTotal = vidaMaxima - getVida();
        vida += cura;

        if (vida > vidaMaxima) {
            vida = vidaMaxima;
            System.out.println(getNome() + " curou " + curaTotal);
            return;
        }
        System.out.println(getNome() + " curou " + cura);
    }
}

static class Guerreiro extends Personagem {
    private int forca;

    Guerreiro(String nome, int vida, int forca) {
        super(nome, vida);
        setForca(forca);
    }
    public void mostrarStatus(){
        super.mostrarStatus();
        System.out.println("Forca: " +getForca());
    }

    /// SET/GET ///
    private void setForca(int forca) {
        if (valorValido(forca)) {
            this.forca = forca;
        }
    }

    public int getForca() {
        return forca;
    }

    /// SET/GET ///

   protected void atacar(Personagem alvo) {
        if(!podeAtacar(alvo)) {
            System.out.println(getNome() +" nao pode atacar");
            return;
        }
        System.out.println(getNome() + " atacou " + alvo.getNome() +" com uma espada, e causou " +getForca() +" de dano");
        alvo.receberDano(getForca());

    }
    protected void ataqueEspecial(Personagem alvo) {
        if(!podeAtacar(alvo)) {
            System.out.println(getNome() +" nao pode usar seu ataque especial!");
            return;
        }
        int danoEspecial = getForca() + 5;
        System.out.println(getNome() +" usou seu golpe pesado em " +alvo.getNome() +", e causou " +danoEspecial +" de dano!");
        alvo.receberDano(danoEspecial);
    }
}


static class Mago extends Personagem {
    private int mana;
    private int danoMagico = 5;

    Mago(String nome, int vida, int mana) {
        super(nome, vida);
        setMana(mana);
    }
    public void mostrarStatus(){
        super.mostrarStatus();
        System.out.println("Mana: " +getMana());
    }

    /// SET/GET ///
    private void setMana(int mana) {
        if(valorValido(mana)) {
            this.mana = mana;
        }
    }
    public int getMana() {return mana;}
    public int getDanoMagico() {return danoMagico;}
    /// SET/GET ///

    boolean temMana(int manaNecessaria) {
        return getMana() >= manaNecessaria;
    }

    protected void atacar(Personagem alvo) {
        if(!podeAtacar(alvo)) {
            System.out.println(getNome() +" nao pode atacar");
            return;
        }
        if(!temMana(1)) {
            System.out.println(getNome() +" nao tem mais mana!");
            return;
        }
        System.out.println(getNome() +" atacou " +alvo.getNome() +" usando seus conhecimentos magicos, causou " +getDanoMagico() +" de dano magico!");
        alvo.receberDano(getDanoMagico());
        mana --;
    }
    protected void ataqueEspecial(Personagem alvo) {
        if(!podeAtacar(alvo)) {
            System.out.println(getNome() +" nao pode usar seu ataque especial!");
            return;
        }if(!temMana(2)) {
            System.out.println(getNome() +" nao tem mana suficiente para seu ataque especial!");
            return;
        }
        int danoEspecial = getDanoMagico() + 7;
        System.out.println(getNome() +" usou sua bola de fogo em " +alvo.getNome() +", e causou " +danoEspecial +" de dano!");
        alvo.receberDano(danoEspecial);
        mana -= 2;
    }

}


static class Arqueiro extends Personagem {
    private int flechas;
    private int danoFlechada = 4;

    Arqueiro(String nome, int vida, int flechas) {
        super(nome, vida);
        setFlechas(flechas);
    }
    public void mostrarStatus(){
        super.mostrarStatus();
        System.out.println("Flechas: " +getFlechas());
    }

    /// SET/GET ///

    private void setFlechas(int flechas) {
        if(valorValido(flechas)) {
            this.flechas = flechas;
        }
    }
    public int getFlechas() {
        return flechas;
    }
    public int getDanoFlechada() {return danoFlechada;}

    /// SET/GET ///

    boolean temFlechas(int flechasNecessarias) {
        return getFlechas() >= flechasNecessarias;
    }

    protected void atacar(Personagem alvo) {
        if(!podeAtacar(alvo)) {
            System.out.println(getNome() +" nao pode atacar");
            return;
        }
        if(!temFlechas(1)) {
            System.out.println(getNome() +" nao tem mais flechas!");
            return;
        }
        System.out.println(getNome() +" atacou " +alvo.getNome() +" com uma flechada, causando " +danoFlechada +" de dano pela flechada");
        alvo.receberDano(danoFlechada);
        flechas --;
    }
    protected void ataqueEspecial(Personagem alvo) {
        if(!podeAtacar(alvo)) {
            System.out.println(getNome() +" nao pode usar seu ataque especial!");
            return;
        }if(!temFlechas(3)) {
            System.out.println(getNome() +" nao tem flechas suficiente para seu ataque especial!");
            return;
        }
        int danoEspecial = getDanoFlechada() * 3;
        System.out.println(getNome() +" usou sua chuva de flechas em " +alvo.getNome() +", e causou " +danoEspecial +" de dano!");
        alvo.receberDano(danoEspecial);
        flechas -= 3;
    }

}
static void executarTurno(Personagem atacante, Personagem alvo, boolean usarHabilidade) {
    if(!atacante.podeAtacar(alvo)) {
        System.out.println(atacante.getNome() +" nao pode executar turno!");
        return;
    }
    if(usarHabilidade) {
        atacante.ataqueEspecial(alvo);
        return;
    }
    atacante.atacar(alvo);
}

public static void main(String[] args) {

    Guerreiro g = new Guerreiro("Bernardo", 25, 15);
    Mago m = new Mago("Leo", 10, 3);
    Arqueiro a = new Arqueiro("Duda", 35, 10);

    System.out.println(m.getVida());
    executarTurno(a, m, false);
    System.out.println(m.getVida());
    executarTurno(m, g, true);
    executarTurno(m, g, true);
    System.out.println(g.getVida());

    g.mostrarStatus();
    m.mostrarStatus();
    a.mostrarStatus();

}
