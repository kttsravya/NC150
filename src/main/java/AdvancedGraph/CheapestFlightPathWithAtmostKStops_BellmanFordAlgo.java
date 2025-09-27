package AdvancedGraph;

import java.util.Arrays;

/* BellmanFord Algo: To find the cheapest path from source to destination with k stops
* we need to create a matrix to find the cheapest path from source node to all other nodes in the graph when stops= 0 to k
* k = 1 row is populated based on results of k = 0. k = 2 is populated based on results of k = 1.
* To find the cheapest path at kth stop. we need to iterate through all the edges and see if (current cost of the edge) + (min cost to the
* src of the edge at k - 1 th level) is smaller than current value(INF). if it is replace the field with min value.
* Ex: 2-> 3 edge represents src:2 and dst:3 to find shortest path from 1 to 3 using atmost 2 edges. we check the cost of 0 to 1
* for kth-1 stop + cost of edge < node 3 value at position kth row.
* we need to iterate through all the edges at every kth level.
*         node_0(src)    node_1      node_2(dest)     node_3
*  k = 0    0            INF            INF             INF
*  k = 1
*  k = 2
*
*  */
public class CheapestFlightPathWithAtmostKStops_BellmanFordAlgo {
    public static void main(String[] args){
        CheapestFlightPathWithAtmostKStops_BellmanFordAlgo cheapestFlightWithAtmostKStops = new CheapestFlightPathWithAtmostKStops_BellmanFordAlgo();
        int n = 4;
        int[][] flights = {{0,1,200},{1,2,100},{1,3,300},{2,3,100}};
        int cheapest = cheapestFlightWithAtmostKStops.findCheapestPrice(n, flights, 0, 3, 1);
        System.out.println(cheapest);
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        // At level k = 0, prices other node other than source node is initialized to max_value. (standard approach)
        // reasoning: distance from src to reach src is 0.
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        // we will start from i = 0 (0 stops) to k(k stops) between src and dest (so overall, loop iterates k+1 times)
        for(int i = 0; i <= k; i ++){
            // at current level we update tempPrices array and after traversing all the edges we
            // set prices to tempPrices and create new tempPrices array at each level to work on.
            int[] tempPrices = Arrays.copyOf(prices, n);
            for(int[] flight: flights){
                int s = flight[0];
                int d = flight[1];
                int p = flight[2];
                if(prices[s] == Integer.MAX_VALUE){
                    continue;
                }
                if(prices[s] + p < tempPrices[d]){
                    tempPrices[d] = prices[s]+ p;
                }
            }
            prices = tempPrices;
        }
        return prices[dst] == Integer.MAX_VALUE? -1:prices[dst];
    }
}
