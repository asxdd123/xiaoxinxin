package src.src.com.hello.pojo;

import src.src.com.hello.annotation.Gender;
import src.src.com.hello.annotation.Name;
import src.src.com.hello.annotation.Profile;

/**
 * Created by mingwei on 12/2/16.
 */
public class Person {

    @Name("阿特罗伯斯")
    private String name;

    @Gender(gender = Gender.GenderType.Male)
    private String gender;

    @Profile(id = 1001, height = 180, nativePlace = "烟台")
    private String profile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}