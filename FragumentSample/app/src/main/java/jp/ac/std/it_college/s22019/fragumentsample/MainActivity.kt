package jp.ac.std.it_college.s22019.fragumentsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import jp.ac.std.it_college.s22019.fragumentsample.databinding.ActivityMainBinding
import jp.ac.std.it_college.s22019.fragumentsample.databinding.FragmentMenuListBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // イベント識別名、LifecycleOwner,イベントリスナを渡して待ち受ける
        supportFragmentManager
            .setFragmentResultListener(REQUEST_SELECTED_MENU, this, ::onSelectedMenu)
    }

    private fun onSelectedMenu(requestKey: String, bundle: Bundle) {
        Log.i("SELECTED_MENU", "requestKey: ${requestKey}, bundle: ${bundle}.")
        // MenuListFragment から受け取ったデータを詰め直して
        // MenuThanksFragmentを表示させる。
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            addToBackStack("Only List")
            replace(R.id.fragmentMainContainer, MenuThanksFragment::class.java,
                bundleOf(
                    ARG_NAME to bundle.getString(RESULT_NAME, ""),
                    ARG_PRICE to bundle.getInt(RESULT_PRICE, 0)
                )
            )
        }
    }
}