public class Main {

    public static void main(String[] args) {

        int DIMENSAOX = 10000;
        int DIMENSAOY = 10000;

        No[][] labirinto = Labirinto.montaLabirinto(DIMENSAOX, DIMENSAOY);

        No inicio = labirinto[0][0];
        No fim = labirinto[DIMENSAOX-1][DIMENSAOY-1];

        Busca busca = new BuscaIDAEstrela(inicio, fim);
        busca.inicia();
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
        busca.getProfundidade();
    }

}