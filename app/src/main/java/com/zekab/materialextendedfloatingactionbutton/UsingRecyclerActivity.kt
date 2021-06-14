package com.zekab.materialextendedfloatingactionbutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zekab.materialextendedfloatingactionbutton.databinding.ActivityUsingRecyclerBinding

class UsingRecyclerActivity : AppCompatActivity() {

    private lateinit var mAdapter: AdapterCountry
    private lateinit var binding:ActivityUsingRecyclerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_using_recycler)

        createRecyclerView()
    }

    private fun createRecyclerView() {
        mAdapter = AdapterCountry()
        binding.recyclerview.adapter = mAdapter
        binding.recyclerview.layoutManager = GridLayoutManager(this, 1)
        mAdapter.submitList(dataProvider())

        mAdapter.setOnItemClickListener(object : OnCountryItemClickListener {
            override fun onItemClick(position: Int) {
                showMessage(mAdapter.currentList[position].countryName)
            }

        })

        binding.recyclerview.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                // Scroll down
                if (dy > 20 && binding.extendedFab.isExtended) {
                    binding.extendedFab.shrink()
                }

                // Scroll up
                if (dy < -20 && !binding.extendedFab.isExtended) {
                    binding.extendedFab.extend()
                }

                // At the top
                if (!recyclerView.canScrollVertically(-1)) {
                    binding.extendedFab.extend()
                }
            }
        })

    }

    // these are dummy values
    private fun dataProvider():ArrayList<CountryItem>{
        val mList:ArrayList<CountryItem> = ArrayList()
        mList.add(CountryItem("+1","Australia"))
        mList.add(CountryItem("+2","Brazil"))
        mList.add(CountryItem("+3","Canada"))
        mList.add(CountryItem("+4","China"))
        mList.add(CountryItem("+5","Germany"))
        mList.add(CountryItem("+6","India"))
        mList.add(CountryItem("+7","Italy"))
        mList.add(CountryItem("+8","Mexico"))
        mList.add(CountryItem("+9","Netherlands"))
        mList.add(CountryItem("+10","Norway"))
        mList.add(CountryItem("+11","Pakistan"))
        mList.add(CountryItem("+12","Spain"))
        mList.add(CountryItem("+13","Switzerland"))
        mList.add(CountryItem("+14","Turkey"))
        mList.add(CountryItem("+15","United Kingdom"))
        mList.add(CountryItem("+16","United States"))
        mList.add(CountryItem("+17","Australia"))
        mList.add(CountryItem("+18","Brazil"))
        mList.add(CountryItem("+19","Canada"))
        mList.add(CountryItem("+20","China"))
        mList.add(CountryItem("+21","Germany"))
        mList.add(CountryItem("+22","India"))
        mList.add(CountryItem("+23","Italy"))
        mList.add(CountryItem("+24","Mexico"))
        mList.add(CountryItem("+25","Netherlands"))
        mList.add(CountryItem("+26","Norway"))
        mList.add(CountryItem("+27","Pakistan"))
        mList.add(CountryItem("+28","Spain"))
        mList.add(CountryItem("+29","Switzerland"))
        mList.add(CountryItem("+30","Turkey"))
        mList.add(CountryItem("+31","United Kingdom"))
        mList.add(CountryItem("+32","United States"))


        return mList

    }

    private fun showMessage(message:String){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
    }
}