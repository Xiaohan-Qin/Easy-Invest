package model;

import java.util.Date;

public class MembershipSubscription extends MembershipUsers {
	protected int transactionId;
	protected String UserName;
	protected double subscriptionPrice;
	protected Date startDate;
	
	public MembershipSubscription(int transactionId, String userName, double subscriptionPrice, Date startDate) {
		super(userName);
		this.transactionId = transactionId;
		this.subscriptionPrice = subscriptionPrice;
		this.startDate = startDate;
	}

	public MembershipSubscription(String userName, double subscriptionPrice, Date startDate) {
		super(userName);
		this.subscriptionPrice = subscriptionPrice;
		this.startDate = startDate;
	}
	
	public MembershipSubscription(int transactionId) {
		this.transactionId = transactionId;
	}
	
	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public double getSubscriptionPrice() {
		return subscriptionPrice;
	}

	public void setSubscriptionPrice(double subscriptionPrice) {
		this.subscriptionPrice = subscriptionPrice;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
}
