package com.example.skiplineplayground

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView


class ProductRecycler(private val titles: Array<String>, private val prices: Array<String>, private val imgs: Array<Int?>) :
    RecyclerView.Adapter<ProductRecycler.MyViewHolder>() {

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MyViewHolder {
        // Create a new view, which defines the UI of the list item
        val itemView: CardView = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.product_item, viewGroup, false) as CardView

        return MyViewHolder(itemView)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // Get element from your array at this position and replace the
        // contents of the view with that element

        val itemView: View = holder.getCardView()
//        val name = itemView.findViewById<TextView>(R.id.title)
//        name?.text = titles[position]
//        val price = itemView.findViewById<TextView>(R.id.price)
//        price?.text = prices[position]
//        val img = itemView.findViewById<ImageView>(R.id.product)
//        img?.setImageResource(imgs[position]!!)

        itemView.setOnClickListener(View.OnClickListener() {
        })
    }

    // Return the size of your array (invoked by the layout manager)
    override fun getItemCount() = 4


    class MyViewHolder(private val itemView: CardView) : RecyclerView.ViewHolder(itemView) {

        fun getCardView(): View {
            return itemView
        }

    }


}