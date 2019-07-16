package com.alserdar.slinker.the_room.interface_listener

import com.alserdar.slinker.the_room.recycle_model.ItemGroup


interface IFirebaseLoadListener {

    fun onFirebaseLoadSuccess(itemGroupList: List<ItemGroup>)

    fun onFirebaseLoadFailed(message:String)


}