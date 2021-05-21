package database;

public class waitDTO {
   private String people;
   private String cli_name;
   private int cli_code3;

   public String getPeople() {
      return people;
   }

   public void setPeople(String people) {
      this.people = people;
   }

   public String getCli_name() {
      return cli_name;
   }

   public void setCli_name(String cli_name) {
      this.cli_name=cli_name;
   }
   
   public int getcode3() {
      return cli_code3;
   }

   public void setcode3(int cli_code3) {
      this.cli_code3 = cli_code3;
   }
}