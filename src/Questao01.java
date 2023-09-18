import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class Questao01
{
    public static void main(String[] args) {
        Stack<String> pilhaDeFrases = new Stack<>();
        String nomeDoArquivo = "/downloads/frases.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(nomeDoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                pilhaDeFrases.push(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int tamanhoDaPilha = pilhaDeFrases.size();
        int numFrasesAMostrar = Math.min(10, tamanhoDaPilha);

        System.out.println("As top " + numFrasesAMostrar + " frases mais buscadas por último são:");
        for (int i = 0; i < numFrasesAMostrar; i++) {
            System.out.println(pilhaDeFrases.pop());
        }


        while (!pilhaDeFrases.isEmpty()) {
            pilhaDeFrases.pop();
        }
    }
}