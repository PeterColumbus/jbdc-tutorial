package com.example.jbdctutorial.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.jbdctutorial.repository.Customer;
import com.example.jbdctutorial.repository.CustomerRepository;
import com.example.jbdctutorial.repository.KartuKredit;

@Service
public class CustomerServices {
	
	private final CustomerRepository customerRepository;
	
	@Autowired
	public CustomerServices(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	public List<Customer> getAllCustomers(){
		return customerRepository.selectAllCustomers();
	}
	
	public List<Customer> getAllCustomersP(int limit, int page){
		return customerRepository.selectAllCustomersP(limit, page);
	}
	
	public List<Customer> getCustomerById(int id){
		return customerRepository.selectCustomerById(id);
	}
	
	public List<Customer> getCustomerByName(String name){
		return customerRepository.selectCustomerByName(name);
	} 
	
	public List<Customer> getCustomerByGender(String gender){
		return customerRepository.selectCustomerByGender(gender);
	}
	
	public List<Customer> getCustomerByPriority(int prior){
		return customerRepository.selectCustomerByPrior(prior);
	}
	
	public void addNewCustomer(Customer customer) {
		customerRepository.insertCustomer(customer);
	}
	
	public void deleteCustomer(int id) {
		customerRepository.deleteCustomer(id);
	}
	
	public void updateCustomer(int id, Customer customer) {
		Optional.ofNullable(customer.getEmail())
        		.ifPresent(email -> customerRepository.updateCustomerEmail(id, email));

		Optional.ofNullable(customer.getName())
        		.filter(name -> !StringUtils.isEmpty(name))
        		.map(StringUtils::capitalize)
        		.ifPresent(name -> customerRepository.updateCustomerName(id, name));

		Optional.ofNullable(customer.getGender())
				.ifPresent(gender -> customerRepository.updateCustomerGender(id, gender));
		
		Optional.ofNullable(customer.getAddress())
				.filter(address -> !StringUtils.isEmpty(address))
				.map(StringUtils::capitalize)
				.ifPresent(address -> customerRepository.updateCustomerAddress(id, address));
		
		Optional.ofNullable(customer.getPriority())
				.ifPresent(prior -> customerRepository.updateCustomerPrior(id, prior));
		
		Optional.ofNullable(customer.getPhone())
				.ifPresent(phone -> customerRepository.updateCustomerPhone(id, phone));
		
	}
	
	public List<KartuKredit> getAllCC(){
		return customerRepository.selectAllCC();
	}
	
	public List<KartuKredit> getAllCCP(int limit, int page){
		return customerRepository.selectAllCCP(limit, page);
	}
	
	public List<KartuKredit> getAllCCbyId(int id){
		return customerRepository.selectAllCCById(id);
	}
	
	public List<KartuKredit> getAllCCbyJenis(String var){
		return customerRepository.selectAllCCByJenis(var);
	}
	
	public List<KartuKredit> getAllCCbyLimit(int var){
		return customerRepository.selectAllCCByLimit(var);
	}
	
	public List<KartuKredit> getAllCCbyNocc(int var){
		return customerRepository.selectAllCCByNocc(var);
	}
	
	public void addNewCC(KartuKredit cc) {
		customerRepository.insertCC(cc);
	}
	
	public void deleteCC(int id) {
		customerRepository.deleteCC(id);
	}
	
	public void updateCC(int id, KartuKredit cc) {
		Optional.ofNullable(cc.getName())
				.filter(name -> !StringUtils.isEmpty(name))
				.map(StringUtils::capitalize)
        		.ifPresent(name -> customerRepository.updateCCName(id, name));

		Optional.ofNullable(cc.getJenis())
        		.ifPresent(jenis -> customerRepository.updateCCjenis(id, jenis));

		Optional.ofNullable(cc.getDate())
				.ifPresent(date -> customerRepository.updateCCDate(id, date));
		
		/*
		Optional.ofNullable(cc.getLimit())
				.ifPresent(limitt -> customerRepository.updateCCLimit(id, limitt));
		*/
		/*
		Optional.ofNullable(cc.getIdowner())
				.ifPresent(idowner -> customerRepository.updateCCidowner(id, idowner));
		*/
		if(cc.getLimit()!=0) {
			customerRepository.updateCCLimit(id, cc.getLimit());
		}
		if(cc.getIdowner()!=0) {
			customerRepository.updateCCidowner(id, cc.getIdowner());
		}
	}
}
