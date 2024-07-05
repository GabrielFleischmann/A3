import java.io.Serializable;
import java.util.Scanner;

public class Turno implements Serializable{

   private Jogador jogadorDaVez;
   private Jogador adversario;
   private boolean formaCombo;

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

    public boolean getFormaCombo(){
        return formaCombo;
    }
    
    public void setFormaCombo(boolean formaCombo){
        this.formaCombo = formaCombo;
    }
  
    public void novaJogada(Jogador jogador1, Jogador jogador2, int[][] tabuleiro, Turno inicial){
    
        jogadorDaVez = jogador1;
        adversario = jogador2;
    
    
        //INÍCIO DO TURNO
        Tabuleiro tab = new Tabuleiro(tabuleiro, inicial);
        System.out.println("\n(Digitar 0 nas coordenadas sempre retorna ao menu principal e salva o jogo)");
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
            x = numeros.nextInt() - 1;

            if(x == -1){ 
                Saves.salvarJogo(jogador1, jogador2, tabuleiro, inicial);
                Menu.executaMenu();
            }

            System.out.print("Digite o número da coluna da sua Esfera:");
            y = numeros.nextInt() - 1;

            if(y == -1){
                Saves.salvarJogo(jogador1, jogador2, tabuleiro, inicial);
                Menu.executaMenu();
            }

            if (x > 8| x < 0 | y > 8 | y <0){
                System.out.println(Terminal.ALERTA + "---Elemento Inválido---" + Terminal.RESET);
                novaJogada(jogador1, jogador2, tabuleiro, inicial);

            } else{
                System.out.printf("O símbolo que você escolheu é %s. L: %d, C: %d, correto?\n1 - Sim / 2 - Não\n", new Esferas(tabuleiro[x][y]), x+1, y+1);
                voltar = numeros.nextInt();
            }
        }while(voltar == 2);

        //PERGUNTA PARA ONDE MOVER A PEÇA/GERA LOOPING SE O OPÇÃO NÃO FOR VÁLIDA
        char direcao;
       
        System.out.print("Digite uma das opções mover a esfera:\nw - Para cima\ns - Para baixo\na - esquerda\nd - direita\n");
        direcao = strings.nextLine().toLowerCase().charAt(0);

        int elemento;
        switch (direcao) {

            case 'w':
                if(x-1 < 0){
                    System.out.println(Terminal.ALERTA + "\n---Jogada Inválida. Tente Novamente---" + Terminal.RESET);
                    novaJogada(getJogadorDaVez(), getAdversario(), tabuleiro, inicial);
                }else{
                    elemento = tabuleiro[x-1][y];
                    tabuleiro[x-1][y] = tabuleiro[x][y];
                    tabuleiro [x][y] = elemento;
                    formaCombo(tabuleiro);

                    if(getFormaCombo() == true){
                        setFormaCombo(false);
                        tab.checaEsferas();
                    }else {
                        elemento = tabuleiro[x-1][y];
                        tabuleiro[x-1][y] = tabuleiro[x][y];
                        tabuleiro [x][y] = elemento;

                        System.out.println(Terminal.ALERTA + "\n---Jogada Inválida. Tente Novamente---" + Terminal.RESET);
                        novaJogada(getJogadorDaVez(), getAdversario(), tabuleiro, inicial);
                    }
                }

            break;
                
            case 's':
                if(x+1 > 7){
                    System.out.println(Terminal.ALERTA + "\n---Jogada Inválida. Tente Novamente---" + Terminal.RESET);
                    novaJogada(getJogadorDaVez(), getAdversario(), tabuleiro, inicial);
                }else{
                    elemento = tabuleiro[x+1][y];
                    tabuleiro[x+1][y] = tabuleiro[x][y];
                    tabuleiro [x][y] = elemento;
                    formaCombo(tabuleiro);

                    if(getFormaCombo() == true){
                        setFormaCombo(false);
                        tab.checaEsferas();
                    }else {
                        elemento = tabuleiro[x+1][y];
                        tabuleiro[x+1][y] = tabuleiro[x][y];
                        tabuleiro [x][y] = elemento;

                        System.out.println(Terminal.ALERTA + "\n---Jogada Inválida. Tente Novamente---" + Terminal.RESET);
                        novaJogada(getJogadorDaVez(), getAdversario(), tabuleiro, inicial);
                    }
                }
                
            break;
                
            case 'a':
                if(y-1 < 0){
                    System.out.println(Terminal.ALERTA + "\n---Jogada Inválida. Tente Novamente---" + Terminal.RESET);
                    novaJogada(getJogadorDaVez(), getAdversario(), tabuleiro, inicial);
                }else{
                    elemento = tabuleiro[x][y-1];
                    tabuleiro[x][y-1] = tabuleiro[x][y];
                    tabuleiro [x][y] = elemento;
                    formaCombo(tabuleiro);

                    if(getFormaCombo() == true){
                        setFormaCombo(false);
                        tab.checaEsferas();
                    }else {
                        elemento = tabuleiro[x][y-1];
                        tabuleiro[x][y-1] = tabuleiro[x][y];
                        tabuleiro [x][y] = elemento;

                        System.out.println(Terminal.ALERTA + "\n---Jogada Inválida. Tente Novamente---" + Terminal.RESET);
                        novaJogada(getJogadorDaVez(), getAdversario(), tabuleiro, inicial);
                    }
                }

            break;
                
            case 'd':
                if(y+1 > 7){
                    System.out.println(Terminal.ALERTA + "\n---Jogada Inválida. Tente Novamente---" + Terminal.RESET);
                    novaJogada(getJogadorDaVez(), getAdversario(), tabuleiro, inicial);
                }else{
                    elemento = tabuleiro[x][y+1];
                    tabuleiro[x][y+1] = tabuleiro[x][y];
                    tabuleiro [x][y] = elemento;
                    formaCombo(tabuleiro);

                    if(getFormaCombo() == true){
                        setFormaCombo(false);
                        tab.checaEsferas();
                    }else {
                        elemento = tabuleiro[x][y+1];
                        tabuleiro[x][y+1] = tabuleiro[x][y];
                        tabuleiro [x][y] = elemento;

                        System.out.println(Terminal.ALERTA + "\n---Jogada Inválida. Tente Novamente---" + Terminal.RESET);
                        novaJogada(getJogadorDaVez(), getAdversario(), tabuleiro, inicial);
                    }
                }

            break;
        }

        numeros.close();
        strings.close();
    }

    public void formaCombo(int[][] tab){
        //HORIZONTAL
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length-2; j++) {
                if((tab[i][j] == tab[i][j+1]) && (tab[i][j+1] == tab[i][j+2])){
                    setFormaCombo(true);
                }
            }
        }

        //VERTICAL
        for (int i = 0; i < tab[i].length-2; i++) {
            for (int j = 0; j < tab[i].length; j++) {        
                if((tab[i][j] == tab[i+1][j]) && (tab[i+1][j] == tab[i+2][j])){
                    setFormaCombo(true); 
                }
            }  
        }
    }

    
    public void salvarJogo(Jogador jogador1, Jogador jogador2, int[][] tabuleiro){



    } 


}