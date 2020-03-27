package com.example.smartariumapp.ui.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import java.util.List;

public class GalleryViewModel extends ViewModel {

    List<String> mListText = new ArrayList<>();
    MutableLiveData<String> mText;

    public GalleryViewModel() {
        mListText.add("NO3 - Azotany");
        mListText.add("NO2 - Azotyny");
        mListText.add("Twardość całkowita (GH)");
        mListText.add("Stabilność pH (KH)");
        mListText.add("Kwasowość (pH)y");
        mListText.add("Chlor");
        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText(int index) {
        mText.setValue(mListText.get(index));
        return  mText;
    }
}