package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Vector2DTest{

    private final double EPS = 1e-9;
    private static Vector2D v1;
    @BeforeAll
    public static void createVector2D(){
        v1=new Vector2D();
    }

    @Test
    public void newVectorShouldHaveZeroLength(){
       // Vector2D v1 = new Vector2D(); //action
        assertEquals(0, v1.length(), EPS);  //expected, real result , delta(1e-9 = 0.0000...01)
    }

    @Test
    public void newVectorShouldHaveZeroX(){
     //   Vector2D v1 = new Vector2D();
        assertEquals(0,v1.getX(), EPS);
    }

    @Test
    public void newVectorShouldHaveZeroY(){
     //   Vector2D v1 = new Vector2D();
        assertEquals(0,v1.getY(), EPS);
    }

}
