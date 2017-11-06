package com.bsuir.library.controller.command.implementation;

import com.bsuir.library.controller.command.Command;
import com.bsuir.library.service.MailService;
import com.bsuir.library.service.ServiceFactory;
import com.bsuir.library.view.Reader;
import com.bsuir.library.view.View;
import com.bsuir.library.view.ViewFactory;

public class SendNotifyCommand  implements Command{
    @Override
    public void execute() {

    }
    SendNotifyCommand(){
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        mailService = serviceFactory.getMailService();
        ViewFactory factory = ViewFactory.getInstance();
        view  = factory.getView();
        reader = factory.getReader();
    }
    private MailService mailService;
    private View view;
    private Reader reader;
}
