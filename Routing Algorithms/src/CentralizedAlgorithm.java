/*  -------------------------------------------------------
 *  CentralizedAlgorithm.java
 *  -------------------------------------------------------
 *  Author:  Matthew Ferlaino
 *  Date:	 November 12th 2020
 *  Class:   COSC4436
 *  ------------------------------------------------------- */


public class CentralizedAlgorithm {
    /*
     * Private Node class, we will instantiate 98 nodes and
     * individually they will run the flooding algorithm from a
     * centralized method
     */
    private class Node {
        private FloodingAlgorithm flood;

        public Node() {
            flood = new FloodingAlgorithm();
        }

        private void run() {
            flood.run();
        }
    }

    private ObjectBinarySearchTree tree;

    public CentralizedAlgorithm() {
        // Populate tree with Nodes
        tree = new ObjectBinarySearchTree();
        for (int x = 0; x <= 98; x++)
            tree.insert(new Node());
    }

    public void run() {
        tree.prePrint();
    }
}

