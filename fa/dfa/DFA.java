package fa.dfa;

import java.io.EOFException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import fa.State;

public class DFA implements DFAInterface{

    private HashSet<DFAState> states = new HashSet<>();
    private HashSet<DFAState> finalStates = new HashSet<>();
    private HashSet<DFAState> alphabet = new HashSet<>();

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
        //String str = new String();
        Set<Character> sigmaSet = new HashSet<>();
        for(char sigma: alphabet){
        sigmaSet.add(sigma);
        }

        return sigmaSet;

    }

    @Override
    public State getState(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getState'");
    }

    @Override
    public boolean isFinal(String name) {
        if(finalStates.contains(name)){
            return true;
        }
        System.out.println(name + " is not a final state");
        return false;
    }

    @Override
    public boolean isStart(String name) {
        
        if(startStates.contains(name)){
            return true;
        }
        System.out.println(name + " is not a start state");
        return false;
    }

    @Override
    public boolean addTransition(String fromState, String toState, char onSymb) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addTransition'");
    }

    @Override
    public DFA swap(char symb1, char symb2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'swap'");
    }
    
}
