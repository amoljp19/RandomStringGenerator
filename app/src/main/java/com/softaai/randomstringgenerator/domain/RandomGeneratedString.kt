package com.softaai.randomstringgenerator.domain


/**
 * Created by amoljp19 on 12/20/2024.
 * softAai Apps.
 */
data class RandomGeneratedString(val randomString: String){
    companion object {
        val initValue = RandomGeneratedString(randomString = "")
    }
}
