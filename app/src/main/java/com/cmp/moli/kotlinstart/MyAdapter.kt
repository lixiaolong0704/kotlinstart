package com.cmp.moli.kotlinstart

import android.content.Context
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.TextView
import android.view.ViewGroup
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.view.LayoutInflater





class MyAdapter : BaseAdapter() {
    override fun getCount(): Int {
        return this.tableHeaders.count() * (this.tableValues.count() + 1)
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getItem(position: Int): Any {
        return if (position < this.tableHeaders.count()) {
            this.tableHeaders[position]
        } else {
            val row = (position - this.tableHeaders.count()) / this.tableHeaders.count()
            val line = position % this.tableHeaders.count()
            this.tableValues[row][line]
        }

    fun getView(position: Int, convertView: View?, container: ViewGroup): View {


        var inflater   = LayoutInflater.from(container.context),



        var convertView = convertView
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item, container, false)
        }


        (convertView.findViewById(android.R.id.message) as TextView).setText(getItem(position))
        return convertView
    }


}
