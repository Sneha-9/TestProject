package com.sneha.shapes;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        Square square =  new Square(2);
        System.out.println(square.area());

        Rectangle rectangle =  new Rectangle(4,5);
        System.out.println(rectangle.area());

        Circle circle =  new Circle(3);
        System.out.println(circle.area());
    }



}
