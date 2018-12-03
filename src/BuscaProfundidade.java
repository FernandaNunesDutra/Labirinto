import java.util.*;

public class BuscaProfundidade extends Busca {

    private int profundidadeMaxima;
    private Stack<No> pilha = new Stack<>();

    BuscaProfundidade(No inicial, No objetivo, int profundidade) {
        super(inicial, objetivo);
        this.profundidadeMaxima = profundidade;
    }

    @Override
    protected void inicia(){
        pilha.push(inicial);
        super.inicia();
    }

    @Override
    protected boolean busca(No atual){

        while (true){
            if(atual == null)
                return false;

            if(atual.getId() == objetivo.getId()) {
                return true;
            }

            visitados.add(atual.getId());
            empilha(atual);

            atual = buscaProximo();

        }
    }

    private No buscaProximo(){
        if (pilha.isEmpty())
            return null;

        No no = pilha.pop();
        if(visitados.contains(no.getId())){
            profundidade--;
        }

        return no;
    }

    private void empilha(No atual){

        if(profundidade == profundidadeMaxima)
            return;

        Map<String, No> adjacentes = new TreeMap<>(Collections.reverseOrder());
        adjacentes.putAll(atual.getArestas());
        profundidade++;

        for(Map.Entry<String,No> entry : adjacentes.entrySet()) {

            boolean empilhado = pilha.search(entry.getKey()) != -1;
            boolean aberto = abertos.contains(entry.getKey());

            if(!empilhado && !aberto){
                pilha.push(entry.getValue());
                pais.put(entry.getKey(), atual.getId());
                abertos.add(entry.getKey());
            }
        }
    }
}
