package com.kotlin.ai.module_app_manager

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.kotlin.ai.lib_base.base.BaseActivity
import com.kotlin.ai.lib_base.helper.ARouterHelper


@Route(path = ARouterHelper.PATH_APP_MANAGER)
class AppManagerActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_manager)
    }
}