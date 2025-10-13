package vo;

import org.springframework.web.multipart.MultipartFile;

public class ProductVO {

	private int idx;
	private String category;
	private String p_num;
	private String p_name;
	private String p_company;
	private int p_price;
	private int p_saleprice;
	private String p_image_s;
	private String p_image_l;
	private String p_content;
	private String p_date;

	private MultipartFile photo1, photo2;
	
	public MultipartFile getPhoto1() {
		return photo1;
	}

	public void setPhoto1(MultipartFile photo1) {
		this.photo1 = photo1;
	}

	public MultipartFile getPhoto2() {
		return photo2;
	}

	public void setPhoto2(MultipartFile photo2) {
		this.photo2 = photo2;
	}

	private int sale_rate;

	public int getSale_rate() {
		if (p_price == 0) {
			return 0;
		}
		return (int) ((p_price - p_saleprice) / (float) p_price * 100);
	}

	// Getter & Setter for idx
	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	// Getter & Setter for category
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	// Getter & Setter for p_num
	public String getP_num() {
		return p_num;
	}

	public void setP_num(String p_num) {
		this.p_num = p_num;
	}

	// Getter & Setter for p_name
	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	// Getter & Setter for p_company
	public String getP_company() {
		return p_company;
	}

	public void setP_company(String p_company) {
		this.p_company = p_company;
	}

	// Getter & Setter for p_price
	public int getP_price() {
		return p_price;
	}

	public void setP_price(int p_price) {
		this.p_price = p_price;
	}

	// Getter & Setter for p_saleprice
	public int getP_saleprice() {
		return p_saleprice;
	}

	public void setP_saleprice(int p_saleprice) {
		this.p_saleprice = p_saleprice;
	}

	// Getter & Setter for p_image_s
	public String getP_image_s() {
		return p_image_s;
	}

	public void setP_image_s(String p_image_s) {
		this.p_image_s = p_image_s;
	}

	// Getter & Setter for p_image_l
	public String getP_image_l() {
		return p_image_l;
	}

	public void setP_image_l(String p_image_l) {
		this.p_image_l = p_image_l;
	}

	// Getter & Setter for p_content
	public String getP_content() {
		return p_content;
	}

	public void setP_content(String p_content) {
		this.p_content = p_content;
	}

	// Getter & Setter for p_date
	public String getP_date() {
		return p_date;
	}

	public void setP_date(String p_date) {
		this.p_date = p_date;
	}
}
