package by.chmut.catalog.controller;

import by.chmut.catalog.bean.News;
import by.chmut.catalog.service.ServiceException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Collections;
import java.util.Set;

public class Controller{

    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    CommandDirector commandDirector = context.getBean("commandDirector", CommandDirector.class);


    public Set<News> doAction(String request) {
        int index = getIndexForParse(request.trim());

        String commandName = "error";;

        if (index != -1) {

            commandName = request.substring(0,index).trim();

            request = request.substring(index+1,request.length());

        }

        Command command = commandDirector.getCommand(commandName);

        Set<News> result = command.execute(request);

        return result;
    }



    private int getIndexForParse(String request) {
        int index=0;
        for (char currentChar: request.toCharArray()) {
            if ((currentChar == '-') && (index!=request.length()-1) ) {
                return index;
            }
            index++;
        }
        index = -1; //error
        return index;
    }
}
