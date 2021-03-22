package com.cp;

public class pageBuilder {
    private static String topPath = "src/main/resources/Top.html";
    private static String bottomPath = "src/main/resources/Bottom.html";
    public static String homePage(){
        String homeBodyText = "src/main/resources/homeBody.html";
        return buildPage(homeBodyText);
    }
    public static String buildPage(String bodyPath){
        return FileManager.readFileAsString(topPath)+
                FileManager.readFileAsString(bodyPath)+
                FileManager.readFileAsString(bottomPath);
    }
    public static String buildPageWUnformattedBody(String bodyText){
        return FileManager.readFileAsString(topPath)+
                "\n <section> \n"+bodyText+"\n </section> \n"+
                FileManager.readFileAsString(bottomPath);
    }
    public static String buildPageWBody(String bodyText){
        return FileManager.readFileAsString(topPath)+
                FileManager.readFileAsString(bodyText)+
                FileManager.readFileAsString(bottomPath);
    }


}
