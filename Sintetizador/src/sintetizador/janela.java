
package sintetizador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSlider;

import javax.swing.JTextPane;

import com.jsyn.JSyn;
import com.jsyn.Synthesizer;
import com.jsyn.unitgen.LineOut;
import com.jsyn.unitgen.SineOscillator;
import com.jsyn.unitgen.UnitOscillator;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import java.awt.Color;
import javax.swing.UIManager;

import java.awt.Font;

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
		
		textPane.setBounds(246, 212, 104, 20);
		frame.getContentPane().add(textPane);
		
		JSlider slider_1 = new JSlider();
		slider_1.setBackground(UIManager.getColor("Button.background"));
		slider_1.setPaintTicks(true);
		slider_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				System.out.println(slider_1.getValue());
				osc.amplitude.set(slider_1.getValue()*0.001);
			}
		});
		slider_1.setBounds(202, 353, 200, 26);
		frame.getContentPane().add(slider_1);
		
		JTextPane txtpnAmplitude = new JTextPane();
		txtpnAmplitude.setFont(new Font("Arial Black", Font.BOLD, 14));
		txtpnAmplitude.setBackground(Color.WHITE);
		txtpnAmplitude.setText("Amplitude");
		txtpnAmplitude.setBounds(246, 280, 104, 26);
		frame.getContentPane().add(txtpnAmplitude);
		
		JTextPane txtpnFrequencia = new JTextPane();
		txtpnFrequencia.setFont(new Font("Arial Black", Font.BOLD, 14));
		txtpnFrequencia.setText("Frequencia");
		txtpnFrequencia.setBounds(246, 169, 99, 43);
		frame.getContentPane().add(txtpnFrequencia);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				slider.setMinimum(0);
				slider.setMaximum(500);
				osc.frequency.set(slider.getValue());
				textPane.setText(Double.toString(osc.frequency.get()));
			}
		});
	}
}
