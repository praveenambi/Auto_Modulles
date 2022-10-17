package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class TestUnit {
//    public static void main(String[] args) {
//        System.out.println("hello maho");

    @Before
public void prerequistes()
{
    System.out.println("launch browser");
    System.out.println("load url");
}

    @Test
    public void operation()
    {
        System.out.println("click login");
        System.out.println("enter username");
        System.out.println("select mobile");


    }
    @Test
    public void operation_two()
    {
        System.out.println("click login");
        System.out.println("enter username");
        System.out.println("select mobile");


    }
    @Test
    public void operation_three()
    {
        System.out.println("click login");
        System.out.println("enter username");
        System.out.println("select mobile");


    }
    @After
    public void postreq()
    {
        System.out.println("close browser");
    }
}
