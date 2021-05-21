package database;

public class payDTO {
	private String menuname;
	private String menuprice;

	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public String getMenuprice() {
		return menuprice;
	}

	public void setMenuprice(String menuprice) {
		this.menuprice = menuprice;
	}

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
	
	private int Tablenum;
	private int Menucount;
	private int Headcount;
	private String Menucode;
	   
	public String getMenucode() {
	   return Menucode;
	}
	public void setMenucode(String menucode) {
	   Menucode = menucode;
	}
	public int getTablenum() {
	   return Tablenum;
	}
	public void setTablenum(int tablenum) {
	   Tablenum = tablenum;
	}
	public int getMenucount() {
	   return Menucount;
	}
	public void setMenucount(int menucount) {
	   Menucount = menucount;
	}
	   
	public int getHeadcount() {
	   return Headcount;
	}
	public void setHeadcount(int headcount) {
		Headcount = headcount;
	}
}