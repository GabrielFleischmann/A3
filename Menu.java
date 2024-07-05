import java.io.File;
import java.util.Scanner;

public class Menu {

    public static void executaMenu() {

        Scanner numeros = new Scanner(System.in);
        Scanner strings = new Scanner(System.in);

        System.out.println("Bem-Vindo ao Puzzle Quest 5!");
        System.out.println("Por favor, escolha uma das opções abaixo:");
        System.out.print("1 - Iniciar Novo Jogo\n2 - Carregar Jogo\n3 - Apagar um jogo existente\n0 - Sair\n");

        int opcao = numeros.nextInt();

        switch (opcao) {
            //NOVO JOGO
            case 1:
                //GERA DIRETÓRIO PARA ARMAZENAR SAVES
                boolean pastaJogosSalvos = new File(System.getProperty("user.dir") + File.separator + "/Saves").mkdir();

                //CRIAÇÃO DOS ELEMENTOS PRINCIPAIS DO JOGO
                System.out.print("Digite o nome do Jogador 1: ");
                Jogador jogador1 = new Jogador(strings.nextLine().toUpperCase());
        
                System.out.print("Digite o nome do Jogador 2: ");
                Jogador jogador2 = new Jogador(strings.nextLine().toUpperCase());
        
                Turno inicial = new Turno();
                Tabuleiro tab = new Tabuleiro(inicial);
                tab.geraTab();
                inicial.novaJogada(jogador1, jogador2, tab.getTabuleiro(), inicial);
                
                break;
                
            //CARREGANDO JOGO
            case 2:
                Saves.carregarJogo();
                break;

            //DELETANDO JOGO EXISTENTE
            case 3:
                Saves.deletarJogo();
                break;

            case 0:
                break;
        }

        numeros.close();
        strings.close();
    }
}