package design.patterns.behavioural.chainofresponsibility;

public class CoRDemo {

    public static void main(String[] args) {
        CreateActor powerChecker = new PowerChecker();
        CreateActor weaponChecker = new WeappnChecker();
        powerChecker.nextHandler(weaponChecker);
        if(powerChecker.shouldCreateActor()) {
            System.out.println("Create actor");
        }
    }
}
