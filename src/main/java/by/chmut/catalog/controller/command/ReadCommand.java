package by.chmut.catalog.controller.command;

import by.chmut.catalog.bean.News;
import by.chmut.catalog.controller.Command;
import by.chmut.catalog.controller.LoggerEx;
import by.chmut.catalog.service.Service;
import by.chmut.catalog.service.ServiceException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Collections;
import java.util.Set;


public class ReadCommand implements Command {

    Service service;

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    @Override
    public Set<News> execute(String request) {

        try {
            service.load();
        } catch (ServiceException e) {
            LoggerEx.logger.error(e.getMessage(),e);
        }

        return Collections.emptySet();
    }
}
