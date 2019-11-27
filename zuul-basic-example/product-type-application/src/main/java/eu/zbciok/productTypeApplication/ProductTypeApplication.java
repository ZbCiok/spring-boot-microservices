package eu.zbciok.productTypeApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ProductTypeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductTypeApplication.class, args);
	}

}

@RestController
class ProductController{

	@GetMapping(value = "/product-types")
	public ProductType getProductType(){
		return new ProductType("Cars", "EU cars.");
	}

}

class ProductType {

	String productTypeName;

	String productTypeDescription;

	public ProductType(String productTypeName, String productTypeDescription) {
		this.productTypeName = productTypeName;
		this.productTypeDescription = productTypeDescription;
	}

	public String getProductTypeName() {
		return productTypeName;
	}

	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}

	public String getProductDescription() {
		return productTypeDescription;
	}

	public void setProductTypeDescription(String productTypeDescription) {
		this.productTypeDescription = productTypeDescription;
	}
}
