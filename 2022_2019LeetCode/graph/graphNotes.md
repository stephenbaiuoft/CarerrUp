It's important to model the problem in a way that standard algorithms or their slight variations can be used for the solutions. Whenever we have a problem where we're given a bunch of entities and they have some sort of connections between them, more often than not it can be modeled as a graph problem. Once you've figured out that the question can be modeled as a graph problem, you then need to think about the various aspects of a graph i.e.

directed vs undirected
weighted vs unweighted
cyclic vs acyclic
These aspects will help define the algorithm that you can consider for solving the problem at hand.

For example a standard rule of thumb that is followed for solving shortest path problems is that we mostly
 - use Breadth-first search for unweighted graphs
 - use Dijkstra's algorithm for weighted graphs. An implied condition to apply the Dijkstra's algorithm is that the weights of the graph must be positive.

 - If the graph has negative weights and can have negative weighted cycles, we would have to employ another algorithm called the
   ==> Bellman Ford's. The point here is that the properties of the graph and the goal define the kind of algorithms we might be able to use.