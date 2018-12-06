import org.omg.CORBA.INTERNAL;

public class Main {

    public static void main(String[] args) {

        int DIMENSAOX = 500;
        int DIMENSAOY = 500;

        No[][] labirinto = Labirinto.montaLabirinto(DIMENSAOX, DIMENSAOY);
        //No[][] labirinto =  Labirinto.montaLabirintoTeste();

        No inicio = labirinto[0][0];
        No fim = labirinto[335][27];

        System.out.println(DIMENSAOX);
        System.out.println(DIMENSAOY);


        System.out.printf("\nIDA*");
        Busca busca7 = new BuscaGulosa(inicio, fim);
        busca7.inicia();
        busca7.getInicial();
        busca7.getFinal();
//busca7.caminho();
        busca7.numeroVisitados();
//busca7.nosVisitados();
        busca7.numeroAbertos();
//busca7.nosAbertos();
        busca7.tempoExecucao();
        busca7.valorMedioRam();
        busca7.getCusto();
        busca7.getProfundidade();
        Busca busca6 = new BuscaLargura(inicio, fim);
        busca6.inicia();
        busca6.getInicial();
        busca6.getFinal();
//busca7.caminho();
        busca6.numeroVisitados();
//busca7.nosVisitados();
        busca6.numeroAbertos();
//busca7.nosAbertos();
        busca6.tempoExecucao();
        busca6.valorMedioRam();
        busca6.getCusto();
        busca6.getProfundidade();

    }

}