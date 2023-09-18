import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Questao02 {
    public static void main(String[] args) {
        Queue<String> filaDeIngressos = new LinkedList<>();
        String nomeDoArquivo = "ingressos.txt"; // Nome do arquivo de ingressos vendidos

        try (BufferedReader br = new BufferedReader(new FileReader(nomeDoArquivo))) {
            String ingresso;
            while ((ingresso = br.readLine()) != null) {
                filaDeIngressos.offer(ingresso);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Os 10 primeiros ingressos vendidos são para entrada VIP:");
        for (int i = 0; i < 10; i++) {
            String ingresso = filaDeIngressos.poll();
            if (ingresso != null) {
                System.out.println(ingresso);
            }
        }

        // Sorteio aleatório para conhecer a banda
        int tamanhoDaFila = filaDeIngressos.size();
        if (tamanhoDaFila > 0) {
            Random random = new Random();
            int posicaoSorteada = random.nextInt(tamanhoDaFila);
            String ingressoSorteado = null;

            for (int i = 0; i < posicaoSorteada; i++) {
                ingressoSorteado = filaDeIngressos.poll();
            }

            System.out.println("Pessoa sorteada para conhecer a banda: " + ingressoSorteado);
        } else {
            System.out.println("Não há mais ingressos na fila.");
        }
    }
}