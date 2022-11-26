package com.pjpsystems.workshopactivitytwo

import android.graphics.Color
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.pjpsystems.workshopactivitytwo.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    lateinit var binding: ActivityProfileBinding
    lateinit var profile : Profile

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

       profile = Profile(email = "parreno@google.com",
            age = 32,
            homeCountry = "Philippines",
            status = true,
            first_name = "Paul John",
            last_name = "Parreno")

        configureUserProfileNameViews()
        configureStatusIndicator()

        configureRecyclerView()
    }

    private fun configureStatusIndicator() {
        if(profile.status)
        {
            binding.statusIndicator.setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY)
        } else {
            binding.statusIndicator.setColorFilter(Color.DKGRAY, PorterDuff.Mode.MULTIPLY)
        }
    }

    private fun configureUserProfileNameViews() {
        val fullName = String.format("%s %s", profile.first_name, profile.last_name)
        binding.toolbar.title = fullName
        binding.profileText.text = fullName
    }

    private fun configureRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = ProfileDetailsAdapter(profile)
    }
}