package com.example.jbdctutorial.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {
	
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public CustomerRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/*
	public ArrayList<String> getAllUserNames() {
		ArrayList<String> usernameList = new ArrayList<>();
		usernameList.addAll(jdbcTemplate.queryForList("select name from customer", String.class));
		return usernameList;
	}
	*/
	
	public List<Customer> selectAllCustomers(){
		String sql = "" +
				"SELECT id, name, gender, address, email, phone, priority FROM customer";
		
		return jdbcTemplate.query(sql, mapCustomerFromDb());
	}
	
	public List<Customer> selectAllCustomersP(int lim, int page){
		int off = lim * (page - 1);
		String sql = "" +
				"SELECT id, name, gender, address, email, phone, priority FROM customer Limit "+ off + ", " + lim;
		return jdbcTemplate.query(sql, mapCustomerFromDb());
	}
	
	
	public List<Customer> selectCustomerById(int id){
		String sql = "" +
				"SELECT id, name, gender, address, email, phone, priority FROM customer "
				+ "where id ="+ id ;
		
		return jdbcTemplate.query(sql, mapCustomerFromDb());
	}
	
	public List<Customer> selectCustomerByName(String name){
		String sql = "" +
				"SELECT id, name, gender, address, email, phone, priority FROM customer "
				+ "where name ='"+ name + "'" ;
		
		return jdbcTemplate.query(sql, mapCustomerFromDb());
	}
	
	public List<Customer> selectCustomerByGender(String gender){
		String sql = "" +
				"SELECT id, name, gender, address, email, phone, priority FROM customer "
				+ "where gender ='"+ gender + "'" ;
		
		return jdbcTemplate.query(sql, mapCustomerFromDb());
	}
	
	public List<Customer> selectCustomerByPrior(int priority){
		String sql = "" +
				"SELECT id, name, gender, address, email, phone, priority FROM customer "
				+ "where priority = " + priority ;
		
		return jdbcTemplate.query(sql, mapCustomerFromDb());
	}
	
	public int insertCustomer(Customer customer) {
		String sql = ""+
				"insert into customer(name, gender, address, email, phone, priority) " +
				" Values (?, ?, ?, ?, ?, ?)";
		return jdbcTemplate.update(
				sql, 
				customer.getName(),
				customer.getGender(),
				customer.getAddress(),
				customer.getEmail(),
				customer.getPhone(),
				customer.getPriority()
			);
	}
	
	public int deleteCustomer(int id) {
		String sql = ""+
				"delete from customer where id = ? ";
		return jdbcTemplate.update(sql, id);
	}
	
	public int updateCustomerName(int id, String var) {
		String sql = ""+
				"Update customer SET name = ? where id = ?";
		return jdbcTemplate.update(sql,var,id);
	}
	
	public int updateCustomerGender(int id, String var) {
		String sql = ""+
				"Update customer SET gender = ? where id = ?";
		return jdbcTemplate.update(sql,var,id);
	}
	public int updateCustomerAddress(int id, String var) {
		String sql = ""+
				"Update customer SET address = ? where id = ?";
		return jdbcTemplate.update(sql,var,id);
	}
	public int updateCustomerEmail(int id, String var) {
		String sql = ""+
				"Update customer SET email = ? where id = ?";
		return jdbcTemplate.update(sql,var,id);
	}
	public int updateCustomerPrior(int id, boolean var) {
		String sql = ""+
				"Update customer SET priority = ? where id = ?";
		return jdbcTemplate.update(sql,var,id);
	}
	
	public int updateCustomerPhone(int id, String var) {
		String sql = ""+
				"Update customer SET phone = ? where id = ?";
		return jdbcTemplate.update(sql,var,id);
	}

	private RowMapper<Customer> mapCustomerFromDb() {
        return (resultSet, i) -> {
            String idStr = resultSet.getString("id");
            long id = Long.parseLong(idStr);

            String name = resultSet.getString("name");
            String gender = resultSet.getString("gender");
            String address = resultSet.getString("address");
            String email = resultSet.getString("email");
            String phone = resultSet.getString("phone");

            String priorityStr = resultSet.getString("priority");
            boolean priority; //= Boolean.parseBoolean(priorityStr);
            if( Integer.parseInt(priorityStr) == 1 )
            	priority = true;
            else
            	priority = false;
            
            return new Customer(
                    id,
                    name,
                    gender,
                    address,
                    email,
                    phone,
                    priority
            );
        };
    }
	
	public List<KartuKredit> selectAllCC(){
		String sql = "" +
				"SELECT idkartu, name, jenis, exp, limitt, idowner FROM kartukredit";
		
		return jdbcTemplate.query(sql, mapCCFromDb());
	}
	
	public List<KartuKredit> selectAllCCP(int lim, int page){
		int off = lim * (page - 1);
		String sql = "" +
				"SELECT idkartu, name, jenis, exp, limitt, idowner FROM kartukredit Limit "+ off + ", " + lim;
		return jdbcTemplate.query(sql, mapCCFromDb());
	}
	
	public List<KartuKredit> selectAllCCById(int id){
		String sql = "" +
				"SELECT idkartu, name, jenis, exp, limitt, idowner FROM kartukredit where idowner= "+ id;
		
		return jdbcTemplate.query(sql, mapCCFromDb());
	}
	
	public List<KartuKredit> selectAllCCByNocc(int var){
		String sql = "" +
				"SELECT idkartu, name, jenis, exp, limitt, idowner FROM kartukredit where idkartu= "+ var;
		
		return jdbcTemplate.query(sql, mapCCFromDb());
	}
	
	public List<KartuKredit> selectAllCCByLimit(int var){
		String sql = "" +
				"SELECT idkartu, name, jenis, exp, limitt, idowner FROM kartukredit where limitt= "+ var;
		
		return jdbcTemplate.query(sql, mapCCFromDb());
	}
	
	public List<KartuKredit> selectAllCCByJenis(String var){
		String sql = "" +
				"SELECT idkartu, name, jenis, exp, limitt, idowner FROM kartukredit where jenis= '"+ var +"'";
		
		return jdbcTemplate.query(sql, mapCCFromDb());
	}
	
	public int insertCC(KartuKredit cc) {
		String sql = ""+
				"insert into kartukredit(idkartu, name, jenis, exp, limitt, idowner) " +
				" Values (?, ?, ?, ?, ?, ?)";
		return jdbcTemplate.update(
				sql, 
				cc.getIdkartu(),
				cc.getName(),
				cc.getJenis(),
				cc.getDate(),
				cc.getLimit(),
				cc.getIdowner()
			);
	}
	
	public int deleteCC(int id) {
		String sql = ""+
				"delete from kartukredit where idkartu = ? ";
		return jdbcTemplate.update(sql, id);
	}
	
	public int updateCCName(int id, String var) {
		String sql = ""+
				"Update kartukredit SET name = ? where idkartu = ?";
		return jdbcTemplate.update(sql,var,id);
	}
	public int updateCCjenis(int id, String var) {
		String sql = ""+
				"Update kartukredit SET jenis = ? where idkartu = ?";
		return jdbcTemplate.update(sql,var,id);
	}
	public int updateCCDate(int id, String var) {
		String sql = ""+
				"Update kartukredit SET exp = ? where idkartu = ?";
		return jdbcTemplate.update(sql,var,id);
	}
	public int updateCCLimit(int id, int var) {
		String sql = ""+
				"Update kartukredit SET limitt = ? where idkartu = ?";
		return jdbcTemplate.update(sql,var,id);
	}
	public int updateCCidowner(int id, int var) {
		String sql = ""+
				"Update kartukredit SET idowner = ? where idkartu = ?";
		return jdbcTemplate.update(sql,var,id);
	}
	
	private RowMapper<KartuKredit> mapCCFromDb() {
		return(resultSet, i) -> {
			return new KartuKredit(
				Integer.parseInt(resultSet.getString("idkartu")),
				resultSet.getString("name"),
                resultSet.getString("jenis"),
                resultSet.getString("exp"),
                Integer.parseInt(resultSet.getString("limitt")),
                Integer.parseInt(resultSet.getString("idowner"))
			);
        };
    }
	
	
	
}
