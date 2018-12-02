import java.util.Random;

class Labirinto {

    private static int RANDOM = 101;
//    private static int DIMENSAOX = 10;
//    private static int DIMENSAOY = 10;
    private static No[][] labirinto;

     static No[][] montaLabirinto(int DIMENSAOX, int DIMENSAOY) {

        labirinto = new No[DIMENSAOX][DIMENSAOY];

        for (int i = 0; i < DIMENSAOX; i++) {
            for (int j = 0; j < DIMENSAOY; j++) {
                String id = String.format("%d%d", i+1, j+1);
                labirinto[i][j] = new No(id, i, j);
            }
        }

        for (int i = 0; i < DIMENSAOX; i++) {
            for (int j = 0; j < DIMENSAOY; j++) {

                if (adiciona(i+1, DIMENSAOX)) {
                    labirinto[i][j].addAresta(labirinto[i + 1][j]);
                    labirinto[i + 1][j].addAresta(labirinto[i][j]);
                }

                if (adiciona(j+1, DIMENSAOY)) {
                    labirinto[i][j].addAresta(labirinto[i][j + 1]);
                    labirinto[i][j + 1].addAresta(labirinto[i][j]);
                }

            }
        }

        return labirinto;
    }

    private static boolean adiciona(int index, int max){
        double numero = Math.random() * RANDOM;

        return numero < 95 && index < max ;
    }


}
