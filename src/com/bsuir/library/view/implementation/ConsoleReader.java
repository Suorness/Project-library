package com.bsuir.library.view.implementation;

import com.bsuir.library.view.Reader;

import java.util.Scanner;

/**
 * Class that reads data through the console
 */
public class ConsoleReader implements Reader {
    /**
     *Read the data line
     * @return Read data
     */
    @Override
    public String dataInputString() {
        String result;
        result = in.nextLine().trim();
        return result;
    }
    /**
     * Read the number
     * @return value
     */
    @Override
    public int dataInputInt() {
        int result;
        String str = in.nextLine().trim();
        try {
            result = Integer.parseInt(str);
        }catch (NumberFormatException e){
            result = -1;
        }
        return result;
    }

    public ConsoleReader(){
        in = new Scanner(System.in);
    }
    private Scanner in;
}
