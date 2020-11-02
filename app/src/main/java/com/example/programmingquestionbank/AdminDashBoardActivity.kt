package com.example.programmingquestionbank

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.example.programmingquestionbank.AdminNote.AdminNoteActivity
import com.example.programmingquestionbank.Image.ImageUploadActivity
import com.example.programmingquestionbank.VideoFile.VideoMainActivity
import java.util.*

class AdminDashBoardActivity : AppCompatActivity() {
    var imageSlider: ImageSlider? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_dash_board)
        supportActionBar!!.title = "Admin DashBoard"
        //now we can create two types of slider first using viewpager
        //and another using third party library which is easy to use let's get started
        imageSlider = findViewById(R.id.slider)
        val slideModel: MutableList<SlideModel> = ArrayList()
        slideModel.add(SlideModel("https://images.unsplash.com/photo-1555949963-ff9fe0c870eb?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60", "Coding"))
        slideModel.add(SlideModel("https://images.unsplash.com/photo-1521185496955-15097b20c5fe?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=947&q=80", "Coding "))
        slideModel.add(SlideModel("https://images.unsplash.com/photo-1546146830-2cca9512c68e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=80", "Developer"))
        slideModel.add(SlideModel("https://images.unsplash.com/photo-1504384308090-c894fdcc538d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80", "Programming Contest"))
        slideModel.add(SlideModel("https://images.unsplash.com/photo-1560264418-c4445382edbc?ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60", "Team Work"))
        slideModel.add(SlideModel("https://images.unsplash.com/photo-1485856407642-7f9ba0268b51?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80", "Code & Tea"))
        imageSlider?.setImageList(slideModel, true)


        val dasboard = arrayOf("Upload Question ", "TODO List ", "Image Upload", "Data send", "Video Upload", "Calender")
        val listView = findViewById<ListView>(R.id.listViewID)
        listView.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dasboard)
        listView.setOnItemClickListener { parent, view, position, id ->
             if (position==0){
                 val intent = Intent(this, UploadFileActivity::class.java)
                 startActivity(intent)
             }

            if (position==1){
                val intent = Intent(this, AdminNoteActivity::class.java)
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

            if (position==5){
                val intent = Intent(this, CalanderActivity::class.java)
                startActivity(intent)
            }

        }
    }
}