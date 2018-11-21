public class Main {

    public static void main(String[] args) {

        No[][] labirinto = Labirinto.montaLabirinto();

        No inicio = labirinto[15][0];
        No fim = labirinto[67][93];

        Busca busca = new BuscaProfundidade(inicio, fim);
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