package com.mahendra.licius.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RetroProductResponse() : Parcelable {
    @SerializedName("statusCode")
    @Expose
    var statusCode: Long = 0

    @SerializedName("statusMessage")
    @Expose
    var statusMessage: String? = null

    @SerializedName("data")
    @Expose
    var data: Data? = null

    constructor(parcel: Parcel) : this() {
        statusCode = parcel.readLong()
        statusMessage = parcel.readString()
        data = parcel.readParcelable(Data::class.java.classLoader)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(statusCode)
        parcel.writeString(statusMessage)
        parcel.writeParcelable(data, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RetroProductResponse> {
        override fun createFromParcel(parcel: Parcel): RetroProductResponse {
            return RetroProductResponse(parcel)
        }

        override fun newArray(size: Int): Array<RetroProductResponse?> {
            return arrayOfNulls(size)
        }
    }

}