public class Jogador {

    private String nome;
    private int vidaMax = 20;
    private int vida = 20;
    private int ouro = 0;
    private int experiencia = 0;
    private int multiplicadorDeDanoDoAtaque = 1;

    public Jogador (String nome){
        this.nome = nome;
    }

    public int getMultiplicadorDeDanoDoAtaque(){
        return multiplicadorDeDanoDoAtaque;
    }

    public void setMultiplicadorDeDanoDoAtaque(int multiplicadorDeDanoDoAtaque){
        this.multiplicadorDeDanoDoAtaque = multiplicadorDeDanoDoAtaque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVidaMax(){
        return vidaMax;
    }

    public void setVidaMax(int vidaMax){
        this.vidaMax = vidaMax;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getOuro() {
        return ouro;
    }

    public void setOuro(int ouro) {
        this.ouro = ouro;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    @Override
    public String toString(){
        return getNome() + "\nVida:" + getVida() + "/" + getVidaMax() + "\nOuro: " + getOuro() + "\nExp: " + getExperiencia();
    }
}