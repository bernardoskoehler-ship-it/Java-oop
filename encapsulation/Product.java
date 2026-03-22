public static class Produto {
    private String nome;
    private double preco;
    private int estoque;

    Produto(String nome, double preco, int estoque) {
        setNome(nome);
        setPreco(preco);

        if(estoque > 0) {
            this.estoque = estoque;
        }else {
            System.out.println("Valor de estoque invalido");
        }
    }

    public void setNome(String nome) {
        if (nome != null && !nome.trim().isEmpty()) {
            this.nome = nome;
        } else {
            System.out.println("Nome invalido");
        }
    }
    public void setPreco(double preco) {
        if(preco > 0) {
            this.preco = preco;
        }else {
            System.out.println("Numero de preco invalido");
        }
    }
    public String getNome() {
        return nome;
    }
    public double getPreco() {
        return preco;
    }
    public int getEstoque () {
        return estoque;
    }

    public void adicionarEstoque(int valor) {
        if(valor > 0) {
            estoque += valor;
            System.out.println(valor +" adicionado ao estoque");
        }else{
            System.out.println("Valor de adicao ao estoque invalido");
        }
    }
    public void removerEstoque(int valor) {
        if(valor <= 0) {
            System.out.println("Valor de remocao do estoque invalido");
        }else {
            if(valor <= estoque) {
                estoque -= valor;
                System.out.println(valor +" foi removido do estoque");
            }else if(valor > estoque) {
                System.out.println("Nao tem estoque o suficiente");
            }
        }
    }
    public void mostrarEstoque() {
        System.out.println("Nome: " +nome +" | Preço: " +preco + " | Estoque: " +estoque);
    }

}
public static void main(String[] args) {
    Produto p = new Produto("Laranja", 10.50, 20);

    p.mostrarEstoque();
    System.out.println(p.getEstoque());
    p.removerEstoque(21);
    p.removerEstoque(-1);
    p.removerEstoque(1);
    System.out.println(p.getEstoque());
    p.adicionarEstoque(2);
    p.adicionarEstoque(-1);
    p.mostrarEstoque();
}
