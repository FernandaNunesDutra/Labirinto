import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

class BuscaIDAEstrela extends Busca{

    private static Stack<No> pilha = new Stack<>();
    private static Stack<Double> descartados = new Stack<>();
    private static Map<String, Double> pesoCaminho = new TreeMap<>();
    private static int numeroArvores = 0;
    private Double patamar;

    BuscaIDAEstrela(No inicial, No objetivo) {
        super(inicial, objetivo);
        patamar = round(heuristica(inicial, objetivo), 2);

    }
    @Override
    protected int getCusto(){


        int custo = pilha.size();
        System.out.printf("\nCusto: %d", custo);

        return custo;
    }
    @Override
    protected void inicia(){

        inicio = System.currentTimeMillis();
        boolean resultadoBusca=false;
        while(resultadoBusca==false && patamar!=-1.0 ){
            numeroArvores++;

            pesoCaminho.put(inicial.getId(),0.0);
            resultadoBusca = busca(inicial);
            if(resultadoBusca==false){

                patamar = getMin();
                pilha.clear();
                descartados.clear();
                pesoCaminho.clear();
                abertos.clear();
                visitados.clear();
            }
        }
            System.out.println("Numero de arvores: "+numeroArvores);
        if(resultadoBusca){
            System.out.println("Caminho encontrado.");
        }else {
            System.out.println("Caminho não encontrado.");
        }

        fim = System.currentTimeMillis();
    }
    private Double getMin(){
        if(descartados.empty())
            return -1.0;
        Double aux,min = Double.POSITIVE_INFINITY;
        while(!descartados.isEmpty()) {
            aux = descartados.pop();

            if(aux< min )
                min = aux;

        }
        return min;
    }
    @Override
    protected boolean busca(No atual){
        while(true) {
            Double totalHeuristica = round(heuristica(inicial, objetivo), 2) + pesoCaminho.get(atual.getId());

            if (atual == objetivo && totalHeuristica <= patamar)
                return true;

            visitados.add(atual.getId());
            abertos.add(atual.getId());
            No proximo = buscaProximo(atual);
            if (proximo == null || totalHeuristica > patamar) {


                if (pilha.empty())
                    return false;
                if (totalHeuristica > patamar) {
                    descartados.add(totalHeuristica);
                }
                proximo = pilha.pop();

            } else {

                pilha.push(atual);
                pesoCaminho.put(proximo.getId(), (pesoCaminho.get(atual.getId()) + 1.0));

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
        No noAux=null;
        Double valorNo = Double.MAX_VALUE;
        for(Map.Entry<String,No> entry : treeMap.entrySet()) {

            String key = entry.getKey();

            if(!abertos.contains(key)){
                double heuristicaAux = round(heuristica(entry.getValue(), objetivo), 2);
                if(heuristicaAux < valorNo) {
                    noAux = entry.getValue();
                    valorNo = heuristicaAux;
                }
            }

        }
        return noAux;

    }
}