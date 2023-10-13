package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var dice: Dice = Dice(6);
    lateinit var button: Button;
    lateinit var image: ImageView;
    lateinit var text: TextView;
    var rolledValue: Int = 1;

    fun init() {
        button = findViewById(R.id.button);
        image = findViewById(R.id.image);
        text = findViewById(R.id.text);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init();

        button.setOnClickListener(View.OnClickListener {
            if (image.visibility == View.GONE) {
                image.visibility = View.VISIBLE;
            }

            rolledValue = dice.Roll();

            text.setText("you got $rolledValue point");
            when (rolledValue) {
                1 -> image.setImageResource(R.drawable.dice_1);

                2 -> image.setImageResource(R.drawable.dice_2);

                3 -> image.setImageResource(R.drawable.dice_3);

                4 -> image.setImageResource(R.drawable.dice_4);

                5 -> image.setImageResource(R.drawable.dice_5);

                6 -> image.setImageResource(R.drawable.dice_6);
            }
        });
    }

    class Dice(private val maxRange: Int) {
        fun Roll(): Int {
            return (1..maxRange).random();
        }
    }
}