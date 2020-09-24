package com.introid.unsplashimagesearch.api

import com.introid.unsplashimagesearch.data.UnsplashPhoto

data class UnsplashResponse(
    val results : List<UnsplashPhoto>
)