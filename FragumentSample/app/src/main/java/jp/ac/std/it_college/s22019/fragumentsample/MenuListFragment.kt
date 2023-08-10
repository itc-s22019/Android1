package jp.ac.std.it_college.s22019.fragumentsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import jp.ac.std.it_college.s22019.fragumentsample.databinding.FragmentMenuListBinding

/**
 * メニュー一覧を表示するためのフラグメント
 */
class MenuListFragment : Fragment() {
    // Bindingクラスのインスタンスを入れておくプロパティ(Nullable)
    private var _binding: FragmentMenuListBinding? = null

    // Activityの時と同じようにbindingを使うための工夫
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenuListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}