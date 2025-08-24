package br.com.mariojp.solid.srp;

public class TaxCalculator {

	private double taxRate;

	public TaxCalculator() {
		String taxRateStr = System.getProperty("tax.rate", "0.10");
		this.taxRate = Double.parseDouble(taxRateStr);
	}

	public double calculate(double amount) {
        return amount * taxRate;
    }

    public double getTaxRate() {
        return taxRate;
    }
}
