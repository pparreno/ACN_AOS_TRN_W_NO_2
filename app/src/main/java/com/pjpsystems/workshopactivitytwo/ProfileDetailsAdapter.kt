package com.pjpsystems.workshopactivitytwo

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.pjpsystems.workshopactivitytwo.databinding.ItemProfileHeaderBinding
import com.pjpsystems.workshopactivitytwo.databinding.ItemProfileTextSubtextBinding


class ProfileDetailsAdapter(private val profile: Profile) :
    RecyclerView.Adapter<BaseProfileViewHolder>() {

    enum class ViewType(val type: Int) {
        HEADER(0),
        REGULAR(1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseProfileViewHolder {
        return if (viewType == ViewType.HEADER.type) {
            val binding =
                ItemProfileHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            ProfileHeaderViewHolder(binding)
        } else {
            val binding = ItemProfileTextSubtextBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            ProfileViewHolder(binding)
        }

    }

    override fun onBindViewHolder(holder: BaseProfileViewHolder, position: Int) {
        if (position > 0) {
            val regularHolder = holder as ProfileViewHolder
            when (position) {
                1 -> {
                    regularHolder.mainText.text = profile.email
                    regularHolder.subText.text = holder.context.getString(R.string.email)
                }
                2 -> {
                    regularHolder.mainText.text = if (profile.status)  holder.context.getString(R.string.online)
                    else holder.context.getString(R.string.offline)
                    regularHolder.subText.text = holder.context.getString(R.string.status)
                }
                3 -> {
                    regularHolder.mainText.text = profile.age.toString()
                    regularHolder.subText.text = holder.context.getString(R.string.age)
                }
                4 -> {
                    regularHolder.mainText.text = profile.homeCountry
                    regularHolder.subText.text = holder.context.getString(R.string.homecountry)
                }
            }
        }

    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0)
            ViewType.HEADER.type
        else
            ViewType.REGULAR.type
    }

    override fun getItemCount(): Int {
        return 4 + 1
    }
}

abstract class BaseProfileViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root)

class ProfileHeaderViewHolder(binding: ItemProfileHeaderBinding) : BaseProfileViewHolder(binding)

class ProfileViewHolder(binding: ItemProfileTextSubtextBinding) : BaseProfileViewHolder(binding) {
    val mainText: TextView = binding.itemMainText
    val subText: TextView = binding.itemSubText
    val context: Context = binding.root.context
}


data class Profile(
    val first_name: String,
    val last_name: String,
    val email: String,
    val age: Int,
    val status: Boolean,
    val homeCountry: String
)

