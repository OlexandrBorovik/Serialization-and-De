import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IllegalAccessException {
        ListsFilds lf = new ListsFilds();
        ListsFilds one = new ListsFilds();
        ListsFilds two = new ListsFilds();

        Serializator ser = new Serializator();
        ser.Serin(lf);

        File file = new File("notes3.txt");
        one = (ListsFilds) ser.serOut(two, file);

    }
}
