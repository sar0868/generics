package ru.safarov.model;

import jdk.internal.dynalink.linker.LinkerServices;
import junit.framework.AssertionFailedError;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class BoxTest {

    @Test
    public void getWeight() {
        Box<Apple> appleBox = new Box<Apple>();
        for (int i = 0; i < 4; i++) {
            appleBox.addToBox(new Apple(1.0f));
        }
        Assertions.assertEquals(4.0, appleBox.getWeight());
    }

    @Test
    public void addToBox() {
        Box<Orange> orangeBox = new Box<Orange>();
        for (int i = 0; i < 10; i++) {
            orangeBox.addToBox(new Orange(1.5f));
        }

        Assertions.assertEquals(10, orangeBox.getSize());
    }

    @Test
    public void takeOutBox() {
        Box<Orange> orangeBox = new Box<Orange>();
        Box<Orange> orangeBox2 = new Box<Orange>();
        for (int i = 0; i < 10; i++) {
            orangeBox.addToBox(new Orange(1.5f));
        }
        orangeBox2.addShift(orangeBox.takeOutBox(3));
        Assertions.assertEquals(7, orangeBox.getSize());
        Assertions.assertEquals(3, orangeBox2.getSize());
    }

    @Test(expected = RuntimeException.class)
    public void takeOutBoxException() {
        Box<Orange> orangeBox = new Box<Orange>();
               for (int i = 0; i < 10; i++) {
            orangeBox.addToBox(new Orange(1.5f));
        }
     orangeBox.takeOutBox(12);
    }

    @Test
    public void compare() {
        Box<Apple> appleBox = new Box<Apple>();
        for (int i = 0; i < 6; i++) {
            appleBox.addToBox(new Apple(1.0f));
        }
        Box<Orange> orangeBox = new Box<Orange>();
        for (int i = 0; i < 4; i++) {
            orangeBox.addToBox(new Orange(1.5f));
        }
        Assertions.assertTrue(appleBox.compare(orangeBox));
        appleBox.takeOutBox(1);
        Assertions.assertFalse(appleBox.compare(orangeBox));
    }

    @Test
    public void addShift() {
    }

    @Test
    public void shiftOutOfTheBox() {
        Box<Apple> appleBox = new Box<Apple>();
        Box<Apple> appleBox2 = new Box<Apple>();
        for (int i = 0; i < 6; i++) {
            appleBox.addToBox(new Apple(1.0f));
        }
        for (int i = 0; i < 2; i++) {
            appleBox2.addToBox(new Apple(1.0f));
        }
        appleBox.shiftOutOfTheBox(appleBox2);
        Assertions.assertEquals(8, appleBox2.getSize());
        Assertions.assertEquals(0, appleBox.getSize());
    }
}