//import org.jetbrains.annotations.NotNull;
package com.example.honeycombmaze;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.valueOf;

public class NodeCollection {

    private ArrayList<Node> nodes;
/****************************************************/
/*************    SUPPORT MAP BUILDER  **************/
/****************************************************/
/****************************************************/
    public Node locateNodeBy(int nodeID) {
        for (Node n : nodes) {
            if (nodeID == n.getID()) {
                return n;
            }
        }
        return new Node();
    }
    public ArrayList<Node> arrayList(){
        return nodes;
    }
    public Node get(int index){ return nodes.get(index); }
/****************************************************/
/**************         BUILD      ******************/
/****************************************************/
/****************************************************/
    public NodeCollection(InputStream in_s)  throws FileNotFoundException {
        Scanner fileRef = new Scanner(in_s);
        nodes = new ArrayList<Node>();
        Node node;
        while (fileRef.hasNext()) {
            String line = fileRef.nextLine();
            node = mapFields(line);
            nodes.add(node);
        }
        fileRef.close();
    }

    //private @NotNull
    Node mapFields(String line) {
        String[] stringArray = line.split(",");
        Node n = new Node();
        n.setID(valueOf(stringArray[0]));
        n.settID(valueOf(stringArray[1]));
        n.setTrID(valueOf(stringArray[2]));
        n.setBrID(valueOf(stringArray[3]));
        n.setbID(valueOf(stringArray[4]));
        n.setBlID(valueOf(stringArray[5]));
        n.setTlID(valueOf(stringArray[6]));
        return n;
    }

    public String toString(){
        String str = "";
        for(Node n : nodes){
            str += n.toString() + "\n";
        }
        return str;
    }
}
