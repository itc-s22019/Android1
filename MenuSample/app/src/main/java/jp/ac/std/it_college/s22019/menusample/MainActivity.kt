package jp.ac.std.it_college.s22019.menusample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import jp.ac.std.it_college.s22019.menusample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val menuList = mutableListOf<jp.ac.std.it_college.s22019.menusample.Menu>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ToolbarをActionbarとして使う
        setSupportActionBar(binding.toolbar)

        initList(binding.lvMenu)
    }

    private fun initList(view: RecyclerView) {
        menuList.addAll(teishokuList)
        view.adapter = MenuListAdapter(menuList, ::order)
        val layoutManager = LinearLayoutManager(this)
        view.layoutManager = layoutManager
        view.addItemDecoration(DividerItemDecoration(this, layoutManager.orientation))
        // コンテキストメニューを有効化する
        registerForContextMenu(view)
    }

    private fun order(name: String, price: Int) {
        startActivity(Intent(this, MenuThanksActivity::class.java).apply {
            putExtra("menuName", name)
            putExtra("menuPrice", price)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_options_menu_list, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val result = when (item.itemId) {
            R.id.menuListOptionsTeishoku -> resetMenu(teishokuList)

            R.id.menuListOptionsCurry -> resetMenu(curryList)

            else -> super.onOptionsItemSelected(item)
        }
        return result
    }

    private fun resetMenu(list: List<jp.ac.std.it_college.s22019.menusample.Menu>): Boolean {
        menuList.clear()
        menuList.addAll(list)
        binding.lvMenu.adapter?.notifyDataSetChanged()
        return true
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        // 親クラスの処理
        super.onCreateContextMenu(menu, v, menuInfo)

        // コンテキストメニューを作る
        menuInflater.inflate(R.menu.menu_context_menu_list, menu)
        // コンテキストメニューのヘッダータイトルを設定
        menu?.setHeaderTitle(R.string.menu_list_context_header)
    }
}