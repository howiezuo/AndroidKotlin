package io.github.howiezuo.androidkotlin.ui

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import io.github.howiezuo.androidkotlin.R
import org.jetbrains.anko.find
import org.jetbrains.anko.support.v4.find
import org.jetbrains.anko.textResource

class NavdrawerFragment: BaseFragment() {

    val recyclerView: RecyclerView by lazy {
        find<RecyclerView>(R.id.recycler_view)
    }
    val adapter = NavdrawerAdapter()

    enum class Items(val index: Int) {
        DUMMY(0) {
            override fun getTitle() = R.string.dummy
        };

        abstract fun getTitle(): Int

        companion object {
            fun findItem(index: Int): Items? {
                for (item in values()) {
                    if (item.index == index) {
                        return item
                    }
                }
                return null
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_navdrawer, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.adapter = adapter
    }

    class NavdrawerAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun getItemCount(): Int {
            return Items.values().size
        }

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder? {
            val view = LayoutInflater.from(parent!!.context).inflate(R.layout.list_item_navdrawer, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
            val vh = holder as ViewHolder
            vh.bindView(Items.findItem(position))
        }

        class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

            private val text = itemView.find<TextView>(R.id.text)

            fun bindView(item: Items?) {
                if (item != null) {
                    text.textResource = item.getTitle()
                }
            }
        }
    }
}