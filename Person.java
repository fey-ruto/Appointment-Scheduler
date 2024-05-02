public class Person {
    private String name;
    private int age = 0;


    public Person (String name, int age) {
        this.name = name;
        this.age = age;

    }

    public Person() {
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public void changeName(String newName){
        name = newName;
    }
}
