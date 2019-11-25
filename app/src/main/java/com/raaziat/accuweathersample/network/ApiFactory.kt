package com.raaziat.accuweathersample.network

import com.raaziat.accuweathersample.utilts.Constants


object ApiFactory{

    val networkInterfaces : NetworkInterfaces = RetrofitFactory.retrofit(Constants.BASE_URL)
        .create(NetworkInterfaces::class.java)

}