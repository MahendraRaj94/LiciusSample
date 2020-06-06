package com.mahendra.licius.ui.grid

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mahendra.licius.base.NetworkState
import com.mahendra.licius.model.Data
import com.mahendra.licius.model.Filter
import com.mahendra.licius.model.Product
import com.mahendra.licius.model.RetroProductResponse
import com.mahendra.licius.network.RestApi
import com.mahendra.licius.network.RetrofitProvider
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MeatGridListViewModel : ViewModel() {
    var restApi : RestApi = RetrofitProvider.getInstance().provideApi();

    var data : LiveData<List<Product?>?> = MutableLiveData<List<Product?>?>();

    var filterItems : LiveData<RetroProductResponse?> = MutableLiveData();

    val networkState : MutableLiveData<NetworkState> = MutableLiveData();

    fun getNetworkState() : LiveData<NetworkState>{
        return networkState;
    }
    fun getFavorites() : LiveData<List<Product?>?> {
        GlobalScope.async {
            networkState.postValue(NetworkState(NetworkState.LOADING))
            restApi.getProductItems().enqueue(object : Callback<RetroProductResponse>{
                override fun onFailure(call: Call<RetroProductResponse>, t: Throwable) {
                    t.printStackTrace()
                    networkState.postValue(NetworkState(NetworkState.LOAD_FAILED))
                }

                override fun onResponse(
                    call: Call<RetroProductResponse>,
                    response: Response<RetroProductResponse>
                ) {
                    if(response.isSuccessful){
                    (data as MutableLiveData).value = response.body()?.data?.products
                    (filterItems as MutableLiveData).value = response.body();
                        networkState.postValue(NetworkState(NetworkState.LOADED))
                    }else{
                        networkState.postValue(NetworkState(NetworkState.LOAD_FAILED))
                    }
                }

            })
        }

        return data;
    }

    fun getResponse() : LiveData<RetroProductResponse?>{
        return filterItems;
    }
}
