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

    @Override
    protected void getProfundidade(){
        System.out.printf("\nProfundidade: %s",  getCusto());
    }

    private void enfileirar(No atual) {

        if(!atual.getArestas().isEmpty()){

            for (Map.Entry<String, No> entry : atual.getArestas().entrySet()) {
                boolean aberto = abertos.contains(entry.getKey());

                if (!aberto) {
                    Double totalguloso = heuristica(entry.getValue(), objetivo);

                    guloso.put(entry.getValue(), round(totalguloso, 2));
                    pais.put(entry.getKey(), atual.getId());
                    abertos.add(entry.getKey());
                }
            }
        }
    }

}
