package com.example.personelkayit.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.personelkayit.activity.EditPersonnelActivity
import com.example.personelkayit.databinding.RecyclerRowListBinding
import com.example.personelkayit.model.Personnel
import com.google.firebase.auth.FirebaseAuth

class ListRecyclerAdapter(
    private val context: Context,
    private val personnelList: ArrayList<Personnel>
) : RecyclerView.Adapter<ListRecyclerAdapter.PostHolder>() {

    private lateinit var auth: FirebaseAuth

    class PostHolder(val binding: RecyclerRowListBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val binding = RecyclerRowListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PostHolder(binding)
    }

    override fun getItemCount(): Int {
        return personnelList.size
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {

        auth = FirebaseAuth.getInstance()

        holder.binding.nameText.text = personnelList[position].name
        holder.binding.title.text = personnelList[position].title

        //Verileri göndermek için
        val name = personnelList[position].name
        val title = personnelList[position].title
        val userEmail= personnelList[position].userEmail
        val telephone = personnelList[position].telephone
        val userId = personnelList[position].userId


        holder.binding.cardView.setOnClickListener {
            val intent = Intent(context, EditPersonnelActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("title", title)
            intent.putExtra("userEmail", userEmail)
            intent.putExtra("telephone", telephone)
            intent.putExtra("userId", userId)
            context.startActivity(intent)
        }
    }
}
