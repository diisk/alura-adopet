package br.com.alura;

import br.com.alura.service.CadastrarAbrigoCommand;
import br.com.alura.service.Command;
import br.com.alura.service.CommandExecutor;
import br.com.alura.service.ImportarPetsAbrigoCommand;
import br.com.alura.service.ListarAbrigoCommand;
import br.com.alura.service.ListarPetsAbrigoCommand;

import java.util.Scanner;

public class AdopetConsoleApplication {

    public static void main(String[] args) {
        CommandExecutor executor = new CommandExecutor();
        Scanner scanner = new Scanner(System.in);
        System.out.println("##### BOAS VINDAS AO SISTEMA ADOPET CONSOLE #####");
        try {
            int opcaoEscolhida = 0;
            while (opcaoEscolhida != 5) {
                exibirMenu();

                String textoDigitado = scanner.nextLine();
                opcaoEscolhida = Integer.parseInt(textoDigitado);

                try {
                    Command command = getCommandInstance(opcaoEscolhida);
                    if (command == null) break;
                    executor.executeCommand(command);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
            scanner.close();
            System.out.println("Finalizando o programa...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void exibirMenu() {
        System.out.println("\nDIGITE O NÚMERO DA OPERAÇÃO DESEJADA:");
        System.out.println("1 -> Listar abrigos cadastrados");
        System.out.println("2 -> Cadastrar novo abrigo");
        System.out.println("3 -> Listar pets do abrigo");
        System.out.println("4 -> Importar pets do abrigo");
        System.out.println("5 -> Sair");
    }

    private static Command getCommandInstance(int option) throws Exception {
        return switch (option) {
            case 1 -> new ListarAbrigoCommand();
            case 2 -> new CadastrarAbrigoCommand();
            case 3 -> new ListarPetsAbrigoCommand();
            case 4 -> new ImportarPetsAbrigoCommand();
            case 5 -> null;
            default -> throw new Exception("NÚMERO INVÁLIDO!");
        };
    }

}
