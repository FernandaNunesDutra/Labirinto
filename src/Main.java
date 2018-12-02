public class Main {

    public static void main(String[] args) {

        No[][] labirinto = Labirinto.montaLabirinto();

        No inicio = labirinto[0][0];
        No fim = labirinto[5][5];

        Busca busca = new BuscaIDAEstrela(inicio, fim);
        busca.getInicial();
        busca.getFinal();
        busca.inicia();
        busca.caminho();
        busca.numeroVisitados();
        busca.nosVisitados();
        busca.numeroAbertos();
        busca.nosAbertos();
        busca.tempoExecucao();
        busca.valorMedioRam();
        busca.getCusto();
    }

}