package Sound;
/*File AudioPlayer02.java
Copyright 2003 Richard G. Baldwin

Demonstrates playback of an audio file.  The
path and name of the audio file is specified by
the user in a text field.

A GUI appears on the screen containing
the following components:
  Text field for the file name
  Play
  Stop

After entering an audio file name in the text
field, the user can click the Play button to
cause the program to play the audio file.  By
default, the program will play the entire file
and then get ready to play another file, or to
play the same file again.

If the user clicks the Stop button while the file
is being played, playback will terminate.
However, because the audio data is buffered in a
large buffer in the playback loop, there may be a
noticeable delay between the time that the Stop
button is clicked and the time that the playback
actually terminates.

The text field contains the default audio file
name, junk.au, when the GUI first appears on the
screen.

The program displays the format of the audio
data in the file before playing the file.  The
format is displayed on the command- line screen.

Tested using SDK 1.4.1 under Win2000
************************************************/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.*;

public class SoundPlayer{

  AudioFormat audioFormat;
  AudioInputStream audioInputStream;
  SourceDataLine sourceDataLine;
  boolean stopPlayback = false;

  public SoundPlayer(){//constructor
  }//end constructor
  //-------------------------------------------//

  //This method plays back audio data from an
  // audio file whose name is specified in the
  // text field.
  public void changePlayback(){
	  
  }
	public void playAudio() {
    try{
      File soundFile =
                   new File("../Resources/Sounds/time-stop.wav");
      audioInputStream = AudioSystem.
                  getAudioInputStream(soundFile);
      audioFormat = audioInputStream.getFormat();
      System.out.println(audioFormat);

      DataLine.Info dataLineInfo =
                          new DataLine.Info(
                            SourceDataLine.class,
                                    audioFormat);

      sourceDataLine =
             (SourceDataLine)AudioSystem.getLine(
                                   dataLineInfo);

      //Create a thread to play back the data and
      // start it running.  It will run until the
      // end of file, or the Stop button is
      // clicked, whichever occurs first.
      // Because of the data buffers involved,
      // there will normally be a delay between
      // the click on the Stop button and the
      // actual termination of playback.
      new PlayThread().start();
    }catch (Exception e) {
      e.printStackTrace();
    }//end catch
  }//end playAudio


//=============================================//
//Inner class to play back the data from the
// audio file.
class PlayThread extends Thread{
  byte tempBuffer[] = new byte[10000];

  public void run(){
    try{
      sourceDataLine.open(audioFormat);
      sourceDataLine.start();

      int cnt;
      //Keep looping until the input read method
      // returns -1 for empty stream or the
      // user clicks the Stop button causing
      // stopPlayback to switch from false to
      // true.
      while((cnt = audioInputStream.read(
           tempBuffer,0,tempBuffer.length)) != -1
                       && stopPlayback == false){
        if(cnt > 0){
          //Write data to the internal buffer of
          // the data line where it will be
          // delivered to the speaker.
          sourceDataLine.write(
                             tempBuffer, 0, cnt);
        }//end if
      }//end while
      //Block and wait for internal buffer of the
      // data line to empty.
      sourceDataLine.drain();
      sourceDataLine.close();

      //Prepare to playback another file
      stopPlayback = false;
    }catch (Exception e) {
      e.printStackTrace();
    }//end catch
  }//end run
}//end inner class PlayThread
//===================================//

}//end outer class AudioPlayer02.java