package patterns.core.chainofresponsibility;

import lombok.Getter;

@Getter
public enum Priority {
    ROUTINE(1),
    IMPORTANT(2),
    ASAP(3);

    int level;

    Priority(int level) {
        this.level = level;
    }
}
