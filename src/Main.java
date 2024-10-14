public class Main {
    public static void main(String[] args) {
        try {
            Cliente rodrigo = new Cliente();
            rodrigo.setNome("Rodrigo");

            Cliente felipe = new Cliente();
            felipe.setNome("Felipe");

            Conta contaCorrenteRodrigo = new ContaCorrente(rodrigo);
            Conta contaPoupancaRodrigo = new ContaPoupanca(rodrigo);

            Conta contaCorrenteFelipe = new ContaCorrente(felipe);
            Conta contaPoupancaFelipe = new ContaPoupanca(felipe);

            Banco banco = new Banco();
            banco.setNome("Santander");
            banco.adicionarConta(contaCorrenteRodrigo);
            banco.adicionarConta(contaPoupancaRodrigo);
            banco.adicionarConta(contaCorrenteFelipe);
            banco.adicionarConta(contaPoupancaFelipe);

            System.out.println("Depositando R$ 100,00 na Conta Corrente de Rodrigo...");
            contaCorrenteRodrigo.depositar(100);
            contaCorrenteRodrigo.imprimirExtrato();

            System.out.println("\nTransferindo R$ 50,00 da Conta Corrente de Rodrigo para a Conta Poupança de Rodrigo...");
            contaCorrenteRodrigo.transferir(50, contaPoupancaRodrigo);
            contaCorrenteRodrigo.imprimirExtrato();
            contaPoupancaRodrigo.imprimirExtrato();

            System.out.println("\nTransferindo R$ 30,00 da Conta Corrente de Rodrigo para a Conta Corrente de Felipe...");
            contaCorrenteRodrigo.transferir(30, contaCorrenteFelipe);
            contaCorrenteRodrigo.imprimirExtrato();
            contaCorrenteFelipe.imprimirExtrato();

            System.out.println("\nSacando R$ 20,00 da Conta Poupança de Felipe...");
            contaPoupancaFelipe.depositar(50);
            contaPoupancaFelipe.sacar(20);
            contaPoupancaFelipe.imprimirExtrato();

            System.out.println("\nContas no banco:");
            for (Conta conta : banco.getContas()) {
                conta.imprimirExtrato();
            }

            banco.removerConta(contaCorrenteRodrigo);
            System.out.println("\nContas no banco após remover a Conta Corrente de Rodrigo:");
            for (Conta conta : banco.getContas()) {
                conta.imprimirExtrato();
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
