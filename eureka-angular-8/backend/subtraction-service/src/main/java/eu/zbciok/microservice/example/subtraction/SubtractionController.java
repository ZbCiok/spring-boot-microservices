package eu.zbciok.microservice.example.subtraction;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eu.zbciok.microservice.example.subtraction.Arithmetic;

@RestController
@RequestMapping("/subtract")
public class SubtractionController {
	
	private int int1 = 0;	
	private int int2 = 0;
	private int subtr = 0; 
	
	@PostMapping
	public void setSubtract(@RequestBody Arithmetic arithmetic) {
		this.int1 = Integer.valueOf(arithmetic.getNr1());
		this.int2 = Integer.valueOf(arithmetic.getNr2());
		this.subtr = this.int1 - this.int2;
	}
	
	@GetMapping()
	public String getSubtr() {
		return "{\"int1\":\"" + this.int1 + "\", \"int2\":\"" + this.int2 + "\", \"subtr\": \"" + this.subtr + "\"}";
	}		
}