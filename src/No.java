import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class No {

    private int x;
    private int y;
    private String id;
    private int peso;
    private Map<String, No> arestas;

    No(String id, int x, int y) {
        this.x = x;
        this.y = y;
        this.id = id;
        arestas = new HashMap<>();
    }

    No(String id) {
        this.id = id;
        arestas = new HashMap<>();
    }

    String getId() {
        return id;
    }

    public int getPeso() {
        return peso;
    }

    Map<String, No> getArestas() {
        return arestas;
    }

    void addAresta(No no){
        arestas.put(no.getId(), no);
    }

    public int getX() { return x; }

    public int getY() { return y; }

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
