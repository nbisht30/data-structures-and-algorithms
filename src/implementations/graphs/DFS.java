package implementations.graphs;

/**
 * @author Nikhil Bisht
 * @date 18-04-2020
 */
/*
Used to find a path between two nodes in a graph/tree.

Approach: Explore deep into on children from starting node before checking out other children.
Example: If there is a path to be found from node 2 to 10 and node 2 is connected to 3, 4 and 5 as shown below.

  /---3---6---8
2---4---7---9
 \---5---10

- First you check if the first child of 2 i.e. 3 has a path to 10, to know that you check if 3's first child i.e 6.
has a path to 10. Then for 6's first child i.e. 8. Then for 8's children which are none.
So you conclude that there is no path from 2 to 10 through node 3.
- Then you check through second child of 2 i.e 4 and again repeating the process you find there is
no path to 10 through node 4.
- Then you check through third child of 2 i.e 5 and repeating the process you find the path.

Disadvantage of DFS: You explore one branch completely before exploring other branches. Like you could have found
that 2 is connected to 10 through 5, but you first checked for branches through children 3 and 4.
This wastes time and BFS solves this problem.

 */
public class DFS {

}
