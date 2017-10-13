package com.bsuir.library;

import com.bsuir.library.controller.Controller;
import com.bsuir.library.view.implementation.ConsoleView;

/**
 * Entry point in the program
 */
public class Main {
    /**
     * Entry point in the program
     * @param args additional parameters when starting from the command line
     */
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.Start();
    }
}
