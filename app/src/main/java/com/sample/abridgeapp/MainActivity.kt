package com.sample.abridgeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.sample.abridgeapp.ui.IssueListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            val fragmentManager = supportFragmentManager.beginTransaction()
            fragmentManager.replace(R.id.fragmentHolder, IssueListFragment.create()).commit()
        }
    }
}
