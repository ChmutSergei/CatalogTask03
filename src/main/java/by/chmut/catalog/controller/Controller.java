package by.chmut.catalog.controller;

import by.chmut.catalog.bean.News;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Set;

public class Controller{

    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    CommandDirector commandDirector = context.getBean("commandDirector", CommandDirector.class);

    public Set<News> doAction(String request) {
        int index = getIndexForParse(request);
        String commandName = request.substring(0,index).trim();
        request = request.substring(index+1,request.length());
        if (request.length() == 0) {
            commandName = "error";
        }
        Command command = commandDirector.getCommand(commandName);

        Set<News> result = command.execute(request);

        return result;
    }

    private int getIndexForParse(String request) {
        int index=0;
        for (char currentChar: request.toCharArray()) {
            if (currentChar == '-') {
                return index;
            }
            index++;
        }
        return index;
    }
}
