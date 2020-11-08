package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Class_Supplies;

 public class ClassSuppliesDao {
	
 	private Connection conn;
 	private final String GET_SUPPLIES_QUERY = "SELECT * FROM class_supplies";
 	private final String ADD_NEW_SUPPLIES_QUERY = "INSERT INTO class_supplies(name, quantity) VALUES(?, ?) WHERE class_id_fk = ?";
 	private final String MODIFY_SUPPLIES_BY_ID_QUERY = "UPDATE class_supplies SET name = ? WHERE id = ?";
 	private final String DELETE_SUPPLIES_BY_ID_QUERY = "DELETE FROM class_supplies WHERE id = ?";
 	
 	public ClassSuppliesDao() {
 		conn = DBConnection.getConnection();	
 	}
 	
 	public List<Class_Supplies> getSupplies() throws SQLException{
 		ResultSet rs = conn.prepareStatement(GET_SUPPLIES_QUERY).executeQuery();
 		List<Class_Supplies> supplies = new ArrayList<Class_Supplies>();
 		while(rs.next()) {
 			supplies.add(populateSupplies(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
 		}
 		
 		return supplies;
 	}
 	
 	public void addNewSupply(String name, int quantity, int classID) throws SQLException {
 		PreparedStatement ps = conn.prepareStatement(ADD_NEW_SUPPLIES_QUERY);
 		ps.setString(1, name);
 		ps.setInt(2, quantity);
 		ps.setInt(3, classID);
 		ps.executeUpdate();
 		
 	}
 	
 	public void modifySuppliesByID(int id, String name, int quantity, int classID) throws SQLException {
 		PreparedStatement ps = conn.prepareStatement(MODIFY_SUPPLIES_BY_ID_QUERY);
 		ps.setString(1, name);
 		ps.setInt(2, quantity);
 		ps.setInt(3, classID);
 		ps.executeUpdate();
 	}
 	
 	public void deleteSuppliesByID(int id) throws SQLException {
 		PreparedStatement ps = conn.prepareStatement(DELETE_SUPPLIES_BY_ID_QUERY);
 		ps.setInt(1, id);
 		ps.executeUpdate();
 	}
 	
 	

	private Class_Supplies populateSupplies(int id, String name, int quantity, int classID) {
		return new Class_Supplies(id, name, quantity, classID);
	}
	

 }