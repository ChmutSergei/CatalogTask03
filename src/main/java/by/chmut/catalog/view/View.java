package by.chmut.catalog.view;

import by.chmut.catalog.bean.News;

import java.util.Scanner;
import java.util.Set;

public class View {

    public static String getRequest() {
        Scanner scanner = new Scanner(System.in);
        String request = scanner.nextLine();
        return request;
    }

    public static void showResult(Set<News> result) {
        if (!result.isEmpty()) {
            for (News news : result) {
                if (news.getCategoryName().equals("Error") & news.getNameNews().equals("") ) {
                    System.out.println("\u001B[31mAttention!\nThere is no such command!!!");
                    break;
                }
                System.out.println(news);
            }
        }
    }
}
