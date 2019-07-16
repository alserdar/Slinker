package com.alserdar.slinker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.alserdar.slinker.databinding.ActivityHomeBinding
import com.alserdar.slinker.the_room.MyGroupAdapter
import com.alserdar.slinker.the_room.interface_listener.IFirebaseLoadListener
import com.alserdar.slinker.the_room.recycle_model.ItemData
import com.alserdar.slinker.the_room.recycle_model.ItemGroup
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() , IFirebaseLoadListener {


    private lateinit var binding: ActivityHomeBinding

    override fun onFirebaseLoadSuccess(itemGroupList: List<ItemGroup>) {

        val adapter = MyGroupAdapter(this , itemGroupList)
        my_recycle_view.adapter = adapter
    }

    override fun onFirebaseLoadFailed(message: String) {

        Toast.makeText(this , message , Toast.LENGTH_SHORT).show()
    }

    lateinit var iFirebaseLoadListener: IFirebaseLoadListener

    lateinit var myData : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  setContentView(R.layout.activity_home)

        binding = DataBindingUtil.setContentView(this , R.layout.activity_home)

        myData = FirebaseDatabase.getInstance().getReference("MyData")

        iFirebaseLoadListener = this


        my_recycle_view.setHasFixedSize(true)
        my_recycle_view.layoutManager = LinearLayoutManager(this)

        getFireBaseData()

    }

    private fun getFireBaseData() {

        myData.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

                iFirebaseLoadListener.onFirebaseLoadFailed(p0.message)

            }

            override fun onDataChange(p0: DataSnapshot) {

                val itemGroups = ArrayList<ItemGroup>()

                for(myDataSnapshot in p0.children)
                {
                    val itemGroup = ItemGroup()
                    itemGroup.headerTitle = myDataSnapshot.child("headerTitle").
                        getValue(true).toString()

                    val t = object: GenericTypeIndicator<ArrayList<ItemData>>(){}

                    itemGroup.listItem = myDataSnapshot.child("listItem").getValue(t)

                    itemGroups.add(itemGroup)
                }

                iFirebaseLoadListener.onFirebaseLoadSuccess(itemGroups)
            }

        })
    }
}
