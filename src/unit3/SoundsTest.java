package unit3;

public class SoundsTest {
	public static void main(String[] args) {
		Sounds[] objects = {new Boat(), new Car(), new Cat(), new Dog()}; //Array of objects.
		for (int i = 0; i < objects.length; i++) { 
			objects[i].makeSound(); //Each object makes their sound.
		}
	}
}
