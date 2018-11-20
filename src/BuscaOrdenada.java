public class BuscaOrdenada extends Busca {
    BuscaOrdenada(No inicial, No objetivo) {
        super(inicial, objetivo);
    }

    @Override
    protected boolean busca(No atual) {
        return false;
    }

    @Override
    protected void caminho() {

    }
}
