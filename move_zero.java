import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


public class move_zero {
	static HashMap<String,Integer> Level = new HashMap<String, Integer>(); // HashMap is used to ignore repeated nodes
	static HashMap<String,String> All_States = new HashMap<String,String>();
	public static Queue<String> bfs= new LinkedList<String>();
	
	// Moving 0 up and modifying the screen
	static void up(String intermediate_state){
        int a = intermediate_state.indexOf("0");
        if(a>2){
            String nextState = intermediate_state.substring(0,a-3)+"0"+intermediate_state.substring(a-2,a)+intermediate_state.charAt(a-3)+intermediate_state.substring(a+1);
            isItFinalState(intermediate_state, nextState);
        }
    }
	// Moving 0 down and modifying String 
    static void down(String intermediate_state){
        int a = intermediate_state.indexOf("0");
        if(a<6){
            String nextState = intermediate_state.substring(0,a)+intermediate_state.substring(a+3,a+4)+intermediate_state.substring(a+1,a+3)+"0"+intermediate_state.substring(a+4);
            isItFinalState(intermediate_state, nextState);
        }
    }
    //Moving 0 left and modifying String
    static void left(String intermediate_state){
        int a = intermediate_state.indexOf("0");
        if(a!=0 && a!=3 && a!=6){
            String nextState = intermediate_state.substring(0,a-1)+"0"+intermediate_state.charAt(a-1)+intermediate_state.substring(a+1);
            isItFinalState(intermediate_state, nextState);
        }
    }
    //Moving 0 right and modifying String 
    static void right(String intermediate_state){
        int a = intermediate_state.indexOf("0");
        if(a!=2 && a!=5 && a!=8){
            String nextState = intermediate_state.substring(0,a)+intermediate_state.charAt(a+1)+"0"+intermediate_state.substring(a+2);
            isItFinalState(intermediate_state, nextState);
        }
    }
    // Checking whether we have reached the final state
    private static void isItFinalState(String oldState, String newState) {
        put_into_hashmap(newState, oldState);		// Adding the new state to the queue
        if(newState.equals("123456780")) {
            System.out.println("Solution Exists at Level "+Level.get(newState)+" of the tree");		// printing at which depth its exist
            String traceState = newState;
            while (traceState != null) {													// Fethcing all its intermediate state
                System.out.println(traceState + " at " + Level.get(traceState));
                traceState = All_States.get(traceState);
            }
            System.exit(0);
        }
    }
    // Adding new entry into hashmap
	static void put_into_hashmap(String newState, String oldState){
    if(!Level.containsKey(newState)){								// checking if the entry exist, if exist incrementing the level
        int newValue = oldState == null ? 0 : Level.get(oldState) + 1;
       Level.put(newState, newValue);					//Adding, to count the depth 
        bfs.add(newState);							//Adding to the queue
        All_States.put(newState, oldState);				//Maintaining the history 
    }	
} 
	
}
