package maulik.coroutinesplayground.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load

@BindingAdapter("imageUrl")
fun setImageFromUrl(imageView: ImageView, url: String?) {
    imageView.load(url) {
        crossfade(true)
    }
}