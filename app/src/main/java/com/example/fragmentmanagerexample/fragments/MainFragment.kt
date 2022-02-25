package com.example.fragmentmanagerexample.fragments

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.*
import com.example.fragmentmanagerexample.R
import com.example.fragmentmanagerexample.databinding.FragmentMainBinding


class MainFragment : Fragment(), PopupMenu.OnMenuItemClickListener {


    private lateinit var fmTransaction: FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            childFragmentManager.commit {
                add<SubFragmentLately>(R.id.main_fragment_containerView)
            }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding =
            DataBindingUtil.inflate<FragmentMainBinding>(
                inflater,
                R.layout.fragment_main,
                container,
                false
            )




        binding.fragmentMenu.setOnClickListener {
            showPopupMenu(it)
        }


        return binding.root
    }

    fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(this.requireActivity(), view)
        popupMenu.setOnMenuItemClickListener(this@MainFragment)
        popupMenu.menuInflater.inflate(R.menu.fragment_menu, popupMenu.menu)
        popupMenu.show()

    }


    override fun onMenuItemClick(p0: MenuItem?): Boolean {
        return when (p0!!.itemId) {

            R.id.lately -> {
                childFragmentManager.commitNow {
                    add<SubFragmentLately>(R.id.main_fragment_containerView, "lately")

                }

                childFragmentManager.commit {
                    val lately = childFragmentManager.findFragmentByTag("lately")
                    Log.d("프래그먼트", "lately : $lately")
                    lately?.let{
                        replace(R.id.main_fragment_containerView, it)
                        Log.d("프래그먼트", "lately replace")
                    }
                }
                true
            }

            R.id.favorite -> {
                childFragmentManager.commitNow {
                    add<SubFragmentFavorite>(R.id.main_fragment_containerView, "favorite")

                }

                childFragmentManager.commit {
                    val favorite= childFragmentManager.findFragmentByTag("favorite")
                    Log.d("프래그먼트", "favorite: $favorite")
                    favorite?.let{
                        replace(R.id.main_fragment_containerView, it)
                        Log.d("프래그먼트", "favorite replace")
                    }
                }

                true
            }
            else -> false
        }
    }
}