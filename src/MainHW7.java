
import java.lang.reflect.*;


public class MainHW7 {
    public static void main(String[] args) {
        try {
            start(Tests.class);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    public static void start(Class c) throws InvocationTargetException, IllegalAccessException {
        Class test = c;
        Method[] m = test.getDeclaredMethods();

        int countB = 0;
        int countA = 0;
        int i = 10;
        for (Method method : m) {
            if (method.isAnnotationPresent(BeforeSuite.class)){
                countB++;}
            if (method.isAnnotationPresent(AfterSuite.class)){
                countA++;
            }
        }
        if (countB > 1||countA > 1) {
            throw new RuntimeException();
        }else {
            for (int j = 10; j > 0; j--) {
                for (Method method : m) {

                    if (method.isAnnotationPresent(BeforeSuite.class)){
                        if (method.getAnnotation(BeforeSuite.class).priority() == j ){

                            method.invoke(null);
                        }
                    }else if (method.isAnnotationPresent(Test.class)){
                        if (method.getAnnotation(Test.class).priority() == j ){

                            method.invoke(null);
                            System.out.print(" с приоритетом = " + method.getAnnotation(Test.class).priority() + " выполнен\n");
                        }

                    }else if (method.isAnnotationPresent(AfterSuite.class)){
                        if (method.getAnnotation(AfterSuite.class).priority() == j ){

                            method.invoke(null);
                        }


                    }
                }
            }
        }

    }
}
