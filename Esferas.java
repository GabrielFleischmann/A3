public class Esferas {

    private String simbolo;

    //CONSTRUTOR DE ESFERAS
    public Esferas(int numeroAleatorio){

        //LEITURA E INTERPRETAÇÃO DO SIMBOLO, ASSOCIA UM NÚMERO A ESFERA CORRESPONDENTE
        switch (numeroAleatorio) {

            case 0:
                this.simbolo = Terminal.CAVEIRA + "☺︎" + Terminal.RESET;
                break;

            case 1:
                this.simbolo = Terminal.ROXO + "♥︎" + Terminal.RESET;
                break;

            case 2:
                this.simbolo = Terminal.BORDO + "◘" + Terminal.RESET;
                break;

            case 3:
                this.simbolo = Terminal.AZUL + "♠︎" + Terminal.RESET;
                break;

            case 4:
                this.simbolo = Terminal.VERDE + "♣︎" + Terminal.RESET;
                break;

            case 5:
                this.simbolo = Terminal.OURO + "♦︎" + Terminal.RESET;
                break;

            case 6:
                this.simbolo = Terminal.EXP + "☯︎" + Terminal.RESET;
                break;

            case 7:
                this.simbolo = " ";

            default:
                this.simbolo = "" + simbolo;


        }
    }

    @Override
    public String toString(){
        return " " + this.simbolo;
    }
}