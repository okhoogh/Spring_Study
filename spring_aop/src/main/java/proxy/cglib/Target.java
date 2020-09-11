package proxy.cglib;

import proxy.jdk.TargetInterface;

public class Target implements TargetInterface {
    public void save() {
        System.out.println("save running...");
    }
}
