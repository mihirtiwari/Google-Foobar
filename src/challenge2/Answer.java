package challenge2;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Answer {

	private static Node[][] board = new Node[8][8];

	public Answer(){
		int num = 0;
		for (int x = 0; x < board.length; x++){
			for (int y = 0; y < board[0].length; y++){
				board[x][y] = new Node(x,y,num);
				num++;
			}
		}
	}

	public Node getNode(int xCoor, int yCoor){
		return board[xCoor][yCoor];
	}

//	public Node getStartNode(){
//		return getNode(startX, startY);
//	}
//
//	public Node getEndNode(){
//		return getNode(endX, endY);
//	}

	public List getAdjacentNodes(Node n){
		ArrayList<Node> adj = new ArrayList<Node>();
		if (getL(n, 1) != null)
			adj.add(getL(n, 1));
		if (getL(n,2) != null)
			adj.add(getL(n, 2));
		if (getL(n, 3) != null)
			adj.add(getL(n, 3));
		if (getL(n, 4) != null)
			adj.add(getL(n, 4));

		return adj;
	}

	//1 is up, 2 is right, 2 is down, 4 is left
	private Node getL(Node n, int dir){
		int x = n.getX();
		int y = n.getY();

		int newX = 0;
		int newY = 0;

		switch(dir){
		case 1:
			newX = x + 1;
			newY = y - 2;

			if (newY < 0 || newX >= board[x].length)
				return null;
			break;
		case 2:
			newX = x + 2;
			newY = y + 1;

			if (newY >= board.length || newX >= board[x].length)
				return null;
			break;
		case 3:
			newX = x + 1;
			newY = y + 2;

			if (newY >= board.length || newX >= board[x].length)
				return null;
			break;
		case 4:
			newX = x - 1;
			newY = y + 2;

			if (newY >= board.length || newX < 0)
				return null;
			break;
		}

		return board[newX][newY];
	}


	//	class Board{
	//		private Node[][] board = new Node[8][8];
	//		private int startX, startY, endX, endY;
	//
	//		public Board(int startX, int startY, int endX, int endY){
	//			this.startX = startX;
	//			this.startY = startY;
	//			this.endX = endX;
	//			this.endY = endY;
	//			
	//			int num = 0;
	//			for (int x = 0; x < board.length; x++){
	//				for (int y = 0; y < board[0].length; y++){
	//					board[x][y] = new Node(x,y,num);
	//					num++;
	//				}
	//			}
	//		}
	//		
	//		public Node getNode(int xCoor, int yCoor){
	//			return board[xCoor][yCoor];
	//		}
	//		
	//		public Node getStartNode(){
	//			return getNode(startX, startY);
	//		}
	//		
	//		public Node getEndNode(){
	//			return getNode(endX, endY);
	//		}
	//		
	//		public List getAdjacentNodes(Node n){
	//			ArrayList<Node> adj = new ArrayList<Node>();
	//			if (getL(n, 1) != null)
	//				adj.add(getL(n, 1));
	//			if (getL(n,2) != null)
	//				adj.add(getL(n, 2));
	//			if (getL(n, 3) != null)
	//				adj.add(getL(n, 3));
	//			if (getL(n, 4) != null)
	//				adj.add(getL(n, 4));
	//			
	//			return adj;
	//		}
	//		
	//		//1 is up, 2 is right, 2 is down, 4 is left
	//		private Node getL(Node n, int dir){
	//			int x = n.getX();
	//			int y = n.getY();
	//			
	//			int newX = 0;
	//			int newY = 0;
	//			
	//			switch(dir){
	//				case 1:
	//					newX = x + 1;
	//					newY = y - 2;
	//					
	//					if (newY < 0 || newX >= board[x].length)
	//						return null;
	//					break;
	//				case 2:
	//					newX = x + 2;
	//					newY = y + 1;
	//					
	//					if (newY >= board.length || newX >= board[x].length)
	//						return null;
	//					break;
	//				case 3:
	//					newX = x + 1;
	//					newY = y + 2;
	//					
	//					if (newY >= board.length || newX >= board[x].length)
	//						return null;
	//					break;
	//				case 4:
	//					newX = x - 1;
	//					newY = y + 2;
	//					
	//					if (newY >= board.length || newX < 0)
	//						return null;
	//					break;
	//			}
	//			
	//			return board[newX][newY];
	//		}
	//		
	////		private Node getUpL(Node n){
	////			int x = n.getX();
	////			int y = n.getY();
	////			
	////			int newX = x + 1;
	////			int newY = y - 2;
	////			
	////			if (newY < 0 || newX >= board[x].length)
	////				return null;
	////			
	////			return board[newX][newY];
	////		}
	////		
	////		private Node getDownL(Node n){
	////			int x = n.getX();
	////			int y = n.getY();
	////			
	////			int newX = x + 1;
	////			int newY = y - 2;
	////			
	////			if (newY < 0 || newX >= board[x].length)
	////				return null;
	////			
	////			return board[newX][newY];
	////		}
	//	}

	class Node{
		private int x, y, val;
		private boolean visited;

		public Node(int x, int y, int val){
			this.x = x;
			this.y = y;
			this.val = val;
			visited = false;
		}

		public int getX(){
			return x;
		}

		public int getY(){
			return y;
		}

		public int getValue(){
			return val;
		}

		public boolean isVisited(){
			return visited;
		}

		public void visit(){
			visited = true;
		}

		public boolean equals(Object o){
			Node n = (Node) o;

			return n.getX() == this.getX() && n.getY() == this.getY();
		}
	}

	class QueueItem{
		private Node n;
		private List<Node> path;

		public QueueItem(Node n, List<Node> p){
			this.n = n;
			path = p;
		}

		public Node getNode(){
			return n;
		}

		public List<Node> getPath(){
			return path;
		}

		public void addToPath(Node n){
			path.add(n);
		}

		public List<Node> getAdjacent(Answer b){
			return b.getAdjacentNodes(n);
		}
	}

	public static int answer(int src, int dest) { 
		if (src > 63 || dest > 63 || src < 0 || dest < 0)
			return 0;
		// Your code goes here.
		String srcPos = getPosOnBoard(src);
		String destPos = getPosOnBoard(dest);
		
		Node head = board[Integer.parseInt(srcPos.substring(0,1))][Integer.parseInt(srcPos.substring(1))];
		Node end = board[Integer.parseInt(destPos.substring(0,1))][Integer.parseInt(destPos.substring(1))];
//		Board b = new Board(Integer.parseInt(srcPos.substring(0,1)), Integer.parseInt(srcPos.substring(1)), Integer.parseInt(destPos.substring(0,1)) , 
//				Integer.parseInt(destPos.substring(1)));

		List<Node> shortestPath = answer(head, end);

		return shortestPath.size();
	}

	public static String getPosOnBoard(int num){
		int n = 0;
		int row = 0, col = 0;
		String s = "";

		for (int x = 0; x < 8; x++){
			for (int y = 0; y < 8; y++){
				if (n == num){
					row = x;
					col = y;
				}
				n++;
			}
		}

		s = row + "" + col;

		return s;
	}

	public static List<Node> answer(Node head, Node end, Answer a){
		Queue<QueueItem> inQueue = new LinkedList<QueueItem>();
		head.visit();
		QueueItem q = new QueueItem(head, new ArrayList<Node>());
		inQueue.offer(q);

		while(!inQueue.isEmpty()){
			QueueItem nextQueueItem = inQueue.poll();
			nextQueueItem.getNode().visit();
			nextQueueItem.addToPath(nextQueueItem.getNode());
			if(nextQueueItem.getNode().equals(end)) {
				return nextQueueItem.getPath();
			}

			List<Node> adjacent = nextQueueItem.getAdjacent(a);
			for (int x = 0; x < adjacent.size(); x++){
				if (!adjacent.get(x).isVisited()){
					adjacent.get(x).visit();
					List<Node> path = nextQueueItem.getPath();
					QueueItem temp = new QueueItem(adjacent.get(x), new ArrayList<Node>(path));
					inQueue.offer(temp);
				}
			}
		}

		return null;
	}

	public static void main(String[] args){

		//		public static List<Tile> calculateBFS(Tile head, Maze m){
		//	        Queue<QueueItem> inQueue = new LinkedList<QueueItem>();
		//	        head.visit();
		//	        QueueItem q = new QueueItem(head, new ArrayList<Tile>());
		//	        inQueue.offer(q);
		//
		//	        while(!inQueue.isEmpty()){
		//	            QueueItem nextQueueItem = inQueue.poll();
		//	            nextQueueItem.getTile().visit();
		//	            nextQueueItem.addToPath(nextQueueItem.getTile());
		//	            if(nextQueueItem.getTile().equals(m.getGoalTile())) {
		//	                return nextQueueItem.getPath();
		//	            }
		//
		//	            List<Tile> adjacent = nextQueueItem.getAdjacent(m);
		//	            for (int x = 0; x < adjacent.size(); x++){
		//	                if (!adjacent.get(x).isVisited() && adjacent.get(x).isTraversable()){
		//	                    adjacent.get(x).visit();
		//	                    List<Tile> path = nextQueueItem.getPath();
		//	                    QueueItem temp = new QueueItem(adjacent.get(x), new ArrayList<Tile>(path));
		//	                    inQueue.offer(temp);
		//	                }
		//	            }
		//	        }
		//
		//	        return null;
		//	    }

	}
}
