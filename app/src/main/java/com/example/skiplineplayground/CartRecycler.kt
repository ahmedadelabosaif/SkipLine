package com.example.skiplineplayground

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class CartRecycler(private val titles: Array<String>, private val icons: Array<Int?>) :
    RecyclerView.Adapter<CartRecycler.MyViewHolder>() {

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): CartRecycler.MyViewHolder {
        // Create a new view, which defines the UI of the list item
        val itemView: CardView = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cart_item, viewGroup, false) as CardView

        return MyViewHolder(itemView)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // Get element from your array at this position and replace the
        // contents of the view with that element

        val itemView: View = holder.getCardView()
//        val textView = itemView.findViewById<TextView>(R.id.name)
//        textView?.text = titles[position]
//        val imageView = itemView.findViewById<ImageView>(R.id.item_img)
//        imageView?.setImageResource(icons[position]!!)
    }



    // Return the size of your array (invoked by the layout manager)
    override fun getItemCount() = 1


    class MyViewHolder(private val itemView: CardView) : RecyclerView.ViewHolder(itemView) {

        fun getCardView(): View {
            return itemView
        }

    }

}
