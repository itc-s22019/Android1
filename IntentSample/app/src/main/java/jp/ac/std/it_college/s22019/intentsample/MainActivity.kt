package jp.ac.std.it_college.s22019.intentsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import jp.ac.std.it_college.s22019.intentsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lvMenu.apply {
            // アダプターをセット
            adapter = MenuListAdapter(menuList)

            // RecyclerView の表示方法を直接的にする
            LinearLayoutManager(this@MainActivity).let {
                // 直線的に並べる
                layoutManager = it
                // 区切り線を並べる方向に合わせて表示する
                addItemDecoration(DividerItemDecoration(this@MainActivity, it.orientation))
            }
        }
    }
}