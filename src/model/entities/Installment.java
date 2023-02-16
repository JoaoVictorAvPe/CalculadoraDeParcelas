package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Installment {
	private LocalDate installmentDate;
	private Double installmentValue;

	public Installment() {
	}

	public Installment(LocalDate installmentDate, Double installmentValue) {
		this.installmentDate = installmentDate;
		this.installmentValue = installmentValue;
	}

	public LocalDate getInstallmentDate() {
		return installmentDate;
	}

	public Double getInstallmentValue() {
		return installmentValue;
	}

	@Override
	public String toString() {
		return installmentDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " - "
				+ String.format("%.2f", installmentValue);
	}
}
