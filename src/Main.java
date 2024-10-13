public class Main {
    public static void main(String[] args) {
        Cliente rodrigo = new Cliente();
        rodrigo.setNome("Rodrigo");

        Conta cc = new ContaCorrente(rodrigo);
        cc.depositar(100);

        Conta cp = new ContaPoupanca(rodrigo);
        cc.transferir(100, cp);

        cc.imprimirExtrato();
        cp.imprimirExtrato();
    }
}
