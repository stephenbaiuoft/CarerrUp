package Leetcode;

public class L65_H {
    public boolean isNumber(String s) {
        return s.matches("\\s*(\\+|-)?((\\.?\\d+)|(\\d+\\.\\d+)|(\\d+\\.))((e|E)(\\+|-)?\\d+)?\\s*");
    }
}
