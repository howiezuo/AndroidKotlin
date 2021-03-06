package io.github.howiezuo.androidkotlin.ui

import android.os.Bundle
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import io.github.howiezuo.androidkotlin.R
import org.jetbrains.anko.find

class MainActivity : BaseActivity() {

    override val layoutResID: Int
        get() = R.layout.activity_main

    private val toolbar: Toolbar by lazy {
        find<Toolbar>(R.id.toolbar)
    }

    private val drawerLayout: DrawerLayout by lazy {
        find<DrawerLayout>(R.id.drawer_layout)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        drawerLayout.addDrawerListener(ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navdrawer_open, R.string.navdrawer_close))

        //        val fab = findViewById(R.id.fab) as FloatingActionButton
        //        fab.setOnClickListener { view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show() }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
