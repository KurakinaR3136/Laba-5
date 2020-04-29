package com.company;

import java.util.List;
import java.util.Vector;

public class LastRemover {
    public Vector<Organization> removeLastElement(List<Organization> input_vector) {
        List<Organization> newList = input_vector;
        Organization lastAddedElement = newList.get(input_vector.size() - 1);
        for (Organization org : newList) {

                newList.remove(org);

        }
        Vector<Organization> newVector = new Vector<>(newList);
        return newVector;
    }
}
