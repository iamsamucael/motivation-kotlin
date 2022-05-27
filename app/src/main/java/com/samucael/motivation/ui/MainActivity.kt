package com.samucael.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.samucael.motivation.infra.MotivationConstants
import com.samucael.motivation.R
import com.samucael.motivation.data.Mock
import com.samucael.motivation.infra.SecurityPreferences
import com.samucael.motivation.databinding.ActivityMainBinding
import java.util.*

open class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var categoryId = MotivationConstants.FILTER.INCLUSIVE
    var mock = Mock()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Esconder a barra de navegação
        supportActionBar?.hide()

        binding.buttonNewPhrase.setOnClickListener(this)
        binding.imageInclusive.setOnClickListener(this)
        binding.imageSmile.setOnClickListener(this)
        binding.imageSunny.setOnClickListener(this)

        handleUserName()
        handleFilter(R.id.image_inclusive)
        handleNextPhrase()

    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_new_phrase) {
            handleNextPhrase()
        } else if (view.id in listOf(R.id.image_inclusive, R.id.image_smile, R.id.image_sunny)) {
            handleFilter(view.id)
        }
    }

    private fun handleNextPhrase() {
        binding.textPhrase.text = Mock().getPhrase(categoryId, Locale.getDefault().language)
    }

    private fun handleFilter(id: Int) {

        binding.imageInclusive.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageSmile.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))

        when (id) {
            R.id.image_inclusive -> {
                binding.imageInclusive.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.INCLUSIVE
            }
            R.id.image_smile -> {
                binding.imageSmile.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.SMILE
            }
            R.id.image_sunny -> {
                binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.SUNNY
            }
        }
    }

    private fun handleUserName() {
        val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
        binding.textUserName.text = "Olá, $name!"
    }

}