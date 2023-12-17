package FlatProject.interfaces;

import FlatProject.exceptions.FlatException;

import java.io.Serializable;

public interface MyFlatInterface extends Printable, Serializable {
    @Override
    public default void print() throws FlatException {
        print();
    }
}
