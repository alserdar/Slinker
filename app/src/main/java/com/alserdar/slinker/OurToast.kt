package com.alserdar.slinker

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast

class OurToast {


         fun myToast(context: Context?, msg: String) {

            val toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT)
            val toastView = toast.view //This'll return the default View of the Toast.

            /* And now you can get the TextView of the default View of the Toast. */
            val toastMessage = toastView.findViewById<TextView>(android.R.id.message)
            toastMessage.setTextColor(Color.WHITE)
            toastMessage.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.ic_launcher, 0, 0, 0)
            toastMessage.gravity = Gravity.CENTER or Gravity.CENTER_HORIZONTAL
            toastMessage.compoundDrawablePadding = 15
            toastView.setBackgroundColor(Color.WHITE)
            toastView.setBackgroundResource(R.drawable.abc_ab_share_pack_mtrl_alpha)
            toast.show()

        }

        fun myToastPic(context: Context, msg: String, icon: Int) {

            val toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT)
            val toastView = toast.view //This'll return the default View of the Toast.

            /* And now you can get the TextView of the default View of the Toast. */
            val toastMessage = toastView.findViewById<TextView>(android.R.id.message)
            toastMessage.setTextColor(Color.WHITE)
            toastMessage.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.ic_launcher, 0, 0, 0)
            toastMessage.setCompoundDrawablesWithIntrinsicBounds(0, 0, icon, 0)
            toastMessage.gravity = Gravity.CENTER or Gravity.CENTER_HORIZONTAL
            toastMessage.compoundDrawablePadding = 15
            toastView.setBackgroundColor(Color.WHITE)
            toastView.setBackgroundResource(R.drawable.abc_ab_share_pack_mtrl_alpha)
            toast.show()

        }
}