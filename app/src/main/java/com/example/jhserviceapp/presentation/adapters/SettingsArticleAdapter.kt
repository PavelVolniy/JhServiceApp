package com.example.jhserviceapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.jhserviceapp.databinding.ArticleFieldBinding
import com.example.jhserviceapp.domain.entity.article.ArticleDTO

class SettingsArticleAdapter(
    val onClickDelete: (article: ArticleDTO) -> Unit
) : ListAdapter<ArticleDTO, SettingsViewHolder>(DiffUtilCallBackArticleDTO()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SettingsViewHolder {
        return SettingsViewHolder(
            ArticleFieldBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SettingsViewHolder, position: Int) {
        val item = getItem(position)
        with(holder.binding) {
            articleNumber.text = item.articleId.toString()
            articleName.text = item.articleName
            deleteDefaultArticle.setOnClickListener {
                onClickDelete(item)
            }
        }
    }
}


class DiffUtilCallBackArticleDTO : DiffUtil.ItemCallback<ArticleDTO>() {
    override fun areItemsTheSame(oldItem: ArticleDTO, newItem: ArticleDTO): Boolean {
        return oldItem.articleId == newItem.articleId
    }

    override fun areContentsTheSame(oldItem: ArticleDTO, newItem: ArticleDTO): Boolean {
        return oldItem == newItem
    }
}

class SettingsViewHolder(val binding: ArticleFieldBinding) :
    RecyclerView.ViewHolder(binding.root)
