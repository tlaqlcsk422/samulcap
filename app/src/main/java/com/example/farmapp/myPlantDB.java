package com.example.farmapp;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {myPlant.class}, version = 1)
public abstract class myPlantDB extends RoomDatabase {
//    private static plantDB INSTANCE;

    public abstract myPlantDao myPlantDao();

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
