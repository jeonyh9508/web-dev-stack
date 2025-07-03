package vo;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class Rent {

	private int rentNO;
	private String id; // foreign key(Client)
	private int bookNO; // foreign key (Book)
	private LocalDate rentDate;

	private Member client;
	private Book book;
}
