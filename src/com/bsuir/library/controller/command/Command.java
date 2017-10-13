package com.bsuir.library.controller.command;


/**
 * The Command interface should be implemented by
 * any class whose instances are intended
 * to be executed by ControllProvider.
 * The class must define a method of no arguments called execute.
   This interface is designed to provide a common protocol
   for objects that wish to execute code.
 */
public interface Command {

    /**
     * This method is designed to provide a common protocol for objects that wish to execute command.
     */
    void execute();
}
