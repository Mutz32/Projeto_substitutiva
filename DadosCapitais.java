import java.util.ArrayList;
import java.util.List;

public class DadosCapitais {

    public static List<Capital> carregarCapitais() {
        List<Capital> capitais = new ArrayList<>();
        
        // Adicionando as capitais conforme fornecido
        capitais.add(new Capital("Aracaju", -10.9167, -37.05));
        capitais.add(new Capital("Belém", -1.4558, -48.5039));
        capitais.add(new Capital("Belo Horizonte", -19.9167, -43.9333));
        capitais.add(new Capital("Boa Vista", 2.81972, -60.67333));
        capitais.add(new Capital("Brasília", -15.7939, -47.8828));
        capitais.add(new Capital("Campo Grande", -20.44278, -54.64639));
        capitais.add(new Capital("Cuiabá", -15.5989, -56.0949));
        capitais.add(new Capital("Curitiba", -25.4297, -49.2711));
        capitais.add(new Capital("Florianópolis", -27.5935, -48.55854));
        capitais.add(new Capital("Fortaleza", -3.7275, -38.5275));
        capitais.add(new Capital("Goiânia", -16.6667, -49.25));
        capitais.add(new Capital("João Pessoa", -7.12, -34.88));
        capitais.add(new Capital("Macapá", 0.033, -51.05));
        capitais.add(new Capital("Maceió", -9.66583, -35.73528));
        capitais.add(new Capital("Manaus", -3.1189, -60.0217));
        capitais.add(new Capital("Natal", -5.7833, -35.2));
        capitais.add(new Capital("Palmas", -10.16745, -48.32766));
        capitais.add(new Capital("Porto Alegre", -30.0331, -51.23));
        capitais.add(new Capital("Porto Velho", -8.76194, -63.90389));
        capitais.add(new Capital("Recife", -8.05, -34.9));
        capitais.add(new Capital("Rio Branco", -9.97472, -67.81));
        capitais.add(new Capital("Rio de Janeiro", -22.9111, -43.2056));
        capitais.add(new Capital("Salvador", -12.9747, -38.4767));
        capitais.add(new Capital("São Luís", -2.5283, -44.3044));
        capitais.add(new Capital("São Paulo", -23.55, -46.6333));
        capitais.add(new Capital("Teresina", -5.08917, -42.80194));
        capitais.add(new Capital("Vitória", -20.2889, -40.3083));

        return capitais;
    }
}
