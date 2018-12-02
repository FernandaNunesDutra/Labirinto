import java.util.*;

public class BuscaAEstrela extends Busca {

    private Map<No, No> caminho = new HashMap<>();
    private Map<No, Double> heuristica = new HashMap<>();
    private Map<String, Double> pesoCaminho = new HashMap<>();

    BuscaAEstrela(No inicial, No objetivo) {
        super(inicial, objetivo);

        pesoCaminho.put(inicial.getId(), 0.0);
    }


    @Override
    protected boolean busca(No atual) {
        while (true) {

            if (atual == null)
                return false;

            if(atual == objetivo)
                return true;

            enfileirar(atual);
            heuristica.remove(atual);
            visitados.add(atual.getId());

            atual = buscaNoMenorHeuristica(heuristica);

        }
    }

    @Override
    protected void caminho() {
        System.out.println("Caminho:");

        Stack<No> pilhaAux = new Stack<>();

        No auxNo=objetivo;

        while(auxNo!=null){

            pilhaAux.push(auxNo);

            auxNo = caminho.get(auxNo);

            if(auxNo==inicial){
                pilhaAux.push(auxNo);
                auxNo=null;
            }

        }

        System.out.println(pilhaAux);

    }


    private void enfileirar(No atual) {

        if(!atual.getArestas().isEmpty()){

            for (Map.Entry<String, No> entry : atual.getArestas().entrySet()) {
                boolean aberto = abertos.contains(entry.getKey());

                if (!aberto) {
                    Double totalCaminho = pesoCaminho.get(atual.getId()) + 1;
                    Double totalHeuristica = heuristica(atual, objetivo) + totalCaminho;

                    heuristica.put(entry.getValue(), round(totalHeuristica, 2));
                    pesoCaminho.put(entry.getValue().getId(), totalCaminho);
                    caminho.put(entry.getValue(), atual);
                    abertos.add(entry.getKey());
                }
            }
        }
    }

}
