package edu.ucsb.cs56.S12.m_a_p.cp3;

import java.io.Serializable;
import java.util.ArrayList;

/** IngredientList is a list of ingredients 

 */
public class IngredientsList extends ArrayList<String> implements Serializable {
	
	/** 
	no arg constructor that just sets up a list
	 */
	 public IngredientsList() {
		    super(1); // we want capacity at least 1
	        }   
	       
	       
	       /**
	       one-arg constructor that takes on string and adds it to the list
	     */
	   
	    public IngredientsList(String r) {
		super(1); // we want capacity at least 1 
		this.add(0,r);
	    }   
}
