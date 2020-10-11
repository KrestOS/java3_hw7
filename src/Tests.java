public class Tests {
    @BeforeSuite
    public static void bSTest(){
        System.out.println("BeforeSuite выполнен");
    }

    @AfterSuite
    public static void aSTest(){
        System.out.println("AfterSuite выполнен");
    }

    @Test(priority = 5)
    public static void Test1(){
        System.out.print("Test1 ");
    }
    @Test(priority = 4)
    public static void Test2(){
        System.out.print("Test2 ");
    }
    @Test(priority = 5)
    public static void Test3(){
        System.out.print("Test3 ");
    }
    @Test(priority = 6)
    public static void Test4(){
        System.out.print("Test4 ");
    }
}
