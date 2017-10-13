package com.bsuir.library.view;

import com.bsuir.library.view.implementation.ConsoleView;

public class ViewFactory {
    private static final ViewFactory factory = new ViewFactory();
    private final View view = new ConsoleView();

    private ViewFactory() {
    }

    public static ViewFactory getInstance() {
        return factory;
    }

    public View getView() {
        return view;
    }
}
