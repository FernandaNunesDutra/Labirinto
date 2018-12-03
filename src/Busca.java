import java.util.*;

public abstract  class Busca {

    int profundidade;
    long inicio;
    long fim;

    Map<String, String> pais = new HashMap<>();
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


     No buscaNoMenorHeuristica(Map<No, Double> nos){

        if(nos.isEmpty()) return null;

        No noMinimo = null;
        double valorMinimo = Double.MAX_VALUE;

        for (Map.Entry<No, Double> entry : nos.entrySet()) {

            No no = entry.getKey();
            double valor = heuristica(no, objetivo);

            if(valor < valorMinimo){
                noMinimo = no;
                valorMinimo = valor;
            }
        }

        return  noMinimo;
    }


    protected void getProfundidade(){
        System.out.printf("\nProfundidade: %s", profundidade);
    }

    protected abstract boolean busca(No atual);

    protected void caminho(){
        System.out.println("\nCaminho:");

        String noId = objetivo.getId();

        while (noId!=null && !noId.equals(inicial.getId())){
            System.out.println(noId);
            noId = pais.get(noId);
        }

        System.out.println(inicial.getId());
    }

    protected void getCusto(){

        int custo = 0;
        String noId = objetivo.getId();

        while (noId != null && !noId.equals(inicial.getId())){
            noId = pais.get(noId);
            custo++;
        }

        System.out.printf("\nCusto: %d", custo);
    }

    protected void valorMedioRam(){

        int ramificacao = (visitados.size() + abertos.size())/ visitados.size();

        System.out.println("\nValor Médio de Ramificação: " + ramificacao);
    }

    void getInicial(){
        System.out.printf("\nInício: %s", inicial.getId());
    }

    void getFinal(){
        System.out.printf("\nFim: %s", objetivo.getId());
    }

    double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
