package designpatterns.nullObjectPattern;

public class NullUser extends User{
    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public String getName() {
        return "no name for null user";
    }

    @Override
    public int getId() {
        return -1;
    }
}
