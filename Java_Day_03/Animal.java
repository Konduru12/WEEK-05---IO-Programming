class Animall{
    public void makeSound() {
        System.out.println("Some generic animal sound");
    }
}
class Dog extends Animall{
    @Override
    public void makeSound() {
        System.out.println("Bowww boww!");
    }
}
public class Animal{
    public static void main(String[] args) {
        Dog myDog = new Dog();  
        myDog.makeSound();      
    }
}
