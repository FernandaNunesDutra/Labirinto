import java.util.*;

public class BuscaProfundidade extends Busca {

    private Stack<No> pilha = new Stack<>();
    int empilhados;
    BuscaProfundidade(No inicial, No objetivo) {
        super(inicial, objetivo);
    }

    @Override
    protected void inicia(){
        pilha.push(inicial);
        super.inicia();
    }

    @Override
    protected boolean busca(No atual){

        if(atual == null)
            return false;

        if(atual.getId() == objetivo.getId()) {
            return true;
        }

        abertos.add(atual.getId());
        empilha(atual);

        atual = buscaProximo();

        return busca(atual);
    }

    @Override
    protected void caminho() {
        System.out.println("Caminho:");
        System.out.println(pilha);
    }

    private No buscaProximo(){
        if (pilha.isEmpty())
            return null;

        return pilha.pop();
    }

    private void empilha(No atual){

        Map<String, No> adjacentes = new TreeMap<>(Collections.reverseOrder());
        adjacentes.putAll(atual.getArestas());

        System.out.println(empilhados);

        for(Map.Entry<String,No> entry : adjacentes.entrySet()) {

            boolean empilhado = pilha.search(entry.getKey()) != -1;
            boolean aberto = abertos.contains(entry.getKey());

            if(!empilhado && !aberto){
                empilhados++;
                pilha.push(entry.getValue());
                visitados.add(entry.getKey());
            }
        }
    }
}
