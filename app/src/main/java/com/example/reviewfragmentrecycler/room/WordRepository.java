package com.example.reviewfragmentrecycler.room;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.reviewfragmentrecycler.dao.WordDao;
import com.example.reviewfragmentrecycler.modle.Word;

import java.util.List;

public class WordRepository {

    private WordDao wordDao;
    private LiveData<List<Word>> allWords;

    WordRepository(Application application) {
        WordDatabase db = WordDatabase.getDatabase(application);
        wordDao = db.wordDao();
        allWords = wordDao.getWord();
    }

    public LiveData<List<Word>> getAllWords() {
        return allWords;
    }

    void insert(Word word) {
        WordDatabase.databaseWriteExecutor.execute(() -> {
            wordDao.insert(word);
        });
    }
}
