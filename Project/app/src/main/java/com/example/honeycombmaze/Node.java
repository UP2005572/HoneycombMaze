package com.example.honeycombmaze;

public class Node {

    private int[] linkIDs;
    private String[] possibleDoors = {"T", "TR", "BR", "B", "BL", "TL"};

    private int ID;
    private int tID;
    private int trID;
    private int brID;
    private int bID;
    private int blID;
    private int tlID;
    private String question;
    private String description;

    private Node tNode;
    private Node trNode;
    private Node brNode;
    private Node bNode;
    private Node blNode;
    private Node tlNode;

    public int getID() {return ID;}
    public int gettID() {return tID;}
    public int getTrID() {return trID;}
    public int getBrID() {return brID; }
    public int getbID() {return bID;}
    public int getBlID() {return blID;}
    public int getTlID() {return tlID;}

    public void settID(int tID) {this.tID = tID;}
    public void setID(int ID) {this.ID = ID;}
    public void setTrID(int trID) {this.trID = trID;}
    public void setBrID(int brID) {this.brID = brID;}
    public void setbID(int bID) {this.bID = bID;}
    public void setBlID(int blID) {this.blID = blID;}
    public void setTlID(int tlID) {this.tlID = tlID;}

    public Node gettNode() {return tNode;}
    public Node getTrNode() {return trNode;}
    public Node getBrNode() {return brNode;}
    public Node getbNode() {return bNode;}
    public Node getBlNode() {return blNode;}
    public Node getTlNode() {return tlNode;}

    public void settNode(Node tNode) {this.tNode = tNode;}
    public void setTrNode(Node trNode) {this.trNode = trNode;}
    public void setBrNode(Node brNode) {this.brNode = brNode;}
    public void setbNode(Node bNode) {this.bNode = bNode;}
    public void setBlNode(Node blNode) {this.blNode = blNode;}
    public void setTlNode(Node tlNode) {this.tlNode = tlNode;}


    public int[] getLinkIDs() {return linkIDs;}



    public void setDescription(){
        if (this.ID == 102){
            this.description = "You have fallen out of the maze!";
        } else {
            this.description = "Onto the next chamber.";
        }
    }

    public String getDescription(){
        return this.description;
    }

    public Node(int ID, int tID, int trID, int brID, int bID, int blID, int tlID) {
        linkIDs = new int[6];

        this.ID = ID;

        this.tID = tID;
        linkIDs[0] = tID;

        this.trID = trID;
        linkIDs[1] = trID;

        this.brID = brID;
        linkIDs[2] = brID;

        this.bID = bID;
        linkIDs[3] = bID;

        this.blID = blID;
        linkIDs[4] = blID;

        this.tlID = tlID;
        linkIDs[5] = tlID;

        setQuestion();

        setDescription();

    }
    public String GenerateOptions(){
        String opt = "";

        for (int i = 0; i < 6; i++){
            if (linkIDs[i] != -1){
                opt += possibleDoors[i] + " ";
            }
        }

        return opt;
    }

    public void setQuestion(){
        for (int id: linkIDs){
            if (id == 102){
                this.question = "Press enter to return to the start.";
            } else {
                this.question = "Choose a door to enter:"+ GenerateOptions();
            }
        }
    }

    public String getQuestion() {
        return question;
    }

    public Node() {}




    @Override
    public String toString() {
        return "nodeID:" + ID +
                ", tID:" + tID +
                ", trID:" + trID +
                ", brID:" + brID +
                ", bID:" + bID +
                ", blID:" + blID +
                ", tlID:" + tlID +
                ", question:'" + question + '\'';
    }


}
