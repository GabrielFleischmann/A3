import java.util.Scanner;


public class Turno{

   public int contador = 0;
   private Jogador jogadorDaVez;
   private Jogador adversario;

   public Jogador getJogadorDaVez() {
       return jogadorDaVez;
   }

   public Jogador getAdversario() {
       return adversario;
   }

   public void novaJogada(Jogador jogador1, Jogador jogador2, int[][] tabuleiro, Turno inicial){
    
        jogadorDaVez = jogador1;
        adversario = jogador2;
      
        //PROCESSO DE CHECAGEM E VALIDAÇÃO DO TABULEIRO A CADA TURNO
        Tabuleiro tab = new Tabuleiro(tabuleiro, inicial);
        tab.validaTab();

        //INÍCIO DO TURNO
        System.out.println("\n(Digitar -1 nas coordenadas sempre salva o jogo e retorna ao menu principal)");
        tab.imprimeTab();
        System.out.printf("%s\n%s\n", jogadorDaVez, adversario);

        Scanner numeros = new Scanner(System.in);
        Scanner strings = new Scanner(System.in);
        
        int voltar = 0;
        int x;
        int y;

        do{
            System.out.printf("\nTurno de: %s", jogadorDaVez.getNome());
            System.out.print("\nDigite o número da linha da sua Esfera:");
            x = numeros.nextInt();


            if(x == -1){

                Menu menu = new Menu();
                menu.salvarJogo();
                menu.executaMenu();
            }

            System.out.print("Digite o número da coluna da sua Esfera:");
            y = numeros.nextInt();

            if(y == -1){

                Menu menu = new Menu();
                menu.salvarJogo();
                menu.executaMenu();
            }

            if (x > 8| x <= 0 | y > 8 | y <=0){
                System.out.println("Elemento Inválido");
                novaJogada(jogador1, jogador2, tabuleiro, inicial);

            } else{
                System.out.printf("O símbolo que você escolheu é %s. L: %d, C: %d, correto?\n1 - Sim / 2 - Não\n", new Esferas(tabuleiro[x-1][y-1]), x, y);
                voltar = numeros.nextInt();
            }
        }while(voltar == 2);

        System.out.print("Digite uma das opções mover a esfera:\nw - Para cima\ns - Para baixo\na - esquerda\nd - direita\n");
        char direcao = strings.nextLine().toUpperCase().charAt(0);

        if(direcao == 'W'){
            tabuleiro[x-2][y-1] = tabuleiro[x-1][y-1];
            tab.checaEsferas();
            
        }else if(direcao == 'S'){
            tabuleiro[x][y-1] = tabuleiro[x-1][y-1];
            tab.checaEsferas();
            
        }else if(direcao == 'A'){
            tabuleiro[x-1][y-2] = tabuleiro[x-1][y-1];
            tab.checaEsferas();
            
        }else if(direcao == 'D'){
            tabuleiro[x-1][y] = tabuleiro[x-1][y-1];
            tab.checaEsferas();
        }
    }
}
