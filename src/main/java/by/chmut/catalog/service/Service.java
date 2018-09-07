package by.chmut.catalog.service;

import by.chmut.catalog.bean.News;
import by.chmut.catalog.bean.criteria.Criteria;

import java.util.List;
import java.util.Set;


public interface Service {

    <E> Set<News> find(List<Criteria> allCriteriaToSearch) throws ServiceException;

    void addNews(News news);

    void load() throws ServiceException;

    void save() throws ServiceException;
}
