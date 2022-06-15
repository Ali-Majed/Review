package com.example.reviewfragmentrecycler.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.reviewfragmentrecycler.modle.Word;

import java.util.List;

@Dao
public interface WordDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert (Word word);

    @Query("DELETE FROM word_table")
    void delete();

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    LiveData<List<Word>> getWord();
}
