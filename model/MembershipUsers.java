package app.model;

import java.util.Date;


public class MembershipUsers extends Users {
	protected float revenue;

	public MembershipUsers(String userName, String password, Date created, Boolean isMember, String firstName,
			String lastName, String email, String phone, CompetencyLevel competencyLevel, float revenue) {
		super(userName, password, created, isMember, firstName, lastName, email, phone, competencyLevel);
		this.revenue = revenue;
	}
	
	
	public MembershipUsers(String userName) {
		super(userName);
	}



	public float getRevenue() {
		return revenue;
	}

	public void setRevenue(float revenue) {
		this.revenue = revenue;
	}
	
}
	
	
	
