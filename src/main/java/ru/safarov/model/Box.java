package ru.safarov.model;

import java.util.ArrayList;

public class Box<T extends Fruit> {

    private ArrayList<T> objects;

    public Box() {
        this.objects = new ArrayList<>();
    }

    public void addToBox(T obj){
        objects.add(obj);
    }

    public ArrayList<T> takeOutBox(int countShift){
        if (objects.size() < countShift){
            throw new RuntimeException("Request exceeds box size");
        }
        ArrayList<T> shift = new ArrayList<>();
        for (int i = 0; i < countShift; i++) {
//            shift.add(objects.get(i));
            //Единственное что, цикл можно упростить --- метод remove возвращает значение,
            // которые вы достали, поэтому можно сразу так:
            shift.add(objects.remove(0));
        }
//        for (int i = 0; i < countShift ; i++) {
//            objects.remove(0);
//        }
        return shift;
    }

    public double getWeight(){
        if(objects.isEmpty()){
            return 0.0f;
        } else {
            return objects.size() * objects.get(0).getWeight();
        }
    }

    public boolean compare(Box<?> other){
        return Math.abs(getWeight() - other.getWeight()) < 0.0001;
    }

    public int getSize() {
        return objects.size();
    }

    public void addShift(ArrayList<T> shift) {
        objects.addAll(shift);
    }

    public void shiftOutOfTheBox(Box<T> other){
        other.addShift(takeOutBox(objects.size()));
        objects.clear();
    }
}
