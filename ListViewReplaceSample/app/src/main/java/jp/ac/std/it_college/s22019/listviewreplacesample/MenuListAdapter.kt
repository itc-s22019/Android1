package jp.ac.std.it_college.s22019.listviewreplacesample

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import jp.ac.std.it_college.s22019.listviewreplacesample.databinding.MenuRowBinding

class MenuListAdapter(
    private val data: List<String>
) : RecyclerView.Adapter<MenuListAdapter.ViewHolder>() {

    class ViewHolder(val binding: MenuRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // LayoutInflater は直接生成できないので、アプリ情報を親Viewから取ってきて
        // 取ってきたcontextをもとに探してきて LayoutInflater　を渡してもらう。
        val inflater = LayoutInflater.from(parent.context)

        // LayoutInflater　のインスタンスがあれば、Bindingクラスをinflateできるようになる
        val binding = MenuRowBinding.inflate(inflater, parent, false)

        // inflateしたBindingクラスのインスタンスを使って MenuListAdapter.ViewHolderを作って返す。
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // ViewHolderのbindingを経由して、表示に関する処理をする。
        holder.binding.tvMenu.text = data[position]

        // アイテムのクリックイベントを設定（ラムダ式）
        holder.binding.root.setOnClickListener {
            // 直接Resource のインスタンスは取れないので、パラメータのView[it]を経由して
            // 関節的に参照する。
            // getStringメソッドで、文字列内の置き換えマーカー（書式設定文字列）に値を埋め込める。
            val msg = it.context.resources.getString(R.string.toast_msg, data[position])

            // トースト
                Toast.makeText(it.context, msg, Toast.LENGTH_LONG).show()
        }
    }
}