package com.introid.unsplashimagesearch.data

import com.introid.unsplashimagesearch.api.UnsplashApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UnsplashRepository @Inject constructor (private val unsplashApi: UnsplashApi){

}