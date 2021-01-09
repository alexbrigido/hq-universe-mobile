package br.com.alexbrigido.hquniverse.view.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.alexbrigido.hquniverse.R
import br.com.alexbrigido.hquniverse.domain.home.BookHome
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.home_book_card.view.*

class HomeBookAdapter(private val homeBooks: List<BookHome>) : RecyclerView.Adapter<HomeBookAdapter.HomeBookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeBookViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.home_book_card,
            parent, false)
        return  HomeBookViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HomeBookViewHolder, position: Int) {
        val currentItem = homeBooks[position]
        Picasso.get().load(currentItem.image).into(holder.imageView)
//        holder.imageView.setImageURI(Uri.parse(currentItem.image))
        holder.textView1.text = currentItem.title
        holder.textView2.text = currentItem.subtitle
    }

    override fun getItemCount() = homeBooks.size

    class HomeBookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.ivHomeCard
        val textView1: TextView = itemView.tvTitleHomeBook
        val textView2: TextView = itemView.tvSubtitleHomeBook
    }

}