package com.chris.acolatse.harrypotterJFX.utils;


import com.chris.acolatse.harrypotterJFX.entity.TextOutput;

public class TextAnimator implements Runnable {

private String text;
private int animationDelay;
private TextOutput textOutput;

public TextAnimator(String text, int animationDelay, TextOutput textOutput){
   this.text = text;
   this.animationDelay = animationDelay;
   this.textOutput = textOutput;
}


    @Override
    public void run() {
        dispayWithDelay(this.text, this.animationDelay);
    }


    public void dispayWithDelay(String input, long delay){
        for (int i=0; i< input.length(); i++){
            //System.out.print(input.charAt(i));
            this.textOutput.writeText(input.substring(0,i));
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        //System.out.print("\n\n");
    }
}

