import java.util.Random;


public class Tabuleiro{


   private int[][] tabuleiro = new int[8][8];
   private final Random r1 = new Random();
   private final int possibilidades = 7;
   private Turno turnos;


   public Tabuleiro(Turno inicial){
       this.turnos = inicial;
   }


   public Tabuleiro(int[][] tab, Turno inicial){
       this.tabuleiro = tab;
       this.turnos = inicial;
   }


   public int[][] getTabuleiro(){
       return tabuleiro;
   }


   public void fazTab() {
       for (int i = 0; i < tabuleiro.length; i++) {
           for (int j = 0; j < tabuleiro[i].length; j++) {
               tabuleiro[i][j] = Math.abs(r1.nextInt()%possibilidades);
           }
       }
   }


   //IMPRIME O TABULEIRO
   public void imprimeTab(){
    System.out.println("    1   2   3   4   5   6   7   8");
    for (int i = 0; i < tabuleiro.length; i++) {
        System.out.printf("%d ", i+1);
        for (int j = 0; j < tabuleiro[i].length; j++) {
            System.out.printf(" %s ", new Esferas(tabuleiro[i][j]));
        }
        System.out.println();
    }
   }


   //VALIDA O TABULEIRO
   public void validaTab(){
       boolean esferasAlinhadas;
       boolean vazios;

       do{
           esferasAlinhadas = false;
           vazios = false;

           //PREENCHE OS VAZIOS
           for (int i = 0; i < tabuleiro.length; i++) {
               for (int j = 1; j < tabuleiro.length-1; j++) {
                   if(tabuleiro[i][j] == 7){
                       tabuleiro[i][j] = Math.abs(r1.nextInt()%possibilidades);
                       vazios = true;
                   }
               }
           }

           //CASO JÁ ESTEJA ESFERAS ALINHADAS NA HORIZONTAL
           for (int i = 0; i < tabuleiro.length; i++) {
               for (int j = 1; j < tabuleiro[i].length-1; j++) {
                   if(tabuleiro[i][j] == tabuleiro[i][j-1]&&tabuleiro[i][j]==tabuleiro[i][j+1]){
                       tabuleiro[i][j] = Math.abs(r1.nextInt()%possibilidades);
                       esferasAlinhadas = true;
                   }
               }
           }

           //CASO JÁ ESTEJA ESFERAS ALINHADAS NA VERTICAL
           for (int i = 1; i < tabuleiro.length-1; i++) {
               for (int j = 0; j < tabuleiro[i].length; j++) {
                   if(tabuleiro[i][j] == tabuleiro[i-1][j]&&tabuleiro[i][j]==tabuleiro[i+1][j]){
                       tabuleiro[i][j] = Math.abs(r1.nextInt()%possibilidades);
                       esferasAlinhadas = true;
                   }
               }  
           }
       }while (esferasAlinhadas|vazios);
   }

   //CHECA AS ESFERAS ALINHADAS E APLICA OS EFEITOS NOS JOGADORES
   public void checaEsferas(){

        int quantidadeDeEsferas = 0;
        int tipoDeEsfera = 0;

        for (int i = 2; i < tabuleiro.length-2; i++) {
            for (int j = 2; j < tabuleiro[i].length-2; j++) {

                //CHECA ESFERAS ALINHDAS NA HORIZONTAL, NA VERTICAL, Ls e Ts
                //CASO 5 ESFERAS
                if(tabuleiro[i][j-2] == tabuleiro[i][j-1] && tabuleiro[i][j-1] == tabuleiro[i][j] && tabuleiro[i][j] == tabuleiro[i][j+1] && tabuleiro[i][j+2] == tabuleiro[i][j+1]|
                tabuleiro[i-2][j] == tabuleiro[i-1][j] && tabuleiro[i-1][j] == tabuleiro[i][j] && tabuleiro[i][j] == tabuleiro[i+1][j] && tabuleiro[i+1][j] == tabuleiro[i+2][j]|
                tabuleiro[i-2][j] == tabuleiro[i-1][j] && tabuleiro[i-1][j] == tabuleiro[i][j] && tabuleiro[i][j] == tabuleiro[i][j+1] && tabuleiro[i][j+1] == tabuleiro[i][j+2] |
                tabuleiro[i-2][j] == tabuleiro[i-1][j] && tabuleiro[i-1][j] == tabuleiro[i][j] && tabuleiro[i][j] == tabuleiro[i][j-1] && tabuleiro[i][j-1] == tabuleiro[i][j-2] |
                tabuleiro[i+2][j] == tabuleiro[i+1][j] && tabuleiro[i+1][j] == tabuleiro[i][j] && tabuleiro[i][j] == tabuleiro[i][j+1] && tabuleiro[i][j+1] == tabuleiro[i][j+2] |
                tabuleiro[i+2][j] == tabuleiro[i+1][j] && tabuleiro[i+1][j] == tabuleiro[i][j] && tabuleiro[i][j] == tabuleiro[i][j-1] && tabuleiro[i][j-1] == tabuleiro[i][j-2] | 
                tabuleiro[i][j] == tabuleiro[i][j+1] && tabuleiro[i][j] == tabuleiro[i][j-1] && tabuleiro[i][j] == tabuleiro[i+1][j] && tabuleiro[i][j] == tabuleiro[i+2][j] | 
                tabuleiro[i][j] == tabuleiro[i][j+1] && tabuleiro[i][j] == tabuleiro[i][j-1] && tabuleiro[i][j] == tabuleiro[i-1][j] && tabuleiro[i][j] == tabuleiro [i-2][j]){
                    quantidadeDeEsferas = 5;
                    tipoDeEsfera = tabuleiro[i][j];
                }
            }
        }

        for (int i = 2; i < tabuleiro.length-2; i++) {
            for (int j = 2; j < tabuleiro[i].length-2; j++) {

                //CHECA ESFERAS ALINHDAS NA HORIZONTAL, NA VERTICAL
                //CASO 4 ESFERAS
                if(tabuleiro[i][j-2] == tabuleiro[i][j-1] && tabuleiro[i][j-1] == tabuleiro[i][j] && tabuleiro[i][j] == tabuleiro[i][j+1] | 
                tabuleiro[i][j-1] == tabuleiro[i][j] && tabuleiro[i][j] == tabuleiro[i][j+1] && tabuleiro[i][j+1] == tabuleiro[i][j+2] |  
                tabuleiro[i-2][j] == tabuleiro[i-1][j] && tabuleiro[i-1][j] == tabuleiro[i][j] && tabuleiro[i][j] == tabuleiro[i+1][j] |
                tabuleiro[i-1][j] == tabuleiro[i][j] && tabuleiro[i][j] == tabuleiro[i+1][j] && tabuleiro[i+1][j] == tabuleiro[i+2][j]){
                    quantidadeDeEsferas = 4;
                    tipoDeEsfera = tabuleiro[i][j];

                }
            }
        }
        for (int i = 1; i < tabuleiro.length-1; i++) {
            for (int j = 1; j < tabuleiro[i].length-1; j++) {

                //CHECA ESFERAS ALINHDAS NA HORIZONTAL, NA VERTICAL
                //CASO 3 ESFERAS
                if (tabuleiro[i][j-1] == tabuleiro[i][j] && tabuleiro[i][j] == tabuleiro[i][j+1]|
                    tabuleiro[i-1][j] == tabuleiro[i][j] && tabuleiro[i][j] == tabuleiro[i+1][j]){
                    
                    quantidadeDeEsferas = 3;
                    tipoDeEsfera = tabuleiro[i][j];
                }
            }
        }

        switch(tipoDeEsfera){
            //AÇÃO DA CAVEIRA
            //Diminui o hp(health point) do adversario em 1 ponto por esfera
            case 0:
                if (turnos.getAdversario().getVida() - quantidadeDeEsferas <= 0){
                    
                    turnos.getAdversario().setVida(0);
                    System.out.println("Fim de jogo muahhaahahaahahaha\n"+ turnos.getJogadorDaVez().getNome()+ " ganhou");

                }else{
                    turnos.getAdversario().setVida((turnos.getAdversario().getVida() - quantidadeDeEsferas) * turnos.getJogadorDaVez().getMultiplicadorDeDanoDoAtaque());
                    quebraEsferas();

                    if(quantidadeDeEsferas == 5 | quantidadeDeEsferas == 4){
                        turnos.getJogadorDaVez().setTurnoExtra(1);
                    }else{
                        turnos.contador = turnos.contador +1;
                    }

                    turnos.getJogadorDaVez().setMultiplicadorDeDanoDoAtaque(1);
                    turnos.novaJogada(turnos.getJogadorDaVez(), turnos.getAdversario(), tabuleiro, turnos);
                }
            break;

            //AÇÃO ESFERA VERMELHA / NOSSO ROXO
            //Aumenta o hp(health point) do jogador atual em 1 ponto por esfera
            case 1:
                if (turnos.getJogadorDaVez().getVida() + quantidadeDeEsferas >= turnos.getJogadorDaVez().getVidaMax()){
                    turnos.getJogadorDaVez().setVida(turnos.getJogadorDaVez().getVidaMax());

                }else{
                    turnos.getJogadorDaVez().setVida(turnos.getJogadorDaVez().getVida() + quantidadeDeEsferas);
                }

                quebraEsferas();
                
                if(quantidadeDeEsferas == 5 | quantidadeDeEsferas == 4){
                    turnos.getJogadorDaVez().setTurnoExtra(1);
                }else{
                    turnos.contador = turnos.contador +1;
                }

                turnos.getJogadorDaVez().setMultiplicadorDeDanoDoAtaque(1);
                turnos.novaJogada(turnos.getJogadorDaVez(), turnos.getAdversario(), tabuleiro, turnos);
            break;

            //AÇÃO ESFERA AZUL / NOSSO BORDO
            //Tranforma todas esferas roxas em caveiras
            case 2:
                for (int i = 2; i < tabuleiro.length-2; i++) {
                    for (int j = 2; j < tabuleiro[i].length-2; j++) {
                        if (tabuleiro[i][j] == 1){
                            tabuleiro[i][j] = 0;
                        }
                    }
                }
                
                quebraEsferas();

                if(quantidadeDeEsferas == 5 | quantidadeDeEsferas == 4){
                    turnos.getJogadorDaVez().setTurnoExtra(1);
                }else{
                    turnos.contador = turnos.contador +1;
                }
                
                turnos.getJogadorDaVez().setMultiplicadorDeDanoDoAtaque(1);
                turnos.novaJogada(turnos.getJogadorDaVez(), turnos.getAdversario(), tabuleiro, turnos);
            break;

            //AÇÃO ESFERA VERDE / NOSSO AZUL
            //Transforma todas caveiras em esferas roxas
            case 3:
            for (int i = 2; i < tabuleiro.length-2; i++) {
                for (int j = 2; j < tabuleiro[i].length-2; j++) {
                        if (tabuleiro[i][j] == 0){
                            tabuleiro[i][j] = 1;
                        }
                    }
                }
                quebraEsferas();

                if(quantidadeDeEsferas == 5 | quantidadeDeEsferas == 4){
                    turnos.getJogadorDaVez().setTurnoExtra(1);
                }else{
                    turnos.contador = turnos.contador +1;
                }

                turnos.getJogadorDaVez().setMultiplicadorDeDanoDoAtaque(1);
                turnos.novaJogada(turnos.getJogadorDaVez(), turnos.getAdversario(), tabuleiro, turnos);
            break;

            //AÇÃO ESFERA AMARELA / NOSSO VERDE
            //Modifica o ouro do adversario para 0
            case 4: 
                turnos.getAdversario().setOuro(0);

                if(quantidadeDeEsferas == 5 | quantidadeDeEsferas == 4){
                    turnos.getJogadorDaVez().setTurnoExtra(1);
                }else{
                    turnos.contador = turnos.contador +1;
                }
            break;

            //AÇÃO OURO 
            //Adiciona 1 ponto de ouro por sequência
            //Quando ouro chega a 10, o adversario leva dano dobrado no próximo turno
            //Obs: Sendo assim se a sequência possui 3 ouros eu ganharia 1 ouro, com 4 - 2 ouros e 5 - 3 ouros
            case 5:
                turnos.getJogadorDaVez().setOuro(turnos.getJogadorDaVez().getOuro() + (quantidadeDeEsferas - 2));

                if (turnos.getJogadorDaVez().getOuro() >= 10){
                    turnos.getJogadorDaVez().setOuro(0);
                    turnos.getJogadorDaVez().setMultiplicadorDeDanoDoAtaque(2);
                }
                quebraEsferas();

                if(quantidadeDeEsferas == 5 | quantidadeDeEsferas == 4){
                    turnos.getJogadorDaVez().setTurnoExtra(1);
                }else{
                    turnos.contador = turnos.contador +1;
                }
                
                turnos.getJogadorDaVez().setMultiplicadorDeDanoDoAtaque(1);
                turnos.novaJogada(turnos.getJogadorDaVez(), turnos.getAdversario(), tabuleiro, turnos);
            break;

            //AÇÃO EXPERIÊNCIA
            //Adiciona 1 ponto de experiência por sequência com bônus.
            //Obs: Sendo assim se a sequencia possui 3 experiência eu ganharia 1 experiência, com 4 - 2 experiência e 5 - 3 experiência
            case 6:

                if(quantidadeDeEsferas == 5 | quantidadeDeEsferas == 4){
                    turnos.getJogadorDaVez().setTurnoExtra(1);
                }else{
                    turnos.contador = turnos.contador +1;
                }

                turnos.getJogadorDaVez().setExperiencia(turnos.getJogadorDaVez().getExperiencia() + (quantidadeDeEsferas - 2));
                if (turnos.getJogadorDaVez().getExperiencia() >= 10) {
                    turnos.getJogadorDaVez().setExperiencia(0);
                    
                    if (turnos.getAdversario().getVidaMax()-10 <= 0){
                        turnos.getAdversario().setVida(0);
                        System.out.println("Fim de jogo muahhaahahaahahaha\n"+turnos.getJogadorDaVez().getNome()+"ganhou");
                        
                    }else{
                        turnos.getAdversario().setVidaMax(turnos.getAdversario().getVida()-10);
                        quebraEsferas();
                        turnos.novaJogada(turnos.getJogadorDaVez(), turnos.getAdversario(), tabuleiro, turnos);
                    }
                }

                turnos.getJogadorDaVez().setMultiplicadorDeDanoDoAtaque(1);
            break;
        }    
    }





}

