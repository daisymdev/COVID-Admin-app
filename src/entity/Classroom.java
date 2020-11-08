package entity;

public class Classroom {
	private int class_id_pk;
	private String class_name;
	private String teacher_name;

	public Classroom(int class_id_pk, String class_name, String teacher_name) {
		this.setClass_id_pk(class_id_pk);
		this.setClass_name(class_name);
		this.setTeacher_name(teacher_name);
	}

	public int getClass_id_pk() {
		return class_id_pk;
	}

	public void setClass_id_pk(int class_id_pk) {
		this.class_id_pk = class_id_pk;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	
	
}



