package com.orion.autovaluewithautogson;

import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;
import com.orion.autovaluewithautogson.gson.AutoGson;

@AutoGson
@AutoValue
public abstract class Person {

    @NonNull
    public abstract String name();

    @NonNull
    public abstract Integer years();

    public static Person create(String name, Integer years) {
        return new AutoValue_Person(name, years);
    }
}
