public abstract class Conta implements OperacoesConta {
    private static final int AGENCIA_PADRAO = 1;
    private static int sequencial = 1;

    private final int agencia;
    private final int numero;
    private double saldo;
    private final Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = sequencial++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        if (valor <= 0 || valor > saldo) {
            throw new IllegalArgumentException("Valor inválido para saque");
        }
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido para depósito");
        }
        saldo += valor;
    }

    @Override
    public void transferir(double valor, OperacoesConta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void imprimirInformacoes() {
        System.out.printf("Titular: %s%n", this.cliente.getNome());
        System.out.printf("Agência: %s%n", this.agencia);
        System.out.printf("Número: %s%n", this.numero);
        System.out.printf("Saldo: R$ %.2f%n", this.saldo);
    }
}