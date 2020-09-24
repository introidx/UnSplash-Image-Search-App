package com.introid.unsplashimagesearch.ui.gallery

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.introid.unsplashimagesearch.data.UnsplashRepository

class GalleryViewModel  @ViewModelInject constructor (
    private val repository : UnsplashRepository
) : ViewModel(){
}