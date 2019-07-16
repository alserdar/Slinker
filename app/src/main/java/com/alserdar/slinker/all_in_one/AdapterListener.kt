package com.alserdar.slinker.all_in_one

import com.alserdar.slinker.viewModels.PostsViewModel
import com.firebase.ui.database.FirebaseListAdapter

interface AdapterListener {

    fun listenToAdapter(fireBaseListAdapter : FirebaseListAdapter<PostsViewModel>)
}