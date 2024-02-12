package fa.dfa;

import java.io.EOFException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import fa.State;

public class DFA implements DFAInterface{

    private Set<String> startStates = new HashSet<>();
    private Set<String> finalStates = new HashSet<>();
    private Set<String> normalStates = new HashSet<>();
    private Set<Character> alphabet = new HashSet<>();

    private HashMap<Character, String> transition = new HashMap<>();

    @Override
    public boolean addState(String name){
       
        if(normalStates.contains(name)){
            System.out.println("State name already exists");
        } 
          return normalStates.add(name);

    }

    @Override
    public boolean setFinal(String name) {
        
        if(!finalStates.contains(name)){
            normalStates.remove(name);
            return finalStates.add(name);
        }
        System.out.println("State is already a final state");
        return false;

    }

    @Override
    public boolean setStart(String name) {
        
        if(!startStates.contains(name)){
            normalStates.remove(name);
            return startStates.add(name);
        }
        System.out.println("State is already a start state");
        return false;
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
        
        String str = new String();

        for(char sigma: alphabet){
            str += sigma + ", ";
        }

        return str;

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
