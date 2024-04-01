package Controller;

public class Student {

	private int id;
	private String name;
	private int semester;
	private String branch;
	private float spi;

	public Student(int id, String name, int semester, String branch, float spi) {
		super();
		this.id = id;
		this.name = name;
		this.branch = branch;
		this.semester = semester;
		this.spi = spi;
	}

	public float getSpi() {
		return spi;
	}

	public void setSpi(float spi) {
		this.spi = spi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

}
