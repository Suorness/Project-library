package com.bsuir.library.view;

import com.bsuir.library.view.implementation.ConsoleReader;
import com.bsuir.library.view.implementation.ConsoleView;
/**
 * This is an class that provides access to the view and read mechanism
 */
public class ViewFactory {
    private static final ViewFactory factory = new ViewFactory();

    private final View view = new ConsoleView();
    private final Reader reader = new ConsoleReader();

    private ViewFactory() {
    }

    /**
     * The method that returns an instance ViewFactory
     * @return  instance ViewFactory
     */
    public static ViewFactory getInstance() {
        return factory;
    }
    /**
     * The method that returns an instance View
     * @return  instance View
     */
    public View getView() {
        return view;
    }
    /**
     * The method that returns an instance Reader
     * @return  instance Reader
     */
    public Reader getReader(){
        return reader;
    }
}
