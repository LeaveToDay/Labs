package com.staynight.lab1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.staynight.lab1.databinding.BottomSheetResultBinding

class ResultBottomSheet(
    private val price: Double,
    private val tip: Int,
    private val personCount: Int
) : BottomSheetDialogFragment() {
    private var binding: BottomSheetResultBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (dialog as BottomSheetDialog).behavior.skipCollapsed = true
        (dialog as BottomSheetDialog).behavior.state = BottomSheetBehavior.STATE_EXPANDED

        binding = BottomSheetResultBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViews()
    }

    private fun bindViews() {
        binding?.apply {
            tvPaying.text =
                ((price + ((price / 100) * tip)) / personCount.toDouble()).toString()
            tvSplit.text = String.format(
                getString(R.string.split_template),
                personCount.toString(),
                tip.toString()
            )
            btnRecalculate.setOnClickListener {
                dismiss()
            }
        }
    }
}