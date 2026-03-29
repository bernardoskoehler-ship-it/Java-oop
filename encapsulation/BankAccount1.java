public static class Conta {
    private String titular;
    private double saldo;

    Conta(String titular, double saldoInicial) {
        setTitular(titular);

        if (saldoInicial >= 0) {
            this.saldo = saldoInicial;
        } else {
            System.out.println("Saldo inicial inválido!");
        }
    }

    public void setTitular(String titular) {
        if (titular != null && !titular.trim().isEmpty()) {
            this.titular = titular;
        } else {
            System.out.println("Titular inválido!");
        }
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println(titular + " depositou " + valor);
        } else {
            System.out.println("Valor de depósito inválido!");
        }
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de saque inválido!");
        } else if (valor > saldo) {
            System.out.println("Saldo insuficiente!");
        } else {
            saldo -= valor;
            System.out.println(titular + " sacou " + valor);
        }
    }
}
public static void main(String[] args) {
    Conta conta = new Conta("Bernardo", 201);
    conta.depositar(1);
    conta.sacar(200);
    System.out.println(conta.getSaldo());
}
