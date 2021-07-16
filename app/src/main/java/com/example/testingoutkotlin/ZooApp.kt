package com.example.testingoutkotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView


class ZooApp : AppCompatActivity() {

    var animalList = ArrayList<Animal>()
    var adapter:AnimalsAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zoo_app)
        animalList.add(Animal("Dog", "This is a Puppy", R.drawable.dog))
        animalList.add(Animal("Panda", "This is a Panda", R.drawable.panda))
        adapter = AnimalsAdapter(this, animalList)
        var listViewAnimals = findViewById<ListView>(R.id.listViewAnimals)
        listViewAnimals.adapter = adapter
    }

    class AnimalsAdapter:BaseAdapter{
        var listOfAnimals = ArrayList<Animal>()
        var context: Context? = null
        constructor(context: Context, listOfAnimals: ArrayList<Animal>):super(){
            this.listOfAnimals = listOfAnimals
            this.context = context
        }
        override fun getCount(): Int {
            return listOfAnimals.size
        }

        override fun getItem(position: Int): Any {
            return listOfAnimals[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val animal = listOfAnimals[position]
            var mInflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var myView: View = mInflater.inflate(R.layout.animal_ticket, null)

            var animalName = myView.findViewById(R.id.AnimalName) as TextView
            var animalDesc = myView.findViewById(R.id.AnimalDesc) as TextView
            var animalImage = myView.findViewById(R.id.AnimalPic) as ImageView

            animalName.text = animal.name!!
            animalDesc.text = animal.desc!!
            animalImage.setImageResource(animal.image!!)
            return myView
        }

    }
}