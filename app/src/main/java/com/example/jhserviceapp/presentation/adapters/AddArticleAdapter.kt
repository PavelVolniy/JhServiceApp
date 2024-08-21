package com.example.jhserviceapp.presentation.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.jhserviceapp.databinding.ArticleItemBinding
import com.example.jhserviceapp.domain.entity.article.ArticleWithCount
import javax.inject.Inject

class AddArticleAdapter (
    val onClickDeleteArticle: (item: ArticleWithCount) -> Unit
) :
    ListAdapter<ArticleWithCount, ArticleRowViewHolder>(DiffUtilCallBackArticle()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleRowViewHolder {
        return ArticleRowViewHolder(
            ArticleItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ArticleRowViewHolder, position: Int) {
        val item = getItem(position)
        with(holder.binding) {
            if (item.articleDTO.articleId != 0L) {
                articleNumber.setText(item.articleDTO.articleId.toString())
            } else {
                articleNumber.setText("")
                articleNumber.hint = "00000000"
            }
            articleName.setText(item.articleDTO.articleName)
            if (item.articleCount.articleCountId != 0) {
                articleCount.setText(item.articleCount.articleCountId.toString())
            } else {
                articleCount.setText("")
                articleCount.hint = item.articleCount.articleCountId.toString()
            }
            if (item.articleCount.engineerNumber != 0) {
                engineerNumber.setText(item.articleCount.engineerNumber.toString())
            } else {
                engineerNumber.setText("")
            }
            isPaid.isChecked = item.articleCount.isPaid
            articleNumber.addTextChangedListener {
                try {
                    item.articleDTO.articleId = if (articleNumber.text.isEmpty()) 0
                    else articleNumber.text.toString().toLong()
                } catch (e: Exception) {
                    Log.e("Number error", e.message.toString())
                }
            }
            articleName.addTextChangedListener {
                item.articleDTO.articleName = articleName.text.toString()
            }
            articleCount.addTextChangedListener {
                try {
                    item.articleCount.articleCountId = if (articleCount.text.toString().isEmpty()
                    ) 0
                    else {
                        (articleCount.text.toString().toDouble() * 10.0).toInt()
                    }
                } catch (e: Exception) {
                    Log.e("Count error", e.message.toString())
                }
            }

            deleteArticleRowButton.setOnClickListener {
                onClickDeleteArticle(item)
            }
        }

    }
}

class DiffUtilCallBackArticle : DiffUtil.ItemCallback<ArticleWithCount>() {
    override fun areItemsTheSame(oldItem: ArticleWithCount, newItem: ArticleWithCount): Boolean {
        return oldItem.articleDTO.articleId == newItem.articleDTO.articleId
    }

    override fun areContentsTheSame(oldItem: ArticleWithCount, newItem: ArticleWithCount): Boolean {
        return oldItem == newItem
    }
}

class ArticleRowViewHolder(val binding: ArticleItemBinding) : RecyclerView.ViewHolder(binding.root)