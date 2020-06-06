package com.mahendra.licius.ui.grid

import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import android.text.style.StrikethroughSpan
import android.text.style.TextAppearanceSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mahendra.licius.R
import com.mahendra.licius.databinding.ListItemMeatBinding
import com.mahendra.licius.model.Product

class MeatListAdapter(var list : List<Product?>?,val itemClickListener: ItemClickListener) :
    RecyclerView.Adapter<MeatListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ListItemMeatBinding>(LayoutInflater.from(parent.context),R.layout.list_item_meat,parent,false)
        return ViewHolder(binding);
    }

    override fun getItemCount(): Int {
       if(list.isNullOrEmpty())
           return 0;
        return list!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        list?.let {list ->
            list[position]?.let {
                Glide.with(holder.itemView)
                    .load(it.productMerchandising?.prImage)
                    .placeholder(R.drawable.ic_chicken)
                    .into(holder.binding.ivMeat);

                holder.binding.tvNettWeight.text = "Net wt. ".plus(it.productMaster?.prWeight)
                val wordOne = "₹ ${it.productPricing?.basePrice}"
                val wordTwo = "₹ ${it.productPricing?.unitGram}"

                val spannableString = SpannableString("$wordOne   $wordTwo")
                spannableString.setSpan(ForegroundColorSpan(holder.itemView.context.resources.getColor(R.color.grey))
                    ,wordOne.length + 2,spannableString.length,0)
                spannableString.setSpan(StrikethroughSpan()
                    ,wordOne.length + 2,spannableString.length,0)
                spannableString.setSpan(RelativeSizeSpan(0.8f)
                    ,wordOne.length + 2,spannableString.length,0)

                holder.binding.tvDiscPrice.text = spannableString
                holder.binding.tvTitle.text = it.productMaster?.prName

                if(holder.adapterPosition % 3 == 0){
                    holder.binding.tvRecommended.visibility = View.VISIBLE
                }else
                    holder.binding.tvRecommended.visibility = View.GONE

                if(holder.adapterPosition % 5 == 0){
                    holder.binding.tvOffer.visibility = View.VISIBLE
                }else
                    holder.binding.tvOffer.visibility = View.GONE
            }

        }

    }

    fun updateList(list: List<Product?>?) {
        this.list = list;
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ListItemMeatBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    interface ItemClickListener{
        fun onItemClicked(product: Product);
    }
}