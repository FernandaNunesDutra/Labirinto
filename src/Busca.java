import java.util.HashSet;
import java.util.Set;

public abstract  class Busca {

    private long inicio;
    private long fim;

    Set<String> visitados = new HashSet<>();
    Set<String> abertos = new HashSet<>();
    No objetivo;
    No inicial;

    Busca(No inicial, No objetivo) {
        this.objetivo = objetivo;
        this.inicial = inicial;
    }

    protected void inicia(){

        inicio = System.currentTimeMillis();

        if(busca(inicial)){
            System.out.println("\nCaminho encontrado.");
        }else {
            System.out.println("\nCaminho não encontrado.");
        }

        fim = System.currentTimeMillis();
    }

    void tempoExecucao(){
        System.out.printf("\nTempo execucao: %dms", fim - inicio);
    }

    void numeroVisitados(){
        System.out.printf("\nNúmero de visitados: %d", visitados.size());
    }

    void nosVisitados(){
        System.out.println("\nVisitados: ");
        System.out.print(visitados);
    }

    void numeroAbertos(){
        System.out.printf("\nNúmero de abertos: %d", abertos.size());
    }

    void nosAbertos(){
        System.out.println("\nAbertos: ");
        System.out.print(abertos);
    }

    double heuristica(No noInicial, No noFinal){
        double distanciaX = Math.pow(noFinal.getX() - noInicial.getX(), 2);
        double distanciaY = Math.pow(noFinal.getY() - noInicial.getY(), 2);
        double euclideana = Math.sqrt(distanciaX + distanciaY);

        return euclideana;
    }

    void getInicial(){
        System.out.printf("\nInício: %s", inicial.getId());
    }

    void getFinal(){
        System.out.printf("\nFim: %s", objetivo.getId());
    }

    protected abstract boolean busca(No atual);

    protected abstract void caminho();

}
