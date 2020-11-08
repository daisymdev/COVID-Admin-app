package entity;

public class Students {
	
	private int student_id_pk;
	private String first_name;
	private String last_name;
	private int age;
	private int classID;
	
	public Students(int student_id_pk, String first_name, String last_name, int age, int classID) {
		this.setStudent_id_pk(student_id_pk);
		this.setFirst_name(first_name);
		this.setLast_name(last_name);
		this.setClassID(classID);
		this.setAge(age);
	}

	public int getStudent_id_pk() {
		return student_id_pk;
	}

	public void setStudent_id_pk(int student_id_pk) {
		this.student_id_pk = student_id_pk;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getClassID() {
		return classID;
	}

	public void setClassID(int classID) {
		this.classID = classID;
	}

}