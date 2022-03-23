package id.ac.ubaya.informatika.advweek4_160419043.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import id.ac.ubaya.informatika.advweek4_160419043.R
import id.ac.ubaya.informatika.advweek4_160419043.util.loadImage
import id.ac.ubaya.informatika.advweek4_160419043.viewmodel.DetailViewModel
import id.ac.ubaya.informatika.advweek4_160419043.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_student_detail.*
import kotlinx.android.synthetic.main.fragment_student_detail.txtID
import kotlinx.android.synthetic.main.fragment_student_detail.txtName
import kotlinx.android.synthetic.main.student_list_item.*

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
        if(arguments != null){
            val id = StudentDetailFragmentArgs.fromBundle(requireArguments()).id
            detailModel = ViewModelProvider(this).get(DetailViewModel::class.java)
            detailModel.detail(id)

            detailModel.studentLD.observe(viewLifecycleOwner, Observer {
                txtID.setText(it.id)
                txtName.setText(it.name)
                txtBod.setText(it.bod)
                txtPhone.setText(it.phone)
                imageView2.loadImage(it.photoUrl.toString(), progressBar)
            })
        }

        btnUpdate.setOnClickListener {
            val id = StudentDetailFragmentArgs.fromBundle(requireArguments()).id
            val action = StudentListFragmentDirections.actionStudentDetail(id)
            Navigation.findNavController(it).navigate(action)
        }
    }
}