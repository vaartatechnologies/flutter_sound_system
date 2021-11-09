package com.vaartatechnologies.flutter_sound_system.includes;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import java.io.IOException;

public class Helper {

    private static MediaRecorder mediaRecorder;
    private static MediaPlayer mediaPlayer;
    private static String audioFilePath = "";

    public static void startRecording(String audioFileNamedPath){
        audioFilePath = audioFileNamedPath;

        mediaRecorder = new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setOutputFile(audioFilePath);
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        try{
            mediaRecorder.prepare();
            mediaRecorder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void stopRecording(){
        try{
            mediaRecorder.stop();
            mediaRecorder.release();
            mediaRecorder = null;
        } catch (RuntimeException stopException) {
            stopException.printStackTrace();
        }
    }

    public static void playMedia(String file){
        mediaPlayer = new MediaPlayer();
        try{
            mediaPlayer.setDataSource(file);
            mediaPlayer.prepare();
            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener(mp -> stopMedia());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void pauseMedia(){
        mediaPlayer.pause();
    }

    public static void stopMedia(){
        mediaPlayer.stop();
    }
}