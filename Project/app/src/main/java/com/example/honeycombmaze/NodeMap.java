package com.example.honeycombmaze;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class NodeMap {

    private Node head;
    private Node currentNode;


/****************************************************/
/**************      NAVIGATE       *****************/
/****************************************************/
/****************************************************/
    public Node GetCurrentNode() { return currentNode;}

    public void decision(int decision) {
        switch (decision) {
            case 1:
                currentNode = currentNode.gettNode();
                break;
            case 2:
                currentNode = currentNode.getTrNode();
                break;
            case 3:
                currentNode = currentNode.getBrNode();
                break;
            case 4:
                currentNode = currentNode.getbNode();
                break;
            case 5:
                currentNode = currentNode.getBlNode();
                break;
            case 6:
                currentNode = currentNode.getTlNode();
                break;
        }
    }
/****************************************************/
/**************         BUILD      ******************/
/****************************************************/
/****************************************************/

    public NodeMap(InputStream in_s)  {
        NodeCollection nodeCollection;
        try {
            nodeCollection = new NodeCollection(in_s);
            head = nodeCollection.get(0);
        } catch (FileNotFoundException e) {
            //message
            return;
        }
        buildMap(nodeCollection);
        currentNode = head;
    }


    private void buildMap(NodeCollection nodeCollection)   {
        if (nodeCollection == null) {return;}
        for(Node source : nodeCollection.arrayList()){
            int tID = source.gettID();
            int trID = source.getTrID();
            int brID = source.getBrID();
            int bID = source.getbID();
            int blID = source.getBlID();
            int tlID = source.getTlID();

            Node topNode = nodeCollection.locateNodeBy(tID);
            Node topRightNode = nodeCollection.locateNodeBy(trID);
            Node bottomRightNode = nodeCollection.locateNodeBy(brID);
            Node bottomNode = nodeCollection.locateNodeBy(bID);
            Node bottomLeftNode = nodeCollection.locateNodeBy(blID);
            Node topLeftNode = nodeCollection.locateNodeBy(tlID);

            source.settNode(topNode);
            source.setTrNode(topRightNode);
            source.setBrNode(bottomRightNode);
            source.setbNode(bottomNode);
            source.setBlNode(bottomLeftNode);
            source.setTlNode(topLeftNode);
        }
    }

    public String toString(){
        String string = "";
        string += topPath() + "\n";
        string += topRightPath() + "\n";
        string += bottomRightPath() + "\n";
        string += bottomPath() + "\n";
        string += bottomLeftPath() + "\n";
        string += topLeftPath() + "\n";
        return string;
    }

    public String topPath(){
        Node node = head;
        String string = "TOP PATH\n";
        while(node != null) {
            string += node.toString() + "\n";
            node = node.gettNode();
            if (node.getID() == -1) { node = null;}
        }
        return string;
    }

    public String topRightPath(){
        Node node = head;
        String string = "TOP RIGHT PATH\n";
        while(node != null) {
            string += node.toString() + "\n";
            node = node.getTrNode();
            if (node.getID() == -1) { node = null;}
        }
        return string;
    }

    public String bottomRightPath(){
        Node node = head;
        String string = "BOTTOM RIGHT PATH\n";
        while(node != null) {
            string += node.toString() + "\n";
            node = node.getBrNode();
            if (node.getID() == -1) { node = null;}
        }
        return string;
    }

    public String bottomPath(){
        Node node = head;
        String string = "BOTTOM PATH\n";
        while(node != null) {
            string += node.toString() + "\n";
            node = node.getbNode();
            if (node.getID() == -1) { node = null;}
        }
        return string;
    }

    public String bottomLeftPath(){
        Node node = head;
        String string = "BOTTOM LEFT PATH\n";
        while(node != null) {
            string += node.toString() + "\n";
            node = node.getBlNode();
            if (node.getID() == -1) { node = null;}
        }
        return string;
    }

    public String topLeftPath(){
        Node node = head;
        String string = "TOP LEFT PATH\n";
        while(node != null) {
            string += node.toString() + "\n";
            node = node.getTlNode();
            if (node.getID() == -1) { node = null;}
        }
        return string;
    }
}