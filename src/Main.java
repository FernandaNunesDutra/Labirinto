public class Main {

    public static void main(String[] args) {

        int DIMENSAOX = 5;
        int DIMENSAOY = 5;

        //No[][] labirinto = Labirinto.montaLabirinto(DIMENSAOX, DIMENSAOY);
        No[][] labirinto =  Labirinto.montaLabirintoTeste();

        No inicio = labirinto[0][0];
        No fim = labirinto[2][3];

        System.out.printf("\nBACKTRACKING\n");
        Busca busca = new Backtracking(inicio, fim);
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
        System.out.printf("\n------------------------------------------------------------------------------------------------------------\n");


        System.out.printf("\nPROFUNDIDADE");
        Busca busca2 = new BuscaProfundidade(inicio, fim,100);
        busca2.inicia();
        busca2.getInicial();
        busca2.getFinal();
        busca2.inicia();
        busca2.caminho();
        busca2.numeroVisitados();
        busca2.nosVisitados();
        busca2.numeroAbertos();
        busca2.nosAbertos();
        busca2.tempoExecucao();
        busca2.valorMedioRam();
        busca2.getCusto();
        busca2.getProfundidade();
        System.out.printf("\n------------------------------------------------------------------------------------------------------------\n");

        System.out.printf("\nLARGURA");
        Busca busca3 = new BuscaLargura(inicio, fim);
        busca3.inicia();
        busca3.getInicial();
        busca3.getFinal();
        busca3.inicia();
        busca3.caminho();
        busca3.numeroVisitados();
        busca3.nosVisitados();
        busca3.numeroAbertos();
        busca3.nosAbertos();
        busca3.tempoExecucao();
        busca3.valorMedioRam();
        busca3.getCusto();
        busca3.getProfundidade();
        System.out.printf("\n------------------------------------------------------------------------------------------------------------\n");

        System.out.printf("\nGULOSA");
        Busca busca4 = new BuscaGulosa(inicio, fim);
        busca4.inicia();
        busca4.getInicial();
        busca4.getFinal();
        busca4.inicia();
        busca4.caminho();
        busca4.numeroVisitados();
        busca4.nosVisitados();
        busca4.numeroAbertos();
        busca4.nosAbertos();
        busca4.tempoExecucao();
        busca4.valorMedioRam();
        busca4.getCusto();
        busca4.getProfundidade();
        System.out.printf("\n------------------------------------------------------------------------------------------------------------\n");


        System.out.printf("\nA*");
        Busca busca6 = new BuscaAEstrela(inicio, fim);
        busca6.inicia();
        busca6.getInicial();
        busca6.getFinal();
        busca6.inicia();
        busca6.caminho();
        busca6.numeroVisitados();
        busca6.nosVisitados();
        busca6.numeroAbertos();
        busca6.nosAbertos();
        busca6.tempoExecucao();
        busca6.valorMedioRam();
        busca6.getCusto();
        busca6.getProfundidade();
        System.out.printf("\n------------------------------------------------------------------------------------------------------------\n");


        System.out.printf("\nIDA*");
        Busca busca7 = new BuscaIDAEstrela(inicio, fim);
        busca7.inicia();
        busca7.getInicial();
        busca7.getFinal();
        busca7.inicia();
        busca7.caminho();
        busca7.numeroVisitados();
        busca7.nosVisitados();
        busca7.numeroAbertos();
        busca7.nosAbertos();
        busca7.tempoExecucao();
        busca7.valorMedioRam();
        busca7.getCusto();
        busca7.getProfundidade();

        System.out.printf("\nORDENADA");
        Busca busca5 = new BuscaOrdenada(inicio, fim);
        busca5.inicia();
        busca5.getInicial();
        busca5.getFinal();
        busca5.inicia();
        busca5.caminho();
        busca5.numeroVisitados();
        busca5.nosVisitados();
        busca5.numeroAbertos();
        busca5.nosAbertos();
        busca5.tempoExecucao();
        busca5.valorMedioRam();
        busca5.getCusto();
        busca5.getProfundidade();
        System.out.printf("\n------------------------------------------------------------------------------------------------------------\n");

    }

}