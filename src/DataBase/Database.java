package DataBase;

public class Database {
    private String name;

    public Database(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String .format("Database [name %s]", name);
    }
}

