import java.util.Random;

class Labirinto {

    private static int RANDOM = 101;
    private static No[][] labirinto;

    static No[][] montaLabirintoTeste(){

        labirinto = new No[5][5];

        labirinto[0][0] = new No("A", 0, 0);
        labirinto[1][0] = new No("B", 1, 0);
        labirinto[2][0] = new No("C", 2, 0);
        labirinto[3][0] = new No("D", 3, 0);
        labirinto[4][0] = new No("E", 4, 0);
        labirinto[0][1] = new No("F", 0, 1);
        labirinto[1][1] = new No("G", 1, 1);
        labirinto[2][1] = new No("H", 2, 1);
        labirinto[3][1] = new No("I", 3, 1);
        labirinto[4][1] = new No("J", 4, 1);
        labirinto[0][2] = new No("K", 0, 2);
        labirinto[1][2] = new No("L", 1, 2);
        labirinto[2][2] = new No("M", 2, 2);
        labirinto[3][2] = new No("N", 3, 2);
        labirinto[4][2] = new No("O", 4, 2);
        labirinto[0][3] = new No("P", 0, 3);
        labirinto[1][3] = new No("Q", 1, 3);
        labirinto[2][3] = new No("R", 2, 3);
        labirinto[3][3] = new No("S", 3, 3);
        labirinto[4][3] = new No("T", 4, 3);
        labirinto[0][4] = new No("U", 0, 4);
        labirinto[1][4] = new No("V", 1, 4);
        labirinto[2][4] = new No("X", 2, 4);
        labirinto[3][4] = new No("X", 3, 4);
        labirinto[4][4] = new No("Z", 4, 4);

        labirinto[0][0].addAresta(labirinto[1][0]);
        labirinto[1][0].addAresta(labirinto[0][0]);

        labirinto[0][0].addAresta(labirinto[0][1]);
        labirinto[0][1].addAresta(labirinto[0][0]);

        labirinto[1][0].addAresta(labirinto[1][1]);
        labirinto[1][1].addAresta(labirinto[1][0]);

        labirinto[1][1].addAresta(labirinto[2][1]);
        labirinto[2][1].addAresta(labirinto[1][1]);

        labirinto[2][0].addAresta(labirinto[2][1]);
        labirinto[2][1].addAresta(labirinto[2][0]);


        labirinto[2][0].addAresta(labirinto[3][0]);
        labirinto[3][0].addAresta(labirinto[2][0]);

        labirinto[3][0].addAresta(labirinto[4][0]);
        labirinto[4][0].addAresta(labirinto[3][0]);

        labirinto[4][0].addAresta(labirinto[4][1]);
        labirinto[4][1].addAresta(labirinto[4][0]);

        labirinto[4][1].addAresta(labirinto[4][2]);
        labirinto[4][2].addAresta(labirinto[4][1]);

        labirinto[4][2].addAresta(labirinto[3][2]);
        labirinto[3][2].addAresta(labirinto[4][2]);

        labirinto[4][2].addAresta(labirinto[4][3]);
        labirinto[4][3].addAresta(labirinto[4][2]);

        labirinto[3][2].addAresta(labirinto[3][1]);
        labirinto[3][1].addAresta(labirinto[3][2]);

        labirinto[3][2].addAresta(labirinto[3][3]);
        labirinto[3][3].addAresta(labirinto[3][2]);

        labirinto[2][2].addAresta(labirinto[1][2]);
        labirinto[1][2].addAresta(labirinto[2][2]);

        labirinto[2][2].addAresta(labirinto[2][3]);
        labirinto[2][3].addAresta(labirinto[2][2]);

        labirinto[1][2].addAresta(labirinto[1][3]);
        labirinto[1][3].addAresta(labirinto[1][2]);

        labirinto[1][2].addAresta(labirinto[0][2]);
        labirinto[0][2].addAresta(labirinto[1][2]);

        labirinto[0][2].addAresta(labirinto[0][3]);
        labirinto[0][3].addAresta(labirinto[0][2]);

        labirinto[0][3].addAresta(labirinto[0][4]);
        labirinto[0][4].addAresta(labirinto[0][3]);

        labirinto[0][4].addAresta(labirinto[1][4]);
        labirinto[1][4].addAresta(labirinto[0][4]);

        labirinto[2][3].addAresta(labirinto[1][3]);
        labirinto[1][3].addAresta(labirinto[2][3]);

        labirinto[3][3].addAresta(labirinto[2][3]);
        labirinto[2][3].addAresta(labirinto[3][3]);

        labirinto[3][3].addAresta(labirinto[3][4]);
        labirinto[3][4].addAresta(labirinto[3][3]);

        labirinto[3][4].addAresta(labirinto[2][4]);
        labirinto[2][4].addAresta(labirinto[3][4]);

        labirinto[4][3].addAresta(labirinto[4][4]);
        labirinto[4][4].addAresta(labirinto[4][3]);

        labirinto[0][2].addAresta(labirinto[0][1]);
        labirinto[0][1].addAresta(labirinto[0][2]);


        return labirinto;
    }

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

        return numero < 85 && index < max ;
    }


}
