package patterns.core.prototype;

public class Student implements Prototype {
    String name ;
    int age ;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public Student getClone(){
        return this;
    }
}
