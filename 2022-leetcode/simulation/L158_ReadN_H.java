package simulation;

public class L158_ReadN_H {
    class Reader4 {
        public int read4(char[] copy) {
            return -1;
        }
    }

    class Solution extends Reader4 {
        /**
         * @param buf Destination buffer
         * @param n   Number of characters to read
         * @return    The number of actual characters read
         */

        private char[] copy = new char[4];
        // readPtr into copy
        private int readPtr = 4;

        // how much is copied to buff total, 0-4
        private int copySize = 4;

        public int read(char[] buf, int n) {
            int cur = 0;
            while (cur < n) {
                if (readPtr < copySize) {
                    buf[cur++] = copy[readPtr++];
                } else {
                    // meaning no more to copy from read4
                    if (copySize < 4) {
                        // we'd exit
                        break;
                    }
                    // update copySize
                    copySize = read4(copy);
                    // reset readPtr to read from scratch
                    readPtr = 0;
                }
            }

            return cur;
        }
    }
}
