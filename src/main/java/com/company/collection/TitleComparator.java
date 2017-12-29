package com.company.collection;

import java.util.Comparator;

public class TitleComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {

        return ((Book)o1).title.compareTo(((Book)o2).title);

    }
}
