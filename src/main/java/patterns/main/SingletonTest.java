package patterns.main;

import patterns.core.singleton.Singleton;

public class SingletonTest {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        System.out.println(instance.hashCode());

        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance2.hashCode());
    }
}
