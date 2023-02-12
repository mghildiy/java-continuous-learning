package spring.beans;

public class DummyDataSource implements DataSource {

    public String get() {
        return "Dummy data";
    }
}
