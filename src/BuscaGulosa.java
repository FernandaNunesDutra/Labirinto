import java.util.*;

public class BuscaGulosa  extends Busca {

    private Map<No, Double> guloso= new HashMap<>();

    BuscaGulosa(No inicial, No objetivo) {
        super(inicial, objetivo);
    }


    @Override
    protected boolean busca(No atual) {
        while (true) {

            if (atual == null)
                return false;

            if(atual == objetivo)
                return true;

            enfileirar(atual);
            guloso.remove(atual);
            visitados.add(atual.getId());

            atual = buscaNoMenorHeuristica(guloso);

        }
    }

    private void enfileirar(No atual) {

        profundidade++;

        if(!atual.getArestas().isEmpty()){

            for (Map.Entry<String, No> entry : atual.getArestas().entrySet()) {
                boolean aberto = abertos.contains(entry.getKey());

                if (!aberto) {
                    Double totalguloso = heuristica(atual, objetivo);

                    guloso.put(entry.getValue(), round(totalguloso, 2));
                    pais.put(entry.getKey(), atual.getId());
                    abertos.add(entry.getKey());
                }
            }
        }
    }

}
