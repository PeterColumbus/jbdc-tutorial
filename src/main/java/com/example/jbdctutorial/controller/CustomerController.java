package com.example.jbdctutorial.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.jbdctutorial.repository.Customer;
import com.example.jbdctutorial.repository.CustomerRepository;
import com.example.jbdctutorial.repository.KartuKredit;
import com.example.jbdctutorial.service.CustomerServices;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	private final CustomerServices customerServices;
	
	@Autowired
	public CustomerController(CustomerServices customerServices) {
		this.customerServices = customerServices;
	}
	//CustomerRepository customerRepository;
	
	
	@GetMapping("/test")
	public String cek() {
		return "berhasil masuk";
	}
	
	/*
	@GetMapping("/user")
	public ArrayList<String> getAllUserNames(){
		return customerRepository.getAllUserNames();
	}
	*/
	/*
	@GetMapping("/all")
	public List<Customer> getAllCustomers(){
		return customerServices.getAllCustomers();
	}
	*/
	// kurang keterangan pagenya
	@GetMapping
	public ResponseEntity<Object> getAllCustomersP(@RequestParam(name = "limit", defaultValue= "10")int limit, 
												@RequestParam(name = "page", defaultValue = "1")int page){
		//int total = customerServices.getAllCustomers().size();
		return new ResponseEntity<>(customerServices.getAllCustomersP(limit, page), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public List<Customer> getCustomerById(@PathVariable int id){
		return customerServices.getCustomerById(id);
	}
	
	@GetMapping("/name/{id}")
	public List<Customer> getCustomerByName(@PathVariable String id){
		return customerServices.getCustomerByName(id);
	}
	
	@GetMapping("/gender/{id}")
	public List<Customer> getCustomerByGender(@PathVariable String id){
		return customerServices.getCustomerByGender(id);
	}
	
	@GetMapping("/priority/{id}")
	public List<Customer> getCustomerByPrior(@PathVariable int id){
		return customerServices.getCustomerByPriority(id);
	}
	
	@PostMapping
	public void addCustomer(@RequestBody Customer customer) {
		customerServices.addNewCustomer(customer);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCustomer(@PathVariable int id) {
		customerServices.deleteCustomer(id);
	}
	
	@PutMapping("/{id}")
    public void updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
        customerServices.updateCustomer(id, customer);
    }
	
	/*
	@GetMapping("/cc")
	public List<KartuKredit> getAllCC(){
		return customerServices.getAllCC();
	}
	*/
	
	// kurang keterangan pagenya
		@GetMapping("/cc")
		public ResponseEntity<Object> getAllCCP(@RequestParam(name = "limit", defaultValue= "10")int limit, 
													@RequestParam(name = "page", defaultValue = "1")int page){
			//int total = customerServices.getAllCustomers().size();
			return new ResponseEntity<>(customerServices.getAllCCP(limit, page), HttpStatus.OK);
		}
	
	@GetMapping("/cc/{id}")
	public List<KartuKredit> getAllCCbyId(@PathVariable int id){
		return customerServices.getAllCCbyId(id);
	}
	@GetMapping("/cc/limit/{var}")
	public List<KartuKredit> getAllCCbyLimit(@PathVariable int var){
		return customerServices.getAllCCbyLimit(var);
	}
	@GetMapping("/cc/nocc/{var}")
	public List<KartuKredit> getAllCCbyNocc(@PathVariable int var){
		return customerServices.getAllCCbyNocc(var);
	}
	
	@GetMapping("/cc/jenis/{id}")
	public List<KartuKredit> getAllCCbyJenis(@PathVariable String id){
		return customerServices.getAllCCbyJenis(id);
	}
	
	@PostMapping("/cc")
	public void addCC(@RequestBody KartuKredit cc) {
		customerServices.addNewCC(cc);
	}
	@DeleteMapping("cc/{id}")
	public void deleteCC(@PathVariable int id) {
		customerServices.deleteCC(id);
	}
	@PutMapping("/cc/{id}")
    public ResponseEntity<Object> updateCC(@PathVariable int id, @RequestBody KartuKredit kartukredit) {
        customerServices.updateCC(id, kartukredit);
        return new ResponseEntity<>("Data update success", HttpStatus.OK);
    }
}
