package project;

/**
@author KIBRU KUTURE
 */
public class Player {
	private String NameAndSurname;
	private Date birthDate;
	private String [] club;
	private Player Next;
	private Player prev;
	
	public Player getPrev() {
		return prev;
	}
	public void setPrev(Player prev) {
		this.prev = prev;
	}
	public Player() {
		NameAndSurname=null;
		birthDate=null;
		club=null;
	}
	public Player(String NameAndSurname,Date birthDate,String[] club ) {
		this.NameAndSurname=NameAndSurname;
		this.birthDate=birthDate;
		this.club=club;
		
	}
	public String getNameAndSurname() {
		return NameAndSurname;
	}
	public void setNameAndSurname(String nameAndSurname) {
		NameAndSurname = nameAndSurname;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String[] getClub() {
		return club;
	}
	public void setClub(String[] club) {
		this.club = club;
	}
	public Player getNext() {
		return Next;
	}
	public void setNext(Player next) {
		Next = next;
	}
        @Override
        public String toString(){
            String str="The club(s) this player has been playing in is(are) as follow:\n";
            for(String s:this.getClub()){
                str=str+s+",";
            }
            return "Name and Surname: "+ this.getNameAndSurname()+"\n"+"The birth_date of the player: "+this.getBirthDate()+"\n"+str+"\n"+"\n";
        }
	
	
	

}
