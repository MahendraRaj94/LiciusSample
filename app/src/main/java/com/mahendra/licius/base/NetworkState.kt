package com.mahendra.licius.base

class NetworkState(val state: Int) {

    companion object{
        const val LOADING : Int = 0;
        const val LOADED : Int = 1;
        const val LOAD_FAILED : Int = 2;
    }
}