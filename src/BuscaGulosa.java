import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BuscaGulosa {// extends Busca {

//    private Stack<No> guloso = new Stack<>();
//    private Map<String, Double> valorHeuristica = new HashMap<>();
//    private int DimensaoX, DimensaoY;
//
//    BuscaGulosa(No inicial, No objetivo, int DimensaoX, int DimensaoY) {
//
//        super(inicial, objetivo);
//        this.DimensaoX = DimensaoX;
//        this.DimensaoY = DimensaoY;
//    }
//
//    @Override
//    protected boolean busca(No atual) {
//
//        if(atual == null) return false;
//
//        if(atual == objetivo) return true;
//
//        abertos.add(atual.getId());
//        empilhar(atual);
//
//        atual = buscaProximo(atual);
//
//        return busca(atual);
//
//    }
//
//    @Override
//    protected void caminho() {
//        System.out.println("Caminho:");
//        System.out.println(guloso);
//    }
//
//    private No buscaProximo(No atual) {
//        double min = Double.MAX_VALUE;
//        if (guloso.isEmpty()){
//            return null;}
//        else {
//
//            if (atual.getArestas().size() == 0) {
//
//                return null;
//            }
//
//            for (Map.Entry<String, No> entry : atual.getArestas().entrySet()) {
//                double valor = valorHeuristica.get(entry.getKey());
//                if (valor < min) {
//                    min = valor;
//
//                }
//
//            }
//
//            return atual;
//        }
//    }
//
//
//    private void empilhar(No atual) {
//        for(No no : atual.getArestas()){
//
//        }
//    }
//
//
//    private void calculaHeuristica(No objetivo) {
//
//        for (int i = 0; i < DimensaoX; i++) {
//            for (int j = 0; j < DimensaoY; j++) {
//                //String id = String.format("%d%d", i+1, j+1);
//                No no = Main.labirinto[i][j];
//                double dist = heuristica(no, objetivo);
//                valorHeuristica.put(no.getId(), dist);
//            }
//        }
//
//    }
}
