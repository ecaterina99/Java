import java.lang.reflect.*;
import java.util.Arrays;

public class ReflectionTest {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Class stringClass = String.class;

        String className = stringClass.getName();
        String simpleClassName = stringClass.getSimpleName();
        int modifiers = stringClass.getModifiers();
        Package classPackage = stringClass.getPackage();
        Class superclass = stringClass.getSuperclass();

        System.out.println(className);
        System.out.println(simpleClassName);
        System.out.println("Is private: " + Modifier.isPrivate(modifiers));
        System.out.println("Is public: " + Modifier.isPublic(modifiers));
        System.out.println("Is final: " + Modifier.isFinal(modifiers));
        System.out.println(classPackage.getName());
        System.out.println(superclass.getName());

        //Manipularea constructorilor
        Class productClass = Product.class;

        Constructor[] constructors = productClass.getConstructors();

        for (Constructor constructor : constructors) {

            System.out.println(constructor.getParameterCount());
            System.out.println(Arrays.toString(constructor.getParameterTypes()));

        }


        //Instanţierea claselor folosind reflecţiile
        try {
            Constructor constructor = productClass.getConstructor(String.class, String.class, double.class);
            Product product = (Product) constructor.newInstance("Logitech", "F710", 129.99);
            System.out.println(product);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException |
                 InvocationTargetException e) {
            e.printStackTrace();
        }

        // Manipularea câmpurilor
        Product product1 = new Product("Logitech", "F710", 129.99);
        Field[] fields = productClass.getDeclaredFields();

        for (Field field : fields) {
            System.out.println(field.getName());
        }

        //Citirea şi modificarea valorilor proprietăţilor
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                System.out.println(field.getName() + ": " + field.get(product1));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        //Manipularea metodelor
        Method[] methods = productClass.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }


        //Apelarea metodelor
        Product product2 = new Product("Opel", "Astra", 129.99);

        Method method = productClass.getMethod("toString");
        String returnValue = (String) method.invoke(product2);

        System.out.println(returnValue);

    }

}
