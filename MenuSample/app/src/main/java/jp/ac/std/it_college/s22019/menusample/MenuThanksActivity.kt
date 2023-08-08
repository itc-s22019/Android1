package jp.ac.std.it_college.s22019.menusample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import jp.ac.std.it_college.s22019.menusample.databinding.ActivityMenuThanksBinding

class MenuThanksActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuThanksBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuThanksBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 前の画面から渡ってくるであろうデータを取り出す
        val menuName = intent.getStringExtra("menuName") ?: ""
        val menuPrice = intent.getIntExtra("menuPrice", 0)

        // データをセット
        binding.tvMenuName.text = menuName
        binding.tvMenuPrice.text = "%,d".format(menuPrice)

        // リストに戻るボタンのイベント設定
        binding.btThxBack.setOnClickListener {
            finish()
        }

    }
}