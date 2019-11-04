package org.wit.dog.activities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_dog.view.*
import org.wit.dog.R
import org.wit.dog.models.DogModel

interface DogListener {
  fun onDogClick(dog: DogModel)
}

class DogAdapter constructor(private var dogs: List<DogModel>,
                                   private val listener: DogListener) : RecyclerView.Adapter<DogAdapter.MainHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
    return MainHolder(LayoutInflater.from(parent?.context).inflate(R.layout.card_dog, parent, false))
  }

  override fun onBindViewHolder(holder: MainHolder, position: Int) {
    val dog = dogs[holder.adapterPosition]
    holder.bind(dog, listener)
  }

  override fun getItemCount(): Int = dogs.size

  class MainHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(dog: DogModel, listener: DogListener) {
      itemView.dogTitle.text = dog.title
      itemView.description.text = dog.description
      itemView.setOnClickListener { listener.onDogClick(dog) }
    }
  }
}