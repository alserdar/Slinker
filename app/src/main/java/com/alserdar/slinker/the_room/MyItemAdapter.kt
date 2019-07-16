package com.alserdar.slinker.the_room

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.alserdar.slinker.R
import com.alserdar.slinker.the_room.interface_listener.IItemClickListener
import com.alserdar.slinker.the_room.recycle_model.ItemData
import com.squareup.picasso.Picasso


class MyItemAdapter(private val context: Context,
                    private val itemList : List<ItemData>?): RecyclerView.Adapter<MyItemAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.layout_item,  parent , false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {

        return itemList?.size?:0
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.text_title.text = itemList!![position].name!!

        Picasso.get().load(itemList[position].image).into(holder.image_item)


        holder.setClick(object :IItemClickListener{
            override fun onItemClickListener(view: View, position: Int) {

                Toast.makeText(context , ""+itemList[position].name , Toast.LENGTH_SHORT).show()
            }

        })
    }


    inner class MyViewHolder (view: View): RecyclerView.ViewHolder(view) , View.OnClickListener {

        var text_title: TextView
        var image_item: ImageView


        lateinit var iItemClickListener: IItemClickListener


        fun setClick(iItemClickListener: IItemClickListener)
        {
            this.iItemClickListener = iItemClickListener
        }

        init {
            text_title = view.findViewById(R.id.tvTitle) as TextView
            image_item = view.findViewById(R.id.itemImage) as ImageView


            view.setOnClickListener(this)
        }


        override fun onClick(view: View?) {

            iItemClickListener.onItemClickListener(view!! , adapterPosition)
        }
    }
}