package com.example.idn.roomdatabase.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.idn.roomdatabase.db.entity.User;

@Database(entities = {User.class}, version = 1)
public abstract class MyDatabase extends RoomDatabase {

    public abstract MyDao myDao();

}
