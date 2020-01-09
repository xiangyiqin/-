import java.io.FileOutputStream;
import java.lang.reflect.Field;

public class Test1 {
    public static void main(String[] args) throws Exception {
        Class<Person> personClass = Person.class;
        Field[] fields = personClass.getFields();
        for(Field field:fields){
            System.out.println(field);
        }
        Field a = personClass.getField("a");
        Person person=new Person();
        Object o = a.get(person);
        System.out.println(o);
        a.set(person,"aa");
        System.out.println(a.get(person));
        Field[] declaredFields = personClass.getDeclaredFields();
        for(Field dField:declaredFields){
            System.out.println(dField+"====");
        }
        Field d = personClass.getDeclaredField("d");
        d.setAccessible(true);
        d.set(person,"111");
        Object o1 = d.get(person);
        System.out.println(o1);
    }
}
