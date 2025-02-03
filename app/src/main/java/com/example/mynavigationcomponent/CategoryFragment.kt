package com.example.mynavigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.mynavigationcomponent.databinding.FragmentCategoryBinding

class CategoryFragment : Fragment() {


    private var _binding: FragmentCategoryBinding? = null
    private val binding get() = _binding!!

    companion object{
        val EXTRA_NAME = "extra_name"
        val EXTRA_DESCRIPTION = "extra_description"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnDetailCategory.setOnClickListener{view ->
            //menggunakan Bundle()
            /*
            val nBundle = Bundle()
            nBundle.putString(EXTRA_NAME,"Lifestyle")
            nBundle.putLong(EXTRA_DESCRIPTION, 7)
            // Mengirim data bundle
            view.findNavController().navigate(R.id.action_categoryFragment_to_detailCategoryFragment, nBundle)
            */

            //Menggunakan safeArgs

            val toDetailCategoryFragment = CategoryFragmentDirections.actionCategoryFragmentToDetailCategoryFragment()
            toDetailCategoryFragment.name = "Lifestyle"
            toDetailCategoryFragment.description = 7
            view.findNavController().navigate(toDetailCategoryFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}