/*
 * Copyright 2010 Phil Burk, Mobileer Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package sintetizador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSlider;

import javax.swing.JTextPane;

import com.jsyn.JSyn;
import com.jsyn.Synthesizer;
import com.jsyn.scope.AudioScope;
import com.jsyn.unitgen.LineOut;
import com.jsyn.unitgen.PulseOscillator;
import com.jsyn.unitgen.RedNoise;
import com.jsyn.unitgen.SawtoothOscillator;
import com.jsyn.unitgen.SineOscillator;
import com.jsyn.unitgen.SquareOscillator;
import com.jsyn.unitgen.TriangleOscillator;
import com.jsyn.unitgen.UnitOscillator;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.UIManager;

import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class janela {
    Synthesizer synth;
    UnitOscillator osc;
    LineOut lineOut;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					janela window = new janela();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public janela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 650, 432);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JSlider slider = new JSlider();
		slider.setPaintTicks(true);

		slider.setBounds(202, 243, 200, 26);
		
		frame.getContentPane().add(slider);
        synth = JSyn.createSynthesizer();

        // Start synthesizer using default stereo output at 44100 Hz.
        synth.start();

        // Add a tone generator.
        synth.add(osc = new SineOscillator());
        
        // Add a stereo audio output unit.
        synth.add(lineOut = new LineOut());

        // Connect the oscillator to both channels of the output.
        osc.output.connect(0, lineOut.input, 0);
        osc.output.connect(0, lineOut.input, 1);

        // Set the frequency and amplitude for the sine wave.
        
        osc.amplitude.set(0.6);
        osc.frequency.set(300.0);
        // We only need to start the LineOut. It will pull data from the
        // oscillator.
        lineOut.start();
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		
		textPane.setBounds(246, 212, 104, 20);
		frame.getContentPane().add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(283, 322, 47, 20);
		frame.getContentPane().add(textPane_1);
		
		JSlider slider_1 = new JSlider();
		slider_1.setBackground(UIManager.getColor("Button.background"));
		slider_1.setPaintTicks(true);
		slider_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				
				osc.amplitude.set(slider_1.getValue()*0.1);
				textPane_1.setText(Double.toString(slider_1.getValue()));
			}
		});
		slider_1.setBounds(202, 353, 200, 26);
		frame.getContentPane().add(slider_1);
		
		JTextPane txtpnAmplitude = new JTextPane();
		txtpnAmplitude.setEditable(false);
		txtpnAmplitude.setFont(new Font("Arial Black", Font.BOLD, 14));
		txtpnAmplitude.setBackground(Color.WHITE);
		txtpnAmplitude.setText("Amplitude");
		txtpnAmplitude.setBounds(258, 294, 92, 26);
		frame.getContentPane().add(txtpnAmplitude);
		
		JTextPane txtpnFrequencia = new JTextPane();
		txtpnFrequencia.setEditable(false);
		txtpnFrequencia.setFont(new Font("Arial Black", Font.BOLD, 14));
		txtpnFrequencia.setText("Frequencia");
		txtpnFrequencia.setBounds(251, 170, 200, 99);
		frame.getContentPane().add(txtpnFrequencia);
		

		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				slider.setMinimum(0);
				slider.setMaximum(500);
				osc.frequency.set(slider.getValue());
				textPane.setText(Double.toString(osc.frequency.get()));
			}
		});
		
		AudioScope scope = new AudioScope(synth);

		scope = new AudioScope(synth);
		scope.addProbe( osc.output ); // display multiple signals
		// Trigger on a threshold level vs AUTO trigger.
		scope.setTriggerMode( AudioScope.TriggerMode.NORMAL );
		scope.start();
		scope.getView().setBounds(251, 170, 99, 43);
		frame.getContentPane().add(scope.getView());
		
        
        JRadioButton rdbtnSawtooth = new JRadioButton("SawTooth");
        rdbtnSawtooth.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		synth.add(osc = new SawtoothOscillator());
        	}
        });
        rdbtnSawtooth.setBounds(27, 74, 109, 23);
        frame.getContentPane().add(rdbtnSawtooth);
        
        JRadioButton rdbtnSine = new JRadioButton("Sine");
        rdbtnSine.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		synth.add(osc = new SineOscillator());
        	}
        });
        rdbtnSine.setBounds(27, 100, 109, 23);
        frame.getContentPane().add(rdbtnSine);
        
        JRadioButton rdbtnNewRadioButton = new JRadioButton("Triangle");
        rdbtnNewRadioButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.out.print("teste");
        		 TriangleOscillator triangulo = new  TriangleOscillator();
        		osc = triangulo;
        	
        	}
        });
        rdbtnNewRadioButton.setBounds(27, 126, 109, 23);
        frame.getContentPane().add(rdbtnNewRadioButton);
        
        JRadioButton rdbtnSquare = new JRadioButton("Square");
        rdbtnSquare.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		synth.add(osc = new SquareOscillator());
        	}
        });
        rdbtnSquare.setBounds(27, 152, 109, 23);
        frame.getContentPane().add(rdbtnSquare);
        
        JRadioButton rdbtnRednoise = new JRadioButton("RedNoise");
        rdbtnRednoise.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		synth.add(osc = new RedNoise());
        	}
        });
        rdbtnRednoise.setBounds(27, 178, 109, 23);
        frame.getContentPane().add(rdbtnRednoise);
        
        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Pulse");
        rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		synth.add(osc = new PulseOscillator());
        	}
        });
        rdbtnNewRadioButton_1.setBounds(27, 204, 109, 23);
        frame.getContentPane().add(rdbtnNewRadioButton_1);
	}
}
