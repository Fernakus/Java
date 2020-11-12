/*  -------------------------------------------------------
 *  Main.java
 *  -------------------------------------------------------
 *  Author:  Matthew Ferlaino
 *  Date:	 November 12th 2020
 *  Class:   COSC4436
 *  ------------------------------------------------------- */

package com.company;

public class Main {
    public static void main(String[] args) {
        // Adaptive Algorithms
        CentralizedAlgorithm centralized = new CentralizedAlgorithm();
        DistributedAlgorithm distributed = new DistributedAlgorithm();

        // Non-Adaptive Algorithms
        FloodingAlgorithm flooding = new FloodingAlgorithm();
        RandomWalkAlgorithm randomWalk = new RandomWalkAlgorithm();

        // Running
        centralized.run();
        distributed.run();
        flooding.run();
        randomWalk.run();
    }
}
