package com.jwetherell.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import com.jwetherell.algorithms.data_structures.BinarySearchTree;
import com.jwetherell.algorithms.data_structures.BinaryHeap;
import com.jwetherell.algorithms.data_structures.BinaryHeap.TYPE;
import com.jwetherell.algorithms.data_structures.Graph.Edge;
import com.jwetherell.algorithms.data_structures.Graph.Vertex;
import com.jwetherell.algorithms.data_structures.Graph;
import com.jwetherell.algorithms.data_structures.HashMap;
import com.jwetherell.algorithms.data_structures.PatriciaTrie;
import com.jwetherell.algorithms.data_structures.RadixTree;
import com.jwetherell.algorithms.data_structures.SuffixTree;
import com.jwetherell.algorithms.data_structures.TrieMap;
import com.jwetherell.algorithms.data_structures.LinkedList;
import com.jwetherell.algorithms.data_structures.Matrix;
import com.jwetherell.algorithms.data_structures.Queue;
import com.jwetherell.algorithms.data_structures.SegmentTree;
import com.jwetherell.algorithms.data_structures.SkipList;
import com.jwetherell.algorithms.data_structures.SplayTree;
import com.jwetherell.algorithms.data_structures.Stack;
import com.jwetherell.algorithms.data_structures.SuffixTrie;
import com.jwetherell.algorithms.data_structures.Treap;
import com.jwetherell.algorithms.data_structures.Trie;
import com.jwetherell.algorithms.graph.BellmanFord;
import com.jwetherell.algorithms.graph.CycleDetection;
import com.jwetherell.algorithms.graph.Dijkstra;
import com.jwetherell.algorithms.graph.FloydWarshall;
import com.jwetherell.algorithms.graph.Johnson;
import com.jwetherell.algorithms.graph.Prim;
import com.jwetherell.algorithms.graph.TopologicalSort;


public class DataStructures {
    private static final int SIZE = 25;
    
    private static Integer[] unsorted = null;
    
    public static void main(String[] args) {
        Random random = new Random();
        
        System.out.print("Array=");
        unsorted = new Integer[SIZE];
        for (int i=0; i<unsorted.length; i++) {
            Integer j = random.nextInt(unsorted.length*10);
            unsorted[i] = j;
            System.out.print(j+",");
        }
        System.out.println();
        System.out.println();

        {
            // Linked List
            System.out.println("Linked List.");
            LinkedList<Integer> list = new LinkedList<Integer>(unsorted);
            System.out.println(list.toString());
            
            int index = 0;
            int next = unsorted[index];
            System.out.println("Removing the head of the List "+next);
            list.remove(next);
            System.out.println(list.toString());
            
            index = unsorted.length-1;
            next = unsorted[index];
            System.out.println("Removing the tail of the List "+next);
            list.remove(next);
            System.out.println(list.toString());

            next = random.nextInt(unsorted.length*100);
            System.out.println("Adding a new HashNode "+next);
            list.add(next);
            System.out.println(list.toString());

            index = random.nextInt(unsorted.length);
            next = unsorted[index];
            System.out.println("Removing a previously added HashNode "+next);
            list.remove(next);
            System.out.println(list.toString());

            while (list.getSize()>0) {
                int headValue = list.getHeadValue();
                list.remove(headValue);
                System.out.println("Removed the head "+headValue+" from the list.");
                System.out.println(list.toString());
            }

            System.out.println();
        }

        {
            // Stack
            System.out.println("Stack.");
            Stack<Integer> stack = new Stack<Integer>(unsorted);
            System.out.println(stack.toString());

            int next = random.nextInt(unsorted.length*100);
            System.out.println("Pushing a new HashNode onto the Stack "+next);
            stack.push(next);
            System.out.println(stack.toString());

            Integer HashNode = stack.pop();
            System.out.println("Popped "+HashNode+" from the Stack.");
            System.out.println(stack.toString());

            int size = stack.getSize();
            for (int j=0; j<size; j++) {
                HashNode = stack.pop();
                System.out.println("Popped "+HashNode+" from the Stack.");
                System.out.println(stack.toString());
            }
            System.out.println();
        }

        {
            // Queue
            System.out.println("Queue.");
            Queue<Integer> queue = new Queue<Integer>(unsorted);
            System.out.println(queue.toString());

            int next = random.nextInt(unsorted.length*100);
            System.out.println("Pushing a new HashNode onto the Queue "+next);
            queue.enqueue(next);
            System.out.println(queue.toString());

            Integer HashNode = queue.dequeue();
            System.out.println("Dequeued "+HashNode+" from the Queue.");
            System.out.println(queue.toString());

            int size = queue.getSize();
            for (int j=0; j<size; j++) {
                HashNode = queue.dequeue();
                System.out.println("Dequeued "+HashNode+" from the Queue.");
                System.out.println(queue.toString());
            }
            System.out.println();
        }

        {
            // SkipList
            System.out.println("Skip List.");
            SkipList<Integer> list = new SkipList<Integer>(unsorted);
            list.add(99);
            System.out.println(list.toString());
            list.remove(99);
            System.out.println(list.toString());

            System.out.println();
        }

        {
            // MIN-HEAP
            System.out.println("Min-Heap.");
            BinaryHeap<Integer> minHeap = new BinaryHeap<Integer>(unsorted);
            System.out.println(minHeap.toString());
            
            Integer next = minHeap.getRootValue();
            System.out.println("Removing the root "+next);
            minHeap.remove(next);
            System.out.println(minHeap.toString());
            
            next = random.nextInt(unsorted.length*100);
            System.out.println("Adding a new HashNode "+next);
            minHeap.add(next);
            System.out.println(minHeap.toString());
            
            int index = random.nextInt(unsorted.length);
            next = unsorted[index];
            System.out.println("Adding a previously added HashNode "+next);
            minHeap.add(next);
            System.out.println(minHeap.toString());

            index = random.nextInt(unsorted.length);
            next = unsorted[index];
            System.out.println("Removing a previously added HashNode "+next);
            minHeap.remove(next);
            System.out.println(minHeap.toString());
            System.out.println();
        }
        
        {
            // MAX-HEAP
            System.out.println("Max-Heap.");
            BinaryHeap<Integer> maxHeap = new BinaryHeap<Integer>(unsorted,TYPE.MAX);
            System.out.println(maxHeap.toString());
            
            Integer next = maxHeap.getRootValue();
            System.out.println("Removing the root "+next);
            maxHeap.remove(next);
            System.out.println(maxHeap.toString());
            
            next = random.nextInt(unsorted.length*100);
            System.out.println("Adding a new HashNode "+next);
            maxHeap.add(next);
            System.out.println(maxHeap.toString());
            
            int index = random.nextInt(unsorted.length);
            next = unsorted[index];
            System.out.println("Adding a previously added HashNode "+next);
            maxHeap.add(next);
            System.out.println(maxHeap.toString());

            index = random.nextInt(unsorted.length);
            next = unsorted[index];
            System.out.println("Removing a previously added HashNode "+next);
            maxHeap.remove(next);
            System.out.println(maxHeap.toString());
            System.out.println();
        }

        {
            // UNDIRECTED GRAPH
            System.out.println("Undirected Graph.");
            List<Vertex<Integer>> verticies = new ArrayList<Vertex<Integer>>();
            Graph.Vertex<Integer> v1 = new Graph.Vertex<Integer>(1);            
            verticies.add(v1);
            Graph.Vertex<Integer> v2 = new Graph.Vertex<Integer>(2);            
            verticies.add(v2);
            Graph.Vertex<Integer> v3 = new Graph.Vertex<Integer>(3);            
            verticies.add(v3);
            Graph.Vertex<Integer> v4 = new Graph.Vertex<Integer>(4);            
            verticies.add(v4);
            Graph.Vertex<Integer> v5 = new Graph.Vertex<Integer>(5);            
            verticies.add(v5);
            Graph.Vertex<Integer> v6 = new Graph.Vertex<Integer>(6);            
            verticies.add(v6);

            List<Edge<Integer>> edges = new ArrayList<Edge<Integer>>();
            Graph.Edge<Integer> e1_2 = new Graph.Edge<Integer>(7, v1, v2);
            edges.add(e1_2);
            Graph.Edge<Integer> e1_3 = new Graph.Edge<Integer>(9, v1, v3);
            edges.add(e1_3);
            Graph.Edge<Integer> e1_6 = new Graph.Edge<Integer>(14, v1, v6);
            edges.add(e1_6);
            Graph.Edge<Integer> e2_3 = new Graph.Edge<Integer>(10, v2, v3);
            edges.add(e2_3);
            Graph.Edge<Integer> e2_4 = new Graph.Edge<Integer>(15, v2, v4);
            edges.add(e2_4);
            Graph.Edge<Integer> e3_4 = new Graph.Edge<Integer>(11, v3, v4);
            edges.add(e3_4);
            Graph.Edge<Integer> e3_6 = new Graph.Edge<Integer>(2, v3, v6);
            edges.add(e3_6);
            Graph.Edge<Integer> e5_6 = new Graph.Edge<Integer>(9, v5, v6);
            edges.add(e5_6);
            Graph.Edge<Integer> e4_5 = new Graph.Edge<Integer>(6, v4, v5);
            edges.add(e4_5);

            Graph<Integer> undirected = new Graph<Integer>(verticies,edges);
            System.out.println(undirected.toString());
            
            Graph.Vertex<Integer> start = v1;
            System.out.println("Dijstra's shortest paths of the undirected graph from "+start.getValue());
            Map<Graph.Vertex<Integer>, Graph.CostPathPair<Integer>> map1 = Dijkstra.getShortestPaths(undirected, start);
            System.out.println(getPathMapString(start,map1));

            Graph.Vertex<Integer> end = v5;
            System.out.println("Dijstra's shortest path of the undirected graph from "+start.getValue()+" to "+end.getValue());
            Graph.CostPathPair<Integer> pair1 = Dijkstra.getShortestPath(undirected, start, end);
            if (pair1!=null) System.out.println(pair1.toString());
            else System.out.println("No path from "+start.getValue()+" to "+end.getValue());

            start = v1;
            System.out.println("Bellman-Ford's shortest paths of the undirected graph from "+start.getValue());
            Map<Graph.Vertex<Integer>, Graph.CostPathPair<Integer>> map2 = BellmanFord.getShortestPaths(undirected, start);
            System.out.println(getPathMapString(start,map2));

            end = v5;
            System.out.println("Bellman-Ford's shortest path of the undirected graph from "+start.getValue()+" to "+end.getValue());
            Graph.CostPathPair<Integer> pair2 = BellmanFord.getShortestPath(undirected, start, end);
            if (pair2!=null) System.out.println(pair2.toString());
            else System.out.println("No path from "+start.getValue()+" to "+end.getValue());

            System.out.println("Prim's minimum spanning tree of the undirected graph from "+start.getValue());
            Graph.CostPathPair<Integer> pair = Prim.getMinimumSpanningTree(undirected, start);
            System.out.println(pair.toString());
            System.out.println();
        }

        {
            // DIRECTED GRAPH
            System.out.println("Directed Graph.");
            List<Vertex<Integer>> verticies = new ArrayList<Vertex<Integer>>();
            Graph.Vertex<Integer> v1 = new Graph.Vertex<Integer>(1);            
            verticies.add(v1);
            Graph.Vertex<Integer> v2 = new Graph.Vertex<Integer>(2);            
            verticies.add(v2);
            Graph.Vertex<Integer> v3 = new Graph.Vertex<Integer>(3);            
            verticies.add(v3);
            Graph.Vertex<Integer> v4 = new Graph.Vertex<Integer>(4);            
            verticies.add(v4);
            Graph.Vertex<Integer> v5 = new Graph.Vertex<Integer>(5);            
            verticies.add(v5);
            Graph.Vertex<Integer> v6 = new Graph.Vertex<Integer>(6);            
            verticies.add(v6);
            Graph.Vertex<Integer> v7 = new Graph.Vertex<Integer>(7);            
            verticies.add(v7);

            List<Edge<Integer>> edges = new ArrayList<Edge<Integer>>();
            Graph.Edge<Integer> e1_2 = new Graph.Edge<Integer>(7, v1, v2);
            edges.add(e1_2);
            Graph.Edge<Integer> e1_3 = new Graph.Edge<Integer>(9, v1, v3);
            edges.add(e1_3);
            Graph.Edge<Integer> e1_6 = new Graph.Edge<Integer>(14, v1, v6);
            edges.add(e1_6);
            Graph.Edge<Integer> e2_3 = new Graph.Edge<Integer>(10, v2, v3);
            edges.add(e2_3);
            Graph.Edge<Integer> e2_4 = new Graph.Edge<Integer>(15, v2, v4);
            edges.add(e2_4);
            Graph.Edge<Integer> e3_4 = new Graph.Edge<Integer>(11, v3, v4);
            edges.add(e3_4);
            Graph.Edge<Integer> e3_6 = new Graph.Edge<Integer>(2, v3, v6);
            edges.add(e3_6);
            Graph.Edge<Integer> e6_5 = new Graph.Edge<Integer>(9, v6, v5);
            edges.add(e6_5);
            Graph.Edge<Integer> e4_5 = new Graph.Edge<Integer>(6, v4, v5);
            edges.add(e4_5);
            Graph.Edge<Integer> e4_7 = new Graph.Edge<Integer>(16, v4, v7);
            edges.add(e4_7);
            
            Graph<Integer> directed = new Graph<Integer>(Graph.TYPE.DIRECTED,verticies,edges);
            System.out.println(directed.toString());
            
            Graph.Vertex<Integer> start = v1;
            System.out.println("Dijstra's shortest paths of the directed graph from "+start.getValue());
            Map<Graph.Vertex<Integer>, Graph.CostPathPair<Integer>> map = Dijkstra.getShortestPaths(directed, start);
            System.out.println(getPathMapString(start,map));

            Graph.Vertex<Integer> end = v5;
            System.out.println("Dijstra's shortest path of the directed graph from "+start.getValue()+" to "+end.getValue());
            Graph.CostPathPair<Integer> pair = Dijkstra.getShortestPath(directed, start, end);
            if (pair!=null) System.out.println(pair.toString());
            else System.out.println("No path from "+start.getValue()+" to "+end.getValue());
            
            start = v1;
            System.out.println("Bellman-Ford's shortest paths of the undirected graph from "+start.getValue());
            Map<Graph.Vertex<Integer>, Graph.CostPathPair<Integer>> map2 = BellmanFord.getShortestPaths(directed, start);
            System.out.println(getPathMapString(start,map2));

            end = v5;
            System.out.println("Bellman-Ford's shortest path of the undirected graph from "+start.getValue()+" to "+end.getValue());
            Graph.CostPathPair<Integer> pair2 = BellmanFord.getShortestPath(directed, start, end);
            if (pair2!=null) System.out.println(pair2.toString());
            else System.out.println("No path from "+start.getValue()+" to "+end.getValue());
            System.out.println();
        }

        {
            // DIRECTED GRAPH (WITH NEGATIVE WEIGHTS)
            System.out.println("Undirected Graph with Negative Weights.");
            List<Vertex<Integer>> verticies = new ArrayList<Vertex<Integer>>();
            Graph.Vertex<Integer> v1 = new Graph.Vertex<Integer>(1);            
            verticies.add(v1);
            Graph.Vertex<Integer> v2 = new Graph.Vertex<Integer>(2);            
            verticies.add(v2);
            Graph.Vertex<Integer> v3 = new Graph.Vertex<Integer>(3);            
            verticies.add(v3);
            Graph.Vertex<Integer> v4 = new Graph.Vertex<Integer>(4);            
            verticies.add(v4);

            List<Edge<Integer>> edges = new ArrayList<Edge<Integer>>();
            Graph.Edge<Integer> e1_4 = new Graph.Edge<Integer>(2, v1, v4);
            edges.add(e1_4);
            Graph.Edge<Integer> e2_1 = new Graph.Edge<Integer>(6, v2, v1);
            edges.add(e2_1);
            Graph.Edge<Integer> e2_3 = new Graph.Edge<Integer>(3, v2, v3);
            edges.add(e2_3);
            Graph.Edge<Integer> e3_1 = new Graph.Edge<Integer>(4, v3, v1);
            edges.add(e3_1);
            Graph.Edge<Integer> e3_4 = new Graph.Edge<Integer>(5, v3, v4);
            edges.add(e3_4);
            Graph.Edge<Integer> e4_2 = new Graph.Edge<Integer>(-7, v4, v2);
            edges.add(e4_2);
            Graph.Edge<Integer> e4_3 = new Graph.Edge<Integer>(-3, v4, v3);
            edges.add(e4_3);
            
            Graph<Integer> directed = new Graph<Integer>(Graph.TYPE.DIRECTED,verticies,edges);
            System.out.println(directed.toString());

            Graph.Vertex<Integer> start = v1;
            System.out.println("Bellman-Ford's shortest paths of the directed graph from "+start.getValue());
            Map<Graph.Vertex<Integer>, Graph.CostPathPair<Integer>> map2 = BellmanFord.getShortestPaths(directed, start);
            System.out.println(getPathMapString(start,map2));

            Graph.Vertex<Integer> end = v3;
            System.out.println("Bellman-Ford's shortest path of the directed graph from "+start.getValue()+" to "+end.getValue());
            Graph.CostPathPair<Integer> pair2 = BellmanFord.getShortestPath(directed, start, end);
            if (pair2!=null) System.out.println(pair2.toString());
            else System.out.println("No path from "+start.getValue()+" to "+end.getValue());

            System.out.println("Johnson's all-pairs shortest path of the directed graph.");
            Map<Vertex<Integer>, Map<Vertex<Integer>, Set<Edge<Integer>>>> paths = Johnson.getAllPairsShortestPaths(directed);
            if (paths==null) System.out.println("Directed graph contains a negative weight cycle.");
            else System.out.println(getPathMapString(paths));

            System.out.println("Floyd-Warshall's all-pairs shortest path weights of the directed graph.");
            Map<Vertex<Integer>, Map<Vertex<Integer>, Integer>> pathWeights = FloydWarshall.getAllPairsShortestPaths(directed);
            System.out.println(getWeightMapString(pathWeights));
            System.out.println();
        }

        {
            // UNDIRECTED GRAPH
            System.out.println("Undirected Graph cycle check.");
            List<Vertex<Integer>> cycledVerticies = new ArrayList<Vertex<Integer>>();
            Graph.Vertex<Integer> cv1 = new Graph.Vertex<Integer>(1);            
            cycledVerticies.add(cv1);
            Graph.Vertex<Integer> cv2 = new Graph.Vertex<Integer>(2);            
            cycledVerticies.add(cv2);
            Graph.Vertex<Integer> cv3 = new Graph.Vertex<Integer>(3);            
            cycledVerticies.add(cv3);
            Graph.Vertex<Integer> cv4 = new Graph.Vertex<Integer>(4);            
            cycledVerticies.add(cv4);
            Graph.Vertex<Integer> cv5 = new Graph.Vertex<Integer>(5);            
            cycledVerticies.add(cv5);
            Graph.Vertex<Integer> cv6 = new Graph.Vertex<Integer>(6);            
            cycledVerticies.add(cv6);

            List<Edge<Integer>> cycledEdges = new ArrayList<Edge<Integer>>();
            Graph.Edge<Integer> ce1_2 = new Graph.Edge<Integer>(7, cv1, cv2);
            cycledEdges.add(ce1_2);
            Graph.Edge<Integer> ce2_4 = new Graph.Edge<Integer>(15, cv2, cv4);
            cycledEdges.add(ce2_4);
            Graph.Edge<Integer> ce3_4 = new Graph.Edge<Integer>(11, cv3, cv4);
            cycledEdges.add(ce3_4);
            Graph.Edge<Integer> ce3_6 = new Graph.Edge<Integer>(2, cv3, cv6);
            cycledEdges.add(ce3_6);
            Graph.Edge<Integer> ce5_6 = new Graph.Edge<Integer>(9, cv5, cv6);
            cycledEdges.add(ce5_6);
            Graph.Edge<Integer> ce4_5 = new Graph.Edge<Integer>(6, cv4, cv5);
            cycledEdges.add(ce4_5);

            Graph<Integer> undirectedWithCycle = new Graph<Integer>(cycledVerticies,cycledEdges);
            System.out.println(undirectedWithCycle.toString());

            System.out.println("Cycle detection of the undirected graph.");
            boolean result = CycleDetection.detect(undirectedWithCycle);
            System.out.println("result="+result);
            System.out.println();

            List<Vertex<Integer>> verticies = new ArrayList<Vertex<Integer>>();
            Graph.Vertex<Integer> v1 = new Graph.Vertex<Integer>(1);
            verticies.add(v1);
            Graph.Vertex<Integer> v2 = new Graph.Vertex<Integer>(2);
            verticies.add(v2);
            Graph.Vertex<Integer> v3 = new Graph.Vertex<Integer>(3);
            verticies.add(v3);
            Graph.Vertex<Integer> v4 = new Graph.Vertex<Integer>(4);
            verticies.add(v4);
            Graph.Vertex<Integer> v5 = new Graph.Vertex<Integer>(5);
            verticies.add(v5);
            Graph.Vertex<Integer> v6 = new Graph.Vertex<Integer>(6);
            verticies.add(v6);
            
            List<Edge<Integer>> edges = new ArrayList<Edge<Integer>>();
            Graph.Edge<Integer> e1_2 = new Graph.Edge<Integer>(7, v1, v2);
            edges.add(e1_2);
            Graph.Edge<Integer> e2_4 = new Graph.Edge<Integer>(15, v2, v4);
            edges.add(e2_4);
            Graph.Edge<Integer> e3_4 = new Graph.Edge<Integer>(11, v3, v4);
            edges.add(e3_4);
            Graph.Edge<Integer> e3_6 = new Graph.Edge<Integer>(2, v3, v6);
            edges.add(e3_6);
            Graph.Edge<Integer> e4_5 = new Graph.Edge<Integer>(6, v4, v5);
            edges.add(e4_5);

            Graph<Integer> undirectedWithoutCycle = new Graph<Integer>(verticies,edges);
            System.out.println(undirectedWithoutCycle.toString());

            System.out.println("Cycle detection of the undirected graph.");
            result = CycleDetection.detect(undirectedWithoutCycle);
            System.out.println("result="+result);
            System.out.println();
        }

        {
            // DIRECTED GRAPH
            System.out.println("Directed Graph topological sort.");
            List<Vertex<Integer>> verticies = new ArrayList<Vertex<Integer>>();
            Graph.Vertex<Integer> cv1 = new Graph.Vertex<Integer>(1);            
            verticies.add(cv1);
            Graph.Vertex<Integer> cv2 = new Graph.Vertex<Integer>(2);            
            verticies.add(cv2);
            Graph.Vertex<Integer> cv3 = new Graph.Vertex<Integer>(3);            
            verticies.add(cv3);
            Graph.Vertex<Integer> cv4 = new Graph.Vertex<Integer>(4);            
            verticies.add(cv4);
            Graph.Vertex<Integer> cv5 = new Graph.Vertex<Integer>(5);            
            verticies.add(cv5);
            Graph.Vertex<Integer> cv6 = new Graph.Vertex<Integer>(6);            
            verticies.add(cv6);

            List<Edge<Integer>> edges = new ArrayList<Edge<Integer>>();
            Graph.Edge<Integer> ce1_2 = new Graph.Edge<Integer>(1, cv1, cv2);
            edges.add(ce1_2);
            Graph.Edge<Integer> ce2_4 = new Graph.Edge<Integer>(2, cv2, cv4);
            edges.add(ce2_4);
            Graph.Edge<Integer> ce4_3 = new Graph.Edge<Integer>(3, cv4, cv3);
            edges.add(ce4_3);
            Graph.Edge<Integer> ce3_6 = new Graph.Edge<Integer>(4, cv3, cv6);
            edges.add(ce3_6);
            Graph.Edge<Integer> ce5_6 = new Graph.Edge<Integer>(5, cv5, cv6);
            edges.add(ce5_6);
            Graph.Edge<Integer> ce4_5 = new Graph.Edge<Integer>(6, cv4, cv5);
            edges.add(ce4_5);

            Graph<Integer> directed = new Graph<Integer>(Graph.TYPE.DIRECTED,verticies,edges);
            System.out.println(directed.toString());

            System.out.println("Topological sort of the directed graph.");
            List<Graph.Vertex<Integer>> results = TopologicalSort.sort(directed);
            System.out.println("result="+results);
            System.out.println();
        }

        {
            // MATRIX
            System.out.println("Matrix.");
            Matrix<Integer> matrix1 = new Matrix<Integer>(4,3);
            matrix1.set(0, 0, 14);
            matrix1.set(0, 1, 9);
            matrix1.set(0, 2, 3);
            matrix1.set(1, 0, 2);
            matrix1.set(1, 1, 11);
            matrix1.set(1, 2, 15);
            matrix1.set(2, 0, 0);
            matrix1.set(2, 1, 12);
            matrix1.set(2, 2, 17);
            matrix1.set(3, 0, 5);
            matrix1.set(3, 1, 2);
            matrix1.set(3, 2, 3);
            
            Matrix<Integer> matrix2 = new Matrix<Integer>(3,2);
            matrix2.set(0, 0, 12);
            matrix2.set(0, 1, 25);
            matrix2.set(1, 0, 9);
            matrix2.set(1, 1, 10);
            matrix2.set(2, 0, 8);
            matrix2.set(2, 1, 5);

            System.out.println("Matrix multiplication.");
            Matrix<Integer> matrix3 = matrix1.multiply(matrix2);
            System.out.println(matrix3);
            
            int rows = 2;
            int cols = 2;
            int counter = 0;
            Matrix<Integer> matrix4 = new Matrix<Integer>(rows,cols);
            for (int r=0; r<rows; r++) {
                for (int c=0; c<cols; c++) {
                    matrix4.set(r, c, counter++);
                }
            }

            System.out.println("Matrix subtraction.");
            Matrix<Integer> matrix5 = matrix4.subtract(matrix4);
            System.out.println(matrix5);

            System.out.println("Matrix addition.");
            Matrix<Integer> matrix6 = matrix4.add(matrix4);
            System.out.println(matrix6);
            
            Matrix<Integer> matrix7 = new Matrix<Integer>(2,2);
            matrix7.set(0, 0, 1);
            matrix7.set(0, 1, 2);
            matrix7.set(1, 0, 3);
            matrix7.set(1, 1, 4);
            
            Matrix<Integer> matrix8 = new Matrix<Integer>(2,2);
            matrix8.set(0, 0, 1);
            matrix8.set(0, 1, 2);
            matrix8.set(1, 0, 3);
            matrix8.set(1, 1, 4);
            
            System.out.println("Matrix multiplication.");
            Matrix<Integer> matrix9 = matrix7.multiply(matrix8);
            System.out.println(matrix9);
        }

        {
            //Segment tree
            System.out.println("Segment Tree.");
            SegmentTree.Segment[] segments = new SegmentTree.Segment[4];
            segments[0] = new SegmentTree.Segment(0,1,0,0,0); //first point in the 0th quadrant
            segments[1] = new SegmentTree.Segment(1,0,1,0,0); //second point in the 1st quadrant
            segments[2] = new SegmentTree.Segment(2,0,0,1,0); //third point in the 2nd quadrant
            segments[3] = new SegmentTree.Segment(3,0,0,0,1); //fourth point in the 3rd quadrant
            SegmentTree tree = new SegmentTree(segments);
            
            SegmentTree.Query query = tree.query(0, 3);
            System.out.println(query.quad1+" "+query.quad2+" "+query.quad3+" "+query.quad4);

            tree.update(1, 0, -1, 1, 0); //Move the first point from quadrant one to quadrant two
            tree.update(2, 0, 1, -1, 0); //Move the second point from quadrant two to quadrant one
            tree.update(3, 1, 0, 0, -1); //Move the third point from quadrant third to quadrant zero
            
            query = tree.query(2, 3);
            System.out.println(query.quad1+" "+query.quad2+" "+query.quad3+" "+query.quad4);

            tree.update(0, -1, 1, 0, 0); //Move the zeroth point from quadrant zero to quadrant one
            tree.update(1, 0, 0, -1, 1); //Move the first point from quadrant three to quadrant four
            
            query = tree.query(0, 2);
            System.out.println(query.quad1+" "+query.quad2+" "+query.quad3+" "+query.quad4);
            System.out.println();
        }

        {
            // BINARY SEARCH TREE (first)
            System.out.println("Binary search tree with first HashNode.");
            BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>(unsorted,BinarySearchTree.TYPE.FIRST);
            System.out.println(bst.toString());

            // Add random HashNode
            int next = random.nextInt(unsorted.length*100);
            System.out.println("Adding a new HashNode "+next);
            bst.add(next);
            System.out.println(bst.toString());

            // Remove a previously added HashNode
            next = random.nextInt(unsorted.length);
            boolean contains = bst.contains(unsorted[next]);
            System.out.println("Does "+unsorted[next]+" exist in the BST? "+contains);
            System.out.println("Removing a previously added HashNode "+unsorted[next]);
            bst.remove(unsorted[next]);
            System.out.println(bst.toString());

            System.out.println();
        }

        {
            // BINARY SEARCH TREE (middle)
            System.out.println("Binary search tree with middle HashNode.");
            BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>(unsorted,BinarySearchTree.TYPE.MIDDLE);
            System.out.println(bst.toString());

            // Add random HashNode
            int next = random.nextInt(unsorted.length*100);
            System.out.println("Adding a new HashNode "+next);
            bst.add(next);
            System.out.println(bst.toString());

            // Remove a previously added HashNode
            next = random.nextInt(unsorted.length);
            boolean contains = bst.contains(unsorted[next]);
            System.out.println("Does "+unsorted[next]+" exist in the BST? "+contains);
            System.out.println("Removing a previously added HashNode "+unsorted[next]);
            bst.remove(unsorted[next]);
            System.out.println(bst.toString());

            System.out.println();
        }

        {
            // BINARY SEARCH TREE (random)
            System.out.println("Binary search tree using random HashNode.");
            BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>(unsorted,BinarySearchTree.TYPE.RANDOM);
            System.out.println(bst.toString());

            // Add random HashNode
            int next = random.nextInt(unsorted.length*100);
            System.out.println("Adding a new HashNode "+next);
            bst.add(next);
            System.out.println(bst.toString());

            // Remove a previously added HashNode
            next = random.nextInt(unsorted.length);
            boolean contains = bst.contains(unsorted[next]);
            System.out.println("Does "+unsorted[next]+" exist in the BST? "+contains);
            System.out.println("Removing a previously added HashNode "+unsorted[next]);
            bst.remove(unsorted[next]);
            System.out.println(bst.toString());

            System.out.println();
        }

        {
            //Treap
            System.out.println("Treap.");
        	Treap<Character> treap = new Treap<Character>();

        	String alphabet = new String("TVWXYABHIJKLMUFGNRSZCDEOPQ");
        	for (int i=0; i<alphabet.length(); i++) {
        	    treap.add(alphabet.charAt(i));
        	}
            System.out.println(treap.toString());

            for (int i=0; i<alphabet.length(); i++) {
                char letter = alphabet.charAt(i);
                boolean contains = treap.contains(letter);
                System.out.println("Does "+letter+" exist in the Treap? "+contains);            
                boolean removed = treap.remove(letter);
                System.out.println("Was "+letter+" removed from the Treap? "+removed);
                System.out.println(treap.toString());
            }

            System.out.println();
        }

        {
            //Splay Tree
            System.out.println("Splay Tree.");
            SplayTree<Character> splay = new SplayTree<Character>();

            String alphabet = new String("KLMUFGNRSTABHIJVWXYZCDEOPQ");
            for (int i=0; i<alphabet.length(); i++) {
                splay.add(alphabet.charAt(i));
            }
            System.out.println(splay.toString());

            int length = alphabet.length()-1;
            for (int i=0; i<=length; i++) {
                char letter = alphabet.charAt(length-i);
                boolean contains = splay.contains(letter);
                contains = splay.contains(letter);
                contains = splay.contains(letter);
                System.out.println("Does "+letter+" exist in the Splay Tree? "+contains);            
                boolean removed = splay.remove(letter);
                System.out.println("Was "+letter+" removed from the Splay Tree? "+removed);
                System.out.println(splay.toString());
            }
            
            System.out.println();
        }

        {
            //Trie
            System.out.println("Trie.");
            Trie<String> trie = new Trie<String>();
            String tea = "tea";
            trie.add(tea);
            String ted = "ted";
            trie.add(ted);
            String ten = "ten";
            trie.add(ten);
            String to = "to";
            trie.add(to);
            String too = "too";
            trie.add(too);
            String inn = "inn";
            trie.add(inn);
            String in = "in";
            trie.add(in);
            String i = "i";
            trie.add(i);
            String A = "A";
            trie.add(A);
            String teenager = "teenager";
            trie.add(teenager);
            String teenage = "teenage";
            trie.add(teenage);
            String teen = "teen";
            trie.add(teen);
            System.out.println(trie.toString());

            //This should fail since it already exists
            boolean bool = trie.add(A);
            System.out.println("Was adding '"+A+"' successful? "+bool);

            trie.remove(tea);
            trie.remove(to);
            System.out.println(trie.toString());

            System.out.println();
        }

        {
            //Suffix Trie
            System.out.println("Suffix Trie.");
            String bookkeeper = "bookkeeper";
            SuffixTrie<String> suffixTrie = new SuffixTrie<String>(bookkeeper);

            System.out.println(suffixTrie.toString());
            System.out.println(suffixTrie.getSuffixes());
            
            boolean exist = suffixTrie.doesSubStringExist(bookkeeper);
            System.out.println("Does "+bookkeeper+" exist in the Suffix Trie? "+exist);
            
            String failed = "booker";
            exist = suffixTrie.doesSubStringExist(failed);
            System.out.println("Does "+failed+" exist in the Suffix Trie? "+exist);
            
            String pass = "kkee";
            exist = suffixTrie.doesSubStringExist(pass);
            System.out.println("Does "+pass+" exist in the Suffix Trie? "+exist);

            System.out.println();
        }

        {
            //Suffix Tree
            System.out.println("Suffix Tree.");
            String bookkeeper = "bookkeeper";
            SuffixTree<String> suffixTree = new SuffixTree<String>(bookkeeper);

            System.out.println(suffixTree.toString());
            System.out.println(suffixTree.getSuffixes());

            boolean exist = suffixTree.doesSubStringExist(bookkeeper);
            System.out.println("Does "+bookkeeper+" exist in the Suffix Trie? "+exist);
            
            String failed = "booker";
            exist = suffixTree.doesSubStringExist(failed);
            System.out.println("Does "+failed+" exist in the Suffix Trie? "+exist);
            
            String pass = "kkee";
            exist = suffixTree.doesSubStringExist(pass);
            System.out.println("Does "+pass+" exist in the Suffix Trie? "+exist);

            System.out.println();
        }

        {
            //Radix Tree
            System.out.println("Patricia Trie.");
            PatriciaTrie<String> tree = new PatriciaTrie<String>();
            String tea = "tea";
            tree.add(tea);
            String ted = "ted";
            tree.add(ted);
            String ten = "ten";
            tree.add(ten);
            String to = "to";
            tree.add(to);
            String too = "too";
            tree.add(too);
            String inn = "inn";
            tree.add(inn);
            String in = "in";
            tree.add(in);
            String i = "i";
            tree.add(i);
            String A = "A";
            tree.add(A);
            String teenager = "teenager";
            tree.add(teenager);
            String teen = "teen";
            tree.add(teen);
            String teenage = "teenage";
            tree.add(teenage);
            String teddybear = "teddybear";
            tree.add(teddybear);
            String teddyruxpin = "teddyruxpin";
            tree.add(teddyruxpin);
            String teddybears = "teddybears";
            tree.add(teddybears);
            String teddy = "teddy";
            tree.add(teddy);
            System.out.println(tree.toString());

            //This should fail since it already exists
            boolean bool = tree.add(teenager);
            System.out.println("Was adding '"+teenager+"' successful? "+bool);

            boolean exists = tree.contains(teddyruxpin);
            System.out.println("Does '"+teenager+"' exist in the tree? "+exists);

            String failure = "failure";
            exists = tree.contains(failure);
            System.out.println("Does '"+failure+"' exist in the tree? "+exists);

            String te = "te";
            exists = tree.contains(te);
            System.out.println("Does '"+te+"' exist in the tree? "+exists);

            tree.remove(tea);
            tree.remove(to);
            System.out.println(tree.toString());

            System.out.println();
        }

        {
            // HashMap
            System.out.println("Hash Map.");
            HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>(unsorted);
            System.out.println(hash.toString());

            int next = random.nextInt(unsorted.length*100);
            System.out.println("Putting a new HashNode into the HashMap "+next);
            hash.put(next,next);
            System.out.println(hash.toString());

            hash.remove(next);
            System.out.println("Removed key="+next+" from the HashMap.");
            System.out.println(hash.toString());

            for (int j=0; j<unsorted.length; j++) {
                int key = unsorted[j];
                hash.remove(key);
                System.out.println("Removed key="+key+" from the HashMap.");
                System.out.println(hash.toString());
            }
            System.out.println();
        }

        {
            //Trie Map
            System.out.println("Trie Map.");
            TrieMap<String,Integer> trieMap = new TrieMap<String,Integer>();
            String tea = "tea";
            trieMap.put(tea, 3);
            String ted = "ted";
            trieMap.put(ted, 4);
            String ten = "ten";
            trieMap.put(ten, 12);
            String to = "to";
            trieMap.put(to, 7);
            String too = "too";
            trieMap.put(too, 32);
            String inn = "inn";
            trieMap.put(inn, 9);
            String in = "in";
            trieMap.put(in, 5);
            String i = "i";
            trieMap.put(i, 11);
            String A = "A";
            trieMap.put(A, 15);
            String teenager = "teenager";
            trieMap.put(teenager, 23);
            String teenage = "teenage";
            trieMap.put(teenage, 45);
            String teen = "teen";
            trieMap.put(teen, 57);
            System.out.println(trieMap.toString());            

            //This should fail since it already exists
            boolean bool = trieMap.put(A, -1);
            System.out.println("Was adding '"+A+"' successful? "+bool);

            trieMap.remove(tea);
            trieMap.remove(to);
            System.out.println(trieMap.toString());

            System.out.println();
        }

        {
            //Trie Map
            System.out.println("Radix Tree (map).");
            RadixTree<String,Integer> radixTree = new RadixTree<String,Integer>();
            String tea = "tea";
            radixTree.put(tea, 3);
            String ted = "ted";
            radixTree.put(ted, 4);
            String ten = "ten";
            radixTree.put(ten, 12);
            String to = "to";
            radixTree.put(to, 7);
            String too = "too";
            radixTree.put(too, 32);
            String inn = "inn";
            radixTree.put(inn, 9);
            String in = "in";
            radixTree.put(in, 5);
            String i = "i";
            radixTree.put(i, 11);
            String A = "A";
            radixTree.put(A, 15);
            String teenager = "teenager";
            radixTree.put(teenager, 23);
            String teenage = "teenage";
            radixTree.put(teenage, 45);
            String teen = "teen";
            radixTree.put(teen, 57);
            System.out.println(radixTree.toString());

            //This should fail since it already exists
            boolean bool = radixTree.put(A, -1);
            System.out.println("Was adding '"+A+"' successful? "+bool);

            radixTree.remove(tea);
            radixTree.remove(to);
            System.out.println(radixTree.toString());

            System.out.println();
        }
    }

    private static final String getPathMapString(Graph.Vertex<Integer> start, Map<Graph.Vertex<Integer>, Graph.CostPathPair<Integer>> map) {
        StringBuilder builder = new StringBuilder();
        for (Graph.Vertex<Integer> v : map.keySet()) {
            Graph.CostPathPair<Integer> pair = map.get(v);
            builder.append("From ").append(start.getValue()).append(" to vertex=").append(v.getValue()).append("\n");
            if (pair!=null) builder.append(pair.toString()).append("\n");

        }
        return builder.toString();
    }

    private static final String getPathMapString(Map<Vertex<Integer>, Map<Vertex<Integer>, Set<Edge<Integer>>>> paths) {
        StringBuilder builder = new StringBuilder();
        for (Graph.Vertex<Integer> v : paths.keySet()) {
            Map<Vertex<Integer>, Set<Edge<Integer>>> map = paths.get(v);
            for (Graph.Vertex<Integer> v2 : map.keySet()) {
                builder.append("From=").append(v.getValue()).append(" to=").append(v2.getValue()).append("\n");
                Set<Graph.Edge<Integer>> path = map.get(v2);
                builder.append(path).append("\n");
            }
        }
        return builder.toString();
    }

    private static final String getWeightMapString(Map<Vertex<Integer>, Map<Vertex<Integer>, Integer>> paths) {
        StringBuilder builder = new StringBuilder();
        for (Graph.Vertex<Integer> v : paths.keySet()) {
            Map<Vertex<Integer>, Integer> map = paths.get(v);
            for (Graph.Vertex<Integer> v2 : map.keySet()) {
                builder.append("From=").append(v.getValue()).append(" to=").append(v2.getValue()).append("\n");
                Integer weight = map.get(v2);
                builder.append(weight).append("\n");
            }
        }
        return builder.toString();
    }
}
