package apcsa;

public class Util {
    static String cleanString(String s) {
        return s.toLowerCase().replaceAll("[\\.!\\?\"'@#$%^&*\\(\\)_\\-\\+=\\\\\\/,:;\\{\\}\\[\\]\\~\\`]", "");
    }
}
