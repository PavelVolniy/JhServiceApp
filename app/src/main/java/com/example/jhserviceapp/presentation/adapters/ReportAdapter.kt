package com.example.jhserviceapp.presentation.adapters

import android.annotation.SuppressLint
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.jhserviceapp.databinding.ReportItemBinding
import com.example.jhserviceapp.domain.entity.report.ReportWithArticleAndCount
import com.example.jhserviceapp.presentation.util.FormatDateUtil
import java.util.Locale

class ReportAdapter(
    val onLongClickItem: (item: ReportWithArticleAndCount) -> Unit,
    val onSharedItem: (item: ReportWithArticleAndCount) -> Unit
) :
    ListAdapter<ReportWithArticleAndCount, ReportViewHolder>(DiffUtilCallBackReport()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReportViewHolder {
        return ReportViewHolder(
            ReportItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ReportViewHolder, position: Int) {
        val item = getItem(position)
        with(holder.binding) {
            loaderId.text = "№ ${item.report.numberLoader}"
            date.text = FormatDateUtil.getDateToStringDDMMYY(item.report.date)
            hours.text = "${item.report.hours} h"
            numberReport.text = FormatDateUtil.getDateToStringYYYYMMDD(item.report.date) +
                    "${item.report.userNumber}$position"
            description.text = item.report.description
            shareButton.setOnClickListener {
                Toast.makeText(
                    root.context, "Button in development",
                    Toast.LENGTH_SHORT
                ).show()
            }
            shareButton.setOnClickListener {
                onSharedItem(item)
            }
            item.articles.forEach {
                articleList.append(
                    "${it.articleDTO.articleId}" +
                            " - ${it.articleDTO.articleName} " +
                            ": ${(it.articleCount.articleCountId / 10.0)}\n"
                )
            }
            itemReport.setOnClickListener {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    description.isSingleLine = !description.isSingleLine
                    articleList.isVisible = !articleList.isVisible
                }
                
            }
            itemReport.setOnLongClickListener {
                onLongClickItem(item)
                true
            }
        }
    }
}

class DiffUtilCallBackReport : DiffUtil.ItemCallback<ReportWithArticleAndCount>() {
    override fun areItemsTheSame(
        oldItem: ReportWithArticleAndCount,
        newItem: ReportWithArticleAndCount
    ): Boolean {
        return oldItem.report.id == newItem.report.id
    }

    override fun areContentsTheSame(
        oldItem: ReportWithArticleAndCount,
        newItem: ReportWithArticleAndCount
    ): Boolean {
        return oldItem == newItem
    }
}

class ReportViewHolder(val binding: ReportItemBinding) : RecyclerView.ViewHolder(binding.root) {

}
