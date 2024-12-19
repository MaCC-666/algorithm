package pattern;

import java.awt.*;
import java.util.List;

public class test1 {
    public static void dfs(Vertex vertex){

        System.out.println(vertex.name);
        vertex.pass=true;
        for (Edge edge : vertex.edges) {
            if(!edge.linked.pass){
                dfs(edge.linked);
            }
        }
    }
    public static void main(String[] args) {
        Vertex a=new Vertex("a");
        Vertex b=new Vertex("b");
        Vertex c=new Vertex("c");
        Vertex d=new Vertex("d");
        a.edges.add(new Edge(b));
        a.edges.add(new Edge(c));
        b.edges.add(new Edge(d));
        c.edges.add(new Edge(d));
        dfs(a);
    }
}
//        if(vertex.pass){
//            System.out.println(vertex.name);
//        }
//        vertex.pass=true;
//        for (Edge edge : vertex.edges) {
//            dfs(edge.linked);
//        }