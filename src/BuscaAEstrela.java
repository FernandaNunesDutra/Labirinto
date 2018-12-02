import java.util.*;

public class BuscaAEstrela extends Busca {


    private int patamarMaximo, patamarAtual;
    private Map<No, Double> heuristica = new HashMap<>();
    private Map<String, Double> pesoCaminho = new HashMap<>();

    BuscaAEstrela(No inicial, No objetivo, int patamar) {
        super(inicial, objetivo);

        patamarAtual = 1;
        patamarMaximo = patamar;
        pesoCaminho.put(inicial.getId(), 0.0);
    }


    @Override
    protected boolean busca(No atual) {
        while (true) {

            if (atual == null || patamarAtual > patamarMaximo)
                return false;

            if(atual == objetivo)
                return true;

            enfileirar(atual);
            heuristica.remove(atual);
            visitados.add(atual.getId());

            atual = buscaProximo();

        }
    }

    @Override
    protected void caminho(){

    }


    private No buscaProximo() {
        No noMinimo = null;
        double heuristicaMinima = Double.MAX_VALUE;

        for (Map.Entry<No, Double> entry :heuristica.entrySet()) {

            No no = entry.getKey();
            double valorHeuristica = heuristica(no, objetivo);

            if(valorHeuristica < heuristicaMinima){
                noMinimo = no;
                heuristicaMinima = valorHeuristica;
            }
        }

        return  noMinimo;
    }

    private void enfileirar(No atual) {

        if(!atual.getArestas().isEmpty()){
            patamarAtual++;

            for (Map.Entry<String, No> entry : atual.getArestas().entrySet()) {
                boolean aberto = abertos.contains(entry.getKey());

                if (!aberto) {
                    Double totalCaminho = pesoCaminho.get(atual.getId()) + 1;
                    Double totalHeuristica = heuristica(atual, objetivo) + totalCaminho;

                    pesoCaminho.put(entry.getValue().getId(), totalCaminho);
                    heuristica.put(entry.getValue(), round(totalHeuristica, 2));
                    abertos.add(entry.getKey());
                }
            }
        }
    }

}
