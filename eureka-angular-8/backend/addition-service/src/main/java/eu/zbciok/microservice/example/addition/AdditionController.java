package eu.zbciok.microservice.example.addition;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/add")
public class AdditionController {

	private int int1 = 0;	
	private int int2 = 0;
	private int sum = 0; 
	
	@PostMapping 
	public void setAdding(@RequestBody Arithmetic arithmetic) {
		this.int1 = Integer.valueOf(arithmetic.getNr1());
		this.int2 = Integer.valueOf(arithmetic.getNr2());
		this.sum = this.int1 + this.int2;
	}	
	
	@GetMapping()
	public String getAdding() {
		return "{\"int1\":\"" + this.int1 + "\", \"int2\":\"" + this.int2 + "\", \"sum\": \"" + this.sum + "\"}";
	}	
}