package ByMonth.august.april;

public class L158_ReadNChars_H {
    // read4 is the dummy one --> worry later
    private int read4(char[]buf) {
        return 0;
    }

    private char[] readBuff = new char[4];
    // bufPtr (pointer for buf read/copied so far range is (0-3))
    private int readBufPtr = 4;
    // (readBufCnt --> 1-4 # of characters read from the file)
    private int readBufCnt = 4;

    public int read(char[] buf, int n) {
        int ptr = 0;

        // ptr keeps track of characters read for far
        while(ptr < n) {
            if(readBufPtr < readBufCnt) {
                // do the copy
                buf[ptr++] = readBuff[readBufPtr++];
            } else {
                // reached the end of the file ( the previous loop finished copying already)
                if (readBufCnt < 4) break;
                // reset readBufPtr
                readBufPtr = 0;
                // and load into the readBuff, with readBufCnt to keep track
                readBufCnt = read4(readBuff);
            }
        }

        return ptr;
    }
}
