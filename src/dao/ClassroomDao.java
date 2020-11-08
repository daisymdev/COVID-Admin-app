package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Classroom;

public class ClassroomDao {
    // "Display Classrooms",
    // "Display a Classroom",
    // "Add Classroom",
    // "Modify Classroom",
    // "Delete Classroom",

    private final String GET_CLASSROOMS = "SELECT * FROM classroom";
    private final String GET_CLASSROOM_BY_ID = "SELECT * FROM classroom WHERE class_id_pk = ?";
    private final String CREATE_NEW_CLASSROOM = "INSERT INTO classroom(class_name, teacher_name) VALUES(?, ?)";
    private final String UPDATE_CLASSROOM_BY_ID = "UPDATE classroom SET class_name = ?, teacher_name = ? WHERE class_id_pk = ?";
    private final String DELETE_CLASSROOM_BY_ID = "DELETE FROM classroom WHERE class_id_pk = ?";
    private Connection connection;
    //private ClassroomDao classroomDao;

    public ClassroomDao() {
        connection = DBConnection.getConnection();
        //classroomDao = new ClassroomDao();
    }

    //get list of classrooms
    public List<Classroom> getClassrooms() throws SQLException {
        ResultSet rs = connection.prepareStatement(GET_CLASSROOMS).executeQuery();
        List<Classroom> Classrooms = new ArrayList<Classroom>();

        while(rs.next()) {
            Classrooms.add(populateClassroom(rs.getInt(1), rs.getString(2), rs.getString(3)));
        }

        return Classrooms;
    }
    
    //get classroom by class id 
    public Classroom getClassroomById(int id) throws SQLException {
    	PreparedStatement ps = connection.prepareStatement(GET_CLASSROOM_BY_ID);
    	ps.setInt(1, id);
		ResultSet rs = ps.executeQuery(); //queries that only select
		rs.next();

		return populateClassroom(rs.getInt(1), rs.getString(2), rs.getString(3));
    }


    private Classroom populateClassroom(int classId, String className, String teacherName) throws SQLException {
        return new Classroom(classId, className, teacherName);
    }
    
	public void createNewClassroom(String className, String teacherName) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_CLASSROOM);
		ps.setString(1, className);
		ps.setString(2, teacherName);
		ps.executeUpdate(); //queries that create, update, or delete

	}
	
	public void updateClassroomById(String className, String teacherName, int classId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_CLASSROOM_BY_ID);
		ps.setString(1, className);
		ps.setString(2, teacherName);
		ps.setInt(3, classId);
		ps.executeUpdate();
	}
	
	public void deleteClassroomById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_CLASSROOM_BY_ID);
		ps.setInt(1, id);
		ps.executeUpdate();
	}

    
}
