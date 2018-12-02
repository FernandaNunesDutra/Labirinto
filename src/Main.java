public class Main {

    public static void main(String[] args) {

        No[][] labirinto = Labirinto.montaLabirinto();

        No inicio = labirinto[0][0];
        No fim = labirinto[499][499];

        Busca busca = new BuscaAEstrela(inicio, fim, Integer.MAX_VALUE);
        busca.getInicial();
        busca.getFinal();
        busca.inicia();
        busca.caminho();
        busca.numeroVisitados();
        busca.nosVisitados();
        busca.numeroAbertos();
        busca.nosAbertos();
        busca.tempoExecucao();
    }

}