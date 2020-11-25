package com.kanyideveloper.ktextensions_lambdas_hof

import android.app.NotificationManager
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat


fun Int.isOdd()  = this % 2 ==0
fun Int.isEven() = !isOdd()


fun test(x: Int){
   val isOdd = x.isOdd()
    val isEven = x.isEven()
}

fun test2(context: Context){
    context.toast("hi kt extensions",Toast.LENGTH_LONG)

}

fun Context.toast(message: String,duration: Int = Toast.LENGTH_SHORT){
    Toast.makeText(this,message,duration).show()
}

fun test3(viewGroup: ViewGroup,@LayoutRes layoutRes: Int){

    val view = LayoutInflater.from(viewGroup.context)
        .inflate(layoutRes, viewGroup,true)

    val view2 = viewGroup.inflate(layoutRes, false)
}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = true) : View{
    return LayoutInflater.from(context)
        .inflate(layoutRes, this,attachToRoot)
}

fun test4(context: Context, id: Int, channelId: String){

    context.notify(0,""){
       setContentText("This is my notification")
        color = ResourcesCompat.getColor(context.resources, R.color.black,null)
        setSmallIcon(R.drawable.ic_launcher_background)
    }

}


// Kt Extensions & Lambda with receiver
fun Context.notify(id: Int, channelId: String, body : NotificationCompat.Builder.() -> Unit){
    val builder = NotificationCompat.Builder(this,channelId)
    builder.body()

    val notification = builder.build()

    val notificationManager = ContextCompat.getSystemService(this,NotificationManager::class.java)
    notificationManager?.notify(id, notification)
}

fun test4(context: Context){
    //Apply some configurations to a textview

    val textView : TextView = TextView(context).apply2 {
        text = "Hello Lambdas"
       textSize = 20f
        hint = "Receivers"
    }
}
fun TextView.apply2(body: TextView.() -> Unit) : TextView{
    body(this)
    return this
}




