package com.example.idn.roomdatabase;

import android.arch.persistence.room.Room;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.idn.roomdatabase.Fragments.MenuUtama;
import com.example.idn.roomdatabase.db.MyDatabase;

public class MainActivity extends AppCompatActivity {

    //TODO 4
    public static FragmentManager fragmentManager;
    public static MyDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDatabase = Room.databaseBuilder(getApplicationContext(),
                MyDatabase.class, "userdb")

                 /*
                 method ini digunakan untuk mengakses database
                 dengan tidak memblok Thread Utama
                 */
                .allowMainThreadQueries()
                .build();

        fragmentManager = getSupportFragmentManager();

        if (findViewById(R.id.fragment_container) != null) {

            if (savedInstanceState != null) {
                return;
            }

            fragmentManager.beginTransaction()
                    .add(R.id.fragment_container, new MenuUtama())
                    .commit();

        }
    }
}
