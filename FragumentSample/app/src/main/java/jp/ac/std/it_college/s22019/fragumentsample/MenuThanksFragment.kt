package jp.ac.std.it_college.s22019.fragumentsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import jp.ac.std.it_college.s22019.fragumentsample.databinding.FragmentMenuThanksBinding

internal const val ARG_NAME = "menuName"
internal const val ARG_PRICE = "menuPrice"

/** Fragment Result API を通じて　Activity へデータを返すためのイベント名　*/
internal const val REQUEST_BACK_MENU = "backMenu"

/**
 * 注文完了を表示するためのフラグメント
 */
class MenuThanksFragment : Fragment() {
    // Bindingクラスのインスタンスを入れておくプロパティ(Nullable)
    private var _binding: FragmentMenuThanksBinding? = null

    // Bindingをnon-null型としてシンプルに使うための工夫
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenuThanksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menuName = arguments?.getString(ARG_NAME) ?: ""
        val menuPrice = arguments?.getInt(ARG_PRICE) ?: 0


        // ビューにパラメータをリセットする。
        binding.tvMenuName.text = menuName
        binding.tvMenuPrice.text = "%,d".format(menuPrice)

        // ボタンのイベントリスナを設定
        binding.btThxBack.setOnClickListener(::onBackButtonClick)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /**
     * 戻るボタンが押されたときの処理。フラグメントの履歴を遡る処理。
     */
    private fun onBackButtonClick(v: View) {
        parentFragmentManager.setFragmentResult(REQUEST_BACK_MENU, bundleOf())
    }

}