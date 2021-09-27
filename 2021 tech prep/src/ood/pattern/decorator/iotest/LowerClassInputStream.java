package ood.pattern.decorator.iotest;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LowerClassInputStream extends FilterInputStream {

    public LowerClassInputStream(InputStream in)  {
        super(in);
    }

    // decorator pattern with super.read()
    // this is important as this is how decorator is able to rely on the instance info

    // We can use super instead of having a InputStream instance in the class
    // FilterInputStream is the decorator abstract class that EXTENDS InputStream
    public int read() throws IOException {
        // This is the int character representation
        int c = super.read();
        return (c == -1 ? c : Character.toLowerCase((char) c));
    }

    public int read(byte[] b, int offset, int len) throws IOException {
        int result = super.read(b, offset, len);
        for (int i = offset; i < offset + result; i++) {
            b[i] = (byte) Character.toLowerCase((char) b[i]);
        }

        return result;
    }
}
