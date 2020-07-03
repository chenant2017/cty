package unit3;

public abstract class Animal implements Sounds {
	private int age_; 
	private float weight_;
	
	//The default constructor, which I will be using.
	protected Animal() {
		age_ = 0;
		weight_ = 0;
	}
	
	//Constructor with parameters that might be useful for someone else using the class.
	protected Animal(int age,float weight) {
		age_ = age;
		weight_ = weight;
	}
	
	//I don't use these getters and setters, but they might be useful for someone else using the class.
	public int getAge() {
		return age_;
	}
	
	public float getWeight() {
		return weight_;
	}
	
	public void setAge(int age) {
		age_ = age;
	}
	
	public void setWeight(float weight) {
		weight_ = weight;
	}
	
	@Override
	public void makeSound() { /**If this method is not overridden by a subclass, 
	then an instance of that subclass will print the string below when makeSound is invoked.*/
		System.out.println("This animal doesn't make a sound.");
	}
}
