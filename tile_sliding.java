/* Name: Jeevjyot Singh Chhabda
 * Assignmnt: Tile Sliding Domain a.k.a 8 Puzzle 
 * 
 */


import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.logging.Level;

public class tile_sliding {

	public static void main(String args[])
	{
		String initial_state="124357680";
		move_zero mv= new move_zero();
		mv.put_into_hashmap(initial_state, null);		
		
		while(!mv.bfs.isEmpty())
		{
			
			String intermediate_state=mv.bfs.remove();
			mv.down(intermediate_state);
			mv.left(intermediate_state);
			mv.right(intermediate_state);
			mv.up(intermediate_state);
		}
		System.out.println("You are in some WEIRD State, No solution EXIST, I'm Sorry :(");
		
		
	}
	
}
