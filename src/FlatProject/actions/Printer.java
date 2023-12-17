package FlatProject.actions;

import FlatProject.exceptions.FlatException;
import FlatProject.interfaces.Printable;


import java.util.Collection;

public class Printer {
    public static void PrintSet(Collection<? extends Printable> array) throws FlatException {
        for(Printable p: array) p.print();
    }
}

