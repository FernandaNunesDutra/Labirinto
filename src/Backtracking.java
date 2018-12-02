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

        if(atual == objetivo)
            return true;

        abertos.add(atual.getId());
        No proximo = buscaProximo(atual);

        if(proximo == null){

            if(pilha.empty())
                return false;

            proximo = pilha.pop();
            profundidade--;

            System.out.println("back");

        } else {

            pilha.push(atual);

        }

        return busca(proximo);

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

            if(abertos.contains(key)){

                return entry.getValue();
            }

        }

        return null;
    }
}