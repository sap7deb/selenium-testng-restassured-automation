package tests;

import org.testng.annotations.*;

public class TestAnnotations {

    @BeforeMethod
    public void BeforeMethod() {
        System.out.println("BeforeMethod");
    }

    @BeforeClass
    public void BeforeClass() {
        System.out.println("BeforeClass");
    }

    @BeforeTest
    public void BeforeTest() {
        System.out.println("BeforeTest");
    }

    @BeforeSuite
    public void BeforeSuite() {
        System.out.println("BeforeSuite");
    }

    @Test
    public void test() {
        System.out.println("Test");
    }

    @Test
    public void test2() {
        System.out.println("Test2");
    }


}
