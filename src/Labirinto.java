import java.util.Random;

class Labirinto {

    private static int DIMENSAOX = 100;
    private static int DIMENSAOY = 100;
    private static int RANDOM = 101;
    private static No[][] labirinto = new No[DIMENSAOX][DIMENSAOY];

     static No[][] montaLabirinto() {

         char a = 'a';
         char b = (char)(a+45);
         System.out.println(b);

        Random random = new Random(RANDOM);
        labirinto = new No[DIMENSAOX][DIMENSAOY];

        for (int i = 0; i < DIMENSAOX; i++) {
            for (int j = 0; j < DIMENSAOY; j++) {
                String id = String.format("%d%d", i+1, j+1);
                labirinto[i][j] = new No(id, i, j);
            }
        }

        for (int i = 0; i < DIMENSAOX; i++) {
            for (int j = 0; j < DIMENSAOY; j++) {

                No no = labirinto[i][j];

                //System.out.printf("\nNO -> %s -> %d . %d", no.getId(), i , j);
                //System.out.printf("\nARESTAS");

                if (adiciona(i+1, DIMENSAOX)) {
                    labirinto[i][j].addAresta(labirinto[i + 1][j]);
                    labirinto[i + 1][j].addAresta(labirinto[i][j]);

                    //System.out.printf("\n%s-> %s", no.getId(), labirinto[i + 1][j].getId());
                }

                if (adiciona(j+1, DIMENSAOY)) {
                    labirinto[i][j].addAresta(labirinto[i][j + 1]);
                    labirinto[i][j + 1].addAresta(labirinto[i][j]);
                    //System.out.printf("\n%s-> %s", no.getId(), labirinto[i][j + 1].getId());
                }

                //System.out.println("\n\n");
            }
        }

        return labirinto;
    }

    private static boolean adiciona(int index, int max){
        Random random = new Random(RANDOM);
        int numero = random.nextInt();

        return numero < 85 && index < max ;
    }


}
