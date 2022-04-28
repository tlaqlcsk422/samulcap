package com.example.farmapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {plant.class}, version = 1)
public abstract class plantDB extends RoomDatabase {
//    private static plantDB INSTANCE;

    public abstract plantDao plantDao();

//    public static plantDB getAppDB(Context context){
//        if(INSTANCE == null){
//            INSTANCE = Room.databaseBuilder(context, plantDB.class, "plant-db")
//                    .build();
//        }
//        return INSTANCE;
//    }
//
//    public static void destroyInstance() {
//        INSTANCE = null;
//    }
}
