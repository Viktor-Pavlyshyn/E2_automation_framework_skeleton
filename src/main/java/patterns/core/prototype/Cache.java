package patterns.core.prototype;

import lombok.Getter;

@Getter
public class Cache {
    Student student;

    public Cache(Student student) {
        this.student = student.getClone();
    }
}
