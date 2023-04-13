package ru.spbstu.application.service.lab3;

import ru.spbstu.application.service.lab3.animals.HedgehogCommon;
import ru.spbstu.application.service.lab3.animals.Lynx;
import ru.spbstu.application.service.lab3.animals.Manul;

import java.util.Collection;

public class Function {
    public static void segregate(Collection<? extends ChordateAbstract> srcCollection,
                                 Collection<? super HedgehogCommon> collection1,
                                 Collection<? super Manul> collection2,
                                 Collection<? super Lynx> collection3) {
        for(var animal : srcCollection) {
            if(HedgehogCommon.class.isAssignableFrom(animal.getClass())) {
                collection1.add((HedgehogCommon) animal);
            }
            if(Manul.class.isAssignableFrom(animal.getClass())) {
                collection2.add((Manul) animal);
            }
            if(Lynx.class.isAssignableFrom(animal.getClass())) {
                collection3.add((Lynx) animal);
            }
        }
    }
}
