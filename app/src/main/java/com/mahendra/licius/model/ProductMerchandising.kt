package com.mahendra.licius.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ProductMerchandising() : Parcelable {
    @SerializedName("product_id")
    @Expose
    var productId: String? = null

    @SerializedName("hub_id")
    @Expose
    var hubId: Long = 0

    @SerializedName("city_id")
    @Expose
    var cityId: Long = 0

    @SerializedName("description")
    @Expose
    var description: String? = null

    @SerializedName("short_description")
    @Expose
    var shortDescription: String? = null

    @SerializedName("meta_title")
    @Expose
    var metaTitle: String? = null

    @SerializedName("meta_description")
    @Expose
    var metaDescription: String? = null

    @SerializedName("meta_keywords")
    @Expose
    var metaKeywords: String? = null

    @SerializedName("pr_image")
    @Expose
    var prImage: String? = null

    @SerializedName("pr_image_bucket")
    @Expose
    var prImageBucket: String? = null

    @SerializedName("pr_tags")
    @Expose
    var prTags: String? = null

    @SerializedName("usp_desc")
    @Expose
    var uspDesc: String? = null

    @SerializedName("msite_desc")
    @Expose
    var msiteDesc: String? = null

    @SerializedName("wt_msg")
    @Expose
    var wtMsg: String? = null

    @SerializedName("product_delivery_type")
    @Expose
    var productDeliveryType: String? = null

    @SerializedName("merchandise_name")
    @Expose
    var merchandiseName: String? = null

    @SerializedName("type")
    @Expose
    var type: String? = null

    @SerializedName("cut_off_time")
    @Expose
    var cutOffTime: Long = 0

    @SerializedName("slider_images")
    @Expose
    var sliderImages: String? = null

    @SerializedName("product_shortname")
    @Expose
    var productShortname: String? = null

    @SerializedName("no_of_piceces")
    @Expose
    var noOfPiceces: String? = null

    @SerializedName("serves")
    @Expose
    var serves: String? = null

    @SerializedName("cooking_time")
    @Expose
    var cookingTime: String? = null

    @SerializedName("best_before")
    @Expose
    var bestBefore: String? = null

    @SerializedName("product_header_tags")
    @Expose
    var productHeaderTags: String? = null

    @SerializedName("pdp_gross_wt")
    @Expose
    var pdpGrossWt: String? = null

    @SerializedName("pdp_net_wt")
    @Expose
    var pdpNetWt: String? = null

    @SerializedName("pdp_pieces_img_url")
    @Expose
    var pdpPiecesImgUrl: String? = null

    @SerializedName("pdp_serves_img_url")
    @Expose
    var pdpServesImgUrl: String? = null

    @SerializedName("pdp_cooktime_img_url")
    @Expose
    var pdpCooktimeImgUrl: String? = null

    @SerializedName("pdp_bestbefore_img_url")
    @Expose
    var pdpBestbeforeImgUrl: String? = null

    @SerializedName("gross_wt_img_pdp")
    @Expose
    var grossWtImgPdp: String? = null

    @SerializedName("net_wt_img_pdp")
    @Expose
    var netWtImgPdp: String? = null

    @SerializedName("display_order")
    @Expose
    var displayOrder: Long = 0

    @SerializedName("created_at")
    @Expose
    var createdAt: Any? = null

    @SerializedName("updated_at")
    @Expose
    var updatedAt: Any? = null

    @SerializedName("score")
    @Expose
    var score: Long = 0

    @SerializedName("inv_sort")
    @Expose
    var invSort: Long = 0

    @SerializedName("count_sort")
    @Expose
    var countSort: Long = 0

    constructor(parcel: Parcel) : this() {
        productId = parcel.readString()
        hubId = parcel.readLong()
        cityId = parcel.readLong()
        description = parcel.readString()
        shortDescription = parcel.readString()
        metaTitle = parcel.readString()
        metaDescription = parcel.readString()
        metaKeywords = parcel.readString()
        prImage = parcel.readString()
        prImageBucket = parcel.readString()
        prTags = parcel.readString()
        uspDesc = parcel.readString()
        msiteDesc = parcel.readString()
        wtMsg = parcel.readString()
        productDeliveryType = parcel.readString()
        merchandiseName = parcel.readString()
        type = parcel.readString()
        cutOffTime = parcel.readLong()
        sliderImages = parcel.readString()
        productShortname = parcel.readString()
        noOfPiceces = parcel.readString()
        serves = parcel.readString()
        cookingTime = parcel.readString()
        bestBefore = parcel.readString()
        productHeaderTags = parcel.readString()
        pdpGrossWt = parcel.readString()
        pdpNetWt = parcel.readString()
        pdpPiecesImgUrl = parcel.readString()
        pdpServesImgUrl = parcel.readString()
        pdpCooktimeImgUrl = parcel.readString()
        pdpBestbeforeImgUrl = parcel.readString()
        grossWtImgPdp = parcel.readString()
        netWtImgPdp = parcel.readString()
        displayOrder = parcel.readLong()
        score = parcel.readLong()
        invSort = parcel.readLong()
        countSort = parcel.readLong()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(productId)
        parcel.writeLong(hubId)
        parcel.writeLong(cityId)
        parcel.writeString(description)
        parcel.writeString(shortDescription)
        parcel.writeString(metaTitle)
        parcel.writeString(metaDescription)
        parcel.writeString(metaKeywords)
        parcel.writeString(prImage)
        parcel.writeString(prImageBucket)
        parcel.writeString(prTags)
        parcel.writeString(uspDesc)
        parcel.writeString(msiteDesc)
        parcel.writeString(wtMsg)
        parcel.writeString(productDeliveryType)
        parcel.writeString(merchandiseName)
        parcel.writeString(type)
        parcel.writeLong(cutOffTime)
        parcel.writeString(sliderImages)
        parcel.writeString(productShortname)
        parcel.writeString(noOfPiceces)
        parcel.writeString(serves)
        parcel.writeString(cookingTime)
        parcel.writeString(bestBefore)
        parcel.writeString(productHeaderTags)
        parcel.writeString(pdpGrossWt)
        parcel.writeString(pdpNetWt)
        parcel.writeString(pdpPiecesImgUrl)
        parcel.writeString(pdpServesImgUrl)
        parcel.writeString(pdpCooktimeImgUrl)
        parcel.writeString(pdpBestbeforeImgUrl)
        parcel.writeString(grossWtImgPdp)
        parcel.writeString(netWtImgPdp)
        parcel.writeLong(displayOrder)
        parcel.writeLong(score)
        parcel.writeLong(invSort)
        parcel.writeLong(countSort)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ProductMerchandising> {
        override fun createFromParcel(parcel: Parcel): ProductMerchandising {
            return ProductMerchandising(parcel)
        }

        override fun newArray(size: Int): Array<ProductMerchandising?> {
            return arrayOfNulls(size)
        }
    }

}