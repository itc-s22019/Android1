package jp.ac.std.it_college.s22019.fragumentsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import jp.ac.std.it_college.s22019.fragumentsample.databinding.ActivityMainBinding
import jp.ac.std.it_college.s22019.fragumentsample.databinding.FragmentMenuListBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
    }
}