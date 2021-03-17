package ac02;

import java.util.Scanner;

public class Bankapp {

    public static Scanner entrada;

    public static void mostrarInfo(BankAccount[] contas) {
        System.out.println("\nContas de todos os clientes:");
        for (int i = 0; i < contas.length; i++) {
            System.out.println("[" + i + "] " + contas[i].toString());
        }
        System.out.println();
    }


    public static void interacaoSacar(BankAccount[] contas) {
        boolean clienteValido = false;
        int indiceConta = -1;
        while (!clienteValido) {
            mostrarInfo(contas);
            System.out.print("O saque será efetuado na conta de qual cliente? (0 a "
                    + (contas.length - 1) + "): ");
            indiceConta = entrada.nextInt();
            if (indiceConta >= 0 && indiceConta < contas.length) {
                clienteValido = true;
            } else {
                System.out.println("Índice de cliente inválido!");
            }
        }

        System.out.print("Qual o valor do saque? ");
        double saque = entrada.nextDouble();
        contas[indiceConta].withDraw(saque);
        System.out.println("Saque finalizado.\n");
    }


    // AC02 - IMPACTA - POO - 16/03/21

    //1:

    public static void interacaoDepositar(BankAccount[] contas) {
        boolean clienteValido = false;
        int indiceConta = -1;
        while (!clienteValido) {
            mostrarInfo(contas);
            System.out.print("O deposito será efetuado na conta de qual cliente? (0 a "
                    + (contas.length - 1) + "): ");
            indiceConta = entrada.nextInt();
            if (indiceConta >= 0 && indiceConta < contas.length) {
                clienteValido = true;
            } else {
                System.out.println("Índice de cliente inválido!");
            }
        }

        System.out.print("Qual o valor do deposito? ");
        double deposito = entrada.nextDouble();
        contas[indiceConta].deposit(deposito);
        System.out.println("Deposito finalizado.\n");
    }

    //3:
    public static void interacaoTransferir(BankAccount[] contas) {
        boolean clienteValido = false;
        int indiceConta = -1;
        int target = -1;
        while (!clienteValido) {
            mostrarInfo(contas);
            System.out.print("A transferencia será feita a partir de qual conta? (0 a "
                    + (contas.length - 1) + "): ");
            indiceConta = entrada.nextInt();

            System.out.print("A transferencia será feita  para qual conta? (0 a "
                    + (contas.length - 1) + "): ");
            target = entrada.nextInt();
            if ((indiceConta >= 0 && indiceConta < contas.length) && (target >= 0 && target < contas.length) && (target != indiceConta)) {
                clienteValido = true;
            } else {
                System.out.println("Índice de algum dos clientes inválido!");
            }
        }

        System.out.print("Qual o valor da transferencia? ");
        double valortransf = entrada.nextDouble();
        contas[indiceConta].transfer(valortransf, contas[target]);
        System.out.println("transferencia finalizada.\n");
    }


    public static void main(String[] args) {
        BankAccount[] contas = new BankAccount[5];
        contas[0] = new BankAccount("Marcos", 1000.00);
        contas[1] = new BankAccount("Júlia", 250.00);
        contas[2] = new BankAccount("João", 2500.00);
        contas[3] = new BankAccount("Roberto", 3000.00);
        contas[4] = new BankAccount("Janaína", 4500.00);

        entrada = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {
            System.out.println("Escolha uma operação:");
            System.out.println("(1) mostrar informações de todas as contas");
            System.out.println("(2) sacar");
            System.out.println("(3) depositar");
            System.out.println("(4) Transferir");
            System.out.println("(0) sair");
            System.out.print("Opção escolhida: ");

            int escolha = entrada.nextInt();
            System.out.println();
            switch (escolha) {
                case 1:
                    mostrarInfo(contas);
                    break;
                case 2:
                    interacaoSacar(contas);
                    break;
                case 3:
                    interacaoDepositar(contas);
                    break;
                case 4:
                    interacaoTransferir(contas);
                    break;
                case 0:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
            System.out.println();
        }
        System.out.println("Fim do programa!");
    }
}
