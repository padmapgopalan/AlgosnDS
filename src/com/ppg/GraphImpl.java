package com.ppg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.LinkedList;

import com.ppg.GraphImpl.Node;

/**
 * The Graph class represents an acyclic directed graph.
 * The nodes in the graph are stored in a Map adjacencyList
 * 
 * Nodes can be added to the graph, children can be added to the nodes 
 * @author padmapriyagopalan
 *
 */

public class GraphImpl<T> {
	
	public static class Node<T>{
		private T name;
		private ArrayList<Node<T>> children;
		private boolean visited = false;
		
		public Node(T nm){
			this.name = nm;
			children = new ArrayList<Node<T>>();
		}
		
		public ArrayList<Node<T>> getChildren(){
			return children;
		}
		
		public boolean containsEdge(Node nghr){
			return children.contains(nghr);	
		}
		
		public boolean addEdge(Node nghr){
			if (containsEdge(nghr)) {
				return false;
			}
		    children.add(nghr);	
		    return true;
		}

		public boolean removeEdge(Node nghr){
			if (!containsEdge(nghr)) {
				return false;
			}
		    children.remove(nghr);	
		    return true;
		}
		
		public int edgeCount(){
			return children.size();
		}
		
		
		
	}
	
	
	private Map<T, Node<T>> adjacencyList;
	public GraphImpl(){
		adjacencyList = new HashMap<>();
	}
	
	public int vertexCount(){
		return adjacencyList.size();
	}
	
	public int edgeCount(){
		int sum = 0;
		for( Node x: adjacencyList.values()){
			sum = sum + x.edgeCount();
		}
		return sum;
	}
	
	/**
	 * Adds a node to the graph
	 * @param nm
	 * @return
	 */
	public boolean addVertex(T nm){
		if(adjacencyList.containsKey(nm)){
			return false;
		}
		adjacencyList.put(nm, new Node(nm));
		return true;		
	}

	/**
	 * Removes a node from a graph
	 * @param nm
	 * @return
	 */
	public boolean removeVertex(T nm){
		if(!adjacencyList.containsKey(nm)){
			return false;
		}
		
		Node toRemove = getNode(nm);
		//remove all edges to which nm is connected to
		adjacencyList.values().forEach(node -> node.removeEdge(toRemove));
		adjacencyList.remove(nm);
		return true;		
	}
	
	
	/**
	 * Adds a adjacent node to an existing node in graph 
	 * @param v1
	 * @param v2
	 * @return
	 */
	public boolean addEdge(T v1, T v2){
		Node v1N = getNode(v1);
		Node v2N = getNode(v2);
		if (!containsNode(v1) || !containsNode(v2)) {
			throw new RuntimeException("Vertex does not exist");
		}
		return v1N.addEdge(v2N);
	}
	
	/**
	 * Removes an existing adjacent node from a node in graph 
	 * @param v1
	 * @param v2
	 * @return
	 */
	public boolean removeEdge(T v1, T v2){
		Node v1N = getNode(v1);
		Node v2N = getNode(v2);
		if (!containsNode(v1) || !containsNode(v2)) {
			throw new RuntimeException("Vertex does not exist");
		}
		return v1N.removeEdge(v2N);
	}

	private Node getNode(T v1) {
		// TODO Auto-generated method stub
		return adjacencyList.get(v1);
	}

	private boolean containsNode(T v1) {
		// TODO Auto-generated method stub
		return adjacencyList.containsKey(v1);
	}

	
	/**
	 * Returns true if end and start are connected in a graph; false otherwise. Uses DFS
	 * @param start
	 * @param end
	 * @return
	 */
	public boolean dfsSearch(T start, T end){
		Node<T> startNode = getNode(start);
		if (startNode == null)
			return false;

		Node<T> endNode = getNode(end);
		if (endNode == null)
			return false;
		
		resetGraph();
		return dfsSearch(startNode, endNode);
	}
	
	
	/**
	 * Returns true if end and start are connected in a graph; false otherwise. Uses BFS
	 * @param start
	 * @param end
	 * @return
	 */
	public boolean bfsSearch(T start, T end){
		Node<T> startNode = getNode(start);
		if (startNode == null)
			return false;

		Node<T> endNode = getNode(end);
		if (endNode == null)
			return false;
		
		resetGraph();
		return bfsSearch(startNode, endNode);
	}
	
	private void resetGraph() {
		// TODO Auto-generated method stub
		for (Node<T> x : adjacencyList.values()){
			x.visited = false;
		}
		
	}
	
	private ArrayList<T> findBuildOrder(){
		
		Set<T> keys = adjacencyList.keySet();
		LinkedList<T> outList = new LinkedList<>();
		for (T tmpKey: keys){
			outList.add(tmpKey);
			Node<T> tmpNode = adjacencyList.get(tmpKey);
		}
		return null;
	}

	private boolean bfsSearch(Node<T> start, Node<T> end){
		start.visited = true;
		LinkedList<Node<T>> nodeQ = new LinkedList();
		
		
		nodeQ.add(start);
		while (!nodeQ.isEmpty()) {
			Node<T> currNode = nodeQ.remove();
			currNode.visited = true;
			if (currNode == end)
				return true;
			for (Node<T> child : currNode.getChildren()){
				nodeQ.add(child);
			}
		}
		
		return false;
	}
	
	private boolean dfsSearch(Node<T> start, Node<T> end){
		start.visited = true;
		for (Node<T> child : start.getChildren()) {
			if (child == end){
				return true;
			}
			if (child.visited == false) {
				if (dfsSearch(child, end)) 
					return true;
			}
		}
	
		return false;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphImpl<Integer> grph = new GraphImpl<>();
		grph.addVertex(78);
		grph.addVertex(88);
		grph.addVertex(8);
		grph.addVertex(98);
		grph.addVertex(67);
		
		System.out.println(grph.bfsSearch(78, 88));
		
		grph.addEdge(78, 88);
		System.out.println(grph.bfsSearch(78, 88));
		
		grph.addEdge(88, 8);
		grph.addEdge(98, 67);
		grph.addEdge(67, 88);
		System.out.println(grph.bfsSearch(78, 8));
		
	}

}
