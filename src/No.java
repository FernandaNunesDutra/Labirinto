import java.util.HashMap;
import java.util.Map;

public class No {

    private String id;
    private int peso;
    private Map<String, No> arestas;

    public No(String id, int peso) {
        this.id = id;
        this.peso = peso;
        arestas = new HashMap<String, No>();
    }

    public No(String id, int peso, Map<String, No> arestas) {
        this.id = id;
        this.peso = peso;
        this.arestas = arestas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public Map<String, No> getArestas() {
        return arestas;
    }

    public void setArestas(Map<String, No> arestas) {
        this.arestas = arestas;
    }

    public void addAresta(No no){
        arestas.put(no.getId(), no);
    }
}