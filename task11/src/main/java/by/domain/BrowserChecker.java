package by.domain;

public class BrowserChecker {

    private final static String firefox = "firefox";
    private final static String edg = "edg";
    private final static String samsung = "samsungbrowser";
    private final static String opera = "opr";
    private final static String chrome = "chrome";
    private final static String mobile = "mobile";
    //TODO: make variable for a safari browser;

    public static String checkBrowser(String fullName) {
        if(containsString(fullName,firefox)) return "Firefox";
        if(containsString(fullName,edg)) return "Microsoft Edge";
        if(containsString(fullName,samsung)) return "Samsung Browser";
        if(containsString(fullName,opera)) return "Opera";
        if(containsString(fullName,chrome) && containsString(fullName,mobile)) return "Chrome Mobile";
        if(containsString(fullName,chrome)) return "Chrome";
        return "Unknown Browser";
    }

    private static boolean containsString(String str,String includeString) {
        return str.toLowerCase().contains(includeString);
    }
}
