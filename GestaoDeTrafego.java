import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class GestaoDeTrafego {

    public static void main(String[] args) {
        // Início do programa e captura do tempo
        LocalDateTime inicio = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        Scanner scanner = new Scanner(System.in);

        // ruas
        String[] ruas = {"Rua A", "Rua B", "Rua C"};
        String[] sinais = {"VERDE", "VERMELHO", "AMARELO"}; // Estado dos sinais
        boolean[] interditadas = {false, false, false}; // Status de interdição

        // Menu interativo
        boolean executando = true;
        while (executando) {
            System.out.println("\n======= GESTÃO DE TRÁFEGO =======");
            for (int i = 0; i < ruas.length; i++) {
                System.out.printf("%d. %s - Sinal: %s - %s\n", 
                    i + 1, 
                    ruas[i], 
                    sinais[i], 
                    interditadas[i] ? "INTERDITADA" : "TRÂNSITO OK");
            }
            System.out.println("4. Atualizar status de uma rua");
            System.out.println("5. Gerar relatório e sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1, 2, 3:
                    int index = opcao - 1;
                    System.out.println("\n-- Informações da " + ruas[index] + " --");
                    System.out.println("Sinal: " + sinais[index]);
                    System.out.println("Status: " + (interditadas[index] ? "INTERDITADA" : "TRÂNSITO OK"));
                    break;

                case 4:
                    System.out.println("\nEscolha a rua para atualizar (1-3): ");
                    int ruaIndex = scanner.nextInt() - 1;
                    if (ruaIndex >= 0 && ruaIndex < ruas.length) {
                        System.out.println("Atualizar sinal (VERDE/AMARELO/VERMELHO): ");
                        sinais[ruaIndex] = scanner.next().toUpperCase();
                        System.out.println("Está interditada? (true/false): ");
                        interditadas[ruaIndex] = scanner.nextBoolean();
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 5:
                    executando = false;
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }

        // Geração do relatório
        LocalDateTime fim = LocalDateTime.now();
        System.out.println("\n======= RELATÓRIO FINAL =======");
        System.out.println("Tempo de execução: " + java.time.Duration.between(inicio, fim).toSeconds() + " segundos");
        System.out.println("Status das ruas:");
        for (int i = 0; i < ruas.length; i++) {
            System.out.printf("%s - Sinal: %s - %s\n", 
                ruas[i], 
                sinais[i], 
                interditadas[i] ? "INTERDITADA" : "TRÂNSITO OK");
        }
        System.out.println("================================");

        scanner.close();
    }
}
