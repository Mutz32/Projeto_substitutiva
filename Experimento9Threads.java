import java.io.Closeable;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Experimento9Threads {
    // Outros métodos e atributos existentes...

    // Método para fazer requisição HTTP e obter os dados climáticos
    private static String fazerRequisicaoHTTP(double latitude, double longitude) throws IOException {
        HttpClient httpClient = HttpClients.createDefault();
        String apiUrl = "https://api.open-meteo.com/v1/forecast?latitude=" + latitude + "&longitude=" + longitude;

        HttpGet httpGet = new HttpGet(apiUrl);
        String respostaJson = null;

        try {
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                respostaJson = EntityUtils.toString(entity);
            }
        } finally {
            ((Closeable) httpClient).close(); // Fecha o cliente HTTP
        }

        return respostaJson;
    }
}
