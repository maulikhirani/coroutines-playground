package maulik.coroutinesplayground.utils

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load

@BindingAdapter("imageUrl")
fun setImageFromUrl(imageView: ImageView, url: String?) {
    imageView.load(url) {
        crossfade(true)
    }
}

@BindingAdapter("showIf")
fun showIf(view: View, condition: Boolean) {
    if (condition) view.show() else view.hide()
}