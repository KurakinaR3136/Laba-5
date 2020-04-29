package com.company;

import java.util.List;
import java.util.Vector;

public class GreaterRemover {
    public Vector<Organization> removeGreaterElement(List<Organization> input_vector) {
        List<Organization> newList = input_vector;
        Organization lastAddedElement = newList.get(input_vector.size() - 1);
        for (Organization org : newList) {
            if (org.getId() > lastAddedElement.getId()) {
                newList.remove(org);
            }
        }
        Vector<Organization> newVector = new Vector<>(newList);
        return newVector;
    }

}
