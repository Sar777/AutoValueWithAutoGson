package com.orion.autovaluewithautogson;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.orion.autovaluewithautogson.gson.AutoValueAdapterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(new AutoValueAdapterFactory())
                .create();

        Person person = Person.create("John", 100);

        Log.e("GSON", "--- TO JSON ---");
        String jsonPerson = gson.toJson(person);
        Log.e("GSON", jsonPerson);

        Log.e("GSON", "--- FROM JSON ---");
        Person fromJsonPerson = gson.fromJson(jsonPerson, Person.class);
        Log.e("GSON", "Name " + fromJsonPerson.name());
        Log.e("GSON", "Years " + fromJsonPerson.years());
    }
}
