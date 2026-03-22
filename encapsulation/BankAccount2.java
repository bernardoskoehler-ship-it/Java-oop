public static class Conta {
        private String nome;
        private double saldo;
        private boolean contaAtiva;

        Conta(String nome, double saldo, boolean contaAtiva) {
            setNome(nome);
            setSaldo(saldo);
            setContaAtiva(contaAtiva);
        }

        void setNome(String nome) {
            if(nome != null && !nome.trim().isEmpty()) {
                this.nome = nome;
            }
        }
        String getNome() {
            return nome;
        }
        private void setSaldo(double saldo) {
            if(valorValido(saldo)) {
                this.saldo = saldo;
            }
        }
        double getSaldo() {
            return saldo;
        }
        private void setContaAtiva(boolean contaAtiva) {
            this.contaAtiva = contaAtiva;
        }
        boolean getContaAtiva() {
            return contaAtiva;
        }

        boolean valorValido(double valor) {
            return valor > 0;
        }
        boolean temSaldo(double valor) {
            return saldo >= valor;
        }
        private void realizarSaque(double valor) {
            saldo -= valor;
        }
        private void realizarDeposito(double valor) {
            saldo += valor;
        }
        private void realizarTransferencia(Conta destino, double valor) {
            realizarSaque(valor);
            destino.realizarDeposito(valor);
        }


        void sacar(double valor) {
            if (!getContaAtiva()) {
                System.out.println("Conta bloqueada");
                return;
            }
            if (!valorValido(valor)) {
                System.out.println("Valor invalido");
                return;
            }
            if (!temSaldo(valor)) {
                System.out.println("Saldo insuficiente");
                return;
            }
            realizarSaque(valor);
            System.out.println("Saque realizado");
        }

        void depositar(double valor) {
            if (!getContaAtiva()) {
                System.out.println("Conta bloqueada");
                return;
            }
            if(!valorValido(valor)) {
                System.out.println("Valor invalido");
                return;
            }
                realizarDeposito(valor);
                System.out.println("Deposito realizado");
            }

        void transferir(Conta destino, double valor) {
            if (!getContaAtiva()) {
                System.out.println("Conta bloqueada");
                return;
            }
            if (destino == this) {
                System.out.println("Nao pode transferir para si mesmo");
                return;
            }
            if (!valorValido(valor)) {
                System.out.println("Valor invalido");
                return;
            }
            if (!temSaldo(valor)) {
                System.out.println("Saldo insuficiente");
                return;
            }
            realizarTransferencia(destino, valor);
            System.out.println("Transferencia realizada");
            }
