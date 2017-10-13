package com.bsuir.library.view;

/**
 * The Reader should be implemented by any class whose instances are intended to be read data
 */
public interface Reader {
    /**
     *Read the data line
     * @return Read data
     */
    String dataInputString();

    /**
     * Read the number
     * @return value
     */
    int dataInputInt();
}
