package unit2;

public class Boat extends Vehicle {
	private float length_;
	private float draft_;
	
	public Boat(float length, float draft) {
		length_ = length;
		draft_ = draft;
	}
	
	public float getLength() {
		return length_;
	}
	
	public float getDraft() {
		return draft_;
	}
	
	public void setDraft(float draft) {
		draft_ = draft;
	}
	
	//No setter for length because it can never change.
	
	@Override
	public void display() { //Boat overrides the abstract method in Vehicle with its own version.
		System.out.println("Boat");
		System.out.println("Length: " + length_);
		System.out.println("Draft: " + draft_);
	}
}