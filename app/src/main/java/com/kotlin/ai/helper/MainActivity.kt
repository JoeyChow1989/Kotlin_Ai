package com.kotlin.ai.helper

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.ai.lib_base.helper.ARouterHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        id_btn.setOnClickListener {
            ARouterHelper.startActivity(ARouterHelper.PATH_APP_MANAGER)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}