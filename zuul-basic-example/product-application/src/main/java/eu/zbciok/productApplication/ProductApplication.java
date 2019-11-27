package eu.zbciok.productApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

}

@RestController
class ProductController{

	@GetMapping(value = "/products")
	public Product getProduct(){
		return new Product("Syrenka", "The best car.");
	}

}

class Product{

	String productName;

	String productDescription;

	public Product(String productName, String productDescription) {
		this.productName = productName;
		this.productDescription = productDescription;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
}
