package com.mahendra.licius.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Data() : Parcelable {
    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("filters")
    @Expose
    var filters: List<Filter?>? = null

    @SerializedName("info_message")
    @Expose
    var infoMessage: String? = null

    @SerializedName("info_badge")
    @Expose
    var infoBadge: String? = null

    @SerializedName("products")
    @Expose
    var products: List<Product?>? = null

    constructor(parcel: Parcel) : this() {
        title = parcel.readString()
        filters = parcel.createTypedArrayList(Filter)
        infoMessage = parcel.readString()
        infoBadge = parcel.readString()
        products = parcel.createTypedArrayList(Product.CREATOR)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeTypedList(filters)
        parcel.writeString(infoMessage)
        parcel.writeString(infoBadge)
        parcel.writeTypedList(products)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Data> {
        override fun createFromParcel(parcel: Parcel): Data {
            return Data(parcel)
        }

        override fun newArray(size: Int): Array<Data?> {
            return arrayOfNulls(size)
        }
    }

}