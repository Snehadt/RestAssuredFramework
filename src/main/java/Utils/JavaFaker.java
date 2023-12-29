package Utils;

import com.github.javafaker.Faker;

public class JavaFaker {

    public static String getPName(){
        Faker faker = new Faker();
        return "Playlist" + faker.regexify("[A-Za-z0-9 ,_-]{10}");
    }

    public static String getDescription(){
        Faker faker = new Faker();
        return "Desc" + faker.regexify("[A-Za-z0-9 ,_-@*&]{20}");
    }
}
