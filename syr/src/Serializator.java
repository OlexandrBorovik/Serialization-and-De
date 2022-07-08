import java.io.*;
import java.lang.reflect.Field;
import java.text.FieldPosition;
import java.util.Scanner;

public class Serializator {



    public void Serin(Object cl) {

        try(FileWriter writer = new FileWriter("notes3.txt", true))
        {
            final Class<?> cls = ListsFilds.class;
            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields)

                if (field.isAnnotationPresent(Save.class)) {

                    writer.write(field.getType().getSimpleName() + " "+field.getName()+" = ");

                    if (field.getType()== String.class){
                        writer.write(field.get(cl) + " ;");
                        writer.append("\n");
                    }
                    if (field.getType().getSimpleName() == "int"){
                        writer.write(field.getInt(cl) + " ;");
                        writer.append("\n");
                    }
                    if (field.getType().getSimpleName() == "boolean"){
                        writer.write(field.getBoolean(cl) + " ;");
                        writer.append("\n");
                    }
                    if (field.getType().getSimpleName() == "char"){
                        writer.write(field.getChar(cl) + " ;");
                        writer.append("\n");
                    }
                    if (field.getType().getSimpleName() == "long"){
                        writer.write(field.getLong(cl) + " ;");
                        writer.append("\n");
                    }
                    if (field.getType().getSimpleName() == "short"){
                        writer.write(field.getShort(cl) + " ;");
                        writer.append("\n");
                    }
                    if (field.getType().getSimpleName() == "byte"){
                        writer.write(field.getByte(cl) + " ;");
                        writer.append("\n");
                    }
                }
                } catch (IOException |  IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public Object serOut (Object o , File file) throws FileNotFoundException, IllegalAccessException {

        final Class<?> cls = o.getClass();
        Field[] fields = cls.getDeclaredFields();
        FileReader fr = new FileReader(file);
        Scanner sc = new Scanner(fr);

        while (sc.hasNextLine()) {
            String text = sc.nextLine();
            String [] line = text.split(" ");
            for (Field field : fields){
               if (line[1].equals(field.getName())){
                   if (field.getType()== String.class){

                   }
                   if (field.getType().getSimpleName() == "int"){
                  field.setInt(o,Integer.parseInt (line[3]));
                   }
                   if (field.getType().getSimpleName() == "boolean"){
                       if(line[3].equals(true)){
                           field.setBoolean(o,true);
                       }else{
                           field.setBoolean(o,false);
                       }
                   }
                   if (field.getType().getSimpleName() == "char"){
                       char c = line[3].charAt(0);
                       field.setChar(o,c);
                   }
                   if (field.getType().getSimpleName() == "long"){
                       field.setLong(o,Long.valueOf(line[3]).longValue());
                   }
                   if (field.getType().getSimpleName() == "short"){
                       field.setShort(o, Short.valueOf(line[3]).shortValue());
                   }
                   if (field.getType().getSimpleName() == "byte"){
                       field.setByte(o,Byte.valueOf(line[3]).byteValue());
                   }
                   if (field.getType()== String.class){
                       field.set(o,line[3]);
                   }
               }
            }
        }
        return o;
    }
}