package unit3;

public class Dog extends Animal {
	public Dog() {
		super();
	}
	
	public Dog(int age,float weight) {
		super(age, weight);
	}
	
	@Override
	public void makeSound() {
		System.out.println("Dog: bow wow");
	}
}
