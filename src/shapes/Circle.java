package shapes;

import java.io.IOException;

public class Circle implements Shape{

    private float pi = (float)Math.PI;
    private float radius;
    Circle(float radius) throws IllegalArgumentException {
        if(radius > 10000  || radius  <= 0){
            throw new IllegalArgumentException("Radius entered is invalid");
        }
        this.radius = radius;
    }
    @Override
    public float area()  {
        return pi*radius*radius;
    }
    public float circumference(){
        return 2*radius*pi;
    }
}
