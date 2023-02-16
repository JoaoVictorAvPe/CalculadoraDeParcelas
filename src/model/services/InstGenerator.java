package model.services;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class InstGenerator {
	
	private Integer qtdInstallment;
	private PaymentService payService;
	
	public InstGenerator(Integer qtdInstallment, PaymentService payService) {
		this.qtdInstallment = qtdInstallment;
		this.payService = payService;
	}
	
	public Integer getQtdInstallment() {
		return qtdInstallment;
	}
	public void setQtdInstallment(Integer qtdInstallment) {
		this.qtdInstallment = qtdInstallment;
	}
	public PaymentService getPayService() {
		return payService;
	}
	public void setPayService(PaymentService paymentService) {
		this.payService = paymentService;
	}
	
	public void processInstallments(Contract contract) {
		double instValue = contract.getValue() / qtdInstallment;
		
		for (int month=1; month<=qtdInstallment; month++) {
			LocalDate installmentDate = contract.getDate().plusMonths(month);
			double installmentValue = getPayService().interest(instValue, month);
			contract.getContInstallments().add(new Installment(installmentDate, installmentValue));
		}
	}
	
}
