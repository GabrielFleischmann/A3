import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Menu {

    Scanner numeros = new Scanner(System.in);
    Scanner strings = new Scanner(System.in);

    public void executaMenu() {
        System.out.println("Bem-Vindo ao Puzzle Quest 5!");
        System.out.println("Por favor, escolha uma das opções abaixo:");
        System.out.print("1 - Iniciar Novo Jogo\n2 - Carregar Jogo\n3 - Apagar um jogo existente\n0 - Sair\n");

        int opcao = numeros.nextInt();

        switch (opcao) {
            //NOVO JOGO
            case 1:
                //GERA DIRETÓRIO PARA ARMAZENAR SAVES E O PRÓPRIO SAVE USANDO AS PERMISSOES DO USUARIO  
                boolean pastaJogosSalvos = new File(System.getProperty("user.dir") + File.separator + "/Saves").mkdir();

                System.out.print("Digite o nome do novo jogo: ");
                try {
                    FileWriter geraSave = new FileWriter("Saves\\" + strings.nextLine().toUpperCase() + ".txt");
                } catch (IOException e) {
                    System.out.println("Falha ao gerar novo save");
                }

                System.out.print("Digite o nome do jogador 1: ");
                Jogador jogador1 = new Jogador(strings.nextLine().toUpperCase());

                System.out.print("Digite o nome do jogador 2: ");
                Jogador jogador2 = new Jogador(strings.nextLine().toUpperCase());

                //DANDO INÍCIO AO JOGO
                Turno inicial = new Turno();
                Tabuleiro tab = new Tabuleiro(inicial);
                inicial.novaJogada(jogador1, jogador2, tab.getTabuleiro(), inicial);
                
            break;




}