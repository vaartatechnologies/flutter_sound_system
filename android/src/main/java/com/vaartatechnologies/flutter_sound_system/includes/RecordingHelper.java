package com.vaartatechnologies.flutter_sound_system.includes;

import android.media.MediaRecorder;

import java.io.IOException;

public class RecordingHelper {

    private static MediaRecorder mediaRecorder;
    private static String audioFilePath = "";
    private static boolean recording = false;

    public static void startRecording(String audioFileNamedPath){
        if(!recording){
            recording = true;

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
    }

    public static String stopRecording(){
        try{
            mediaRecorder.stop();
            mediaRecorder.release();
            mediaRecorder = null;
        } catch (RuntimeException stopException) {
            stopException.printStackTrace();
            audioFilePath = "";
        }

        return audioFilePath;
    }

}