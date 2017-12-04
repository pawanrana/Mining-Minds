/**
* 
* Copyright [2016] [Claudia Villalonga & Muhammad Asif Razzaq]
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
* Unless required by applicable law or agreed to in writing, software distributed under 
* the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF
*  ANY KIND, either express or implied.
*  See the License for the specific language governing permissions and limitations under the License.
*/
package mm.icl.hlc.HLCBuilder;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.hp.hpl.jena.ontology.AllValuesFromRestriction;
import com.hp.hpl.jena.ontology.ComplementClass;
import com.hp.hpl.jena.ontology.DatatypeProperty;
import com.hp.hpl.jena.ontology.EnumeratedClass;
import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.ontology.SomeValuesFromRestriction;
import com.hp.hpl.jena.rdf.model.ModelFactory;

import mm.icl.hlc.OntologyTools.ContextOntology;
import mm.icl.hlc.OntologyTools.HLCA;
import mm.icl.hlc.OntologyTools.LowLevelContext;
import mm.icl.hlc.OntologyTools.NutritionContext;
import mm.icl.hlc.OntologyTools.ClinicalContext;
import mm.icl.hlc.OntologyTools.PhysicalActivityContext;
/**
 * Context Instantiator. Subcomponent of the HLC Builder which generates
 * unclassified HLC instances from concurrent LLC instances.
 * 
 * @author Claudia Villalonga & Muhammad Asif Razzaq
 * @version 2.5
 * @since 2015-11-06
 */
public class ContextInstantiator {
	/**
	 * Context Ontology which represents the Mining Minds Context Model.
	 */
	private ContextOntology ont;
	/**
	 * Identifier of the Context Instantiator.
	 */
	private int instantiatiorId;
	/**
	 * Counter of the number HLC instances generated by the Context
	 * Instantiator.
	 */
	private long hlcInstNum;
	/**
	 * Constructor of a new Context Instantiator.
	 * 
	 * @param ont
	 *            Context Ontology which represents the Mining Minds Context
	 *            Model.
	 */
	public ContextInstantiator(ContextOntology ont) {
		this.ont = ont;
		Random rand = new Random();
		this.instantiatiorId = rand.nextInt(Integer.MAX_VALUE);
		this.hlcInstNum = 0;
	}
	/**
	 * Method to generate a new HLC Instance due to the start of a LLC.
	 * 
	 * @param llc
	 *            Low Level Context which start is the trigger for the
	 *            generation of the new HLC.
	 * @param listLlcConc
	 *            List of Low Level Context Instances which are concurrent at
	 *            the start time of llc.
	 * @return PhysicalActivity and Nutrition Context are composed of the llc and the listLlcConc, and
	 *         which starts at the start of llc.
	 */
	public PhysicalActivityContext instantiateNewHlcDueToLlcStart(LowLevelContext llc, List<LowLevelContext> listLlcConc) {
		OntModel hlcModel = createHlcModel();
		Individual hlcIndiv = createHlcIndiv(hlcModel);
		setUserForHlc(hlcIndiv, llc);
		setStartTimeForHlcDueToLlcStart(hlcIndiv, llc);
		boolean act = false;
		boolean loc = false;
		boolean emo = false;
		boolean foo = false;
		boolean bg = false;
		boolean bp = false;
		boolean wi = false;
		switch (llc.getLlcCategoryName()) {
		case HLCA.activityClassName:
			setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llc, ont.getActivityProp());
			act = true;
			break;
		case HLCA.locationClassName:
			setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llc, ont.getLocationProp());
			loc = true;
			break;
		case HLCA.emotionClassName:
			setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llc, ont.getEmotionProp());
			emo = true;
			break;
		case HLCA.BloodGlucoseClassName:
			setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llc, ont.getBloodGlucoseProp());
			bg = true;
			break;
		case HLCA.BloodPressureClassName:
			setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llc, ont.getBloodPressureProp());
			bp= true;
			break;
		case HLCA.WaterIntakeClassName:
			setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llc, ont.getWaterIntakeProp());
			wi = true;
			break;
		case HLCA.eggClassName:      
			setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llc, ont.getFoodProp());
			foo = true;
			break;
		case HLCA.fruitClassName :      
			setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llc, ont.getFoodProp());
			foo = true;
			break;
		case HLCA.grainClassName :      
			setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llc, ont.getFoodProp());
			foo = true;
			break;
		case HLCA.legumesClassName :      
			setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llc, ont.getFoodProp());
			foo = true;
			break;
		case HLCA.meatClassName :      
			setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llc, ont.getFoodProp());
			foo = true;
			break;
		case HLCA.milkdairyClassName :      
			setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llc, ont.getFoodProp());
			foo = true;
			break;
		case HLCA.nutsClassName :      
			setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llc, ont.getFoodProp());
			foo = true;
			break;
		case HLCA.seafoodClassName :      
			setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llc, ont.getFoodProp());
			foo = true;
			break;
		case HLCA.snacksClassName :      
			setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llc, ont.getFoodProp());
			foo = true;
			break;
		case HLCA.vegClassName :      
			setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llc, ont.getFoodProp());
			foo = true;
			break;
		}
		Iterator<LowLevelContext> itConc = listLlcConc.iterator();
		while (itConc.hasNext()) {
			LowLevelContext llcConc = itConc.next();
			switch (llcConc.getLlcCategoryName()) {
			case HLCA.activityClassName:
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getActivityProp());
				act = true;
				break;
			case HLCA.locationClassName:
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getLocationProp());
				loc = true;
				break;
			case HLCA.emotionClassName:
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getEmotionProp());
				emo = true;
				break;
			case HLCA.BloodGlucoseClassName:
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getBloodGlucoseProp());
				bg = true;
				break;
			case HLCA.BloodPressureClassName:
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getBloodPressureProp());
				bp = true;
				break;
			case HLCA.WaterIntakeClassName:
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getWaterIntakeProp());
				wi = true;
				break;
			case HLCA.eggClassName:      
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getFoodProp());
				foo = true;
				break;
			case HLCA.fruitClassName :      
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getFoodProp());
				foo = true;
				break;
			case HLCA.grainClassName :      
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getFoodProp());
				foo = true;
				break;
			case HLCA.legumesClassName :      
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getFoodProp());
				foo = true;
				break;
			case HLCA.meatClassName :      
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getFoodProp());
				foo = true;
				break;
			case HLCA.milkdairyClassName :      
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getFoodProp());
				foo = true;
				break;
			case HLCA.nutsClassName :      
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getFoodProp());
				foo = true;
				break;
			case HLCA.seafoodClassName :      
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getFoodProp());
				foo = true;
				break;
			case HLCA.snacksClassName :      
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getFoodProp());
				foo = true;
				break;
			case HLCA.vegClassName :      
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getFoodProp());
				foo = true;
				break;
			}
		}
		if (!act)
			setNoLlcBeingPartOfHlc(hlcModel, hlcIndiv, ont.getLlcCategoryClass(HLCA.activityClassName),
					ont.getActivityProp());
		if (!loc)
			setNoLlcBeingPartOfHlc(hlcModel, hlcIndiv, ont.getLlcCategoryClass(HLCA.locationClassName),
					ont.getLocationProp());
		if (!emo)
			setNoLlcBeingPartOfHlc(hlcModel, hlcIndiv, ont.getLlcCategoryClass(HLCA.emotionClassName),
					ont.getEmotionProp());
		if (!bg)
			setNoLlcBeingPartOfHlc(hlcModel, hlcIndiv, ont.getLlcCategoryClass(HLCA.BloodGlucoseClassName),
					ont.getBloodGlucoseProp());
		if (!bp)
			setNoLlcBeingPartOfHlc(hlcModel, hlcIndiv, ont.getLlcCategoryClass(HLCA.BloodPressureClassName),
					ont.getBloodPressureProp());
		if (!wi)
			setNoLlcBeingPartOfHlc(hlcModel, hlcIndiv, ont.getLlcCategoryClass(HLCA.WaterIntakeClassName),
					ont.getWaterIntakeProp());
		if (!foo)   //Asif
			setNoLlcBeingPartOfHlc(hlcModel, hlcIndiv, ont.getLlcCategoryClass(HLCA.foodClassName),
					ont.getFoodProp());
		this.hlcInstNum++;
		return new PhysicalActivityContext(hlcModel);
	}
	/**
	 * Method to generate a new HLC Instance due to the start of a LLC.
	 * 
	 * @param llc
	 *            Low Level Context which start is the trigger for the
	 *            generation of the new HLC.
	 * @param listLlcConc
	 *            List of Low Level Context Instances which are concurrent at
	 *            the start time of llc.
	 * @return PhysicalActivity and Nutrition Context composed of the llc and the listLlcConc, and
	 *         which starts at the start of llc.
	 */
	public NutritionContext instantiateNewNutHlcDueToLlcStart(LowLevelContext llc, List<LowLevelContext> listLlcConc) {
		OntModel hlcModel = createHlcModel();
		Individual hlcIndiv = createNutHlcIndiv(hlcModel);
		setUserForHlc(hlcIndiv, llc);
		setStartTimeForHlcDueToLlcStart(hlcIndiv, llc);
		boolean act = false;
		boolean loc = false;
		boolean emo = false;
		boolean foo = false;
		boolean bg = false;
		boolean bp = false;
		boolean wi  = false;
		switch (llc.getLlcCategoryName()) {
		case HLCA.activityClassName:
			setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llc, ont.getActivityProp());
			act = true;
			break;
		case HLCA.locationClassName:
			setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llc, ont.getLocationProp());
			loc = true;
			break;
		case HLCA.emotionClassName:
			setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llc, ont.getEmotionProp());
			emo = true;
			break;
		case HLCA.BloodGlucoseClassName:
			setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llc, ont.getBloodGlucoseProp());
			bg = true;
			break;
		case HLCA.BloodPressureClassName:
			setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llc, ont.getBloodPressureProp());
			bp= true;
			break;
		case HLCA.WaterIntakeClassName:
			setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llc, ont.getWaterIntakeProp());
			wi = true;
			break;
		case HLCA.eggClassName:      
			setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llc, ont.getFoodProp());
			foo = true;
			break;
		case HLCA.fruitClassName :      
			setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llc, ont.getFoodProp());
			foo = true;
			break;
		case HLCA.grainClassName :      
			setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llc, ont.getFoodProp());
			foo = true;
			break;
		case HLCA.legumesClassName :      
			setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llc, ont.getFoodProp());
			foo = true;
			break;
		case HLCA.meatClassName :      
			setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llc, ont.getFoodProp());
			foo = true;
			break;
		case HLCA.milkdairyClassName :      
			setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llc, ont.getFoodProp());
			foo = true;
			break;
		case HLCA.nutsClassName :      
			setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llc, ont.getFoodProp());
			foo = true;
			break;
		case HLCA.seafoodClassName :      
			setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llc, ont.getFoodProp());
			foo = true;
			break;
		case HLCA.snacksClassName :      
			setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llc, ont.getFoodProp());
			foo = true;
			break;
		case HLCA.vegClassName :      
			setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llc, ont.getFoodProp());
			foo = true;
			break;
		}
		Iterator<LowLevelContext> itConc = listLlcConc.iterator();
		while (itConc.hasNext()) {
			LowLevelContext llcConc = itConc.next();
			switch (llcConc.getLlcCategoryName()) {
			case HLCA.activityClassName:
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getActivityProp());
				act = true;
				break;
			case HLCA.locationClassName:
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getLocationProp());
				loc = true;
				break;
			case HLCA.emotionClassName:
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getEmotionProp());
				emo = true;
				break;
			case HLCA.BloodGlucoseClassName:
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getBloodGlucoseProp());
				bg = true;
				break;
			case HLCA.BloodPressureClassName:
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getBloodPressureProp());
				bp = true;
				break;
			case HLCA.WaterIntakeClassName:
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getWaterIntakeProp());
				wi = true;
				break;
			case HLCA.eggClassName:      
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getFoodProp());
				foo = true;
				break;
			case HLCA.fruitClassName :      
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getFoodProp());
				foo = true;
				break;
			case HLCA.grainClassName :      
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getFoodProp());
				foo = true;
				break;
			case HLCA.legumesClassName :      
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getFoodProp());
				foo = true;
				break;
			case HLCA.meatClassName :      
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getFoodProp());
				foo = true;
				break;
			case HLCA.milkdairyClassName :      
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getFoodProp());
				foo = true;
				break;
			case HLCA.nutsClassName :      
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getFoodProp());
				foo = true;
				break;
			case HLCA.seafoodClassName :      
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getFoodProp());
				foo = true;
				break;
			case HLCA.snacksClassName :      
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getFoodProp());
				foo = true;
				break;
			case HLCA.vegClassName :      
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getFoodProp());
				foo = true;
				break;
			}
		}
		if (!act)
			setNoLlcBeingPartOfHlc(hlcModel, hlcIndiv, ont.getLlcCategoryClass(HLCA.activityClassName),
					ont.getActivityProp());
		if (!loc)
			setNoLlcBeingPartOfHlc(hlcModel, hlcIndiv, ont.getLlcCategoryClass(HLCA.locationClassName),
					ont.getLocationProp());
		if (!emo)
			setNoLlcBeingPartOfHlc(hlcModel, hlcIndiv, ont.getLlcCategoryClass(HLCA.emotionClassName),
					ont.getEmotionProp());
		if (!bg)
			setNoLlcBeingPartOfHlc(hlcModel, hlcIndiv, ont.getLlcCategoryClass(HLCA.BloodGlucoseClassName),
					ont.getBloodGlucoseProp());
		if (!bp)
			setNoLlcBeingPartOfHlc(hlcModel, hlcIndiv, ont.getLlcCategoryClass(HLCA.BloodPressureClassName),
					ont.getBloodPressureProp());
		if (!wi)
			setNoLlcBeingPartOfHlc(hlcModel, hlcIndiv, ont.getLlcCategoryClass(HLCA.WaterIntakeClassName),
					ont.getWaterIntakeProp());
		if (!foo)   //Asif
			setNoLlcBeingPartOfHlc(hlcModel, hlcIndiv, ont.getLlcCategoryClass(HLCA.foodClassName),
					ont.getFoodProp());
		this.hlcInstNum++;
		return new NutritionContext(hlcModel);
	}
	/*
	 * Method to generate a new HLC Instance due to the start of a LLC.
	 * 
	 * @param llc
	 *            Low Level Context which start is the trigger for the
	 *            generation of the new HLC.
	 * @param listLlcConc
	 *            List of Low Level Context Instances which are concurrent at
	 *            the start time of llc.
	 * @return PhysicalActivity and Nutrition Context composed of the llc and the listLlcConc, and
	 *         which starts at the start of llc.
	 */
	public ClinicalContext instantiateNewCliHlcDueToLlcStart(LowLevelContext llc, List<LowLevelContext> listLlcConc) {
		OntModel hlcModel = createHlcModel();
		Individual hlcIndiv = createCliHlcIndiv(hlcModel);
		setUserForHlc(hlcIndiv, llc);
		setStartTimeForHlcDueToLlcStart(hlcIndiv, llc);
		boolean act = false;
		boolean loc = false;
		boolean emo = false;
		boolean foo = false;
		boolean bg = false;
		boolean bp = false;
		boolean wi  = false;
		switch (llc.getLlcCategoryName()) {
		case HLCA.activityClassName:
			setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llc, ont.getActivityProp());
			act = true;
			break;
		case HLCA.locationClassName:
			setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llc, ont.getLocationProp());
			loc = true;
			break;
		case HLCA.emotionClassName:
			setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llc, ont.getEmotionProp());
			emo = true;
			break;
		case HLCA.BloodGlucoseClassName:
			setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llc, ont.getBloodGlucoseProp());
			bg = true;
			break;
		case HLCA.BloodPressureClassName:
			setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llc, ont.getBloodPressureProp());
			bp= true;
			break;
		case HLCA.WaterIntakeClassName:
			setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llc, ont.getWaterIntakeProp());
			wi = true;
			break;
		case HLCA.eggClassName:      
			setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llc, ont.getFoodProp());
			foo = true;
			break;
		case HLCA.fruitClassName :      
			setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llc, ont.getFoodProp());
			foo = true;
			break;
		case HLCA.grainClassName :      
			setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llc, ont.getFoodProp());
			foo = true;
			break;
		case HLCA.legumesClassName :      
			setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llc, ont.getFoodProp());
			foo = true;
			break;
		case HLCA.meatClassName :      
			setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llc, ont.getFoodProp());
			foo = true;
			break;
		case HLCA.milkdairyClassName :      
			setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llc, ont.getFoodProp());
			foo = true;
			break;
		case HLCA.nutsClassName :      
			setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llc, ont.getFoodProp());
			foo = true;
			break;
		case HLCA.seafoodClassName :      
			setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llc, ont.getFoodProp());
			foo = true;
			break;
		case HLCA.snacksClassName :      
			setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llc, ont.getFoodProp());
			foo = true;
			break;
		case HLCA.vegClassName :      
			setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llc, ont.getFoodProp());
			foo = true;
			break;
		}
		Iterator<LowLevelContext> itConc = listLlcConc.iterator();
		while (itConc.hasNext()) {
			LowLevelContext llcConc = itConc.next();
			switch (llcConc.getLlcCategoryName()) {
			case HLCA.activityClassName:
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getActivityProp());
				act = true;
				break;
			case HLCA.locationClassName:
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getLocationProp());
				loc = true;
				break;
			case HLCA.emotionClassName:
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getEmotionProp());
				emo = true;
				break;
			case HLCA.BloodGlucoseClassName:
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getBloodGlucoseProp());
				bg = true;
				break;
			case HLCA.BloodPressureClassName:
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getBloodPressureProp());
				bp = true;
				break;
			case HLCA.WaterIntakeClassName:
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getWaterIntakeProp());
				wi = true;
				break;
			case HLCA.eggClassName:      
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getFoodProp());
				foo = true;
				break;
			case HLCA.fruitClassName :      
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getFoodProp());
				foo = true;
				break;
			case HLCA.grainClassName :      
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getFoodProp());
				foo = true;
				break;
			case HLCA.legumesClassName :      
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getFoodProp());
				foo = true;
				break;
			case HLCA.meatClassName :      
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getFoodProp());
				foo = true;
				break;
			case HLCA.milkdairyClassName :      
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getFoodProp());
				foo = true;
				break;
			case HLCA.nutsClassName :      
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getFoodProp());
				foo = true;
				break;
			case HLCA.seafoodClassName :      
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getFoodProp());
				foo = true;
				break;
			case HLCA.snacksClassName :      
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getFoodProp());
				foo = true;
				break;
			case HLCA.vegClassName :      
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getFoodProp());
				foo = true;
				break;
			}
		}
		if (!act)
			setNoLlcBeingPartOfHlc(hlcModel, hlcIndiv, ont.getLlcCategoryClass(HLCA.activityClassName),
					ont.getActivityProp());
		if (!loc)
			setNoLlcBeingPartOfHlc(hlcModel, hlcIndiv, ont.getLlcCategoryClass(HLCA.locationClassName),
					ont.getLocationProp());
		if (!emo)
			setNoLlcBeingPartOfHlc(hlcModel, hlcIndiv, ont.getLlcCategoryClass(HLCA.emotionClassName),
					ont.getEmotionProp());
		if (!bg)
			setNoLlcBeingPartOfHlc(hlcModel, hlcIndiv, ont.getLlcCategoryClass(HLCA.BloodGlucoseClassName),
					ont.getBloodGlucoseProp());
		if (!bp)
			setNoLlcBeingPartOfHlc(hlcModel, hlcIndiv, ont.getLlcCategoryClass(HLCA.BloodPressureClassName),
					ont.getBloodPressureProp());
		if (!wi)
			setNoLlcBeingPartOfHlc(hlcModel, hlcIndiv, ont.getLlcCategoryClass(HLCA.WaterIntakeClassName),
					ont.getWaterIntakeProp());
		if (!foo)   //Asif
			setNoLlcBeingPartOfHlc(hlcModel, hlcIndiv, ont.getLlcCategoryClass(HLCA.foodClassName),
					ont.getFoodProp());
		this.hlcInstNum++;
		return new ClinicalContext(hlcModel);
	}
	/**
	 * Method to generate a new HLC Instance due to the end of a LLC.
	 * 
	 * @param llc
	 *            Low Level Context which end is the trigger for the generation
	 *            of the new HLC.
	 * @param listLlcConc
	 *            List of Low Level Context Instances which are concurrent at
	 *            the end time of llc.
	 * @return PhysicalActivity and Nutrition Context composed of the listLlcConc and which starts
	 *         at the end of llc.
	 */
	public PhysicalActivityContext instantiateNewHlcDueToLlcEnd(LowLevelContext llc, List<LowLevelContext> listLlcConc) {
		OntModel hlcModel = createHlcModel();
		Individual hlcIndiv = createHlcIndiv(hlcModel);
		setUserForHlc(hlcIndiv, llc);
		setStartTimeForHlcDueToLlcEnd(hlcIndiv, llc);
		boolean act = false;
		boolean loc = false;
		boolean emo = false;
		boolean foo = false;
		boolean bg = false; 
		boolean bp = false; 
		boolean wi = false; 
		Iterator<LowLevelContext> itConc = listLlcConc.iterator();
		while (itConc.hasNext()) {
			LowLevelContext llcConc = itConc.next();
			switch (llcConc.getLlcCategoryName()) {
			case HLCA.activityClassName:
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getActivityProp());
				act = true;
				break;
			case HLCA.locationClassName:
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getLocationProp());
				loc = true;
				break;
			case HLCA.emotionClassName:
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getEmotionProp());
				emo = true;
				break;
			case HLCA.foodClassName: 
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getFoodProp());
				foo = true;
				break;
			case HLCA.BloodGlucoseClassName: 
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getBloodGlucoseProp());
				bg= true;
				break;
			case HLCA.BloodPressureClassName: 
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getBloodPressureProp());
				bp= true;
				break;
			case HLCA.WaterIntakeClassName: 
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getWaterIntakeProp());
				wi = true;
				break;

			}
		}
		if (!act)
			setNoLlcBeingPartOfHlc(hlcModel, hlcIndiv, ont.getLlcCategoryClass(HLCA.activityClassName),
					ont.getActivityProp());
		if (!loc)
			setNoLlcBeingPartOfHlc(hlcModel, hlcIndiv, ont.getLlcCategoryClass(HLCA.locationClassName),
					ont.getLocationProp());
		if (!emo)
			setNoLlcBeingPartOfHlc(hlcModel, hlcIndiv, ont.getLlcCategoryClass(HLCA.emotionClassName),
					ont.getEmotionProp());
		if (!foo)
			setNoLlcBeingPartOfHlc(hlcModel, hlcIndiv, ont.getLlcCategoryClass(HLCA.foodClassName),
					ont.getFoodProp());
		if (!bg)
			setNoLlcBeingPartOfHlc(hlcModel, hlcIndiv, ont.getLlcCategoryClass(HLCA.BloodGlucoseClassName),
					ont.getBloodGlucoseProp());
		if (!bp)
			setNoLlcBeingPartOfHlc(hlcModel, hlcIndiv, ont.getLlcCategoryClass(HLCA.BloodPressureClassName),
					ont.getBloodPressureProp());
		if (!wi)
			setNoLlcBeingPartOfHlc(hlcModel, hlcIndiv, ont.getLlcCategoryClass(HLCA.WaterIntakeClassName),
					ont.getWaterIntakeProp());
		this.hlcInstNum++;
		return new PhysicalActivityContext(hlcModel);
	}
	/**
	 * Method to generate a new HLC Instance due to the end of a LLC.
	 * 
	 * @param llc
	 *            Low Level Context which end is the trigger for the generation
	 *            of the new HLC.
	 * @param listLlcConc
	 *            List of Low Level Context Instances which are concurrent at
	 *            the end time of llc.
	 * @return PhysicalActivity and Nutrition Context composed of the listLlcConc and which starts
	 *         at the end of llc.
	 */
	public NutritionContext instantiateNewNutHlcDueToLlcEnd(LowLevelContext llc, List<LowLevelContext> listLlcConc) {
		OntModel hlcModel = createHlcModel();
		Individual hlcIndiv = createNutHlcIndiv(hlcModel);
		setUserForHlc(hlcIndiv, llc);
		setStartTimeForHlcDueToLlcEnd(hlcIndiv, llc);
		boolean act = false;
		boolean loc = false;
		boolean emo = false;
		boolean foo = false; 
		boolean bg = false; 
		boolean bp = false; 
		boolean wi = false; 
		Iterator<LowLevelContext> itConc = listLlcConc.iterator();
		while (itConc.hasNext()) {
			LowLevelContext llcConc = itConc.next();
			switch (llcConc.getLlcCategoryName()) {
			case HLCA.activityClassName:
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getActivityProp());
				act = true;
				break;
			case HLCA.locationClassName:
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getLocationProp());
				loc = true;
				break;
			case HLCA.emotionClassName:
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getEmotionProp());
				emo = true;
				break;
			case HLCA.foodClassName: 
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getFoodProp());
				foo = true;
				break;
			case HLCA.BloodGlucoseClassName: 
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getBloodGlucoseProp());
				bg= true;
				break;
			case HLCA.BloodPressureClassName: 
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getBloodPressureProp());
				bp= true;
				break;
			case HLCA.WaterIntakeClassName: 
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getWaterIntakeProp());
				wi = true;
				break;				
			}
		}
		if (!act)
			setNoLlcBeingPartOfHlc(hlcModel, hlcIndiv, ont.getLlcCategoryClass(HLCA.activityClassName),
					ont.getActivityProp());
		if (!loc)
			setNoLlcBeingPartOfHlc(hlcModel, hlcIndiv, ont.getLlcCategoryClass(HLCA.locationClassName),
					ont.getLocationProp());
		if (!emo)
			setNoLlcBeingPartOfHlc(hlcModel, hlcIndiv, ont.getLlcCategoryClass(HLCA.emotionClassName),
					ont.getEmotionProp());
		if (!foo)  //Asif
			setNoLlcBeingPartOfHlc(hlcModel, hlcIndiv, ont.getLlcCategoryClass(HLCA.foodClassName),
					ont.getFoodProp());
		if (!bg)
			setNoLlcBeingPartOfHlc(hlcModel, hlcIndiv, ont.getLlcCategoryClass(HLCA.BloodGlucoseClassName),
					ont.getBloodGlucoseProp());
		if (!bp)
			setNoLlcBeingPartOfHlc(hlcModel, hlcIndiv, ont.getLlcCategoryClass(HLCA.BloodPressureClassName),
					ont.getBloodPressureProp());
		if (!wi)
			setNoLlcBeingPartOfHlc(hlcModel, hlcIndiv, ont.getLlcCategoryClass(HLCA.WaterIntakeClassName),
					ont.getWaterIntakeProp());
		this.hlcInstNum++;
		return new NutritionContext(hlcModel);
	}
	/**
	 * Method to generate a new HLC Instance due to the end of a LLC.
	 * 
	 * @param llc
	 *            Low Level Context which end is the trigger for the generation
	 *            of the new HLC.
	 * @param listLlcConc
	 *            List of Low Level Context Instances which are concurrent at
	 *            the end time of llc.
	 * @return PhysicalActivity and Nutrition Context composed of the listLlcConc and which starts
	 *         at the end of llc.
	 */
	public ClinicalContext instantiateNewCliHlcDueToLlcEnd(LowLevelContext llc, List<LowLevelContext> listLlcConc) {
		OntModel hlcModel = createHlcModel();
		Individual hlcIndiv = createNutHlcIndiv(hlcModel);
		setUserForHlc(hlcIndiv, llc);
		setStartTimeForHlcDueToLlcEnd(hlcIndiv, llc);
		boolean act = false;
		boolean loc = false;
		boolean emo = false;
		boolean foo = false; 
		boolean bg = false; 
		boolean bp = false; 
		boolean wi = false; 
		Iterator<LowLevelContext> itConc = listLlcConc.iterator();
		while (itConc.hasNext()) {
			LowLevelContext llcConc = itConc.next();
			switch (llcConc.getLlcCategoryName()) {
			case HLCA.activityClassName:
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getActivityProp());
				act = true;
				break;
			case HLCA.locationClassName:
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getLocationProp());
				loc = true;
				break;
			case HLCA.emotionClassName:
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getEmotionProp());
				emo = true;
				break;
			case HLCA.foodClassName: 
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getFoodProp());
				foo = true;
				break;
			case HLCA.BloodGlucoseClassName: 
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getBloodGlucoseProp());
				bg= true;
				break;
			case HLCA.BloodPressureClassName: 
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getBloodPressureProp());
				bp= true;
				break;
			case HLCA.WaterIntakeClassName: 
				setLlcBeingPartOfHlc(hlcModel, hlcIndiv, llcConc, ont.getWaterIntakeProp());
				wi = true;
				break;				
			}
		}
		if (!act)
			setNoLlcBeingPartOfHlc(hlcModel, hlcIndiv, ont.getLlcCategoryClass(HLCA.activityClassName),
					ont.getActivityProp());
		if (!loc)
			setNoLlcBeingPartOfHlc(hlcModel, hlcIndiv, ont.getLlcCategoryClass(HLCA.locationClassName),
					ont.getLocationProp());
		if (!emo)
			setNoLlcBeingPartOfHlc(hlcModel, hlcIndiv, ont.getLlcCategoryClass(HLCA.emotionClassName),
					ont.getEmotionProp());
		if (!foo)  //Asif
			setNoLlcBeingPartOfHlc(hlcModel, hlcIndiv, ont.getLlcCategoryClass(HLCA.foodClassName),
					ont.getFoodProp());
		if (!bg)
			setNoLlcBeingPartOfHlc(hlcModel, hlcIndiv, ont.getLlcCategoryClass(HLCA.BloodGlucoseClassName),
					ont.getBloodGlucoseProp());
		if (!bp)
			setNoLlcBeingPartOfHlc(hlcModel, hlcIndiv, ont.getLlcCategoryClass(HLCA.BloodPressureClassName),
					ont.getBloodPressureProp());
		if (!wi)
			setNoLlcBeingPartOfHlc(hlcModel, hlcIndiv, ont.getLlcCategoryClass(HLCA.WaterIntakeClassName),
					ont.getWaterIntakeProp());
		this.hlcInstNum++;
		return new ClinicalContext(hlcModel);
	}
	
	/**
	 * Method to create the OntModel associated to a new HLC.
	 * 
	 * @return OntModel associated to a new HLC.
	 */
	private OntModel createHlcModel() {
		OntModel hlcModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
		hlcModel.setNsPrefix(HLCA.nsPrefix, HLCA.ns);
		return hlcModel;
	}
	/**
	 * Method to create an individual of the HLC class which represents the new
	 * HLC instance.
	 * 
	 * @param hlcModel
	 *            OntModel associated to the new HLC in which the individual
	 *            will be created.
	 * @return Individual representing the HLC instance.
	 */
	private Individual createHlcIndiv(OntModel hlcModel) {
		return hlcModel.createIndividual(HLCA.ns + "hlc_" + String.format("%010d", this.instantiatiorId) + "_"
				+ String.format("%019d", this.hlcInstNum), ont.getHlcClass());
	}
	/**
	 * Method to create an individual of the HLC class which represents the new
	 * HLC instance.
	 * 
	 * @param hlcModel
	 *            OntModel associated to the new HLC in which the individual
	 *            will be created.
	 * @return Individual representing the HLC instance.
	 */
	private Individual createNutHlcIndiv(OntModel hlcModel) {
		return hlcModel.createIndividual(HLCA.ns + "hlc_" + String.format("%010d", this.instantiatiorId) + "_"
				+ String.format("%019d", this.hlcInstNum), ont.getNutHlcClass());
	}
	/**
	 * Method to create an individual of the HLC class which represents the new
	 * HLC instance.
	 * 
	 * @param hlcModel
	 *            OntModel associated to the new HLC in which the individual
	 *            will be created.
	 * @return Individual representing the HLC instance.
	 */
	private Individual createCliHlcIndiv(OntModel hlcModel) {
		return hlcModel.createIndividual(HLCA.ns + "hlc_" + String.format("%010d", this.instantiatiorId) + "_"
				+ String.format("%019d", this.hlcInstNum), ont.getClinicalHlcClass());
	}
	/**
	 * Method to set the User in the HLC instance, i.e., to assert the value of
	 * the property which links the PhysicalActivity and Nutrition Context to the User it belongs
	 * to.
	 * 
	 * @param hlcIndiv
	 *            Individual representing the HLC instance.
	 * @param llc
	 *            Low Level Context which triggered the creation of the HLC and
	 *            from which the User should be obtained.
	 */
	private void setUserForHlc(Individual hlcIndiv, LowLevelContext llc) {
		ObjectProperty ctxOfProp = ont.getContextOfProp();
		hlcIndiv.addProperty(ctxOfProp, llc.getObjectPropertyValue(ctxOfProp));
	}
	/**
	 * Method to set the start time of the HLC instance, i.e., to assert the
	 * value of the property which links the PhysicalActivity and Nutrition Context to its start
	 * time.
	 * 
	 * @param hlcIndiv
	 *            Individual representing the HLC instance.
	 * @param llc
	 *            Low Level Context which start triggered the creation of the
	 *            HLC and from which the start time should be obtained.
	 */
	private void setStartTimeForHlcDueToLlcStart(Individual hlcIndiv, LowLevelContext llc) {
		DatatypeProperty startTimeProp = ont.getStartTimeProp();
		hlcIndiv.addProperty(startTimeProp, llc.getDataPropertyValue(startTimeProp));
	}
	/**
	 * Method to set the start time of the HLC instance, i.e., to assert the
	 * value of the property which links the PhysicalActivity and Nutrition Context to its start
	 * time.
	 * 
	 * @param hlcIndiv
	 *            Individual representing the HLC instance.
	 * @param llc
	 *            Low Level Context which end triggered the creation of the HLC
	 *            and from which the start time should be obtained.
	 */
	private void setStartTimeForHlcDueToLlcEnd(Individual hlcIndiv, LowLevelContext llc) {
		hlcIndiv.addProperty(ont.getStartTimeProp(), llc.getDataPropertyValue(ont.getEndTimeProp()));
	}
	/**
	 * Method to set in a HLC instance the LLC instance which is part of it.
	 * This means asserting the value of the property which links the High Level
	 * Context to the Low Level Context and asserting the class which states
	 * that this LLC instance is the only value that the property can take. The
	 * type assertion is necessary in order to overcome the Open World
	 * Assumption of OWL.
	 * 
	 * @param hlcModel
	 *            OntModel associated to the HLC instance.
	 * @param hlcIndiv
	 *            Individual representing the HLC instance.
	 * @param llc
	 *            Low Level Context which should be set as part of the HLC.
	 * @param llcProp
	 *            ObjectProperty linking the HLC to the LLC which is part of it.
	 */
	private void setLlcBeingPartOfHlc(OntModel hlcModel, Individual hlcIndiv, LowLevelContext llc,
			ObjectProperty llcProp) {
		Individual llcIndiv = llc.getCtxIndiv();
		hlcIndiv.addProperty(llcProp, llcIndiv);
		EnumeratedClass llcEnumClass = hlcModel.createEnumeratedClass(null, null);
		llcEnumClass.addOneOf(llcIndiv);
		AllValuesFromRestriction llcRestr = hlcModel.createAllValuesFromRestriction(null, llcProp, llcEnumClass);
		hlcIndiv.addOntClass(llcRestr);
		hlcModel.add(llc.getCtxModel());
	}
	/**
	 * Method to set in a HLC instance that there is no LLC instance of a given
	 * category, e.g., Activity, Location, food or Emotion) being part of it. This
	 * type assertion is necessary in order to overcome the Open World
	 * Assumption of OWL.
	 * 
	 * @param hlcModel
	 *            OntModel associated to the HLC instance.
	 * @param hlcIndiv
	 *            Individual representing the HLC instance.
	 * @param llcCategoryClass
	 *            OntClass representing the LLC Category for which there is no
	 *            LLC instance.
	 * @param llcProp
	 *            ObjectProperty linking the HLC to the LLC Category for which
	 *            there is no LLC instance.
	 */
	private void setNoLlcBeingPartOfHlc(OntModel hlcModel, Individual hlcIndiv, OntClass llcCategoryClass,
			ObjectProperty llcProp) {
		SomeValuesFromRestriction llcRestr = hlcModel.createSomeValuesFromRestriction(null, llcProp, llcCategoryClass);
		ComplementClass llcCompl = hlcModel.createComplementClass(null, llcRestr);
		hlcIndiv.addOntClass(llcCompl);
	}
}