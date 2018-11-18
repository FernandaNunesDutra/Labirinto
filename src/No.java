import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class No {

    private String id;
    private int peso;
    private Map<String, No> arestas;

    public No(String id, int peso) {
        this.id = id;
        this.peso = peso;
        arestas = new HashMap<>();
    }

    public No(String id, int peso, Map<String, No> arestas) {
        this.id = id;
        this.peso = peso;
        this.arestas = arestas;
    }

    public String getId() {
        return id;
    }

    public int getPeso() {
        return peso;
    }

    public Map<String, No> getArestas() {
        return arestas;
    }

    public void addAresta(No no){
        arestas.put(no.getId(), no);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        No no = (No) o;
        return Objects.equals(id, no.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return id;
    }
}
