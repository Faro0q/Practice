package io.wcygan.algorithms.graph.pathfinding;

import io.wcygan.collections.graph.Graph;
import io.wcygan.collections.graph.SimpleGraph;
import io.wcygan.collections.graph.Vertex;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class UnweightedShortestPathTest {

  @ParameterizedTest
  @MethodSource("unweightedShortestPathGraphProvider")
  public void testUnweightedShortestPath(
      int start, int end, Integer[][] edges, Integer[][] expectedEdges) {
    Graph<Integer> initial = buildGraph(edges);

    Vertex<Integer> startingVertex = initial.getVertex(Integer.toString(start));
    Vertex<Integer> endingVertex = initial.getVertex(Integer.toString(end));

    Graph<Integer> actual = ShortestPath.Dijkstra(initial, startingVertex, endingVertex);
    Graph<Integer> expected = buildGraph(expectedEdges);

    Helpers.validateShortestPath(actual, expected, start, end, expectedEdges.length);
  }

  private static Stream<Arguments> unweightedShortestPathGraphProvider() {
    return Stream.of(
        Arguments.of(
            // The starting vertex
            1,
            // The ending vertex
            3,
            // The edges in the graph
            new Integer[][] {
              {1, 2}, {2, 3},
            },
            // The expected path
            new Integer[][] {{1, 2}, {2, 3}}),
        Arguments.of(
            // The starting vertex
            1,
            // The ending vertex
            10,
            // The edges in the graph
            new Integer[][] {
              {1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}, {7, 8}, {8, 9}, {9, 10}, {1, 3},
              {3, 5}, {5, 8}
            },
            // The expected path
            new Integer[][] {{1, 3}, {3, 5}, {5, 8}, {8, 9}, {9, 10}}));
  }

  private <T> Graph<T> buildGraph(T[][] edges) {
    Graph<T> graph = new SimpleGraph<>();

    for (T[] edge : edges) {
      T first = edge[0];
      T second = edge[1];

      Vertex<T> from = graph.addNamedVertex(first, first.toString());
      Vertex<T> to = graph.addNamedVertex(second, second.toString());

      graph.addEdge(from, to);
    }

    return graph;
  }
}
