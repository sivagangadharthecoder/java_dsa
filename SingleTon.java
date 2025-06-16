import java.util.Scanner;
class Person{
	private int id;
	private String name;
	private char gender;
	private String location;
	
	private static Person person;
	
	private Person() {
		System.out.println("Person Object is created.");
	}
	
	public static Person createPerson() {
		if(person == null) {
			person = new Person();
		}
		return person;
	}
	
	public void setPerson(int id,String name,char gender,String location) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.location = location;
	}
	
	@Override
	public String toString() {
		return "id: "+id+"\nname: "+name+"\ngender: "+gender+"\nlocation: "+location;
	}
}
public class SingleTon {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Person person1 = Person.createPerson();
		person1.setPerson(101,"Manikanta",'m',"Rajahmundry");
		System.out.println(person1);
	}
}