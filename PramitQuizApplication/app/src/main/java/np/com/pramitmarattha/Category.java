package np.com.pramitmarattha;

public class Category {
    public static final int PYTHON_CHALLENGE = 1;
    public static final int JAVA_CHALLENGE = 2;
    public static final int Csharp_CHALLENGE = 3;

    private int id;
    private String name;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getName();
    }
}