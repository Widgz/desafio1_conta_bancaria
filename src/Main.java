import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);

        double balance = 2500;

        String telaInicial = """
                **********************************************
                Dados iniciais do cliente:
                
                Nome: Paulo Estrela
                Tipo de conta: Corrente
                Saldo inicial: R$ %.2f
                **********************************************
                """.formatted(balance);

        String opcoes = """
                
                Operações
                
                1- Consultar saldo
                2- Receber valor
                3- Transferir valor
                4- Sair
                
                Digite a opção desejada:
                """;

        System.out.println(telaInicial);
        while (true) {
            System.out.println(opcoes);
            int opcao = inputReader.nextInt();

            if (opcao == 4) {
                break;
            }

            if (opcao == 1) {
                System.out.println("O saldo atual é R$ " + String.format("%.2f", balance));
            }

            if (opcao == 2) {
                System.out.println("Informe o valor a receber: ");
                double recebido = inputReader.nextDouble();

                if (recebido > 0) {
                    balance +=recebido;
                    System.out.println("Saldo atualizado R$ " + String.format("%.2f", balance));
                } else {
                    System.out.println("Valor inválido");
                }
            }

            if (opcao == 3) {
                System.out.println("Informe o valor a ser transferido: ");
                double transferido = inputReader.nextDouble();

                if (transferido > balance) {
                    System.out.println("Não há saldo suficiente para realizar esta transferência.");
                }

                if (transferido <= balance && transferido > 0) {
                    balance -=transferido;
                    System.out.println("Saldo atualizado R$ " + String.format("%.2f", balance));
                }

                if(transferido < 0) {
                    System.out.println("Valor inválido");
                }
            }

            if (opcao > 4) {
                System.out.println("Opção inválida");
            }
        }
    }
}
