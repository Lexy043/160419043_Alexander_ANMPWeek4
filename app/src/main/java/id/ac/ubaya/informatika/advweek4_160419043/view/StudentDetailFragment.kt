package id.ac.ubaya.informatika.advweek4_160419043.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.ac.ubaya.informatika.advweek4_160419043.R
import id.ac.ubaya.informatika.advweek4_160419043.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_student_detail.*
import kotlinx.android.synthetic.main.fragment_student_list.*

class StudentDetailFragment : Fragment() {
    private lateinit var detailModel: DetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_detail, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        detailModel.fetch()

        observeViewModel()
    }

    fun observeViewModel()
    {
        detailModel.studentLD.observe(viewLifecycleOwner, Observer {
            txtID.setText(it.id)
            txtName.setText(it.name)
            txtBod.setText(it.dob)
            txtPhone.setText(it.phone)
        })
    }

}