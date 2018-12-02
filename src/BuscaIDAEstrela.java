import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

class BuscaIDAEstrela extends Busca{


    private int patamarMaximo;

    BuscaIDAEstrela(No inicial, No objetivo, int patamarMaximo) {
        super(inicial, objetivo);

        this.patamarMaximo = patamarMaximo;
    }

    @Override
    protected boolean busca(No atual) {

        int patamar = 2;

        while (true){

            Busca busca = new BuscaAEstrela(inicial, objetivo, patamar);

            if(patamar == patamarMaximo)
                return false;

            if(busca.busca(inicial))
                return true;

            patamar++;
        }
    }

    @Override
    protected void caminho() {

    }
}