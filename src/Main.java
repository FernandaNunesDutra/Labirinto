import org.omg.CORBA.INTERNAL;

public class Main {

    public static void main(String[] args) {

        int DIMENSAOX = 100;
        int DIMENSAOY = 100;

        No[][] labirinto = Labirinto.montaLabirinto(DIMENSAOX, DIMENSAOY);
        //No[][] labirinto =  Labirinto.montaLabirintoTeste();

        No inicio = labirinto[0][0];
        No fim = labirinto[32][27];

        System.out.println(DIMENSAOX);
        System.out.println(DIMENSAOY);


        System.out.printf("\nIDA*");
        Busca busca7 = new BuscaIDAEstrela(inicio, fim);
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

    }

}