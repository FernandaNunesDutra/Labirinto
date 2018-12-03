import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

class Backtracking extends Busca{

    private static Stack<No> pilha = new Stack<>();

    Backtracking(No inicial, No objetivo) {
        super(inicial, objetivo);
    }

    @Override
    protected boolean busca(No atual){
        System.out.println(atual.getId());

        pais.put(atual.getId(), "-1");

        while(true){
            if(atual == objetivo)
                return true;

            abertos.add(atual.getId());
            visitados.add(atual.getId());
            No proximo = buscaProximo(atual);

            if(proximo == null){

                if(pilha.empty())
                    return false;

                proximo = pilha.pop();
                profundidade--;

                //System.out.println("back");

            } else {

                pilha.push(atual);
                pais.put(proximo.getId(), atual.getId());

            }

            atual = proximo;
        }

    }


    private No buscaProximo(No atual){

        profundidade++;

        Map<String, No> treeMap = new TreeMap<>(atual.getArestas());

        for(Map.Entry<String,No> entry : treeMap.entrySet()) {
            String key = entry.getKey();

            if(!abertos.contains(key)){
                return entry.getValue();
            }

        }

        return null;
    }
}