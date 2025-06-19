package java_dsa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonStack {

	private int stackPtr;
	List<Person> stack;

	{
		stackPtr = -1;
		stack = new ArrayList<>();
	}

	public void push(Person person) {
		stack.add(person);
		stackPtr++;
	}

	public Person pop() {
		if (stackPtr == -1) {
			System.out.println("Stack is empty");
			return null;
		}
		Person person = stack.get(stackPtr);
		stack.remove(stackPtr);
		stackPtr--;
		return person;
	}

	public void displayStack() {
		if (stackPtr == -1) {
			System.out.println("Stack is empty");
			return;
		}
		System.out.println("Stack elements are: ");
		for (int i = 0; i <= stackPtr; i++) {
			Person person = stack.get(i);
			int id = person.getId();
			String name = person.getName();
			System.out.println("id: " + id + "\tname: " + name);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		PersonStack personstack = new PersonStack();

		int choice = 0;

		System.out.println("--STACK OPERATIONS--");
		while (true) {
			System.out.print("1.Push 2.Pop 3.Display 4.Exit -> Enter your choice: ");

			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.print("Enter ID: ");
				int id = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter name: ");
				String name = scanner.nextLine();
				personstack.push(new Person(id, name));
				break;
			case 2:
				Person person = personstack.pop();
				if (person != null) {
					System.out.print("Popped person is: " + person);
				}
				break;
			case 3:
				personstack.displayStack();
				break;
			case 4:
				personstack.stack = null;
				System.out.print("--END OF OPERATIONS--");
				scanner.close();
				return;
			default:
				System.out.println("Invalid choice");
				break;
			}
		}
	}
}
