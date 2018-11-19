import java.util.*;

public class Labirinto {

    public static void main(String[] args) {

        int DIMENSAO = 30;

        Random random = new Random(101);
        No[][] labirinto = new No[10][6];
        List<No> nos = new ArrayList<>();

        String id ="A";
        for(int i=0; i<10; i++){
            for(int j=0; j<6; j++){
                labirinto[i][j] = new No(id, i, j);
                id = id + 1;
            }
        }

        for(int i=0; i<10; i++){
            for(int j=0; j<6; j++) {

                int r1 = random.nextInt();
                int r2 = random.nextInt();

                if (i < 10 && r1 < 80) {
                    labirinto[i][j].addAresta(labirinto[i + 1][j]);
                    labirinto[i + 1][j].addAresta(labirinto[i][j]);
                }

                if (j < 6 && r2 < 80) {
                    labirinto[i][j].addAresta(labirinto[i][j + 1]);
                    labirinto[i][j + 1].addAresta(labirinto[i][j]);

                }
            }
        }


//        Busca busca = new BuscaLargura(a,d);
//        busca.inicia();
//        busca.caminho();
//        busca.numeroVisitados();
//        busca.nosVisitados();
//        busca.numeroAbertos();
//        busca.nosAbertos();
//        busca.tempoExecucao();
    }

}