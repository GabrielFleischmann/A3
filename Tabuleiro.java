import java.io.Serializable;
import java.util.Random;

public class Tabuleiro implements Serializable{

    //ATRIBUTOS
   private int[][] tabuleiro = new int[8][8];
   private final Random r1 = new Random();
   private Turno turnos;
   private int tipoDeEsfera;
   
   //CONSTRUTORES
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

   public void setTipoDeEsfera(int tipoDeEsfera){
        this.tipoDeEsfera = tipoDeEsfera;
    }
    public int getTipoDeEsferas(){
        return tipoDeEsfera;
    }

    //CRIA O TABULEIRO
   public void geraTab() {
       for (int i = 0; i < tabuleiro.length; i++) {
           for (int j = 0; j < tabuleiro[i].length; j++) {
               tabuleiro[i][j] = r1.nextInt(7);
            }
        }
        
       validaTabInicial();
   }

   //IMPRIME TABULEIRO
   public void imprimeTab(){
        System.out.println("    1   2   3   4   5   6   7   8");
        for (int i = 0; i < tabuleiro.length; i++) {
            System.out.printf("%d ", i+1);
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.printf(" %s ", new Esferas (tabuleiro[i][j]));
            }
            System.out.println();
        }
    }

    //CHECA SE O TABULEIRO GERADO JA POSSUI SEQUENCIAS PRONTAS
    public void validaTabInicial(){
       boolean esferasAlinhadas;
       
       do{
           esferasAlinhadas = false;
           
           //CASO JÁ EXISTA ESFERAS ALINHADAS NA HORIZONTAL
           for (int i = 0; i < tabuleiro.length; i++) {
               for (int j = 1; j < tabuleiro[i].length-1; j++) {
                   if(tabuleiro[i][j-1] == tabuleiro[i][j] && tabuleiro[i][j]== tabuleiro[i][j+1]){
                    tabuleiro[i][j] = r1.nextInt(7);
                    esferasAlinhadas = true;
                    }
               }
           }
           //CASO JÁ EXISTA ESFERAS ALINHADAS NA VERTICAL
           for (int i = 1; i < tabuleiro.length-1; i++) {
               for (int j = 0; j < tabuleiro[i].length; j++) {
                   if(tabuleiro[i-1][j] == tabuleiro[i][j] && tabuleiro[i][j] == tabuleiro[i+1][j]){
                    tabuleiro[i][j] = r1.nextInt(7);
                    esferasAlinhadas = true;
                    }
               }
           }
       }while (esferasAlinhadas);
    }
   
   //MÉTODO PARA CONTAR AS ESFERAS ALINHADAS E APLICAR EFEITOS NOS JOGADORES
   public void checaEsferas(){

        boolean temCombo;
        boolean turnoExtra = false;
        int quantidadeDeEsferas;

        do{
            temCombo = false;
            quantidadeDeEsferas = 0;
            setTipoDeEsfera(7);

            //CASO ALINHE 3 ESFERAS
            //HORIZONTAL
            for (int i = 0; i < tabuleiro.length; i++) {
                for (int j = 0; j < tabuleiro.length-2; j++) {
                    if((tabuleiro[i][j] == tabuleiro[i][j+1]) && (tabuleiro[i][j+1] == tabuleiro[i][j+2])){
                        temCombo = true;
                        quantidadeDeEsferas = 3;
                        setTipoDeEsfera(tabuleiro[i][j]);
                    }
                }
            }

            //VERTICAL
            for (int i = 0; i < tabuleiro.length-2; i++) {
                for (int j = 0; j < tabuleiro.length; j++) {        
                    if((tabuleiro[i][j] == tabuleiro[i+1][j]) && (tabuleiro[i+1][j] == tabuleiro[i+2][j])){
                        temCombo = true;
                        quantidadeDeEsferas = 3;
                        setTipoDeEsfera(tabuleiro[i][j]);
                    }
                }  
            } 
            
            //CASO ALINHE 4 ESFERAS
            //HORIZONTAL
            for (int i = 0; i < tabuleiro.length; i++) {
                for (int j = 0; j < tabuleiro.length-3; j++) {
                    if((tabuleiro[i][j] == tabuleiro[i][j+1]) && (tabuleiro[i][j+1] == tabuleiro[i][j+2]) && (tabuleiro[i][j+2] == tabuleiro[i][j+3])){
                        temCombo = true;
                        turnoExtra = true;
                        quantidadeDeEsferas = 4;
                        setTipoDeEsfera(tabuleiro[i][j]); 
                    }
                }
            }

            //VERTICAL
            for (int i = 0; i < tabuleiro.length-3; i++) {
                for (int j = 0; j < tabuleiro.length; j++) {
                    if((tabuleiro[i][j] == tabuleiro[i+1][j]) && (tabuleiro[i+1][j] == tabuleiro[i+2][j]) && (tabuleiro[i+2][j] == tabuleiro[i+3][j])){
                        temCombo = true;
                        turnoExtra = true;
                        quantidadeDeEsferas = 4;
                        setTipoDeEsfera(tabuleiro[i][j]);  
                    }
                }
            }

            //CASO ALINHE 5 ESFERAS
            //HORIZONTAL
            for (int i = 0; i < tabuleiro.length; i++) {
                for (int j = 0; j < tabuleiro[i].length-4; j++) {
                    if((tabuleiro[i][j] == tabuleiro[i][j+1]) && (tabuleiro[i][j+1] == tabuleiro[i][j+2]) && (tabuleiro[i][j+2] == tabuleiro[i][j+3]) && (tabuleiro[i][j+3] == tabuleiro[i][j+4])){
                        temCombo = true;
                        turnoExtra = true;
                        quantidadeDeEsferas = 5;
                        setTipoDeEsfera(tabuleiro[i][j]);                        
                    } 
                }
            }

            //VERTICAL
            for (int i = 0; i < tabuleiro.length-4; i++) {
                for (int j = 0; j < tabuleiro[i].length; j++) {   
                    if((tabuleiro[i][j] == tabuleiro[i+1][j]) && (tabuleiro[i+1][j] == tabuleiro[i+2][j]) && (tabuleiro[i+2][j] == tabuleiro[i+3][j]) && (tabuleiro[i+3][j] == tabuleiro[i+4][j])){
                        temCombo = true;
                        turnoExtra = true;
                        quantidadeDeEsferas = 5;
                        setTipoDeEsfera(tabuleiro[i][j]);
                    }
                }
            }

            //CASO L        
            for (int i = 0; i < tabuleiro.length-2; i++) {
                for (int j = 0; j < tabuleiro[i].length-2; j++) {   
                    if((tabuleiro[i][j] == tabuleiro[i+1][j]) && (tabuleiro[i+1][j] == tabuleiro[i+2][j]) && (tabuleiro[i+2][j]== tabuleiro[i][j+1]) && (tabuleiro[i][j+1] == tabuleiro[i][j+2])){
                        temCombo = true;
                        turnoExtra = true;
                        quantidadeDeEsferas = 5;
                        setTipoDeEsfera(tabuleiro[i][j]);
                    }
                }
            }

            //CASO L PARA ESQUERDA
            for (int i = 0; i < tabuleiro.length-2; i++) {
                for (int j = 2; j < tabuleiro[i].length; j++) { 
                    if((tabuleiro[i][j] == tabuleiro[i+1][j]) && (tabuleiro[i+1][j] == tabuleiro[i+2][j]) && (tabuleiro[i+2][j]==tabuleiro[i][j-1]) && (tabuleiro[i][j-1] == tabuleiro[i][j-2])){
                        temCombo = true;
                        turnoExtra = true;
                        quantidadeDeEsferas = 5;
                        setTipoDeEsfera(tabuleiro[i][j]);
                    }
                }
            }

            //CASO L INVERTIDO
            for (int i = 2; i < tabuleiro.length; i++) {
                for (int j = 0; j < tabuleiro.length-2; j++) {
                    if((tabuleiro[i][j] == tabuleiro[i-1][j]) && (tabuleiro[i-1][j] == tabuleiro[i-2][j]) && (tabuleiro[i-2][j] == tabuleiro[i][j+1]) && (tabuleiro[i][j+1] == tabuleiro[i][j+2])){
                        temCombo = true;
                        turnoExtra = true;
                        quantidadeDeEsferas = 5;
                        setTipoDeEsfera(tabuleiro[i][j]);
                    }
                }
            }
            
            //CASO L INVERTIDO PARA ESQUERDA
            for (int i = 2; i < tabuleiro.length; i++) {
                for (int j = 2; j < tabuleiro[i].length; j++) { 
                    if((tabuleiro[i][j] == tabuleiro[i-1][j]) && (tabuleiro[i-1][j] == tabuleiro[i-2][j]) && (tabuleiro[i-2][j]== tabuleiro[i][j-1]) && (tabuleiro[i][j-1]==tabuleiro[i][j-2])){
                        temCombo = true;
                        turnoExtra = true;
                        quantidadeDeEsferas = 5;
                        setTipoDeEsfera(tabuleiro[i][j]);
                    }
                }
            }

            //SWITCH PARA ATRIBUIR AS AÇÕES DAS ESFERAS SE BASEANDO NA VARIAVEL TIPO DE ESFERAS
            switch(getTipoDeEsferas()){
                //AÇÃO DA CAVEIRA
                //Diminui o hp(health point) do adversario em 1 ponto por esfera
                case 0:
                    if (turnos.getAdversario().getVida() - quantidadeDeEsferas <= 0){
                        turnos.getAdversario().setVida(0);

                    }else{
                        turnos.getAdversario().setVida((turnos.getAdversario().getVida() - quantidadeDeEsferas) * turnos.getJogadorDaVez().getMultiplicadorDeDanoDoAtaque());
                        turnos.getJogadorDaVez().setMultiplicadorDeDanoDoAtaque(1);
                    }

                    break; 

                //AÇÃO ROXO
                //Aumenta o hp(health point) do jogador atual em 1 ponto por esfera
                case 1:
                    if (turnos.getJogadorDaVez().getVida() + quantidadeDeEsferas >= turnos.getJogadorDaVez().getVidaMax()){
                        turnos.getJogadorDaVez().setVida(turnos.getJogadorDaVez().getVidaMax());

                    }else{
                        turnos.getJogadorDaVez().setVida(turnos.getJogadorDaVez().getVida() + quantidadeDeEsferas);
                    }

                    break;

                //AÇÃO BORDO
                //Tranforma todas esferas roxas em caveiras
                case 2:
                    for (int i = 0; i < tabuleiro.length; i++) {
                        for (int j = 0; j < tabuleiro[i].length; j++) {
                            if (tabuleiro[i][j] == 1){
                                tabuleiro[i][j] = 0;
                            }
                        }
                    }

                    break;

                //AÇÃO AZUL
                //Transforma todas caveiras em esferas roxas
                case 3:
                for (int i = 0; i < tabuleiro.length; i++) {
                    for (int j = 0; j < tabuleiro[i].length; j++) {
                            if (tabuleiro[i][j] == 0){
                                tabuleiro[i][j] = 1;
                            }
                        }
                    }

                    break;

                //AÇÃO VERDE
                //Modifica o ouro do adversario para 0
                case 4: 
                    turnos.getAdversario().setOuro(0);

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

                    break;

                //AÇÃO EXPERIÊNCIA
                //Adiciona 1 ponto de experiência por sequência com bônus.
                //Obs: Sendo assim se a sequencia possui 3 experiência eu ganharia 1 experiência, com 4 - 2 experiência e 5 - 3 experiência
                case 6:
                    turnos.getJogadorDaVez().setExperiencia(turnos.getJogadorDaVez().getExperiencia() + (quantidadeDeEsferas - 2));
                    
                    if (turnos.getJogadorDaVez().getExperiencia() >= 10) {
                        turnos.getJogadorDaVez().setExperiencia(0);
                        
                        if (turnos.getAdversario().getVidaMax()-10 >= turnos.getAdversario().getVida()){
                            turnos.getAdversario().setVida(0);
                        }else{
                            turnos.getAdversario().setVida(turnos.getAdversario().getVida() - 10);
                            turnos.getAdversario().setVidaMax(turnos.getAdversario().getVidaMax()-10);
                        }
                    }
                                
                    break;

                case 7:
                    break;
            }    

            quebraEsferas();

        }while(temCombo);

        //CHECA TURNO EXTRA E SE JOGO CONTINUA
        if(turnos.getJogadorDaVez().getVida() > 0 && turnos.getAdversario().getVida() > 0){
            if(turnoExtra){
                turnos.novaJogada(turnos.getJogadorDaVez(), turnos.getAdversario(), tabuleiro, turnos);
            }else{
                turnos.novaJogada(turnos.getAdversario(), turnos.getJogadorDaVez(), tabuleiro, turnos);
            }
        } else{
            System.out.println("Fim de jogo MUAHAHAHAHAHHAHAHAHA\n"+turnos.getJogadorDaVez().getNome()+" é o vencedor da partida!!");
        }
    }
    
    public void quebraEsferas(){

        //CASO ALINHE 5 ESFERAS
        //HORIZONTAL
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length-4; j++) {
                if((tabuleiro[i][j] == tabuleiro[i][j+1]) && (tabuleiro[i][j+1] == tabuleiro[i][j+2]) && (tabuleiro[i][j+2] == tabuleiro[i][j+3]) && (tabuleiro[i][j+3] == tabuleiro[i][j+4])){

                    //QUEBRA ESFERAS
                    tabuleiro[i][j] = 7;    
                    tabuleiro[i][j+1] = 7;
                    tabuleiro[i][j+2] = 7;
                    tabuleiro[i][j+3] = 7;
                    tabuleiro[i][j+4] = 7;
                    
                } 
            }
        }

        //VERTICAL
        for (int i = 0; i < tabuleiro.length-4; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {   
                if((tabuleiro[i][j] == tabuleiro[i+1][j]) && (tabuleiro[i+1][j] == tabuleiro[i+2][j]) && (tabuleiro[i+2][j] == tabuleiro[i+3][j]) && (tabuleiro[i+3][j] == tabuleiro[i+4][j])){
                
                    //QUEBRA ESFERAS
                    tabuleiro[i][j] = 7;
                    tabuleiro[i+1][j] = 7;
                    tabuleiro[i+2][j] = 7;
                    tabuleiro[i+3][j] = 7;
                    tabuleiro[i+4][j] = 7;

                }
            }
        }

        //CASO ALINHE 4 ESFERAS
        //HORIZONTAL
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro.length-3; j++) {
                if((tabuleiro[i][j] == tabuleiro[i][j+1]) && (tabuleiro[i][j+1] == tabuleiro[i][j+2]) && (tabuleiro[i][j+2] == tabuleiro[i][j+3])){

                    //QUEBRA ESFERAS
                    tabuleiro[i][j] = 7;    
                    tabuleiro[i][j+1] = 7;
                    tabuleiro[i][j+2] = 7;
                    tabuleiro[i][j+3] = 7;
                }
            }
        }

        //VERTICAL
        for (int i = 0; i < tabuleiro.length-3; i++) {
            for (int j = 0; j < tabuleiro.length; j++) {
                if((tabuleiro[i][j] == tabuleiro[i+1][j]) && (tabuleiro[i+1][j] == tabuleiro[i+2][j]) && (tabuleiro[i+2][j] == tabuleiro[i+3][j])){

                    //QUEBRA AS ESFERAS
                    tabuleiro[i][j] = 7;
                    tabuleiro[i+1][j] = 7;
                    tabuleiro[i+2][j] = 7;
                    tabuleiro[i+3][j] = 7;
                }
            }
        }

        //CASO ALINHE 3 ESFERAS
        //HORIZONTAL
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro.length-2; j++) {
                if((tabuleiro[i][j] == tabuleiro[i][j+1]) && (tabuleiro[i][j+1] == tabuleiro[i][j+2])){
                    
                    //QUEBRA AS ESFERAS
                    tabuleiro[i][j] = 7;
                    tabuleiro[i][j+1] = 7;
                    tabuleiro[i][j+2] = 7;
                }
            }
        }

        //VERTICAL
        for (int i = 0; i < tabuleiro.length-2; i++) {
            for (int j = 0; j < tabuleiro.length; j++) {        
                if((tabuleiro[i][j] == tabuleiro[i+1][j]) && (tabuleiro[i+1][j] == tabuleiro[i+2][j])){
                    
                    //QUEBRA AS ESFERAS
                    tabuleiro[i][j] = 7;
                    tabuleiro[i+1][j] = 7;
                    tabuleiro[i+2][j] = 7;                    
                }
            }  
        }      

        organizaEsferas();
    }

    //PEGA ESPAÇOS VAZIOS E OS PREENCHE RANDOMIZANDO NOVAMENTE AS ESFERAS PARA O TABULEIRO
    public void organizaEsferas(){

        boolean temVazios;
        
        //DESCE AS ESFERAS ACIMA DE ESPAÇOS VAZIOS
        do{
            temVazios = false;

            for (int i = 0; i < tabuleiro.length-1; i++) {
                for (int j = 0; j < tabuleiro.length; j++) {
                    if (tabuleiro[i][j] != 7 && tabuleiro[i + 1][j] == 7) {
                        tabuleiro[i + 1][j] = tabuleiro[i][j];
                        tabuleiro[i][j] = 7;
                        temVazios = true;
                    }
                }
            }
        }while(temVazios);

        //PREENCHE OS ESPAÇOS VAZIOS JÁ NO TOPO DO TABULEIRO
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro.length; j++) {

                if(tabuleiro[i][j] == 7){
                    tabuleiro[i][j] = r1.nextInt(7);
                }
                
                if(tabuleiro[i][j] == 1 && getTipoDeEsferas() == 2){
                    tabuleiro[i][j] = 0;
                }
                
                if(tabuleiro[i][j] == 0 && getTipoDeEsferas() == 3){
                    tabuleiro[i][j] = 1;
                }
            }
        }
    }
}