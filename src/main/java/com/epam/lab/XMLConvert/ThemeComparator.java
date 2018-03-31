package com.epam.lab.XMLConvert;

import com.epam.lab.Model.OldCard;

import java.util.Comparator;

class ThemeComparator implements Comparator {
    public int compare(Object o1, Object o2) {
        OldCard s1 = (OldCard) o1;
        OldCard s2 = (OldCard) o2;
        return s1.getTheme().compareTo(s2.getTheme());
    }
}