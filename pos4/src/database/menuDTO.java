package database;

public class menuDTO {

	private String manuname;
	private String menuprice;

	public String getManuname() {
		return manuname;
	}

	public void setManuname(String manuname) {
		this.manuname = manuname;
	}

	public String getMenuprice() {
		return menuprice;
	}

	public void setMenuprice(String menuprice) {
		this.menuprice = menuprice;
	}

	@Override
	public String toString() {
		return "menuDTP[manuname = " + ", menuprice = " + menuprice + "]";
	}

}
