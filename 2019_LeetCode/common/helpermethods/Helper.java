package common.helpermethods;

import java.util.List;

public class Helper {

    public static <Element> void printList(List<Element> list) {
        if (list == null) {
            System.out.println("List Data Invalid");
            return;
        }

        for (Element e: list) {
            System.out.println(e.toString());
        }
    }
}
