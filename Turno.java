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
       if (contador % 2 == 0 | jogador1.getTurnoExtra() == 1){
           jogadorDaVez = jogador1;
           adversario = jogador2;
       }else{
           jogadorDaVez = jogador2;
           adversario = jogador1;
       }
   }
}
