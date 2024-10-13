public interface OperacoesConta {
    void sacar(double valor);
    void depositar(double valor);
    void transferir(double valor, OperacoesConta contaDestino);
    void imprimirExtrato();
}
