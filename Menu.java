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
                //GERA DIRETÓRIO PARA ARMAZENAR SAVES E O PRÓPRIO SAVE USANDO AS PERMISSOES DO USUARIO  
                boolean pastaJogosSalvos = new File(System.getProperty("user.dir") + File.separator + "/Saves").mkdir();
                
                System.out.print("Digite o nome do jogador 1: ");
                Jogador jogador1 = new Jogador(strings.nextLine().toUpperCase());

                System.out.print("Digite o nome do jogador 2: ");
                Jogador jogador2 = new Jogador(strings.nextLine().toUpperCase());

                //DANDO INÍCIO AO JOGO
                Turno inicial = new Turno();
                Tabuleiro tab = new Tabuleiro(inicial);
                tab.geraTab();
                inicial.novaJogada(jogador1, jogador2, tab.getTabuleiro(), inicial);

                break;
                
            //CARREGANDO JOGO
            case 2:
                System.out.println("Selecione um jogo salvo para carregar:");
                mostrarSaves();
                int carregarSave = numeros.nextInt();
                break;

            //DELETANDO JOGO EXISTENTE
            case 3:
                deletarJogo();
                executaMenu();
                break;

            case 0:
                break;
        }

        numeros.close();
        strings.close();
    }

    public static void mostrarSaves(){
        File diretorio = new File("Saves\\");
        File[] arquivos = diretorio.listFiles();

        for (int i = 0; i < arquivos.length; i++) {
            System.out.printf("%s", arquivos[i].getName());
            System.out.println();
        }
    }

    public static void deletarJogo(){
        File diretorio = new File("Saves\\");
        File[] arquivos = diretorio.listFiles();

        if(arquivos.length > 0) {
            Scanner strings = new Scanner(System.in);

            System.out.println("Digite o nome completo do save que deseja apagar:");
            mostrarSaves();

            File save = new File("Saves\\" + strings.nextLine().toUpperCase());

            if (save.delete()) {
                System.out.println("O save foi deletado");
            } else {
                System.out.println("Erro ao deletar save! Tente novamente");
            }

            strings.close();
        }else{
            System.out.println("--- Não há saves para deletar ---");
        }
    }
}