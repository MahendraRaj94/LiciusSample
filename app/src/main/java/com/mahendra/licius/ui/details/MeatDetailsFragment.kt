package com.mahendra.licius.ui.details

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.mahendra.licius.model.Product

import com.mahendra.licius.R

class MeatDetailsFragment : Fragment() {

    companion object {
        const val KEY_PRODUCT : String = "key_product"
        fun newInstance(product: Product) : MeatDetailsFragment{
            val fragment = MeatDetailsFragment();
            fragment.arguments?.apply {
                putParcelable(KEY_PRODUCT,product)
            }

            return fragment
        }
    }

    private lateinit var viewModel: MeatDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.meat_details_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MeatDetailsViewModel::class.java)
    }

}
