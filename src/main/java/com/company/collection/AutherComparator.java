package com.company.collection;

import java.util.Comparator;

public class AutherComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {

        return ((Book)o1).auther.compareTo(((Book)o2).auther);

    }
}
