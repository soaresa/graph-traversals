# Graph Traversal Methods

The purpose of this project is to compare statistics of Breadth First Search and Depth First Search when used to search the path between two vertices in a random graph with uniform number of connections for each vertex.

## Sampling
Given the size n of the Graph, number of connections k each vertex must have and the sample number t the program will initialize a new graph with n vertices, produce k distinct connections for each vertex and sample t searches using both methods with random pairs (origin, target).

## Input
The first line provides size n of the graph, the second line provides the number k of random connections each vertex must have, and the third line provides the number t of sampling random searches the program must produce.  

#Constraints
1 < n < 10^6
1 < k < 50

## Output
The output must show t lines with a pair of results. The results will be composed by the size of the first path found between each pair using both methods.

## Example

### Input below:
100000
20
20

### Outputs:
#### Path to Target
| Method  | Min  |   Max |    Mean |
|---------|------|-------|---------|
| DFS     | 415  | 10128 | 3547.70 |
| BFS     |  3   |    5  |   4.00  |

#### Visited Vertices
| Method |  Min |  Max  | Mean     |
|--------|------|-------|----------|
| DFS    |  495 | 89302 | 47971.40 |
| BFS    | 4872 | 96891 | 59990.10 |

## Running
Run the class GraphSampling to start a new random sampling.

## TODO 
provide command to clone project.
provide commands to compile and run it.

