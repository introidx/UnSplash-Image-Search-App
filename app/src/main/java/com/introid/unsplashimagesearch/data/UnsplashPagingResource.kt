package com.introid.unsplashimagesearch.data

import androidx.paging.PagingSource
import com.introid.unsplashimagesearch.api.UnsplashApi
import retrofit2.HttpException
import java.io.IOException

private const val UNSPLASH_STARTING_PAGE_Index =1

class UnsplashPagingResource(
    private val unsplashApi: UnsplashApi,
    private val query : String
) : PagingSource<Int, UnsplashPhoto>(){

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UnsplashPhoto> {
        val position = params.key ?: UNSPLASH_STARTING_PAGE_Index

        return try {
            val response = unsplashApi.searchPhotos(query , position , params.loadSize)
            val photos = response.results

            LoadResult.Page(
                data = photos,
                prevKey = if (position == UNSPLASH_STARTING_PAGE_Index) null else position -1,
                nextKey =  if (photos.isEmpty()) null else position + 1
            )
        }catch (e: IOException){
            LoadResult.Error(e)
        }catch (e : HttpException){
            LoadResult.Error(e)
        }
    }

}