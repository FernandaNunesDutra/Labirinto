import java.util.*;

class BuscaIDAEstrela extends Busca{

    private Stack<No> pilha = new Stack<>();
    private Map<No, Double> descartados = new HashMap<>();
    private Set<String> nosDescartados = new HashSet<>();

    private Map<String, Double> pesoCaminho = new TreeMap<>();
    private Double patamar;

    BuscaIDAEstrela(No inicial, No objetivo) {
        super(inicial, objetivo);
        pesoCaminho.put(inicial.getId(),0.0);
        patamar = heuristica(inicial, objetivo) ;
    }

    @Override
    protected boolean busca(No atual){

        while(true){

            No proximo = null;
            Double patamarAtual = heuristica(atual, objetivo) + pesoCaminho.get(atual.getId());

            if(patamarAtual > patamar){

                if(pilha.isEmpty()){
                    proximo = buscaNoMenorHeuristica(descartados);
                }else{
                    proximo =  pilha.pop();
                }

                nosDescartados.add(atual.getId());
                descartados.put(atual, patamarAtual);
                patamar = heuristica(proximo, objetivo)  + pesoCaminho.get(atual.getId());

            }else{

                if(atual == objetivo)
                    return true;

                visitados.add(atual.getId());
                proximo = buscaProximo(atual);

                if(proximo == null){

                    if(pilha.empty()) return false;

                    proximo = pilha.pop();

                } else {
                    pilha.push(atual);
                }
            }

            atual = proximo;

        }
    }

    @Override
    protected void caminho() {
        System.out.println("Caminho:");
        System.out.println(pilha);
    }


    private No buscaProximo(No atual){

        profundidade++;

        Map<String, No> treeMap = new TreeMap<>(atual.getArestas());

        for(Map.Entry<String,No> entry : treeMap.entrySet()) {
            String key = entry.getKey();

            boolean visitado = visitados.contains(key);
            boolean descartado = nosDescartados.contains(key);

            if(!visitado && !descartado){
                Double totalCaminho = pesoCaminho.get(atual.getId()) + 1;
                pesoCaminho.put(entry.getKey(), totalCaminho);
                pais.put(entry.getKey(), atual.getId());
                return entry.getValue();
            }
        }

        return null;
    }
}