package com.alserdar.slinker.the_room

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alserdar.slinker.R
import com.alserdar.slinker.the_room.recycle_model.ItemGroup


class MyGroupAdapter (private var context: Context,
                      private var dataList:List<ItemGroup>?): RecyclerView.Adapter<MyGroupAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.layout_rec_group,  parent , false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {

        return dataList?.size ?:0

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {


        holder.itemTitle.text = dataList!![position].headerTitle

        val items = dataList!![position].listItem

        val listIteAdapter = MyItemAdapter(context , items)

        holder.rec_view_list.setHasFixedSize(true)
        holder.rec_view_list.layoutManager = LinearLayoutManager(context , LinearLayoutManager.HORIZONTAL , false)
        holder.rec_view_list.adapter = listIteAdapter

        holder.rec_view_list.isNestedScrollingEnabled = false

        holder.btnMore.setOnClickListener{

            Toast.makeText(context , "" + dataList!![position].headerTitle , Toast.LENGTH_SHORT).show()
        }

    }


    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {

        var itemTitle: TextView
        var rec_view_list: RecyclerView
        var btnMore: Button

        init {

            itemTitle = view.findViewById(R.id.itemTitle) as TextView
            rec_view_list = view.findViewById(R.id.my_recycle_view_list) as RecyclerView
            btnMore = view.findViewById(R.id.buttonMore) as Button


        }


    }
}