package com.biggcclife.sportcollabclient.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Information about your sorry ass self goes here :)"
    }
    val text: LiveData<String> = _text
}