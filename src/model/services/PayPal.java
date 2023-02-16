package model.services;

public class PayPal implements PaymentService {
	
	public PayPal() {
	}
	
	@Override
	public double interest(double amount, int month) {
		double monthInst = amount + amount*0.01*month;
		return monthInst + monthInst*0.02;
	}

}
