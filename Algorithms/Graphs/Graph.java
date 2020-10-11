/*Danielle Anderson
10/11/19
435L-111*/
import java.util.LinkedList;
//import java.util.List;
//import java.util.Random;
import java.util.Stack;

//import LinkedList.Node;


public class Graph {
	private Vertex vertexList[];
	private int adjMat[][];
	private LinkedList<LinkedList<Integer>> adjlist;
	private int nVerts;
//	private Stack<Integer> theStack; //for DFS
//	private Queue theQueue; //for BFS
	
	public static void main(String[] args) {
		// complete the main method to create a graph for problem 5 in Assignment 5
		// test if the graph contains cycles
		char[] element = {'0', '1', '2', '3', '4', '5'};
		Graph theGraph = new Graph(element.length);
		
		for (char c :element)
		{
			theGraph.addVertex(c);
		}
		theGraph.addEdge(0, 1);
		theGraph.addEdge(0, 2);
		theGraph.addEdge(1, 2);
		theGraph.addEdge(1, 3);
		theGraph.addEdge(2, 3);
		theGraph.addEdge(3, 4);
		theGraph.addEdge(4, 0);
		theGraph.addEdge(4, 1);
		theGraph.addEdge(4, 5);
		
		System.out.println("The adjacency matrix of this graph is:");
		theGraph.printMat(element.length);
		System.out.println();
		
		if (theGraph.detectcycle(element) == true)
			System.out.println("There is a cycle in this graph.");
		else
			System.out.println("There is not a cycle in this graph.");
		
		/* An example to create a graph using the Graph class
		char[] element = {'A','B','C','D','E'};
		Graph theGraph = new Graph(element.length);
		 for(char s :element){
		   theGraph.addVertex(s);
		  }
		// A: 0, B: 1, C: 2, D: 3, E: 4
		theGraph.addEdge(0, 1);
		theGraph.addEdge(1, 2);
		theGraph.addEdge(0, 3);
		theGraph.addEdge(3, 4);
 
		System.out.print("visits:");
		// theGraph.dfs();
		// theGraph.bfs();
		theGraph.dfsr();
		System.out.println();
		
		*/
		
	}
 
	public void printMat(int size)
	{
		for (int i = 0; i < size; i++)
		{
			for (int j = 0; j < size; j++)
				System.out.print(adjMat[i][j] + " ");
			System.out.println();
		}
	}
	 public Graph(int n) {
		  vertexList = new Vertex[n];
//		  vertexcycleflag = new int[n];
		  
		  //cycleflag 
/*		  for  (int i = 0; i < n; i++) {
			  vertexcycleflag[i]=-1;
		  }*/
		 
		  
		  //adj matrix
		  adjMat = new int[n][n];
		  nVerts = 0;
		  for (int i = 0; i < n; i++) {
		   for (int j = 0; j < n; j++) {
		    adjMat[i][j] = 0;
		   }
		  }
		  
		  //adj list
		  
		  adjlist = new LinkedList<LinkedList<Integer>>();
		  for (int i = 0; i < n; i++) {
				
				adjlist.add(new LinkedList<Integer>());
			}
		  
		  //theStack = new Stack<Integer>();
		  //theQueue = new Queue();
		 }

	
 
	public void addVertex(char nodename) {// add vertex
		vertexList[nVerts++] = new Vertex(nodename);
	}
 
	public void addEdge(int start, int end) {// undirected
		//adj matrix
		adjMat[start][end] = 1;
		//adjMat[end][start] = 1; this would be for undirected graphs
		//adj list
		
		if(!adjlist.get(start).contains(end))
			adjlist.get(start).add(end);
			 
		if(!adjlist.get(end).contains(start))
			adjlist.get(end).add(start);
		
	}
 
	public void displayVertex(int v) {// print vertex label
		System.out.print(vertexList[v].lable);
	}
 
	public int getAdjUnvisitedVertex(int v) {// get an unvisited connected vertex
		for (int i = 0; i < nVerts; i++) {
			if (adjMat[v][i] == 1 && vertexList[i].wasVisited == false) {
				return i;
			}
		}
		return -1;
	}
	
public boolean detectcycle(char[] nodenames)
{
	// complete the method to detect cycles in the graph
	// feel free to change the return type, parameters
	int next = getAdjUnvisitedVertex(0); //gets the index for the next neighbor
	int prev = 0; 
	Vertex neighbor = vertexList[next];
	Vertex top = new Vertex(nodenames[0]);
	Stack<Vertex> s = new Stack<>();
	s.push(top);
	top.wasVisited = true;
	top.cycleflag = 0;
	while (!s.empty())
	{	
		top = s.peek();
			
		//if the adjacent neighbor is currently in the stack
		if (neighbor.cycleflag == 0)
			return true; //there is a cycle
		//if the adjacent neighbor has not yet been visited
		else if (neighbor.cycleflag == -1)
		{
			neighbor.cycleflag = 0;
			s.push(neighbor);
		}
		else //if the top vertex has had all their neighbors visited
		{
			top.cycleflag = 1;
			s.pop();
		}
		prev = next;
		next = getAdjUnvisitedVertex(next);
		if (next != -1)
			neighbor = vertexList[next];
		else //in case next returns -1, go back to the previous next
		{
			neighbor.cycleflag = 1; //if return is -1 this vertex has no neighbors
			next = prev;
		}
	}
	return false;
}//detectcycle

}

