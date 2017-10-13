package com.bsuir.library;

import com.bsuir.library.controller.Controller;
import com.bsuir.library.view.implementation.ConsoleView;

public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.Start();
    }
}
