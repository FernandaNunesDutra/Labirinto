import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Labirinto {

    private static int DIMENSAOX = 10;
    private static int DIMENSAOY = 6;
    private static int RANDOM = 101;
    private static String id = "A";
    private static No[][] labirinto;

    public static No[][] montaLabirinto() {

        Random random = new Random(RANDOM);
        labirinto = new No[DIMENSAOX][DIMENSAOY];

        for (int i = 0; i < DIMENSAOX; i++) {
            for (int j = 0; j < DIMENSAOY; j++) {
                labirinto[i][j] = new No(id, i, j);
                id = id + 1;
            }
        }

        for (int i = 0; i < DIMENSAOX; i++) {
            for (int j = 0; j < DIMENSAOY; j++) {

                No no = labirinto[i][j];

                if (adiciona(i, DIMENSAOX)) {
                    no.addAresta(labirinto[i + 1][j]);
                    labirinto[i + 1][j].addAresta(labirinto[i][j]);
                }

                if (adiciona(j, DIMENSAOY)) {
                    no.addAresta(labirinto[i][j + 1]);
                    labirinto[i][j + 1].addAresta(labirinto[i][j]);

                }
            }
        }

        return labirinto;
    }

    private static boolean adiciona(int index, int max){
        Random random = new Random(RANDOM);
        int numero = random.nextInt();

        return numero < 85 && index < max;
    }


}
