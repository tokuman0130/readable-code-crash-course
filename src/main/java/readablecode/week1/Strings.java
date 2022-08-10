package readablecode.week1;

public class Strings {

    // TODO 1: 7.5,7.7 and 9.1

    // public static String capitalize(String str) {
    // String ret = str;//これいらない
    // if (str == null) {
    // ret = str;
    // } else if (str.length() == 0) {
    // ret = str;
    // } else {
    //// ここのネストを解消したい
    // if (str.length() == 1) {
    // ret = str.toUpperCase();
    // } else {
    // ret = str.substring(0, 1).toUpperCase() + str.substring(1);
    // }
    // }
    //// returnを各if文ごとに返していく
    // return ret;
    // }

    public static String capitalize(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        if (str.length() == 1) {
            return str.toUpperCase();
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);

    }

}
