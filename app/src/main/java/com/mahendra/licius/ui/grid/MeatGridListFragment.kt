package com.mahendra.licius.ui.grid

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.mahendra.licius.model.Product

import com.mahendra.licius.R
import com.mahendra.licius.base.NetworkState
import com.mahendra.licius.databinding.MeatGridListFragmentBinding

class MeatGridListFragment : Fragment(), MeatListAdapter.ItemClickListener {

    companion object {
        fun newInstance() = MeatGridListFragment()
    }

    private  var adapter: MeatListAdapter? = null
    private lateinit var binding: MeatGridListFragmentBinding
    private lateinit var viewModel: MeatGridListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding =  MeatGridListFragmentBinding.inflate(inflater)
        return binding.root;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initViews()

    }

    private fun initViews() {
        viewModel = ViewModelProvider(this).get(MeatGridListViewModel::class.java)
        binding.rvMeat.layoutManager = GridLayoutManager(context,2)
        adapter = MeatListAdapter(ArrayList(),this);
        binding.rvMeat.adapter = adapter
        viewModel.getFavorites().observe(viewLifecycleOwner,
            Observer<List<Product?>?> { t ->
                adapter?.updateList(t)
            })

        viewModel.getNetworkState().observe(viewLifecycleOwner, Observer {
            if(it.state == NetworkState.LOADING){
                binding.flProgress.visibility = View.VISIBLE
            }else if(it.state == NetworkState.LOADED){
                binding.flProgress.visibility = View.GONE

            }else if(it.state == NetworkState.LOAD_FAILED){
                binding.flProgress.visibility = View.GONE
                Toast.makeText(context,"Failed to load data",Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.getResponse().observe(viewLifecycleOwner, Observer {
            it?.let {
                it.data?.let { data ->
                    binding.tvMessage.text = data.infoMessage
                    binding.tvBadge.text = String.format("(%s)",data.infoBadge)
                    if(!data.filters.isNullOrEmpty() && data.filters!!.size > 1){
                        binding.btnOne.text = data.filters!![0]?.title
                        binding.btnTwo.text = data.filters!![1]?.title
                    }

                    binding.toolbarTitle.text = data.title

                }
            }
        })
    }

    override fun onItemClicked(product: Product) {

    }

}
