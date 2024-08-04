public class Main {
    public static void main(String[] args) {
        Logger logger = new Logger();

        System.out.println( logger.shouldPrintMessage(1, "foo"));  // return true, next allowed timestamp for "foo" is 1 + 10 = 11
        System.out.println( logger.shouldPrintMessage(2, "bar"));  // return true, next allowed timestamp for "bar" is 2 + 10 = 12

        System.out.println( logger.shouldPrintMessage(3, "foo"));  // 3 < 11, return false
        System.out.println( logger.shouldPrintMessage(8, "bar"));  // 8 < 12, return false
        System.out.println( logger.shouldPrintMessage(10, "foo")); // 10 < 11, return false
        System.out.println( logger.shouldPrintMessage(11, "foo")); // 11 >= 11, return true, next allowed timestamp for "foo" is 11 + 10 = 21

        logger.loggerSize(); // 2, in logger you have: foo, bar
        System.out.println( logger.clean(11)); // message "bar" would be printed in this timestamp, return false
        System.out.println( logger.clean(12)); // in timestamp 12 there is no messages in stream, return true

    }
}