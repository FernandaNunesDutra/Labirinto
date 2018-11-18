import java.util.*;

public class BuscaProfundidade {

    private static Map<String, No> visitados = new HashMap<>();
    private static Stack<No> pilha = new Stack<>();
    private static Stack<No> pilha2 = new Stack<>();
    private static No objetivo;

    static void inicia(No inicial, No objetivo){

        BuscaProfundidade.objetivo = objetivo;
        pilha2.push(inicial);
        pilha.push(inicial);

        if(busca(inicial)){
            System.out.println("Caminho encontrado.");
        }else {
            System.out.println("Caminho não encontrado.");
        }
    }

    private static boolean busca(No atual){

        if(atual == null)
            return false;

        System.out.println(atual.getId());

        if(atual == objetivo)
            return true;

        visitados.put(atual.getId(), atual);
        empilha(atual);

        atual = buscaProximo();

        return busca(atual);
    }

    private static No buscaProximo(){
        while(!pilha.isEmpty()){
            No proximo = pilha.pop();

            if(!visitados.containsKey(proximo.getId()))
                return proximo;
        }

        return null;
    }

    private static void empilha(No atual){

        Map<String, No> adjacentes = new TreeMap(Collections.reverseOrder());
        adjacentes.putAll(atual.getArestas());

        for(Map.Entry<String,No> entry : adjacentes.entrySet()) {

            boolean empilhado = pilha.search(entry.getKey()) != -1;
            boolean visitado = visitados.containsKey(entry.getKey());

            if(!empilhado && !visitado){
                pilha.push(entry.getValue());
                pilha2.push(entry.getValue());
            }
        }
    }
}
