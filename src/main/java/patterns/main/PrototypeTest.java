package patterns.main;

import patterns.core.prototype.Cache;
import patterns.core.prototype.Student;

public class PrototypeTest {
    public static void main(String[] args) {
        Student student = new Student("Den", 23);
        Cache cache = new Cache(student);

        System.out.println(cache.getStudent().hashCode());
    }
}
