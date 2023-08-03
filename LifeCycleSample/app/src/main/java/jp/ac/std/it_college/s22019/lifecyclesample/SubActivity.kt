package jp.ac.std.it_college.s22019.lifecyclesample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import jp.ac.std.it_college.s22019.lifecyclesample.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySubBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("LifeCycleSample", "Sub onCreate() called.")
        super.onCreate(savedInstanceState)
        binding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btPrevious.setOnClickListener(::onPreviousClick)
    }

    override fun onStart() {
        Log.i("LifeCycleSample", "Main onStart() called.")
        super.onStart()
    }

    override fun onRestart() {
        Log.i("LifeCycleSample", "Main onRestart() called.")
        super.onRestart()
    }

    override fun onResume() {
        Log.i("LifeCycleSample", "Main onResume() called.")
        super.onResume()
    }

    override fun onPause() {
        Log.i("LifeCycleSample", "Main onPause() called.")
        super.onPause()
    }

    override fun onStop() {
        Log.i("LifeCycleSample", "Main onStop() called.")
        super.onStop()
    }

    override fun onDestroy() {
        Log.i("LifeCycleSample", "Main onDestroy() called.")
        super.onDestroy()
    }

    private fun onPreviousClick(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}