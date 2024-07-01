import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Experimento3Threads {

    private static final String API_URL = "https://api.open-meteo.com/v1/forecast";

    public static void main(String[] args) throws InterruptedException {
        List<Capital> capitais = DadosCapitais.carregarCapitais();

        long tempoInicial = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            long tempoRodadaInicial = System.currentTimeMillis();

            Map<String, Map<Integer, Temperaturas>> dadosPorCapital = new HashMap<>();
            int numThreads = 3;
            Thread[] threads = new Thread[numThreads];

            for (int j = 0; j < numThreads; j++) {
                int inicio = j * (capitais.size() / numThreads);
                int fim = (j + 1) * (capitais.size() / numThreads);
                List<Capital> subListaCapitais = capitais.subList(inicio, fim);
                threads[j] = new Thread(() -> fazerRequisicoes(subListaCapitais, dadosPorCapital));
                threads[j].start();
            }

            for (Thread thread : threads) {
                thread.join();
            }

            exibirDados(dadosPorCapital);

            long tempoRodadaFinal = System.currentTimeMillis();
            long tempoRodada = tempoRodadaFinal - tempoRodadaInicial;
            System.out.println("Tempo da rodada " + (i + 1) + ": " + tempoRodada + " ms");
        }

        long tempoFinal = System.currentTimeMillis();
        long tempoMedio = (tempoFinal - tempoInicial) / 10;
        System.out.println("Tempo médio de execução: " + tempoMedio + " ms");
    }

    private static void fazerRequisicoes(List<Capital> capitais, Map<String, Map<Integer, Temperaturas>> dadosPorCapital) {
        for (Capital capital : capitais) {
            System.out.println("Fazendo requisição para: " + capital.getNome());
            try {
                String respostaJson = fazerRequisicaoHTTP(capital.getLatitude(), capital.getLongitude());
                Temperaturas temperaturas = processarRespostaJSON(respostaJson);
                armazenarDados(capital.getNome(), temperaturas, dadosPorCapital);
            } catch (IOException e) {
                System.err.println("Erro ao fazer requisição para " + capital.getNome() + ": " + e.getMessage());
            }
        }
    }

    private static String fazerRequisicaoHTTP(double latitude, double longitude) throws IOException {
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(API_URL + "?latitude=" + latitude + "&longitude=" + longitude);
        String respostaJson = null;

        try {
            HttpResponse response = httpClient.execute(request);
            if (response.getStatusLine().getStatusCode() == 200) {
                respostaJson = EntityUtils.toString(response.getEntity());
            } else {
                System.err.println("Falha na requisição HTTP: Código " + response.getStatusLine().getStatusCode());
            }
        } finally {
            ((Closeable) httpClient).close();
        }

        return respostaJson;
    }

    private static Temperaturas processarRespostaJSON(String respostaJson) {
        // Implementação similar ao Experimento1Thread
        Temperaturas temperaturas = new Temperaturas();
        temperaturas.setTemperaturaMedia(25.5);
        temperaturas.setTemperaturaMinima(20.1);
        temperaturas.setTemperaturaMaxima(30.8);
        return temperaturas;
    }

    private static void armazenarDados(String nomeCapital, Temperaturas temperaturas, Map<String, Map<Integer, Temperaturas>> dadosPorCapital) {
        dadosPorCapital.putIfAbsent(nomeCapital, new HashMap<>());
        Map<Integer, Temperaturas> temperaturasPorDia = dadosPorCapital.get(nomeCapital);
        temperaturasPorDia.put(1, temperaturas); // Exemplo: armazena para o dia 1
    }

    private static void exibirDados(Map<String, Map<Integer, Temperaturas>> dadosPorCapital) {
        for (Map.Entry<String, Map<Integer, Temperaturas>> entry : dadosPorCapital.entrySet()) {
            String nomeCapital = entry.getKey();
            Map<Integer, Temperaturas> temperaturasPorDia = entry.getValue();

            System.out.println("Dados para a capital: " + nomeCapital);
            for (Map.Entry<Integer, Temperaturas> entryDia : temperaturasPorDia.entrySet()) {
                int dia = entryDia.getKey();
                Temperaturas temperaturas = entryDia.getValue();

                System.out.println("Dia " + dia + ": Média=" + temperaturas.getTemperaturaMedia() +
                        ", Mínima=" + temperaturas.getTemperaturaMinima() +
                        ", Máxima=" + temperaturas.getTemperaturaMaxima());
            }
        }
    }

    static class Temperaturas {
        private double temperaturaMedia;
        private double temperaturaMinima;
        private double temperaturaMaxima;

        public double getTemperaturaMedia() {
            return temperaturaMedia;
        }

        public void setTemperaturaMedia(double temperaturaMedia) {
            this.temperaturaMedia = temperaturaMedia;
        }

        public double getTemperaturaMinima() {
            return temperaturaMinima;
        }

        public void setTemperaturaMinima(double temperaturaMinima) {
            this.temperaturaMinima = temperaturaMinima;
        }

        public double getTemperaturaMaxima() {
            return temperaturaMaxima;
        }

        public void setTemperaturaMaxima(double temperaturaMaxima) {
            this.temperaturaMaxima = temperaturaMaxima;
        }
    }
}
