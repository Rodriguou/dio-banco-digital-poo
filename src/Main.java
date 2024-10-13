public class Main {
    public static void main(String[] args) {
        Cliente rodrigo = new Cliente();
        rodrigo.setNome("Rodrigo");

        Conta contaCorrente = new ContaCorrente(rodrigo);
        Conta contaPoupanca = new ContaPoupanca(rodrigo);

        contaCorrente.depositar(100);
        contaCorrente.transferir(100, contaPoupanca);

        contaCorrente.imprimirExtrato();
        contaPoupanca.imprimirExtrato();
    }
}
