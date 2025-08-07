package designpatterns.nullObjectPattern;

public class ValidUser extends User {

    public ValidUser(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getId() {
        return super.getId();
    }
}
