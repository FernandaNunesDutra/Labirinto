import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

class BuscaIDAEstrela extends Busca{

    private Stack<No> pilha = new Stack<>();
    private Map<No, Double> descartados = new HashMap<>();


    private Stack<Double> pilhaFechado = new Stack<>();
    private Map<String, Double> pesoCaminho = new TreeMap<>();
    private Double patamar;
    private Double patamar_old=-1.0;

    BuscaIDAEstrela(No inicial, No objetivo) {
        super(inicial, objetivo);
        pesoCaminho.put(inicial.getId(),0.0);
        patamar = heuristica(inicial, objetivo);

    }

    @Override
    protected boolean busca(No atual){

        while(true){

            No proximo = null;
            Double patamarAtual = heuristica(atual, objetivo) + pesoCaminho.get(atual.getId());

            if(patamarAtual > patamar){

                if(descartados.isEmpty()) return false;

                if(pilha.isEmpty()){
                    proximo = buscaNoMenorHeuristica(descartados);
                }else{
                    descartados.put(atual, patamarAtual);
                    proximo =  pilha.pop();
                }

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

        Map<String, No> treeMap = new TreeMap<>(atual.getArestas());

        for(Map.Entry<String,No> entry : treeMap.entrySet()) {
            String key = entry.getKey();

            if(!visitados.contains(key)){
                return entry.getValue();
            }
        }

        return null;
    }
}