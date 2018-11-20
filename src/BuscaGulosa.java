public class BuscaGulosa extends Busca {
    BuscaGulosa(No inicial, No objetivo) {
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
