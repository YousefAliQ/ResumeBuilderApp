package edu.mum.resumebuilder.ui.visa


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import edu.mum.resumebuilder.R
import kotlinx.android.synthetic.main.fragment_technical_skills.*


class VisaStatusFragment : Fragment() {

    private lateinit var shareViewModel: VisaViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        shareViewModel =
            ViewModelProviders.of(this).get(VisaViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_technical_skills, container, false)


        fun submit(view: View) {
            // Return the object of SharedPreferences
            val spf = activity?.getSharedPreferences("myspf", Context.MODE_PRIVATE)

            // To write a data using SharedPreferences Object by calling edit, return Editor object
            val spe = spf?.edit()

            // Using put method to write the data in SharedPreferences
            spe?.putString("data", et1.text.toString())
            spe?.apply()

            // Once finished writing we need to go back to the main activity to show the text
            Toast.makeText(this.context, "Data Saved", Toast.LENGTH_LONG).show()
            et1.text.clear()
        }

        fun show(view: View) {
            val spf = activity?.getSharedPreferences("myspf", Context.MODE_PRIVATE)
            val name = spf?.getString("data", "No data Available")
            tv.text = name
        }


        return root
    }


}