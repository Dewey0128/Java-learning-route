package com.george.studyinterface.example;

import java.util.ArrayList;

public interface StudentOperator {
    default void printInfo(ArrayList<Student> students) {

    }

    default void printAvergeScore(ArrayList<Student> students){

    }
}
