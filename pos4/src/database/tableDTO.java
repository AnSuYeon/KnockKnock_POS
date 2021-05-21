package database;

public class tableDTO {
	private int res_code7;
	private int alone;
	private int two;
	private int four;
	private int many;

	public int getcode7() {
		return res_code7;
	}

	public void setcode7(int res_code7) {
		this.res_code7 = res_code7;
	}

	public int getalone() {
		return alone;
	}

	public void setalone(int alone) {
		this.alone = alone;
	}

	public int gettwo() {
		return two;
	}

	public void settwo(int two) {
		this.two = two;
	}

	public int getfour() {
		return four;
	}

	public void setfour(int four) {
		this.four = four;
	}

	public int getmany() {
		return many;
	}

	public void setmany(int many) {
		this.many = many;
	}

	public tableDTO() {

	}

	public tableDTO(int res_code7, int alone, int two, int four, int many) {
		super();
		this.res_code7 = res_code7;
		this.alone = alone;
		this.two = two;
		this.four = four;
		this.many = many;
	}
}
