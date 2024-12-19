package pattern;
import java.util.ArrayList;
import java.util.List;
public class Vertex {
    public String name;
    //jdk版本不一致,要对edges先初始化
    public List<Edge> edges;
    Boolean pass=false;

    public Vertex(String name) {
        this.name = name;
        this.edges=new ArrayList<>();
    }

    public Vertex(String name, List<Edge> edges) {
        this.name = name;
        this.edges = edges;
    }

    public String getName() {
        return name;
    }

}
