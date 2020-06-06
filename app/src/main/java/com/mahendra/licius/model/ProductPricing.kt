package com.mahendra.licius.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ProductPricing() : Parcelable {
    @SerializedName("product_id")
    @Expose
    var productId: String? = null

    @SerializedName("city_id")
    @Expose
    var cityId: Long = 0

    @SerializedName("hub_id")
    @Expose
    var hubId: Long = 0

    @SerializedName("base_price")
    @Expose
    var basePrice: Long = 0

    @SerializedName("price_gram")
    @Expose
    var priceGram = 0.0

    @SerializedName("unit_gram")
    @Expose
    var unitGram: Long = 0

    @SerializedName("cgst")
    @Expose
    var cgst: Long = 0

    @SerializedName("sgst")
    @Expose
    var sgst: Long = 0

    @SerializedName("created_at")
    @Expose
    var createdAt: Any? = null

    @SerializedName("updated_at")
    @Expose
    var updatedAt: Any? = null

    constructor(parcel: Parcel) : this() {
        productId = parcel.readString()
        cityId = parcel.readLong()
        hubId = parcel.readLong()
        basePrice = parcel.readLong()
        priceGram = parcel.readDouble()
        unitGram = parcel.readLong()
        cgst = parcel.readLong()
        sgst = parcel.readLong()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(productId)
        parcel.writeLong(cityId)
        parcel.writeLong(hubId)
        parcel.writeLong(basePrice)
        parcel.writeDouble(priceGram)
        parcel.writeLong(unitGram)
        parcel.writeLong(cgst)
        parcel.writeLong(sgst)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ProductPricing> {
        override fun createFromParcel(parcel: Parcel): ProductPricing {
            return ProductPricing(parcel)
        }

        override fun newArray(size: Int): Array<ProductPricing?> {
            return arrayOfNulls(size)
        }
    }

}