package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.ClassSuppliesDao;
import dao.ClassroomDao;
import dao.StudentDao;
import entity.Class_Supplies;
import entity.Classroom;
import entity.Students;

public class Menu {

	private ClassroomDao classroomDao = new ClassroomDao();
	private StudentDao studentDao = new StudentDao();
	private ClassSuppliesDao classSuppliesDao = new ClassSuppliesDao();
	private Scanner scanner = new Scanner(System.in);
	
	private List<String> options = Arrays.asList(
			"Display Classrooms",
			"Display a Classroom",
			"Add Classroom",
			"Modify Classroom",
			"Delete Classroom",
			"Display Students",
			"Add Student",
			"Modify Student",
			"Delete Student",
			"Display Supplies",
			"Add Supplies",
			"Modify Supplies",
			"Delete Supplies"
			);
	
	
	public void start() {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
		try {
			if (selection.equals("1")) {
				displayClassrooms();
			} else if (selection.equals("2")) {
				displayAClassroom();
			} else if (selection.equals("3")) {
				addClassroom();
			} else if (selection.equals("4")) {
				modifyClassroom();
			}  else if (selection.equals("5")) {
				deleteClassroom();
			} else if (selection.equals("6")) {
				displayStudents();
			} else if (selection.equals("7")) {
				addStudent();
			} else if (selection.equals("8")) {
				modifyStudent();
			}  else if (selection.equals("9")) {
				deleteStudent();
			} else if (selection.equals("10")) {
				displaySupplies();
			} else if (selection.equals("11")) {
				addSupplies();
			}  else if (selection.equals("12")) {
				modifySupplies();
			} else if (selection.equals("13")) {
				deleteSupplies();
			}	
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
			System.out.println("Press enter to continue");
			scanner.nextLine();
			
		} while (!selection.equals("-1"));
	}
	
	private void printMenu() {
		System.out.println("Select an option:\n---------------------------------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i+1+ ")" + options.get(i));
		}
	}
//###########################CLASSROOM FUNCTIONS###############
	private void displayClassrooms() throws SQLException {
		List<Classroom> classrooms = classroomDao.getClassrooms();
		for(Classroom classroom : classrooms) {
			System.out.println(classroom.getClass_id_pk() + ": " + classroom.getClass_name() + ": " + classroom.getTeacher_name());
		}
	}
	
	private void displayAClassroom() throws SQLException {
		System.out.println("Enter Class Id: ");
		int id = Integer.parseInt(scanner.nextLine());
		
		Classroom classrooms = classroomDao.getClassroomById(id);
		System.out.println(classrooms.getClass_id_pk() + ": " + classrooms.getClass_name() + " " + classrooms.getTeacher_name());
	}
	
	private void addClassroom() throws SQLException {
		System.out.print("Enter new Class Name: ");
		String className = scanner.nextLine();
		System.out.print("Enter new Teacher Name: ");
		String teacherName = scanner.nextLine();
		
		classroomDao.createNewClassroom(className, teacherName);
	}
	
	private void modifyClassroom() throws SQLException {
		System.out.print("Which class do you want to modify? (Enter Class Id: ");
		int classId = Integer.parseInt(scanner.nextLine());
		System.out.print("What do you want the class name to be? ");
		String className = scanner.nextLine();
		System.out.print("What is the new teacher name? ");
		String teacherName = scanner.nextLine();
		
		classroomDao.updateClassroomById(className, teacherName, classId);
	}
	
	private void deleteClassroom() throws SQLException {
		System.out.print("Enter Class Id to delete: ");
		int id = Integer.parseInt(scanner.nextLine());
		classroomDao.deleteClassroomById(id);
	}
	
	
	//###########################STUDENT FUNCTIONS###############
	private void displayStudents() throws SQLException {
		List<Students> students = studentDao.getStudents();
		for (Students student : students) {
			System.out.println(student.getStudent_id_pk() + ": " + student.getFirst_name() + student.getLast_name() + student.getAge() + student.getClassID());
		}
	}

	private void addStudent() throws SQLException {
		System.out.print("Enter student first name:");
		String studentFirstName = scanner.nextLine();
		System.out.print("Enter student last name:");
		String studentLastName = scanner.nextLine();
		System.out.print("Enter student age:");
		int age = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter student classroom id:");
		int classID = Integer.parseInt(scanner.nextLine());
		studentDao.addNewStudent(studentFirstName, studentLastName, age, classID);
    }
	private void modifyStudent() throws SQLException {
		System.out.print("Enter student id to modify:");
		int id = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter new first name to modify:");
		String firstName = scanner.nextLine();
		System.out.print("Enter new last name to modify:");
		String lastName = scanner.nextLine();
		System.out.print("Enter new age to modify:");
		int age = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter new classroom id to modify:");
		int classID = Integer.parseInt(scanner.nextLine());
		studentDao.modifyStudentByID(id, firstName, lastName, age, classID);
	}
	private void deleteStudent() throws SQLException {
		System.out.println("Enter student id to delete:");
		int id = Integer.parseInt(scanner.nextLine());
		studentDao.deleteStudentByID(id);
    }
	
	//###########################SUPPLIES FUNCTIONS###############	
	private void displaySupplies() throws SQLException {
		List<Class_Supplies> supplies = classSuppliesDao.getSupplies();
		for (Class_Supplies supply : supplies) {
			System.out.println(supply.getSupplies_id() + ": " + supply.getSupply_name() + " " + supply.getQuantity());
		}
	}

	private void addSupplies() throws SQLException {
		System.out.print("Enter supply name:");
		String supplyName = scanner.nextLine();
		System.out.print("Enter supply quantity:");
		int amount = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter supply classroom id:");
		int classroomID = Integer.parseInt(scanner.nextLine());
		classSuppliesDao.addNewSupply(supplyName, amount, classroomID);
    }
	private void modifySupplies() throws SQLException {
		System.out.print("Enter supply id to modify:");
		int id = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter new supply name to modify:");
		String supplyName = scanner.nextLine();
		System.out.print("Enter new supply quantity to modify:");
		int amount = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter supply classroom id:");
		int classroomID = Integer.parseInt(scanner.nextLine());
		classSuppliesDao.modifySuppliesByID(id, supplyName, amount, classroomID);
	}
	private void deleteSupplies() throws SQLException {
		System.out.println("Enter supply id to delete:");
		int id = Integer.parseInt(scanner.nextLine());
		classSuppliesDao.deleteSuppliesByID(id);
	}

}
	

