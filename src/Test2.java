import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class Test2 {
    public static void main(String[] args) throws Exception {
        Properties properties=new Properties();
        ClassLoader classLoader = Test2.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("pro.properties");
        properties.load(is);
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");

        Class<?> aClass = Class.forName(className);
        Object o = aClass.newInstance();
        Method declaredMethod = aClass.getDeclaredMethod(methodName);
        declaredMethod.invoke(o);
        Method rice = aClass.getDeclaredMethod("eat", String.class,int.class);
        rice.invoke(o,"r",1);

    }
}
