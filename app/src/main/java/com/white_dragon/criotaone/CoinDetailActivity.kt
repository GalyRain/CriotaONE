package com.white_dragon.criotaone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.white_dragon.criotaone.databinding.ActivityCoinDetailBinding
import com.white_dragon.criotaone.databinding.ActivityCoinPriceListBinding

class CoinDetailActivity : AppCompatActivity() {
    private lateinit var viewModel: CoinViewModel
    lateinit var binding: ActivityCoinDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_detail)

        binding = ActivityCoinDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (!intent.hasExtra(EXTRA_FROM_SYMBOL)) {
            finish()
            return
        }
        val fromSymbols = intent.getStringExtra(EXTRA_FROM_SYMBOL)

        viewModel = ViewModelProviders.of(this)[CoinViewModel::class.java]
        viewModel.getDetailInfo(fromSymbols!!).observe(this, Observer {

        })
    }

    companion object {
        const val EXTRA_FROM_SYMBOL = "fSym"
    }
}