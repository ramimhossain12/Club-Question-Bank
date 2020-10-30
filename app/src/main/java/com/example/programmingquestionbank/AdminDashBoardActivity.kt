package com.example.programmingquestionbank

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.example.programmingquestionbank.Image.ImageUploadActivity
import com.example.programmingquestionbank.VideoFile.VideoMainActivity
import java.util.*

class AdminDashBoardActivity : AppCompatActivity() {
    var imageSlider: ImageSlider? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_dash_board)
        //now we can create two types of slider first using viewpager
        //and another using third party library which is easy to use let's get started
        imageSlider = findViewById(R.id.slider)
        val slideModel: MutableList<SlideModel> = ArrayList()
        slideModel.add(SlideModel("https://images.pexels.com/photos/376464/pexels-photo-376464.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940", "Best Pizza Collection "))
        slideModel.add(SlideModel("https://cyber-breeze.com/wp-content/uploads/2017/02/featured-image-39.jpg", "Pizza "))
        slideModel.add(SlideModel("https://specials-images.forbesimg.com/imageserve/1152308114/960x0.jpg?fit=scale", "Best Coffee Collection"))
        slideModel.add(SlideModel("https://images.pexels.com/photos/376464/pexels-photo-376464.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940", "Click The Butoon"))
        slideModel.add(SlideModel("https://ichef.bbci.co.uk/news/660/cpsprodpb/3DAD/production/_104898751_gettyimages-844466808.jpg", "Many items Food This Apps"))
        slideModel.add(SlideModel("https://post.healthline.com/wp-content/uploads/sites/3/2020/02/324771_1100-1100x628.jpg", "Tea"))
        imageSlider?.setImageList(slideModel, true)


        val dasboard = arrayOf("Upload PDF File ","Note ","Image Upload","Data send","Video Upload","Calender")
        val listView = findViewById<ListView>(R.id.listViewID)
        listView.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,dasboard)
        listView.setOnItemClickListener { parent, view, position, id ->
             if (position==0){
                 val intent = Intent(this,UploadFileActivity::class.java)
                 startActivity(intent)
             }

            if (position==1){
                val intent = Intent(this, NoteStudentActivity::class.java)
                startActivity(intent)
            }
            if (position==2){
                val intent = Intent(this, ImageUploadActivity::class.java)
                startActivity(intent)
            }

            if (position==4){
                val intent = Intent(this, VideoMainActivity::class.java)
                startActivity(intent)
            }

        }
    }
}