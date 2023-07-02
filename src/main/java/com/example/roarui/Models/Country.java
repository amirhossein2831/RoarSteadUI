package com.example.roarui.Models;

import com.example.roarui.App;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Country {
    private static final String COUNTRIES_PATH = "countries.json";
    private String name;

    @SerializedName("dial_code")
    private String dialCode;

    private String emoji;
    private String code;

    public static Country getCountryByDialCode(String dialCode){
        try (FileReader fileReader = new FileReader(COUNTRIES_PATH)){
            Type listCountryType = new TypeToken<ArrayList<Country>>(){}.getType();
            List<Country> countries = App.gson().fromJson(fileReader, listCountryType);
            for (Country country :
                    countries) {
                if (country.getDialCode().equals(dialCode)){
                    return country;
                }
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDialCode() {
        return dialCode;
    }

    public void setDialCode(String dialCode) {
        this.dialCode = dialCode;
    }

    public String getEmoji() {
        return emoji;
    }

    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
