package com.example.viewpagersample

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.PopupWindow
import com.example.viewpagersample.databinding.LayoutPopupMenuBinding

enum class EnterFrom {
    FIRST_FRAGMENT,
    SECOND_FRAGMENT
}

class PopupMenu(context: Context, private val mode: Int, onItemClicked: ((Int) -> Unit)? = null) :
    PopupWindow(context) {
    private var binding = LayoutPopupMenuBinding.inflate(LayoutInflater.from(context))

    init {
        contentView = binding.root
        setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        width = context.resources.getDimensionPixelSize(R.dimen.popup_menu_width)
        height = WRAP_CONTENT
        isOutsideTouchable = true

        when (mode) {
            EnterFrom.FIRST_FRAGMENT.ordinal -> {
                binding.textAdd.visibility = View.GONE
                binding.textRemove.visibility = View.GONE
            }

            else -> {
                binding.textBuy.visibility = View.GONE
                binding.textSell.visibility = View.GONE
            }
        }

        binding.textAdd.setOnClickListener {
            onItemClicked?.invoke(0)
            dismiss()
        }
        binding.textRemove.setOnClickListener {
            onItemClicked?.invoke(1)
            dismiss()
        }
        binding.textBuy.setOnClickListener {
            onItemClicked?.invoke(2)
            dismiss()
        }
        binding.textSell.setOnClickListener {
            onItemClicked?.invoke(3)
            dismiss()
        }
    }

    fun showPopup(anchorView: View) {
        if (!isShowing) {
            showAsDropDown(anchorView)
        }
    }
}