import java.util.*;

public class BuscaProfundidade extends Busca {

    private Stack<No> pilha = new Stack<>();
    private int profundidade;
    private int profundidadeAtual;


    BuscaProfundidade(No inicial, No objetivo, int profundidade) {
        super(inicial, objetivo);
        this.profundidadeAtual = 0;
        this.profundidade = profundidade;
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

    @Override
    protected void caminho() {
        System.out.println("Caminho:");
        System.out.println(pilha);
    }

    private No buscaProximo(){
        if (pilha.isEmpty())
            return null;

        No no = pilha.pop();
        if(visitados.contains(no.getId())){
            profundidadeAtual--;
        }

        return no;
    }

    private void empilha(No atual){

        if(profundidadeAtual == profundidade)
            return;

        Map<String, No> adjacentes = new TreeMap<>(Collections.reverseOrder());
        adjacentes.putAll(atual.getArestas());
        profundidadeAtual++;

        for(Map.Entry<String,No> entry : adjacentes.entrySet()) {

            boolean empilhado = pilha.search(entry.getKey()) != -1;
            boolean aberto = abertos.contains(entry.getKey());

            if(!empilhado && !aberto){
                pilha.push(entry.getValue());
                abertos.add(entry.getKey());
            }
        }
    }
}
