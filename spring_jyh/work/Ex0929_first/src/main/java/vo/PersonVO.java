package vo;

public class PersonVO {

	private String name;
	private int age;
	private String tel;

	public PersonVO( String name, int age, String tel) {
		this.name = name;
		this.age = age;
		this.tel = tel;
		
		System.out.println("생성자 injection : " + name + " / " + age + " / " + tel);
	}
	
	public PersonVO() {
		System.out.println("PersonVO 기본 생성자");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("--setName() : " + name);
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
		System.out.println("--setAge() : " + age);
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
		System.out.println("--setTel() : " + tel);
	}
}
