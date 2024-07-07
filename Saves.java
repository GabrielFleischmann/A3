import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Saves{
   
    public static void salvarJogo(Jogador jogador1, Jogador jogador2, int[][] tab, Turno turno){

        Scanner strings = new Scanner(System.in);
        
        try{
            System.out.print("Digite o nome para seu save: ");
            Path caminho = Paths.get("Saves/" + strings.nextLine().toUpperCase());
            ObjectOutputStream save = new ObjectOutputStream(Files.newOutputStream(caminho));
            
            save.writeObject(jogador1);
            save.writeObject(jogador2);
            save.writeObject(tab);
            save.writeObject(turno);
    
            Menu.executaMenu();
            strings.close();
            
        }catch(IOException e){
            System.out.println("Falha ao salvar jogo");
            turno.novaJogada(jogador1, jogador2, tab, turno);
        }
    }
    
    public static void carregarJogo(){

        Scanner strings = new Scanner(System.in);
        mostrarSaves();
        System.out.print("Digite o nome completo do seu save:");
        Path caminho = Paths.get("Saves/" + strings.nextLine().toUpperCase());

        try (ObjectInputStream load = new ObjectInputStream(Files.newInputStream(caminho))){
            Jogador jogador1 = (Jogador) load.readObject();
            Jogador jogador2 = (Jogador) load.readObject();
            int[][] tabuleiro = (int[][]) load.readObject();
            Turno turnoAtual = (Turno) load.readObject();

            turnoAtual.novaJogada(jogador1, jogador2, tabuleiro, turnoAtual);
            strings.close();

        }catch(IOException | ClassNotFoundException a){
            System.out.println("Falha ao carregar jogo");
            Menu.executaMenu();
        }
    }

    public static void mostrarSaves(){
        File diretorio = new File("Saves/");
        File[] arquivos = diretorio.listFiles();

        for (int i = 0; i < arquivos.length; i++) {
            System.out.printf("%s", arquivos[i].getName());
            System.out.println();
        }
    }

    public static void deletarJogo(){
        File diretorio = new File("Saves/");
        File[] arquivos = diretorio.listFiles();

        if(arquivos.length > 0) {
            Scanner strings = new Scanner(System.in);

            System.out.println("Digite o nome completo do save que deseja apagar:");
            mostrarSaves();

            File save = new File("Saves/" + strings.nextLine().toUpperCase());

            if (save.delete()) {
                System.out.println("O save foi deletado");
            } else {
                System.out.println("Erro ao deletar save! Tente novamente");
            }

            strings.close();
        }else{
            System.out.println("--- Não há saves para deletar ---");
        }

        Menu.executaMenu();
    }

}
