package com.kylemiles.mockdraftsjdbc.model.entity;

public enum Round {

	  FIRST(1), 
	  SECOND(2), 
	  THIRD(3), 
	  FOURTH(4), 
	  FIFTH(5), 
	  SIXTH(6), 
	  SEVENTH(7);
	  
	  private int value;
	
	Round (int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
}
