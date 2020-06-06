package com.mahendra.licius.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Product() : Parcelable {
    @SerializedName("product_master")
    @Expose
    var productMaster: ProductMaster? = null

    @SerializedName("product_merchantdising")
    @Expose
    var productMerchandising: ProductMerchandising? = null

    @SerializedName("product_pricing")
    @Expose
    var productPricing: ProductPricing? = null

    @SerializedName("product_inventory")
    @Expose
    var productInventory: ProductInventory? = null

    constructor(parcel: Parcel) : this() {
        productMaster = parcel.readParcelable(ProductMaster::class.java.classLoader)
        productMerchandising = parcel.readParcelable(ProductMerchandising::class.java.classLoader)
        productPricing = parcel.readParcelable(ProductPricing::class.java.classLoader)
        productInventory = parcel.readParcelable(ProductInventory::class.java.classLoader)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(productMaster, flags)
        parcel.writeParcelable(productMerchandising, flags)
        parcel.writeParcelable(productPricing, flags)
        parcel.writeParcelable(productInventory, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }

}