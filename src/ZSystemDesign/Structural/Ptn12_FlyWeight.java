package ZSystemDesign.Structural;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
    /**
     Flyweight pattern used to minimize memory usage by sharing as much data as possible with similar objects.

     It separates the intrinsic (shared) state from the extrinsic (unique) state,
     so that shared parts of objects are stored only once and reused wherever needed.

     Trade Off:
     Adds complexity (especially around factory and object management).
     Harder to debug due to shared state.
     It can lead to tight coupling between flyweight and client code if not designed carefully.
     */

public class Ptn12_FlyWeight {
    public static void main(String[] args) {
        Forest forest = new Forest();

        // Planting 1 million trees
        for(int i = 0; i < 1000000; i++) {
            forest.plantTree(i, i, "Oak", "Green", "Rough");
        }

        System.out.println("Planted 1 million trees.");
    }
}

// ============= TreeType Class ================
class TreeType {
    // Properties that are common among all trees of this type
    private String name;
    private String color;
    private String texture;

    public TreeType(String name, String color, String texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    public void draw(int x, int y) {
        System.out.println("Drawing " + name + " tree at (" + x + ", " + y + ")");
    }
}


// ================ Tree Class =================
class Tree {
    // Attributes that keep on changing
    private int x;
    private int y;

    // Attributes that remain constant
    private TreeType treeType;

    public Tree(int x, int y, TreeType treeType) {
        this.x = x;
        this.y = y;
        this.treeType = treeType;
    }

    public void draw() {
        treeType.draw(x, y);
    }
}


// ============ TreeFactory Class ==============
class TreeFactory {

    static Map<String, TreeType> treeTypeMap = new HashMap<>();

    public static TreeType getTreeType(String name, String color, String texture) {
        String key = name + " - " + color + " - " + texture;

        if (!treeTypeMap.containsKey(key)) {
            treeTypeMap.put(key, new TreeType(name, color, texture));
        }
        return treeTypeMap.get(key);
    }
}


// ================ Forest Class =================
class Forest {
    private List<Tree> trees = new ArrayList<>();

    public void plantTree(int x, int y, String name, String color, String texture) {
        Tree tree = new Tree(x, y, TreeFactory.getTreeType(name, color, texture));
        trees.add(tree);
    }

    public void draw() {
        for (Tree tree : trees) {
            tree.draw();
        }
    }
}
