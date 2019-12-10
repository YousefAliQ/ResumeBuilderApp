package edu.mum.resumebuilder.ui.contactinfo

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import edu.mum.resumebuilder.R
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_contact_info.*
import kotlinx.android.synthetic.main.fragment_contact_info.view.*
import kotlinx.android.synthetic.main.fragment_technical_skills.*

class ContactInfoFragment : Fragment() {

    //private lateinit var ContactViewModel: ContactViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //ContactViewModel =
         //   ViewModelProviders.of(this).get(ContactViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_contact_info, container, false)
        /*val textView: TextView = root.findViewById(R.id.text_gallery)
        galleryViewModel.text.observe(this, Observer {
            textView.text = it
        })*/
        root.btn_contact_add.setOnClickListener(){
           //Setting Shared Preferences to save the data and retrieve the data
            var name:String?=edit_contact_name.text.toString()
            var phone:String?=edit_contact_phone.text.toString()
            var address:String?=edit_contact_address.text.toString()
            var email:String?=edit_menu_email.text.toString()
            var linkedin:String?=edit_contact_linkedin.text.toString()

            val spf = activity?.getSharedPreferences("contactinfo", Context.MODE_PRIVATE)
            // To write a data using SharedPreferences Object by calling edit, return Editor object
            val spe = spf?.edit()
            spe?.putString("name", name)
            spe?.putString("phone", phone)
            spe?.putString("address", address)
            spe?.putString("email", email)
            spe?.putString("linkedin", linkedin)
            spe?.apply()
            Toast.makeText(activity,"Data Saved",Toast.LENGTH_LONG).show()
            clearText()
        }
        root.btn_contact_show.setOnClickListener(){
            var spf:SharedPreferences?=null
            var name:String?=null
            var phone:String?=null
            var address:String?=null
            var email:String?=null
            var linkedin:String?=null
            var merge:String?=null

            spf=activity?.getSharedPreferences("contactinfo",Context.MODE_PRIVATE)
            name=spf?.getString("name",null)
            phone=spf?.getString("phone",null)
            address=spf?.getString("address",null)
            email=spf?.getString("email",null)
            linkedin=spf?.getString("linkedin",null)

            merge="Name :" + name + "\n" + "Phone # :" + phone + "\n" + "Email :" + email + "\n" +"Address :" + address + "\n" + "Email :" + email + "\n" +"LinkedIn :" + linkedin + "\n"
           if (merge!=null)
               tv_showdata.text=merge
        }
        return root
    }
    fun clearText(){
        edit_contact_name.text.clear()
        edit_contact_address.text.clear()
        edit_contact_linkedin.text.clear()
        edit_contact_phone.text.clear()
        edit_menu_email.text.clear()
    }
}