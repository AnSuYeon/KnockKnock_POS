package database;

public class signupDTO {

	private String res_name;
	private String res_num;
	private String res_gps;
	private String res_time;
	private String res_id;
	private String res_pw;
	private int res_code;

	public String getRes_name() {
		return res_name;
	}

	public void setRes_name(String res_name) {
		this.res_name = res_name;
	}

	public String getRes_num() {
		return res_num;
	}

	public void setRes_num(String res_num) {
		this.res_num = res_num;
	}

	public String getRes_gps() {
		return res_gps;
	}

	public void setRes_gps(String res_gps) {
		this.res_gps = res_gps;
	}

	public String getRes_time() {
		return res_time;
	}

	public void setRes_time(String res_time) {
		this.res_time = res_time;
	}

	public String getRes_id() {
		return res_id;
	}

	public void setRes_id(String res_id) {
		this.res_id = res_id;
	}

	public String getRes_pw() {
		return res_pw;
	}

	public void setRes_pw(String res_pw) {
		this.res_pw = res_pw;
	}

	public int getRes_code() {
		return res_code;
	}

	public void setRes_code(int res_code) {
		this.res_code = res_code;
	}

	public signupDTO() {

	}

	public signupDTO(String res_name, String res_num, String res_gps, String res_time, String res_id, String res_pw,
			int res_code) {
		super();
		this.res_name = res_name;
		this.res_num = res_num;
		this.res_gps = res_gps;
		this.res_time = res_time;
		this.res_id = res_id;
		this.res_pw = res_pw;
		this.res_code = res_code;
	}

}
