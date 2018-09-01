package by.chmut.catalog.controller;

import by.chmut.catalog.controller.command.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class CommandDirector {

    private Map<String, Command> commands = new HashMap<String, Command>();

    CommandDirector() {}

    public CommandDirector(ReadCommand readCommand, SearchCommand searchCommand, AddCommand addCommand, SaveCommand saveCommand) {

//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

//        ReadCommand readCommand = context.getBean("readCommand",ReadCommand.class);
//        SearchCommand searchCommand = context.getBean("searchCommand",SearchCommand.class);
//        AddCommand addCommand = context.getBean("addCommand",AddCommand.class);
//        SaveCommand saveCommand = context.getBean("saveCommand",SaveCommand.class);

        commands.put("read", readCommand);
        commands.put("search", searchCommand);
        commands.put("add", addCommand);
        commands.put("save", saveCommand);
        commands.put("error", new ErrorCommand());
    }

    public Command getCommand(String commandName) {
        Command command = commands.get(commandName);
        if (command == null) {
            command = new ErrorCommand();
        }
        return command;
    }
}
