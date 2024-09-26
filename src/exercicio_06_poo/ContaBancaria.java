package exercicio_06_poo;

import java.util.Scanner;

public class ContaBancaria {
    private double saldo;
    private int contadorConsultas;

    // Construtor
    public ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
        this.contadorConsultas = 0;
    }

    // Método para depósito (com taxa de 1%)
    public void depositar(double valor) {
        if (valor > 0) {
            double taxa = valor * 0.01;
            saldo += (valor - taxa);
            System.out.println("Depósito realizado com sucesso. Taxa de 1% aplicada.");
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    // Método para saque (com taxa de 0,5%)
    public void sacar(double valor) {
        double taxa = valor * 0.005;
        if (valor + taxa <= saldo && valor > 0) {
            saldo -= (valor + taxa);
            System.out.println("Saque realizado com sucesso. Taxa de 0,5% aplicada.");
        } else {
            System.out.println("Saldo insuficiente ou valor inválido para saque.");
        }
    }

    // Método para consulta de saldo (a cada 5 consultas, cobra 0,10 centavos)
    public void consultarSaldo() {
        contadorConsultas++;
        if (contadorConsultas % 5 == 0) {
            if (saldo >= 0.10) {
                saldo -= 0.10;
                System.out.println("Foi cobrada uma taxa de 0,10 centavos pela 5ª consulta.");
            } else {
                System.out.println("Saldo insuficiente para cobrar a taxa de consulta.");
            }
        }
        System.out.println("Seu saldo atual é: R$ " + String.format("%.2f", saldo));
    }

    // Método main para capturar as informações do usuário
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Captura do saldo inicial
        System.out.println("Insira o saldo inicial da conta:");
        double saldoInicial = scanner.nextDouble();

        ContaBancaria conta = new ContaBancaria(saldoInicial);

        boolean continuar = true;
        while (continuar) {
            // Menu de opções
            System.out.println("\nEscolha uma operação:");
            System.out.println("1. Depósito");
            System.out.println("2. Saque");
            System.out.println("3. Consultar Saldo");
            System.out.println("4. Sair");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    // Depósito
                    System.out.println("Insira o valor para depósito:");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 2:
                    // Saque
                    System.out.println("Insira o valor para saque:");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case 3:
                    // Consulta de saldo
                    conta.consultarSaldo();
                    break;
                case 4:
                    // Sair
                    continuar = false;
                    System.out.println("Encerrando o sistema.");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }

        scanner.close();
    }
}
