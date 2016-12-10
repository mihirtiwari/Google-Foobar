package challenge2;

import java.util.ArrayList;
import java.util.List;

import challenge2.Answer.Node;

public class Answer2 {

	private static int[][] board = new int[8][8];

	public Answer2(){
		int num = 0;
		for (int row = 0; row < board.length; row++){
			for (int col = 0; col < board[row].length; col++){
				board[row][col] = num;
				num++;
			}
		}
	}

	public static int answer(int src, int dest) { 

		// Your code goes here.

		//I know it is breath first search but I do not know
		//how to implement it

		List<Integer> l = answer(src, dest, new ArrayList<Integer>());

		return l.size();
	} 

	private static List answer(int current, int end, ArrayList<Integer> path){
		if (current == end){
			path.add(end);
			return path;
		}

		List<Integer> adjacent = getAdjacentNums(current);

		if (!containsAllNeg(adjacent)){		
			int x = 0;

			while (x < adjacent.size()){
				int next = adjacent.get(x);

				if (next != -1){
					path.add(next);

					int nextX = Integer.parseInt(getPos(next).substring(0,1));
					int nextY = Integer.parseInt(getPos(next).substring(1));

					board[nextX][nextY] = -1;

					return  answer(next, end, path);
				}
			}
		}

		return null;
	}

	public static boolean containsAllNeg(List<Integer> i){
		for (int j : i)
			if (j != -1)
				return false;

		return true;
	}

	private static String getPos(int num){
		int n = 0;
		int xPos = 0;
		int yPos = 0;

		for (int x = 0; x < board.length; x++){
			for (int y = 0; y < board[x].length; y++){
				if (n == num){
					xPos = x;
					yPos = y;
				}
			}
		}

		return xPos + "" + yPos;
	}

	private static List getAdjacentNums(int n){
		ArrayList<Integer> adj = new ArrayList<Integer>();
		if (getL(n, 1) != -1)
			adj.add(getL(n, 1));
		if (getL(n,2) != -1)
			adj.add(getL(n, 2));
		if (getL(n, 3) != -1)
			adj.add(getL(n, 3));
		if (getL(n, 4) != -1)
			adj.add(getL(n, 4));

		return adj;
	}

	//1 is up, 2 is right, 2 is down, 4 is left
	private static int getL(int n, int dir){
		int x = Integer.parseInt(getPos(n).substring(0,1));
		int y = Integer.parseInt(getPos(n).substring(1));

		int newX = 0;
		int newY = 0;

		switch(dir){
		case 1:
			newX = x + 1;
			newY = y - 2;

			if (newY < 0 || newX >= board[x].length)
				return -1;
			break;
		case 2:
			newX = x + 2;
			newY = y + 1;

			if (newY >= board.length || newX >= board[x].length)
				return -1;
			break;
		case 3:
			newX = x + 1;
			newY = y + 2;

			if (newY >= board.length || newX >= board[x].length)
				return -1;
			break;
		case 4:
			newX = x - 1;
			newY = y + 2;

			if (newY >= board.length || newX < 0)
				return -1;
			break;
		}

		return board[newX][newY];
	}

	public static void main(String[] args){
		Answer2 a = new Answer2();

		System.out.println(a.answer(19, 36));
	}
}
