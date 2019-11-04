package org.wit.dog.activities

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_dog_list.*
import kotlinx.android.synthetic.main.card_dog.view.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.startActivityForResult
import org.wit.dog.R
import org.wit.dog.main.MainApp
import org.wit.dog.models.DogModel

class DogListActivity : AppCompatActivity(), DogListener {

  lateinit var app: MainApp

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_dog_list)
    app = application as MainApp
    toolbar.title = title
    setSupportActionBar(toolbar)

    val layoutManager = LinearLayoutManager(this)
    recyclerView.layoutManager = layoutManager
    recyclerView.adapter = DogAdapter(app.dogs.findAll(), this)
  }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.menu_main, menu)
    return super.onCreateOptionsMenu(menu)
  }

  override fun onOptionsItemSelected(item: MenuItem?): Boolean {
    when (item?.itemId) {
      R.id.item_add -> startActivityForResult<DogActivity>(0)
    }
    return super.onOptionsItemSelected(item)
  }

  override fun onDogClick(dog: DogModel) {
    startActivityForResult(intentFor<DogActivity>().putExtra("dog_edit", dog), AppCompatActivity.RESULT_OK)
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    recyclerView.adapter = DogAdapter(app.dogs.findAll(), this)
    recyclerView.adapter?.notifyDataSetChanged()
  }
}