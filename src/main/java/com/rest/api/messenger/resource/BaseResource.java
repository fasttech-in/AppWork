package com.rest.api.messenger.resource;

public class BaseResource {
	private static int hitCounter = 0;
	public BaseResource() {
	//		System.out.println("Inside BaseResource Constructor.");
		hitCounter++;
	}

	public int getHitCounter(){
		return hitCounter;
	}
}
