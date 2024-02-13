package fa.dfa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import fa.State;

public class DFA implements DFAInterface{

    private HashSet<DFAState> states = new HashSet<>();
    private HashSet<DFAState> finalStates = new HashSet<>();
    private HashSet<Character> alphabet = new HashSet<>();

    private HashMap<Character, Character> sigma = new HashMap<>();
    private DFAState start;

    @Override
    public boolean addState(String name){
       
       return states.add(new DFAState(name));

    }

    @Override
    public boolean setFinal(String name) {
        
        states.remove(name);
        return finalStates.add(new DFAState(name));
        
    }

    @Override
    public boolean setStart(String name) {
      
        return start.setName(name);
    
    }

    @Override
    public void addSigma(char symbol) {
        alphabet.add(symbol);
    }

    @Override
    public boolean accepts(String s) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'accepts'");
    }

    @Override
    public Set<Character> getSigma() {
        
        Set<Character> sigmaSet = new HashSet<>();
        for(char sigma: alphabet){
        sigmaSet.add(sigma);
        }

        return sigmaSet;

    }

    @Override
    public State getState(String name) {
        
        if(states.contains(name) == true){
            return new DFAState(name);
        } else if(finalStates.contains(name) == true){
            return new DFAState(name);
        } else if (start.getName() == name){
            return new DFAState(name);
        }

        return null;
        
    }
    

    @Override
    public boolean isFinal(String name) {
        if(finalStates.contains(name) == true){
            return true;
        }
        System.out.println(name + " is not a final state");
        return false;
    }

    @Override
    public boolean isStart(String name) {
        
        if (start.getName() == name){
            return true;
        }
        return false;
        
    }

    @Override
    public boolean addTransition(String fromState, String toState, char onSymb) {
        
        if(!states.contains(fromState) || finalStates.contains(fromState) || start.getName() != fromState){
            return false;
        }

        if(!states.contains(toState) || finalStates.contains(toState) || start.getName() != toState){
            return false;
        }

        if (!alphabet.contains(onSymb)) {
            return false;
        }
    }

    @Override
    public DFA swap(char symb1, char symb2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'swap'");
    }
    
}
