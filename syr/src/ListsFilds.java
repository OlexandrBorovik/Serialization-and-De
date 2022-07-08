import java.io.Serializable;

public class ListsFilds implements Serializable {

    public String name = "Grisha";
    @Save
     public int age = 150;

     public boolean alive = false;
    @Save
     public String ex = "Telo";

    public ListsFilds(String name, int age, boolean alive, String ex) {
        this.name = name;
        this.age = age;
        this.alive = alive;
        this.ex = ex;
    }

    public ListsFilds() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }

    @Override
    public String toString() {
        return "ListsFilds{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", alive=" + alive +
                ", ex='" + ex + '\'' +
                '}';
    }
}
