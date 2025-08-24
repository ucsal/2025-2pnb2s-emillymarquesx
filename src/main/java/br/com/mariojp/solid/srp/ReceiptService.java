package br.com.mariojp.solid.srp;

public class ReceiptService {

	private final TaxCalculator taxCalculator;
	private final ReceiptFormatter formatter;

	public ReceiptService(){
		this.taxCalculator = new TaxCalculator();
		this.formatter = new ReceiptFormatter();
	}

	public String generate(Order order) {
		double subtotal = order.getItems().stream().mapToDouble(i -> i.getUnitPrice() * i.getQuantity()).sum();
		double tax = taxCalculator.calculate(subtotal);
		double total = subtotal + tax;

		return formatter.format(order, subtotal, tax, total);
	}
}
