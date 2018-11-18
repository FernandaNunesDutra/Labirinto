import java.util.*;

public class BuscaLargura extends Busca {

    private Queue<No> fila = new ArrayDeque<>();
    private Map<String, String> pais = new HashMap<>();

     BuscaLargura(No inicial, No objetivo) {
        super(inicial, objetivo);
    }

    @Override
    protected boolean busca(No atual) {

        if (atual == null)
            return false;

        abertos.add(atual.getId());

        if (atual == objetivo)
            return true;

        enfileirar(atual);

        return busca(buscaProximo());
    }

    @Override
    protected void caminho() {
        System.out.println("\nCaminho:");

        String noId = objetivo.getId();

        while (!noId.equals(inicial.getId())){
            System.out.println(noId);
            noId = pais.get(noId);
        }

        System.out.println(inicial.getId());
    }

    private No buscaProximo() {
        if (fila.isEmpty())
            return null;

        return fila.remove();
    }

    private void enfileirar(No atual) {
        Map<String, No> adjacentes = new TreeMap<>(atual.getArestas());

        for (Map.Entry<String, No> entry : adjacentes.entrySet()) {

            boolean empilhado = fila.contains(entry.getValue());
            boolean aberto = abertos.contains(entry.getKey());

            if (!empilhado && !aberto) {
                fila.add(entry.getValue());
                visitados.add(entry.getKey());
                pais.put(entry.getKey(), atual.getId());
            }
        }
    }
}
