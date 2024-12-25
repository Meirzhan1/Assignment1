import java.util.ArrayList;
public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Person> students = new ArrayList<>();
        Person person1 = new Person("Harry", "Potter", 21, true);
        Person person2 = new Person("Ron", "Qeasley", 20, true);
        Person person3 = new Person("Hermione ", "Granger ", 19, false);
        Person person4 = new Person("Luna", " Lovegood", 20, false);
        Person person5 = new Person("Draco ", "Malfoy", 19, true);
        System.out.println(person1.toString());
        System.out.println(person2.toString());
        System.out.println(person3.toString());
        System.out.println(person4.toString());
        System.out.println(person5.toString());

    }
}

