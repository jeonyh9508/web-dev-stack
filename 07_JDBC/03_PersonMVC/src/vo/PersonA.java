package vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// VO(Value Object) : 값만 담는 객체 
@NoArgsConstructor @AllArgsConstructor
@Data
public class PersonA {
	
	private int id;
	private String name; 
	private int age;
	private String addr;
	
	
}
