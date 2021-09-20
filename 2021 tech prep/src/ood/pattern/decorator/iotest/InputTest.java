package ood.pattern.decorator.iotest;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputTest {
    public static void main(String[] args) throws IOException {
        int c;
        try {
            InputStream in = new LowerClassInputStream(
                    new BufferedInputStream(
                            new FileInputStream("/Users/stephen/IdeaProjects/JavaApps/2021 tech prep/" +
                                    "src/ood/pattern/decorator/iotest/test.txt")
                    )
            );

            while ((c = in.read()) > 0) {
                System.out.print((char) c);
            }

            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
