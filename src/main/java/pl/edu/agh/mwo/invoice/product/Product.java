package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public abstract class Product {
	private final String name;

	private final BigDecimal price;

	private final BigDecimal taxPercent;

	protected Product(String name, BigDecimal price, BigDecimal tax) {
		if(name.isEmpty())
			throw new IllegalArgumentException("Object name is empty");
		if(name.equals(null))
			throw new IllegalArgumentException("Name is null");
		if(price.equals(null))
			throw new IllegalArgumentException("Price is null");
		if (price.longValue() < 0)
			throw new IllegalArgumentException("Price is lower than 0");
		this.name = name;
		this.price = price;
		this.taxPercent = tax;
	}

	public String getName() {
		return this.name;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public BigDecimal getTaxPercent() {
		return this.taxPercent;
	}

	public BigDecimal getPriceWithTax() {
		return this.price.multiply(this.taxPercent.add(BigDecimal.valueOf(1)));
	}
}
