package com.example.listify.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.listify.R
import com.example.listify.data.db.model.ShoppingItem
import com.example.listify.ui.shoppingList.ShoppingItemsViewModel

class ShoppingItemAdapter(
    var items: List<ShoppingItem>,
    private val viewModel: ShoppingItemsViewModel
) : RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.shopping_item, parent, false
        )
        return ShoppingViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ShoppingViewHolder,
        position: Int
    ) {
        val currentShoppingItem = items[position]
        holder.itemView.findViewById<TextView>(R.id.tv_item_name).text = currentShoppingItem.name
        holder.itemView.findViewById<TextView>(R.id.tv_item_amount).text =
            "${currentShoppingItem.amount}"

        holder.itemView.findViewById<ImageView>(R.id.iv_delete).setOnClickListener {
            viewModel.delete(currentShoppingItem)
        }

        holder.itemView.findViewById<ImageView>(R.id.iv_item_increase).setOnClickListener {
            currentShoppingItem.amount++
            viewModel.upsert(currentShoppingItem)
        }

        holder.itemView.findViewById<ImageView>(R.id.iv_item_decrease).setOnClickListener {
            if (currentShoppingItem.amount > 0) {
                currentShoppingItem.amount--
                viewModel.upsert(currentShoppingItem)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ShoppingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}