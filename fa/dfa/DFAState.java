package fa.dfa;

import java.util.HashMap;
import java.util.Map;

import fa.State;

public class DFAState extends State{
    private Map<Character, State> transitionMap;
    
    public DFAState(String name) {
        super(name);
        transitionMap = new HashMap<>();
    }

    public void addTransition(char symbol, State nextState){
        transitionMap.put(symbol, nextState);
    }

    public State nextState(char symbol){
        return transitionMap.get(symbol);
    }

}
