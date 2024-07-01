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
}

