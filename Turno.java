import java.util.Scanner;

public class Turno{

   private Jogador jogadorDaVez;
   private Jogador adversario;

   public Jogador getJogadorDaVez() {
       return jogadorDaVez;
   }

   public Jogador getAdversario() {
       return adversario;
   }

    public void setJogadorDaVez(Jogador jogadorDaVez) {
        this.jogadorDaVez = jogadorDaVez;
    }

    public void setAdversario(Jogador adversario) {
        this.adversario = adversario;
    }

    int x;
    int y;

    public void novaJogada(Jogador jogador1, Jogador jogador2, int[][] tabuleiro, Turno inicial){
    
        jogadorDaVez = jogador1;
        adversario = jogador2;

        //INÍCIO DO TURNO
        Tabuleiro tab = new Tabuleiro(tabuleiro, inicial);
        System.out.println("\n(Digitar 0 nas coordenadas sempre salva o jogo e retorna ao menu principal)");
        tab.imprimeTab();
        System.out.printf("%s\n%s\n", jogadorDaVez, adversario);

        Scanner numeros = new Scanner(System.in);
        Scanner strings = new Scanner(System.in);
        
        int voltar = 0;
        

        do{
            System.out.printf("\nTurno de: %s", jogadorDaVez.getNome());
            System.out.print("\nDigite o número da linha da sua Esfera:");
            x = numeros.nextInt() - 1;


            if(x == -1){

                Menu menu = new Menu();
                menu.salvarJogo();
                menu.executaMenu();
            }

            System.out.print("Digite o número da coluna da sua Esfera:");
            y = numeros.nextInt() - 1;

            if(y == -1){

                Menu menu = new Menu();
                menu.salvarJogo();
                menu.executaMenu();
            }

            if (x > 8| x < 0 | y > 8 | y <0){
                System.out.println("Elemento Inválido");
                novaJogada(jogador1, jogador2, tabuleiro, inicial);

            } else{
                System.out.printf("O símbolo que você escolheu é %s. L: %d, C: %d, correto?\n1 - Sim / 2 - Não\n", new Esferas(tabuleiro[x][y]), x+1, y+1);
                voltar = numeros.nextInt();
            }
        }while(voltar == 2);

        System.out.print("Digite uma das opções mover a esfera:\nw - Para cima\ns - Para baixo\na - esquerda\nd - direita\n");
        char direcao = strings.nextLine().toLowerCase().charAt(0);

        int elemento;

        switch (direcao) {

            case 'w':
                elemento = tabuleiro[x-1][y];
                tabuleiro[x-1][y] = tabuleiro[x][y];
                tabuleiro [x][y] = elemento;
                tab.checaEsferas();

            break;
                
            case 's':
                elemento = tabuleiro[x+1][y];
                tabuleiro[x+1][y] = tabuleiro[x][y];
                tabuleiro [x][y] = elemento;
                tab.checaEsferas();
               
            break;
                
            case 'a':
                elemento = tabuleiro[x][y-1];
                tabuleiro[x][y-1] = tabuleiro[x][y];
                tabuleiro [x][y] = elemento;
                tab.checaEsferas();

            break;
                
            case 'd':
                elemento = tabuleiro[x][y+1];
                tabuleiro[x][y+1] = tabuleiro[x][y];
                tabuleiro [x][y] = elemento;
                tab.checaEsferas();

            break;
        }
    }





}