static class Personagem {
     String nome;
     int vida;

    Personagem(String nome, int vida) {
        this.nome = nome;
        this.vida = vida;
    }
    void atacar() {
        if(vida > 0) {
            System.out.println(nome +" atacou!");
        }else {
            System.out.println(nome +"esta morto e nao pode atacar!");
        }
    }
}
static class Guerreiro extends Personagem {
    int forca;

    Guerreiro(String nome, int vida, int forca) {
        super(nome, vida);
        this.forca = forca;
    }

    void atacar() {
        if(vida > 0) {
            System.out.println(nome +" atacou com " +forca +" de forca!");
        }else {
            System.out.println(nome +"esta morto e nao pode atacar!");
        }
    }
}
public static void main(String[] args) {
    Guerreiro g = new Guerreiro("Arthur", 100, 50);
    g.atacar();
}
