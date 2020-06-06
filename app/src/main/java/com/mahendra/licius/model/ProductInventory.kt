package com.mahendra.licius.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ProductInventory() : Parcelable {
    @SerializedName("product_id")
    @Expose
    var productId: String? = null

    @SerializedName("hub_id")
    @Expose
    var hubId: Long = 0

    @SerializedName("cat_id")
    @Expose
    var catId: Long = 0

    @SerializedName("stock_units")
    @Expose
    var stockUnits: Long = 0

    @SerializedName("stock_lock")
    @Expose
    var stockLock: Long = 0

    @SerializedName("merchant_delta")
    @Expose
    var merchantDelta: Long = 0

    @SerializedName("created_at")
    @Expose
    var createdAt: Any? = null

    @SerializedName("updated_at")
    @Expose
    var updatedAt: Any? = null

    @SerializedName("dispatched_quantity")
    @Expose
    var dispatchedQuantity: Long = 0

    @SerializedName("rm_buffer")
    @Expose
    var rmBuffer: Long = 0

    constructor(parcel: Parcel) : this() {
        productId = parcel.readString()
        hubId = parcel.readLong()
        catId = parcel.readLong()
        stockUnits = parcel.readLong()
        stockLock = parcel.readLong()
        merchantDelta = parcel.readLong()
        dispatchedQuantity = parcel.readLong()
        rmBuffer = parcel.readLong()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(productId)
        parcel.writeLong(hubId)
        parcel.writeLong(catId)
        parcel.writeLong(stockUnits)
        parcel.writeLong(stockLock)
        parcel.writeLong(merchantDelta)
        parcel.writeLong(dispatchedQuantity)
        parcel.writeLong(rmBuffer)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ProductInventory> {
        override fun createFromParcel(parcel: Parcel): ProductInventory {
            return ProductInventory(parcel)
        }

        override fun newArray(size: Int): Array<ProductInventory?> {
            return arrayOfNulls(size)
        }
    }

}