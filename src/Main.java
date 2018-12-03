public class Main {

    public static void main(String[] args) {

        int DIMENSAOX = 5;
        int DIMENSAOY = 5;

        //No[][] labirinto = Labirinto.montaLabirinto(DIMENSAOX, DIMENSAOY);
        No[][] labirinto =  Labirinto.montaLabirintoTeste();

        No inicio = labirinto[0][0];
        No fim = labirinto[2][3];

        System.out.printf("\nGULOSA");
        Busca busca4 = new BuscaGulosa(inicio, fim);
        busca4.inicia();
        busca4.getInicial();
        busca4.getFinal();
        busca4.caminho();
        busca4.numeroVisitados();
        busca4.nosVisitados();
        busca4.numeroAbertos();
        busca4.nosAbertos();
        busca4.tempoExecucao();
        busca4.valorMedioRam();
        busca4.getCusto();
        busca4.getProfundidade();
        System.out.printf("\n------------------------------------------------------------------------------------------------------------\n");    }

}