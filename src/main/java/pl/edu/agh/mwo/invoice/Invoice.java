package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
	private Collection<Product> products = new ArrayList<Product>();

	public void addProduct(Product product) {
		this.products.add(product);
		System.out.println(product.getName() + " " + product.getPrice() + " " + product.getTaxPercent());
	}

	public void addProduct(Product product, Integer quantity) {
		if (quantity <= 0) {
			throw new IllegalArgumentException("Invalid quantity");
		}
		for (int i = 0; i < quantity; i++) {
			this.products.add(product);
		}
	}

	public BigDecimal getSubtotal() {
		BigDecimal subtotal = BigDecimal.ZERO;
		for (Product product : this.products) {
			subtotal = subtotal.add(product.getPrice());
		}
		return subtotal;
	}

	public BigDecimal getTax() {
		BigDecimal tax = BigDecimal.ZERO;
		for (Product product : products) {
			tax = tax.add(product.getPriceWithTax().subtract(product.getPrice()));
		}
		return tax;
	}

	public BigDecimal getTotal() {
		BigDecimal total = BigDecimal.ZERO;
		for (Product product : products) {
			total = total.add(product.getPriceWithTax());
		}
		return total;
	}
}
