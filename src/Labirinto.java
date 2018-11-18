import java.util.ArrayList;

public class Labirinto {

    public static void main(String[] args) {

        No a = new No("A", 1);
        No b = new No("B", 1);
        No c = new No("C", 1);
        No d = new No("D", 1);
        No e = new No("E", 1);
        No f = new No("F", 1);
        No g = new No("G", 1);
        No h = new No("H", 1);
        No i = new No("I", 1);
        No j = new No("J", 1);
        No k = new No("K", 1);
        No l = new No("L", 1);
        No m = new No("M", 1);
        No n = new No("N", 1);
        No o = new No("O", 1);
        No p = new No("P", 1);
        No q = new No("Q", 1);
        No r = new No("R", 1);
        No s = new No("S", 1);

        a.addAresta(b);
        a.addAresta(e);
        b.addAresta(a);
        b.addAresta(c);
        c.addAresta(b);
        c.addAresta(d);
        d.addAresta(c);
        d.addAresta(h);
        e.addAresta(a);
        e.addAresta(i);
        f.addAresta(g);
        f.addAresta(j);
        g.addAresta(f);
        g.addAresta(h);
        h.addAresta(d);
        h.addAresta(g);
        i.addAresta(e);
        i.addAresta(n);
        i.addAresta(j);
        j.addAresta(f);
        j.addAresta(l);
        j.addAresta(o);
        l.addAresta(g);
        l.addAresta(j);
        l.addAresta(m);
        m.addAresta(l);
        m.addAresta(q);
        n.addAresta(i);
        q.addAresta(m);
        q.addAresta(p);
        p.addAresta(s);
        p.addAresta(o);
        p.addAresta(q);
        o.addAresta(p);
        o.addAresta(j);
        o.addAresta(r);

        BuscaProfundidade.inicia(a,d);
    }

}