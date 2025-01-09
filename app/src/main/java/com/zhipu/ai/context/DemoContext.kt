package com.zhipu.ai.context

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.zhipu.ai.model.Config

object DemoContext {
    private var params: Array<String> = emptyArray()
    private var audioProfile: Int = 0//Constants.AUDIO_PROFILE_DEFAULT
    private var audioScenario: Int = 7 //Constants.AUDIO_SCENARIO_CHORUS

    fun clearParams() {
        params = emptyArray()
    }

    fun addParams(params: String) {
        this.params += params
    }

    fun removeParams(param: String) {
        params = params.filter { it != param }.toTypedArray()
    }

    fun getParams(): Array<String> {
        return params
    }

    fun setAudioProfile(audioProfile: Int) {
        this.audioProfile = audioProfile
    }

    fun getAudioProfile(): Int {
        return audioProfile
    }

    fun setAudioScenario(audioScenario: Int) {
        this.audioScenario = audioScenario
    }

    fun getAudioScenario(): Int {
        return audioScenario
    }

    fun parseConfigJson(jsonString: String): Config {
        val gson = Gson()
        val configType = object : TypeToken<Config>() {}.type
        return gson.fromJson(jsonString, configType)
    }
}