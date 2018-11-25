package com.hfad.workout11;

public class Workout {
    private String name;
    private String description;

    public static final Workout[] workouts = {
            new Workout("A", "1번째 설명"),
            new Workout("B", "2번째 설명"),
            new Workout("C", "3번째 설명"),
            new Workout("D", "4번째 설명")
    };

    //각 Workout은 이름과 설명을 포함
    private Workout(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public String getName(){
        return name;
    }

    public String toString(){
        return this.name;
    }
}
