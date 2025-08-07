package designpatterns.nullObjectPattern;

public abstract class User {

    protected int id;
    protected String name;
    public abstract boolean isValid();
    public String getName() {return name;};
    public int getId() {return id;}


}
