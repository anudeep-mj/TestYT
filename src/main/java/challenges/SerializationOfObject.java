package challenges;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class SerializationOfObject
{

    public static void main (String[] args) throws IOException, ClassNotFoundException
    {
        SerializationOfObject.MyObject myObject = new SerializationOfObject.MyObject();

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(myObject);
        objectOutputStream.close();

        ByteArrayInputStream byteArrayInputStream =
            new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        MyObject generatedObject = (MyObject) objectInputStream.readObject();

        if (generatedObject.getMap().size() == 0) {
            System.out.println("fine");
        }
    }

    static class MyObject
    {
        Map<Integer, Integer> map = new HashMap<>();

        public Map<Integer, Integer> getMap ()
        {
            return map;
        }

        public void setMap (Map<Integer, Integer> map)
        {
            this.map = map;
        }
    }
}
