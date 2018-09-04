package com.football.brofinder.brofinder.presentation.activities

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.football.brofinder.brofinder.R
import com.football.brofinder.brofinder.presentation.views.FFmpegView
import com.github.hiteshsondhi88.libffmpeg.ExecuteBinaryResponseHandler
import com.github.hiteshsondhi88.libffmpeg.FFmpeg
import com.github.hiteshsondhi88.libffmpeg.FFmpegExecuteResponseHandler
import com.github.hiteshsondhi88.libffmpeg.FFmpegLoadBinaryResponseHandler
import com.mcxiaoke.koi.ext.onClick
import kotlinx.android.synthetic.main.ffmpeg_example_layout.*
import java.util.jar.Manifest

class FFmpegActivity : AppCompatActivity(), FFmpegView {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ffmpeg_example_layout)
        checkPermission()
        ffmpeg_action_button.onClick { ffmpegAction() }
    }


    private fun checkPermission(){
        val writePermission = ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
        if(writePermission != PackageManager.PERMISSION_GRANTED){
            requestPermission()
        }
    }

    private fun requestPermission(){
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE), 10)
    }

    @SuppressLint("SdCardPath")
    private fun ffmpegAction() {

        //runtime permission check

        val originalVideoPath = "sdcard/Movies/sample_video.mp4"

        val resultVideoPath = "sdcard/Movies/tag2.mp4"

        val mFFmpeg: FFmpeg = FFmpeg.getInstance(this)

        mFFmpeg.loadBinary(object : FFmpegLoadBinaryResponseHandler {
            override fun onFinish() {

            }

            override fun onSuccess() {

            }

            override fun onFailure() {

            }

            override fun onStart() {

            }

        })

        try {

            val cmd = arrayOf(
                    "-i",
                    originalVideoPath,
                    "-ss",
                    "00:00:05",
                    "-t",
                    "00:00:15",
                    "-async",
                    "1",
                    resultVideoPath)

            mFFmpeg.execute(cmd, object : ExecuteBinaryResponseHandler() {
                override fun onFinish() {
                    super.onFinish()
                }

                override fun onSuccess(message: String?) {
                    super.onSuccess(message)
                    Log.e("Success", message)
                    isLoading(false)
                }

                override fun onFailure(message: String?) {
                    super.onFailure(message)
                    Log.e("Error", message)
                    isLoading(false)
                }

                override fun onProgress(message: String?) {
                    super.onProgress(message)
                    Log.e("Progress", message)
                }

                override fun onStart() {
                    super.onStart()
                    isLoading(true)
                }
            })
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun isLoading(inProgress: Boolean) {
        if(inProgress){
            loading_progress_bar.visibility = View.VISIBLE
            ffmpeg_action_button.visibility = View.GONE
        }else{
            loading_progress_bar.visibility = View.GONE
            ffmpeg_action_button.visibility = View.VISIBLE
        }
    }
}