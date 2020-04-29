package com.company;
import java.util.Vector;
import java.util.List;


public class LowerRemover {

    public Vector<Organization> removeLowerElement(List<Organization> input_vector) {
        List<Organization> newList = input_vector;
        Organization lastAddedElement = newList.get(input_vector.size() - 1);
        for (Organization org : newList) {
            if (org.getId() < lastAddedElement.getId()) {
                newList.remove(org);
            }
        }
        Vector<Organization> newVector = new Vector<>(newList);
        return newVector;
    }

}
