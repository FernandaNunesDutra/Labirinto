import java.util.*;

class Backtracking {


    private static Map<String, No> visitados = new HashMap<>();
    private static Stack<No> pilha = new Stack<>();
    private static No objetivo;

    static void inicia(No inicial, No objetivo){

        Backtracking.objetivo = objetivo;

        if(busca(inicial)){
            System.out.println("Caminho encontrado.");
        }else {
            System.out.println("Caminho não encontrado.");
        }
    }

    private static boolean busca(No atual){
        System.out.println(atual.getId());

        if(atual == objetivo)
            return true;

        visitados.put(atual.getId(), atual);
        No proximo = buscaProximo(atual);

        if(proximo == null){

            if(pilha.empty())
                return false;

            proximo = pilha.pop();
            System.out.println("back");

        } else {

            pilha.push(atual);

        }

        return busca(proximo);

    }

    private static No buscaProximo(No atual){

        Map<String, No> treeMap = new TreeMap<>(atual.getArestas());

        for(Map.Entry<String,No> entry : treeMap.entrySet()) {
            String key = entry.getKey();

            if(visitados.get(key) == null){

                return entry.getValue();
            }

        }

        return null;
    }
}