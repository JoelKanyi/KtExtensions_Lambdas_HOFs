package com.kanyideveloper.ktextensions_lambdas_hof

import android.app.NotificationManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        click.setOnClickListener {
            this.toast("This is Button One")
        }

        click2.setOnClickListener {
            this.toast("This is Button 2",Toast.LENGTH_SHORT)
        }

        click3.setOnClickListener {
            this.notify(0,""){
                setContentText("This is my notification")
                setSmallIcon(R.drawable.ic_launcher_background)
            }

        }

    }

    //Extension function to reuse the Toast
    private fun Context.toast(message: String, duration: Int = Toast.LENGTH_LONG){
        Toast.makeText(this, message, duration).show()
    }

    // Kt Extensions & Lambda with receiver
    fun Context.notify(id: Int, channelId: String, body : NotificationCompat.Builder.() -> Unit){
        val builder = NotificationCompat.Builder(this,channelId)
        builder.body()

        val notification = builder.build()

        val notificationManager = ContextCompat.getSystemService(this, NotificationManager::class.java)
        notificationManager?.notify(id, notification)
    }

}