package com.example.jbdctutorial.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.jbdctutorial.Paging;
import com.example.jbdctutorial.PagingCC;
import com.example.jbdctutorial.entity.Customer;
import com.example.jbdctutorial.entity.KartuKredit;
import com.example.jbdctutorial.repository.CustomerRepository;

@Service
public class CustomerServices {
	
	private final CustomerRepository customerRepository;
	
	@Autowired
	public CustomerServices(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	/*
	public List<Customer> getAllCustomers(String gender, String name, Boolean prior, int id){
		return customerRepository.selectAllCustomers(gender, name, prior, id);
	}
	*/
	
	public Paging getAllCustomersP(int lim, int page, String gender, String name, Boolean prior, int id){
		double total_data = customerRepository.selectAllCustomers(gender, name, prior, id).size();
		List<Customer> datas = customerRepository.selectAllCustomersP(lim, page, gender, name, prior, id);
		double total_page = Math.ceil(total_data/lim);
		
		return new Paging(page, (int)total_page , (int)total_data, datas);
	}
	
	/*
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
	*/
	
	
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
	
	/*
	public List<KartuKredit> getAllCC(){
		return customerRepository.selectAllCC();
	}
	*/
	
	public PagingCC getAllCCP(int lim, int page, int id_kartu, String jenis, int limit, int id_owner){
		double total_data = customerRepository.selectAllCC(id_kartu, jenis, limit, id_owner).size();
		List<KartuKredit> datas = customerRepository.selectAllCCP(lim, page, id_kartu, jenis, limit, id_owner);
		double total_page = Math.ceil(total_data/lim);
		
		return new PagingCC(page, (int)total_page , (int)total_data, datas);
	}
	
	/*
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
	*/
	
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
	
	public boolean genderChecking(String var) {
		if(var.compareToIgnoreCase("male")== 0 || var.compareToIgnoreCase("female")== 0) {
			return true;
		}
		else
			return false;
	}
	
	public boolean jenisChecking(String var) {
		if(var.compareToIgnoreCase("platinum")== 0 || var.compareToIgnoreCase("gold")== 0 || var.compareToIgnoreCase("silver")== 0) {
			return true;
		}
		else
			return false;
	}
	public boolean emailChecking(String var) {
		if(var.contains("@"))
			return true;
		else
			return false;
	}
	
	public boolean dateChecking(String strDate){
		/* Check if date is 'null' */
		if (strDate.trim().equals(""))
		{
		    return false;
		}
		/* Date is not 'null' */
		else
		{
		    /* Set preferred date format,
		     * For example MM-dd-yyyy, MM.dd.yyyy,dd.MM.yyyy etc.*/
		    SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy-MM-dd");
		    sdfrmt.setLenient(false);
		    /* Create Date object
		     * parse the string into date 
	             */
		    try
		    {
		        Date javaDate = sdfrmt.parse(strDate); 
		        //System.out.println(strDate+" is valid date format");
		    }
		    /* Date format is invalid */
		    catch (ParseException e)
		    {
		        //System.out.println(strDate+" is Invalid Date format");
		        return false;
		    }
		    /* Return true if date format is valid */
		    return true;
		}
	}
}
