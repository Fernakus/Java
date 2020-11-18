/*  -------------------------------------------------------
 *  CentralizedAlgorithm.java
 *  -------------------------------------------------------
 *  Author:  Matthew Ferlaino
 *  Date:	 November 12th 2020
 *  Class:   COSC4436
 *  ------------------------------------------------------- */

import java.time.LocalTime;

public class CentralizedAlgorithm {
    /*
     * Class for threads
     */
    public class Node implements Runnable{
        public void run() {
            new FloodingAlgorithm().run();
        }
    }

    private BinarySearchTree treeNetwork;

    public CentralizedAlgorithm() {
        // Populate tree with Nodes
        treeNetwork = new BinarySearchTree();
        for (int x = 0; x <= 98; x++)
            treeNetwork.insert(new Node());
    }

    public void run() {
        // Start Algorithm
        try {
            LocalTime start = LocalTime.now();
            treeNetwork.traverseAndRun();
            LocalTime end = LocalTime.now();

            System.out.println();
            System.out.println("--- Centralized Flooding Algorithm Test ---");
            System.out.println("Starting Time: " + start);
            System.out.println("Ending Time: " + end);

            String difference = (start.getNano() > end.getNano()) ? (start.getNano() - end.getNano()) + "" : (end.getNano() - start.getNano()) + "";
            System.out.println("Difference (Nanoseconds): " + difference);
        }

        catch (Exception ex) {
            System.out.println(ex);
        }
    }
}

