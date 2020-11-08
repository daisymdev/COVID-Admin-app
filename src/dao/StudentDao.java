package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Students;

public class StudentDao {
	
	private Connection connection;
	private final String GET_STUDENTS_QUERY = "SELECT * FROM student";
	private final String ADD_NEW_STUDENT_QUERY = "INSERT INTO student(first_name, last_name, age, class_id_fk) VALUES(?, ?, ?, ?)";
	private final String MODIFY_STUDENT_BY_ID_QUERY = "UPDATE student SET first_name = ?, last_name = ?, age = ?, class_id_fk = ? WHERE student_id_pk = ?";
	private final String DELETE_STUDENT_BY_ID_QUERY = "DELETE FROM student WHERE student_id_pk = ?";
	
	public StudentDao() {
		
		connection = DBConnection.getConnection();
	}
	
	public List<Students> getStudents() throws SQLException{
		ResultSet rs = connection.prepareStatement(GET_STUDENTS_QUERY).executeQuery();
		List<Students> students = new ArrayList<Students>();
		
		while (rs.next()) {
			students.add(populateStudent(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
		}
		
		return students;
	}
	
	public void addNewStudent(String firstName, String lastName, int age, int classID) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(ADD_NEW_STUDENT_QUERY);
		ps.setString(1, firstName);
		ps.setString(2, lastName);
		ps.setInt(3, age);
		ps.setInt(4, classID);
		ps.executeUpdate();
		
	}
	
	public void modifyStudentByID(int id, String firstName, String lastName, int age, int classID) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(MODIFY_STUDENT_BY_ID_QUERY);
		ps.setString(1, firstName);
		ps.setString(2, lastName);
		ps.setInt(3, age);
		ps.setInt(4, classID);
		ps.setInt(5, id);
		ps.executeUpdate();
	}
	
	public void deleteStudentByID(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_STUDENT_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	private Students populateStudent(int id, String first_name, String last_name, int age, int classID) {
		return new Students(id, first_name, last_name, age, classID);
	}

}
