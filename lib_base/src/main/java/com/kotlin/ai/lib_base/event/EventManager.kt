package com.kotlin.ai.lib_base.event

import org.greenrobot.eventbus.EventBus

/**
 * EventBus管理
 */
object EventManager {

    //注册
    fun register(subscriber: Any) {
        EventBus.getDefault().register(subscriber)
    }

    //解绑
    fun unRegister(subscriber: Any) {
        EventBus.getDefault().unregister(subscriber)
    }

    //发送事件类
    private fun post(event: MessageEvent) {
        EventBus.getDefault().post(event)
    }

    //发送事件类型
    fun post(type: Int) {
        post(MessageEvent(type))
    }

    //发送事件，携带string
    fun post(type: Int, string: String) {
        val event = MessageEvent(type)
        event.stringValue = string
        post(event)
    }

    //发送事件，携带int
    fun post(type: Int, int: Int) {
        val event = MessageEvent(type)
        event.intValue = int
        post(event)
    }

    //发送事件，携带bool
    fun post(type: Int, bool: Boolean) {
        val event = MessageEvent(type)
        event.boolValue = bool
        post(event)
    }

}