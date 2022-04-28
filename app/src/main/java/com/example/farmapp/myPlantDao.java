package com.example.farmapp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * Data Access Object
 */
@Dao
public interface myPlantDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE) //삽입
    void setInsertPlant(myPlant myPlant);

    @Update //수정
    void setUpdatePlant(myPlant myPlant);

    @Delete //삭제
    void setDeletePlant(myPlant myPlant);



    //조회 쿼리
    @Query("SELECT * FROM myPlant") //쿼리 : 데이터베이스에 요청하는 명령문
    List<myPlant> getMyPlantDBAll();

    @Query("SELECT * FROM myPlant WHERE id= :id")
    List<myPlant> getPlantById(int id);

}
