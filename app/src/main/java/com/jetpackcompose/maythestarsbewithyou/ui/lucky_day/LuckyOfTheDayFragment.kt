package com.jetpackcompose.maythestarsbewithyou.ui.lucky_day

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.core.animation.doOnEnd
import androidx.core.animation.doOnStart
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.jetpackcompose.maythestarsbewithyou.R
import com.jetpackcompose.maythestarsbewithyou.databinding.FragmentLuckyOfTheDayBinding
import dagger.hilt.android.AndroidEntryPoint



/**
 * Information Fragment
 */

@AndroidEntryPoint
class LuckyOfTheDayFragment : Fragment() {

    private val vm by viewModels<LuckyOfTheDayViewModel> ()
    private var _binding: FragmentLuckyOfTheDayBinding? = null
    private val binding get() =_binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentLuckyOfTheDayBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewBackCardContainer.viewBack.setOnClickListener{
            vm.prepareCard()
            paintCard()
            flipCard()
        }
    }

    private fun flipCard() {
       try {
           //Set visibility
           binding.viewFrontCardContainer.viewFront.isVisible=true
           //3D effect
           val scale = requireContext().resources.displayMetrics.density
           val cameraDist = 8000 * scale
           binding.viewFrontCardContainer.viewFront.cameraDistance = cameraDist
           binding.viewBackCardContainer.viewBack.cameraDistance = cameraDist
           //Recover FLIP OUT anim
           val flipOutAnimatorSet= AnimatorInflater.loadAnimator(
               requireContext(), R.animator.flip_out
           ) as AnimatorSet
           //and apply it to the cardReverse:
           flipOutAnimatorSet.setTarget(binding.viewBackCardContainer.viewBack)

           //Recover FLIP OUT anim
           val flipInAnimatorSet= AnimatorInflater.loadAnimator(
               requireContext(), R.animator.flip_in
           ) as AnimatorSet
           //and apply it to cardFront
           flipInAnimatorSet.setTarget(binding.viewFrontCardContainer.viewFront)
           flipInAnimatorSet.doOnStart {
                animateTitle()
           }
           //init the animations:
           flipOutAnimatorSet.start()
           flipInAnimatorSet.start()

           flipInAnimatorSet.doOnEnd {
               binding.viewBackCardContainer.viewBack.isVisible=false

           }


       }catch (e: Exception){
            Log.d("", e.message!!)
       }
    }
    private fun paintCard(){
        binding.viewFrontCardContainer.ivLuckyCard.setImageDrawable(
            ContextCompat.getDrawable(requireContext(),vm.cardSelected.value!!.image)
        )
        binding.tvLuckyInfo.text=getString(vm.cardSelected.value!!.cardName)
    }
    private fun animateTitle(){
        //binding.tvLuckyInfo.animate().alpha(1f).duration = 1500L
        //binding.tvLuckyInfo.animate().rotation(360f).duration = 1500L
        val alphaAnimation= AnimationUtils.loadAnimation(requireContext(),R.anim.alpha_animation)
        binding.tvLuckyInfo.startAnimation(alphaAnimation)
    }
}