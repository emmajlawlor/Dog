package org.wit.dog.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_dog.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.toast
import org.wit.dog.R
import org.wit.dog.main.MainApp
import org.wit.dog.models.DogModel

class DogActivity : AppCompatActivity(), AnkoLogger {

  var dog = DogModel()
  lateinit var app: MainApp

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_dog)
    toolbarAdd.title = title
    setSupportActionBar(toolbarAdd)
    info("Dog Activity started..")

    app = application as MainApp

    if (intent.hasExtra("dog_edit")) {
      dog = intent.extras?.getParcelable<DogModel>("dog_edit")!!
      dogTitle.setText(dog.title)
      description.setText(dog.description)
    }

    btnAdd.setOnClickListener() {
      dog.title = dogTitle.text.toString()
      dog.description = description.text.toString()
      if (dog.title.isNotEmpty()) {
        app.dogs.create(dog.copy())
        info("add Button Pressed: $dogTitle")
        setResult(AppCompatActivity.RESULT_OK)
        finish()
      } else {
        toast("Please Enter a title")
      }
    }
  }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.menu_dog, menu)
    return super.onCreateOptionsMenu(menu)
  }

  override fun onOptionsItemSelected(item: MenuItem?): Boolean {
    when (item?.itemId) {
      R.id.item_cancel -> {
        finish()
      }
    }
    return super.onOptionsItemSelected(item)
  }
}

