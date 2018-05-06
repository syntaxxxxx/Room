package com.example.idn.roomdatabase.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.idn.roomdatabase.db.entity.User;

import java.util.List;

/**
 * Created by idn on 5/6/2018.
 */

@Dao
public interface MyDao {

    @Insert
    void addUser(User user);

    @Query("select * from users")
    List<User> getUsers();

    @Update
    void updateUser(User user);

    @Delete
    void deleteUser(User user);
}
