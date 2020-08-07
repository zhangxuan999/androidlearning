package com.chujian.ups.mvvmtest;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel
{

    private MutableLiveData<Integer> num;

    public MutableLiveData<Integer> getNum(){
        if (num == null){
            num = new MutableLiveData<>();
            num.setValue(0);
        }
        return  num;
    }

    public void setNum(int n){
        num.setValue(num.getValue()+n);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
