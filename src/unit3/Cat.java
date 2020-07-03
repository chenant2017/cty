package unit3;

public class Cat extends Animal { 
	public Cat() { 
		super();
	}
	
	public Cat(int age,float weight) {
		super(age, weight);
	}
	
	@Override
	public void makeSound() {
		System.out.println("Cat: meow");
	}
}
