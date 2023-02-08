package com.postgresql.test.select_equal_like;

public class Actor {
	
	private Integer actorID;
	private String firstName;
	private String lastName;
	private String lastUpdate;
	
	public Actor() {
		
	}
	
	public Actor(Integer actorID, String firstName, String lastName, String lastUpdate){
		this.actorID = actorID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.lastUpdate = lastUpdate;
	}

	public Integer getActorID() {
		return actorID;
	}

	public void setActorID(Integer actorID) {
		this.actorID = actorID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public String toString() {
		return "Actor [" + actorID + ", " + firstName + ", " + lastName + ", "
				+ lastUpdate + "]";
	}
	
	

}
