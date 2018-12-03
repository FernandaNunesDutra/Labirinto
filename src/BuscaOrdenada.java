import java.util.HashMap;
import java.util.Map;

public class BuscaOrdenada extends Busca {

    private Map<No, Double> pesoCaminho = new HashMap<>();
    private Map<No, No> caminho = new HashMap<>();

    BuscaOrdenada(No inicial, No objetivo) {
        super(inicial, objetivo);

        pesoCaminho.put(inicial, 0.0);
    }


    @Override
    protected boolean busca(No atual) {
        while (true) {

            if (atual == null)
                return false;

            if(atual == objetivo)
                return true;

            enfileirar(atual);

            pesoCaminho.remove(atual);
            visitados.add(atual.getId());

            atual = buscaNoMenorHeuristica(pesoCaminho);

        }
    }

    private void enfileirar(No atual) {

        profundidade++;

        if(!atual.getArestas().isEmpty()){

            for (Map.Entry<String, No> entry : atual.getArestas().entrySet()) {
                boolean aberto = abertos.contains(entry.getKey());

                if (!aberto) {
                    Double totalCaminho = pesoCaminho.get(atual) + 1;
                    pesoCaminho.put(entry.getValue(), totalCaminho);
                    pais.put(entry.getKey(), atual.getId());
                    abertos.add(entry.getKey());
                }
            }
        }
    }
}
