package com.zekab.materialextendedfloatingactionbutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.NestedScrollView
import androidx.databinding.DataBindingUtil
import com.zekab.materialextendedfloatingactionbutton.databinding.ActivityUsingScrollBinding

class UsingScrollActivity : AppCompatActivity() {

    private lateinit var binding:ActivityUsingScrollBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_using_scroll)

        binding.nestedScrollView.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener{v,scrollX,scrollY,oldScrollX,oldScrollY ->
            if (scrollY > oldScrollY + 20 && binding.extendedFab.isExtended) {     // Scroll Down
                binding.extendedFab.shrink()
            }

            if(scrollY < oldScrollY - 20 && !binding.extendedFab.isExtended) {      // Scroll Up
                binding.extendedFab.extend()
            }

            if (scrollY == 0) {     // At the top
                binding.extendedFab.extend()
            }
        })
    }
}