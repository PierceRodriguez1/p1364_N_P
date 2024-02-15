package fa.dfa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import fa.State;
/**
 * This class creates 3 hashsets, 1 hashmap and a DFAState to handle
 * creating a deterministic finite automata. We have the functionality
 * to handle creating a DFA, printing out its five tuple as well as
 * determining if a string is accepted by that machine.
 * @author Pierce Rodriguez and Nolan Stetz
 */
public class DFA implements DFAInterface{
    
    //Instantiating our hashsets for regular states, final states and our alphabet
    private Set<DFAState> states;
    private Set<DFAState> finalStates;
    private Set<Character> alphabet;

    private Map<Character, DFAState> transitions;
    //Instantiating our start DFAState
    private DFAState start;

    /**
     * Constructor that initializes empty DFA
     */
    public DFA(){
        states = new HashSet<>();
        finalStates = new HashSet<>();
        alphabet = new HashSet<>();
        transitions = new HashMap<>();
        start = null;
    }
    @Override
    public boolean addState(String name){
       //adding a new state to our states hashset
       return states.add(new DFAState(name));

    }

    @Override
    public boolean setFinal(String name) {
        //adding it to our final states
        return finalStates.add(new DFAState(name));
        
    }

    @Override   
    public boolean setStart(String name) {
      //creates a new state to become a start state.
        return start.setName(name);
    
    }

    @Override
    public void addSigma(char symbol) {
        //adds a new character to alphabet
        alphabet.add(symbol);
    }

    @Override
    public boolean accepts(String s) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'accepts'");
    }

    @Override
    public Set<Character> getSigma() {
        
        Set<Character> sigmaSet = new HashSet<>(); //creating a new set to return
        
        for(char sigma: alphabet){
        sigmaSet.add(sigma); //looping thru alphabet to add to new set
        }

        return sigmaSet; //returning alphabet in new set

    }

    @Override
    public State getState(String name) {
        //checking all three places(regular states, start and final) a state can be 
        //to see if it's created
        DFAState getState = new DFAState(name); //creating a new state to check against hashset instead of string

        if(states.contains(getState) == true){
            return new DFAState(name);
        } else if(finalStates.contains(getState) == true){
            return new DFAState(name);
        } else if (start.getName() == name){
            return new DFAState(name);
        }

        return null;
        
    }
    

    @Override
    public boolean isFinal(String name) {
        DFAState isFinal = new DFAState(name);
        //checking if state name given is a final state and then return true or false
        if(finalStates.contains(isFinal) == true){
            return true;
        }
        System.out.println(name + " is not a final state");
        return false;
    }

    @Override
    public boolean isStart(String name) {
        //checking if state name given is a start state and then return true or false
        if (start.getName() == name){
            return true;
        }
        return false;
        
    }

    @Override
    public boolean addTransition(String fromState, String toState, char onSymb) {
        

        Iterator<DFAState> i = states.iterator();

        while(i.hasNext()){
            if(!((State) i).getName().equals(fromState) || !((State) i).getName().equals(toState)){
                return false;
            }
        }

        Iterator<DFAState> h = finalStates.iterator();

        while(h.hasNext()){
            if(!((State) h).getName().equals(fromState) || !((State) h).getName().equals(toState)){
                return false;
            }
        }
        
        if( start.getName() != fromState || start.getName() != toState){
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
