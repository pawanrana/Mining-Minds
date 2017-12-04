/*
Copyright [2016] [Jae Hun, Bang]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package org.uclab.mm.icl.llc.AER.jh;

import java.io.IOException;
import java.util.Arrays;
import java.util.Vector;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.uclab.mm.icl.llc.MachineLearningTools.FeatureExtraction;
import org.uclab.mm.icl.llc.MachineLearningTools.FilterBankPreprocessing;
import org.uclab.mm.icl.llc.MachineLearningTools.TimeDomainFeatureExtraction;

/**
 * This Class extract MiningMind v2.5 Audio based ER Feature Extraction
 * 
 * @author Bang Gae
 *
 */
public class AERFeatureExtraction extends
		FeatureExtraction<AudioInputStream, double[]> {

	
	/**
	 * Extract the Audio features
	 */
	@Override
	public double[] extractFeature(AudioInputStream input) {
		// TODO Auto-generated method stub
		FilterBankPreprocessing fbp = new FilterBankPreprocessing();
		TimeDomainFeatureExtraction tdfe = new TimeDomainFeatureExtraction();
		double[][] mfccMatrix = null;
		double[] features = null;
		try {
			mfccMatrix = fbp.getMfcc(input);
			features = tdfe.getTimeDomainFeatures(mfccMatrix);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return features;
	}

}
