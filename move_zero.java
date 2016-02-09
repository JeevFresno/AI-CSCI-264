import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


public class move_zero {
	static HashMap<String,Integer> Level = new HashMap<String, Integer>(); // HashMap is used to ignore repeated nodes
	static HashMap<String,String> All_States = new HashMap<String,String>();
	public static Queue<String> bfs= new LinkedList<String>();
	
	 private static void isItFinalState(String oldState, String newState) {
	        put_into_hashmap(newState, oldState);
	        if(newState.equals("123456780")) {
	            System.out.println("Solution Exists at Level "+Level.get(newState)+" of the tree");
	            String traceState = newState;
	            while (traceState != null) {
	                System.out.println(traceState + " at " + Level.get(traceState));
	                traceState = All_States.get(traceState);
	            }
	            System.exit(0);
	        }
	    }
    static void put_into_hashmap(String newState, String oldState){
        if(!Level.containsKey(newState)){
            int newValue = oldState == null ? 0 : Level.get(oldState) + 1;
           Level.put(newState, newValue);
            bfs.add(newState);
            All_States.put(newState, oldState);
        }
    } 
	
	static void up(String currentState){
        int a = currentState.indexOf("0");
        if(a>2){
            String nextState = currentState.substring(0,a-3)+"0"+currentState.substring(a-2,a)+currentState.charAt(a-3)+currentState.substring(a+1);
            isItFinalState(currentState, nextState);
        }
    }

    static void down(String currentState){
        int a = currentState.indexOf("0");
        if(a<6){
            String nextState = currentState.substring(0,a)+currentState.substring(a+3,a+4)+currentState.substring(a+1,a+3)+"0"+currentState.substring(a+4);
            isItFinalState(currentState, nextState);
        }
    }
    static void left(String currentState){
        int a = currentState.indexOf("0");
        if(a!=0 && a!=3 && a!=6){
            String nextState = currentState.substring(0,a-1)+"0"+currentState.charAt(a-1)+currentState.substring(a+1);
            isItFinalState(currentState, nextState);
        }
    }
    static void right(String currentState){
        int a = currentState.indexOf("0");
        if(a!=2 && a!=5 && a!=8){
            String nextState = currentState.substring(0,a)+currentState.charAt(a+1)+"0"+currentState.substring(a+2);
            isItFinalState(currentState, nextState);
        }
    }
	
}
