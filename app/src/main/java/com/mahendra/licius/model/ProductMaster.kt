package com.mahendra.licius.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ProductMaster() : Parcelable {
    @SerializedName("pr_name")
    @Expose
    var prName: String? = null

    @SerializedName("slug")
    @Expose
    var slug: String? = null

    @SerializedName("pr_weight")
    @Expose
    var prWeight: String? = null

    @SerializedName("gross")
    @Expose
    var gross: String? = null

    @SerializedName("net")
    @Expose
    var net: String? = null

    @SerializedName("uom")
    @Expose
    var uom: String? = null

    @SerializedName("status")
    @Expose
    var status: Long = 0

    @SerializedName("hsn_no")
    @Expose
    var hsnNo: Long = 0

    @SerializedName("created_at")
    @Expose
    var createdAt: Any? = null

    @SerializedName("updated_at")
    @Expose
    var updatedAt: Any? = null

    @SerializedName("product_id")
    @Expose
    var productId: String? = null

    @SerializedName("pieces")
    @Expose
    var pieces: String? = null

    @SerializedName("text")
    @Expose
    var text: String? = null

    constructor(parcel: Parcel) : this() {
        prName = parcel.readString()
        slug = parcel.readString()
        prWeight = parcel.readString()
        gross = parcel.readString()
        net = parcel.readString()
        uom = parcel.readString()
        status = parcel.readLong()
        hsnNo = parcel.readLong()
        productId = parcel.readString()
        pieces = parcel.readString()
        text = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(prName)
        parcel.writeString(slug)
        parcel.writeString(prWeight)
        parcel.writeString(gross)
        parcel.writeString(net)
        parcel.writeString(uom)
        parcel.writeLong(status)
        parcel.writeLong(hsnNo)
        parcel.writeString(productId)
        parcel.writeString(pieces)
        parcel.writeString(text)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ProductMaster> {
        override fun createFromParcel(parcel: Parcel): ProductMaster {
            return ProductMaster(parcel)
        }

        override fun newArray(size: Int): Array<ProductMaster?> {
            return arrayOfNulls(size)
        }
    }

}